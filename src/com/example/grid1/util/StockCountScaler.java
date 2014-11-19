package com.example.grid1.util;

import java.util.Locale;

import com.vaadin.data.util.converter.Converter;

public class StockCountScaler implements Converter<Double, Integer> {

	private static final double MAX = 600.0;

	@Override
	public Integer convertToModel(Double value,
			Class<? extends Integer> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		return (int) (value*MAX);
	}

	@Override
	public Double convertToPresentation(Integer value,
			Class<? extends Double> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		return value/MAX;
	}

	@Override
	public Class<Integer> getModelType() {
		return Integer.class;
	}

	@Override
	public Class<Double> getPresentationType() {
		return Double.class;
	}

}
