package com.nagarro.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class DeleteItemFromCartPage {
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
		driver.findElement(By.id("a-autoid-1")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"a-autoid-1-announce\"]")));
        element.click();

	}
	
	public static void clickOnShoppingCart(WebDriver driver) {
		driver.findElement(By.id("nav-cart-count")).click();
	}
	
	public static void clickOnDelete(WebDriver driver) {
		WebElement deleteElement = driver.findElement(By.cssSelector("span[data-action='delete']"));
        deleteElement.click();
	}
	
	public static void clickOnQuantityButton(WebDriver driver) {
		WebElement quantityElement = driver.findElement(By.cssSelector("span.a-button-text.a-declarative[data-action='a-dropdown-button']"));
        quantityElement.click();
        WebElement quantityOption = driver.findElement(By.xpath("//div[@class='a-popover-wrapper']//a[contains(text(),'2')]"));
        quantityOption.click();
	}

	

	
//	Method to search and add products to shopping cart
	public static void addProductToShoppingCart(WebDriver driver, String product ) {
		Reporter.log("Searching for iphone cover", true);
		enterProductToSearch(driver, product);
		clickSearchButton(driver);
		addToShoppingCart(driver);
		clickOnShoppingCart(driver);
		clickOnQuantityButton(driver);
		Reporter.log("Searched iphone cover and added to the shopping cart now deleting...", true);
		clickOnDelete(driver);
		
	}
	
}
