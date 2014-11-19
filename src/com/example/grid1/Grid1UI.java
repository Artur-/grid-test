package com.example.grid1;

import java.math.BigDecimal;
import java.util.List;

import com.example.grid1.data.Availability;
import com.example.grid1.data.MockDataGenerator;
import com.example.grid1.data.Product;
import com.example.grid1.util.CamelCase;
import com.example.grid1.util.CurrencyConverter;
import com.example.grid1.util.FilterRow;
import com.example.grid1.util.StockCountScaler;
import com.vaadin.annotations.Theme;
import com.vaadin.data.Container.Indexed;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.converter.StringToBigDecimalConverter;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.Grid;
import com.vaadin.ui.components.grid.GridHeader.HeaderCell;
import com.vaadin.ui.components.grid.GridHeader.HeaderRow;
import com.vaadin.ui.components.grid.renderers.ButtonRenderer;
import com.vaadin.ui.components.grid.renderers.ButtonRenderer.RendererClickEvent;
import com.vaadin.ui.components.grid.renderers.ButtonRenderer.RendererClickListener;
import com.vaadin.ui.components.grid.renderers.HtmlRenderer;
import com.vaadin.ui.components.grid.renderers.ProgressBarRenderer;

@SuppressWarnings("serial")
@Theme("grid1theme")
public class Grid1UI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		layout.addComponent(createGrid());
	}

	private Grid createGrid() {
		List<Product> products = MockDataGenerator.createData();
		Indexed container = new BeanItemContainer<Product>(Product.class, products);
		Grid grid = new Grid(container);

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		grid.setColumnOrder("id", "productName", "price", "availability",
				"category", "stockCount");
		grid.setWidth("800px");
		grid.getColumn("id").setWidth(60);
		grid.getColumn("productName").setWidth(300);
		grid.getColumn("category").setWidth(200);
		grid.getColumn("availability").setWidth(150);

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		for (Object propertyId : grid.getContainerDatasource()
				.getContainerPropertyIds()) {
			grid.getColumn(propertyId).setHeaderCaption(
					CamelCase.toHumanReadable(propertyId));
		}

		
		
		
		
		
		
		
		grid.getColumn("price").setConverter(new CurrencyConverter(" €"));

		
		
		
		
		
		
		grid.setLastFrozenPropertyId("productName");

		
		
		
		
		
		
		HeaderRow row = grid.getHeader().prependRow();
		
		
		
		
		
		
		
		
		
		
		
		
		
		HeaderCell cell = row.join("availability", "category");
		cell.setHtml("Our <u><b>joined</b></u> columns");

		
		
		
		
		
		
		
		
		FilterRow.add(grid);

		
		
		
		
		
		
		
		
		grid.getColumn("productName").setRenderer(new HtmlRenderer());

		
		
		
		
		
		ButtonRenderer buttonRenderer = new ButtonRenderer();
		buttonRenderer.addClickListener(new RendererClickListener() {
			@Override
			public void click(RendererClickEvent event) {
				Grid grid = (Grid) event.getComponent();
				Object clickedItemId = event.getItemId();
				String productName = (String) grid.getContainerDatasource()
						.getItem(clickedItemId).getItemProperty("productName")
						.getValue();
				Notification.show("Selected " + productName);
			}
		});
		grid.getColumn("stockCount").setRenderer(buttonRenderer);

		
		
		
		
		
		
		

		
		
         grid.getColumn("stockCount").setRenderer(new ProgressBarRenderer(),
		 new StockCountScaler());

		
		
		

		FooterRow f = grid.getFooter().appendRow();
		f.getCell("availability").setHtml("");
		for (Availability a : Availability.values()) {
			f.getCell("availability").setHtml(f.getCell("availability").getHtml()+"<br/>"+
					a.toString() + ": " + countAvailability(grid, a));

		}
		
		
		
		
		// grid.getEditorRow().setEnabled(true);
		// grid.getEditorRow().setFieldGroup(new
		// BeanFieldGroup<Product>(Product.class));
		// grid.getEditorRow().setFieldFactory(new CustomFieldFactory());
		
		
		
		
		
		return grid;
	}

	private int countAvailability(Grid grid, Availability a) {
		int count=0;
		Indexed ds = grid.getContainerDatasource();
		for (Object itemId : ds.getItemIds()) {
			Availability ab = (Availability) ds.getItem(itemId).getItemProperty("availability").getValue();
			if (a.equals(ab))
				count++;
		}
		
		return count;
	}

	private String convert(BigDecimal value) {
		StringToBigDecimalConverter converter = new CurrencyConverter(" €");
		return converter
				.convertToPresentation(value, String.class, getLocale());
	}

	private BigDecimal calcAverage(Grid grid) {
		Indexed ds = grid.getContainerDatasource();
		double sum = 0.0;
		int rows = ds.size();
		for (Object itemId : ds.getItemIds()) {
			sum += ((BigDecimal) ds.getItem(itemId).getItemProperty("price")
					.getValue()).doubleValue();
		}

		sum /= rows;
		return new BigDecimal(sum);
	}

}