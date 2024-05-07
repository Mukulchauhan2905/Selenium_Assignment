package com.nagarro.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class SideNavPage {
	public static WebElement element = null;

	public static void clickSideNavButton(WebDriver driver) {
		driver.findElement(By.id("nav-hamburger-menu")).click();
	}
	
	public static void clickBestSellerButton(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[2]/a")).click();
	}
	
	public static void clickSeeMore1Button(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"CardInstance1_7F0jks79GfExQ77wcRwQ\"]/div/div/div/div[1]/div[1]/div/a")).click();
	}
	
	public static void clickSeeMore2Button(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"CardInstanceweuAc__GRvUxOXtkGO336Q\"]/div/div/div/div[1]/div[1]/div/a")).click();
	}
	
	public static void addToShoppingCart(WebDriver driver) {
		driver.findElement(By.id("add-to-cart-button")).click();
//		driver.findElement(By.xpath("//*[@id=\"dealsx_atc_btn\"]/span/a")).click();

	}
	
	public static void clickOnShoppingCart(WebDriver driver) {
		driver.findElement(By.id("nav-cart")).click();
	}
	
	public static void clickOnProduct1(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"B0D33S4LFF\"]/div/div/a/span/div")).click();
	}
	
	public static void clickOnProduct2(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"B00KIMHR0Q\"]/div/div/a/span/div")).click();
	}
	
	

	
//	Method to search and add products to shopping cart
	public static void addBestSellerProductToShoppingCart(WebDriver driver) {

		Reporter.log("Searching for Best seller item1", true);
		clickSideNavButton(driver);
		clickBestSellerButton(driver);
		clickOnProduct1(driver);
		addToShoppingCart(driver);
		Reporter.log("Searched Bestsellers in Car & Motorbike and added to the shopping cart", true);
		
		Reporter.log("Searching for Best seller item2", true);
		clickSideNavButton(driver);
		clickBestSellerButton(driver);
		clickOnProduct2(driver);
		addToShoppingCart(driver);
		Reporter.log("Searched Bestsellers in Clothing & Accessories and added to the shopping cart", true);
		
	}
	
//	Method to validate the shopping cart
	public static void validateShoppingCart(WebDriver driver) {
		Reporter.log("Checking for items in the shopping cart", true);
		clickOnShoppingCart(driver);
		Reporter.log("found items in shopping cart and checked for proceed to check out", true);
	}
}
