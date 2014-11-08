package com.multivision.ehrms.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The Class PropertyKeyReader.
 */
public class PropertyKeyReader {

	public String getKey(String key) throws Exception {
		String fileName = "ehrms_config.properties";
		ClassLoader.getSystemClassLoader().getResourceAsStream(fileName);

		Properties props = new Properties();
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream(fileName);
		if (inputStream == null) {
			throw new FileNotFoundException("property file '" + fileName
					+ "' not found in the classpath");
		}
		props.load(inputStream);
		String value = props.getProperty(key);
		inputStream.close();
		return value;
	}

}
