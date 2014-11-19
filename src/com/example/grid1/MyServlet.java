package com.example.grid1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.example.grid1.util.MyConverterFactory;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@WebServlet(value = "/*", asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = Grid1UI.class)
public class MyServlet extends VaadinServlet {

	@Override
	protected void servletInitialized() throws ServletException {
		super.servletInitialized();
		getService().addSessionInitListener(e -> {
			e.getSession().setConverterFactory(new MyConverterFactory());
		});
	}
}
