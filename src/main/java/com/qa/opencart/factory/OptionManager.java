package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManager {
	
	
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;
	private Properties prop;
	
	
	public OptionManager (Properties prop)
	{
		this.prop = prop;
	}
	
	public ChromeOptions getChromeOptions()
	{
		co = new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless")))
		{
			co.addArguments("--headless=new");
		}
		if(Boolean.parseBoolean(prop.getProperty("incongnito")))
		{
			co.addArguments("--incongnito");
		}
		return co;
		
	}
	
	public FirefoxOptions getFireFoxOptions()
	{
		fo = new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless")))
		{
			fo.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incongnito")))
		{
			fo.addArguments("--incongnito");
		}
		return fo;
		
	}

}
