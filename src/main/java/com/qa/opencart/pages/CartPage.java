package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class CartPage {
	
	String product = "ipad";
	
	By pxpath = By.id("product");
	public void clickProduct()
	{
		System.out.println("Please click the product");
	}

}
