package com.example.grid1.util;

import com.vaadin.data.fieldgroup.DefaultFieldGroupFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.NativeSelect;

public class CustomFieldFactory extends DefaultFieldGroupFieldFactory {

	@Override
	public <T extends Field> T createField(Class<?> dataType, Class<T> fieldType) {
		if (Enum.class.isAssignableFrom(dataType) && fieldType == Field.class) {
			return (T) super.createField(dataType, NativeSelect.class);
		}
		return super.createField(dataType, fieldType);
	}

}
