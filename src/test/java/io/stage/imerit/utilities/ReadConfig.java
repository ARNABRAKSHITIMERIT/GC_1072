package io.stage.imerit.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties readProperties;
	String pathProperties = ".\\configurations\\config.properties";

	public ReadConfig() {
		try {
			readProperties = new Properties();
			FileInputStream fileInputStream = new FileInputStream(pathProperties);
			readProperties.load(fileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getBaseURL() {
		String getBaseURLValue = readProperties.getProperty("baseURL");
		if (getBaseURLValue != null)
			return getBaseURLValue;
		else
			throw new RuntimeException("URL not specified in Config File");
	}

	public String getBrowser() {
		String getBrowserValue = readProperties.getProperty("browser");
		if (getBrowserValue != null)
			return getBrowserValue;
		else
			throw new RuntimeException("Browser not specified in Config File");
	}
}
