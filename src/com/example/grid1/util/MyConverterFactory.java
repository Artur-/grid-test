package com.example.grid1.util;

import java.util.Collection;

import com.vaadin.data.util.converter.Converter;
import com.vaadin.data.util.converter.DefaultConverterFactory;

public class MyConverterFactory extends DefaultConverterFactory {

	@Override
	public <PRESENTATION, MODEL> Converter<PRESENTATION, MODEL> createConverter(
			Class<PRESENTATION> presentationType, Class<MODEL> modelType) {
		if (Collection.class.isAssignableFrom(modelType) && presentationType == String.class) {
			return (Converter<PRESENTATION, MODEL>) new CollectionToStringConverter(this);
		}
		return super.createConverter(presentationType, modelType);
	}
}
