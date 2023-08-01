package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

	WebDriver driver;
	Properties prop;
	OptionManager optionManager;
	public static String highliht;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	
	
	
	/**
	 * 
	 * @param browserName
	 * @return
	 */
	public WebDriver inItDriver(Properties prop) {
		String browserName=  prop.getProperty("browser");
		System.out.println("Browser name is  : " + browserName);
		optionManager = new OptionManager(prop);
		
		highliht= prop.getProperty("highlight");
		
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			//driver = new ChromeDriver(optionManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionManager.getChromeOptions()));

			break;
		case "firefox":
			//driver = new FirefoxDriver(optionManager.getFireFoxOptions());
			tlDriver.set(new FirefoxDriver(optionManager.getFireFoxOptions()));

			break;
		case "edge":
			//driver = new EdgeDriver();
			tlDriver.set(new EdgeDriver());

			break;
		case "safari":
			//driver = new SafariDriver();
			tlDriver.set(new SafariDriver());

			break;

		default:
			System.out.println("please provide valid browser "+browserName);
			break;
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}
	
	/**
	 * This method is used for init properties
	 * @return
	 */
	public Properties initProp()
	{
		
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}

}
