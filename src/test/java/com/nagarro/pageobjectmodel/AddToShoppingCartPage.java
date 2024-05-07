package com.nagarro.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class AddToShoppingCartPage {
	public static WebElement element = null;

	public static void enterProductToSearch(WebDriver driver, String product) {
		element = driver.findElement(By.id("twotabsearchtextbox"));
		element.clear();
		element.sendKeys(product);
	}
	
	public static void clickSearchButton(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
	}
	
	public static void addToShoppingCart(WebDriver driver) {
//		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.xpath("//*[@id=\"a-autoid-1-announce\"]")).click();

	}
	
	public static void clickOnShoppingCart(WebDriver driver) {
		driver.findElement(By.id("nav-cart-count")).click();
	}

	public static void clickOnProceedCheckout(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span/input")).click();
		driver.navigate().back();
		driver.navigate().refresh();
	}
	
	
//	Method to search and add products to shopping cart
	public static void addProductToShoppingCart(WebDriver driver, String product1, String product2 ) {
//		To add product1 : iphone11 to the shopping cart
		Reporter.log("Searching for iphone 11", true);
		enterProductToSearch(driver, product1);
		clickSearchButton(driver);
		addToShoppingCart(driver);
		Reporter.log("Searched iphone 11 and added to the shopping cart", true);
		
//		To add product2 : canon camera to the shopping cart
		Reporter.log("Searching for canon camera", true);
		enterProductToSearch(driver, product2);
		clickSearchButton(driver);
		addToShoppingCart(driver);
		Reporter.log("Searched canon camera and added to the shopping cart", true);
		
	}
	
//	Method to validate the shopping cart
	public static void validateShoppingCart(WebDriver driver) {
		Reporter.log("Checking for items in the shopping cart", true);
		clickOnShoppingCart(driver);
		clickOnProceedCheckout(driver);
		Reporter.log("found items in shopping cart and clicked on proceed to check out", true);
	}
}