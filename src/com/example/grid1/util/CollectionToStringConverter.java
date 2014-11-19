package com.example.grid1.util;

import java.util.Collection;
import java.util.Locale;

import com.vaadin.data.util.converter.Converter;
import com.vaadin.data.util.converter.ConverterFactory;

public class CollectionToStringConverter implements
		Converter<String, Collection> {

	private ConverterFactory factory;

	public CollectionToStringConverter(ConverterFactory converterFactory) {
		this.factory = converterFactory;
	}

	@Override
	public Collection convertToModel(String value,
			Class<? extends Collection> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String convertToPresentation(Collection value,
			Class<? extends String> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		if (value == null)
			return null;

		String result = " , ";
		for (Object o : value) {
			result+= o.toString()+" , ";
		}
		
		return result.substring(3,result.length()-3);
	}

	@Override
	public Class<Collection> getModelType() {
		return Collection.class;
	}

	@Override
	public Class<String> getPresentationType() {
		return String.class;
	}

}
