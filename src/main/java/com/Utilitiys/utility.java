package com.Utilitiys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.Constant.Aps_project_constant;

public class utility {

	static Properties properties;
	static InputStream input;

	static WebDriver driver;

	public static Properties loadProperties(String path) {
		try {
			input = new FileInputStream(path);
			properties = new Properties();
			properties.load(input);
			return properties;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public static void Load_properties() {
		Aps_project_constant.URL = properties.getProperty("url");
		Aps_project_constant.USERNAME = properties.getProperty("username");
		Aps_project_constant.PASSWORD = properties.getProperty("password");
		Aps_project_constant.BROWSER = properties.getProperty("browser");

	}

}
