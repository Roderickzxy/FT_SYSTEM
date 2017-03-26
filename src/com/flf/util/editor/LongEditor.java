package com.flf.util.editor;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.propertyeditors.PropertiesEditor;

/**
 * @content
 * @author joie
 * @date 2015-11-12
 */
public class LongEditor extends PropertiesEditor {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			if (StringUtils.isBlank(text)) {
				setValue(null);
			}else
			{
				setValue(text);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setValue(null);
		}

	}

	@Override
	public String getAsText() {
		return getValue().toString();
	}
}
