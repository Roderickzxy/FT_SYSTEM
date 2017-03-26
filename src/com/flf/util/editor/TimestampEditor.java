/**
 * 
 */
package com.flf.util.editor;

import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.propertyeditors.PropertiesEditor;

/**
 * @content
 * @author joie
 * @date 2015-11-12
 */
public class TimestampEditor extends PropertiesEditor {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			System.out.println("经过Editor。");
			if (StringUtils.isNotBlank(text)) {
				Timestamp timestamp = Timestamp.valueOf(text);
				setValue(timestamp);
			} else {
				setValue(null);
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
