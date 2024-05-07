package com.nagarro.testclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.nagarro.basicsetup.BaseClass;
import com.nagarro.pageobjectmodel.DeleteItemFromCartPage;
import com.nagarro.pageobjectmodel.SideNavPage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestClass2 extends BaseClass {
	
	@AfterMethod
    public void applyWaits() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
    }
	
	@Test(priority=1)
	public void addBestSellerItemsToShoppingCart() throws IOException {
		SideNavPage.addBestSellerProductToShoppingCart(driver);;
	}
	
	@Test(priority=2)
	public void validateShoppingCartItems() throws IOException {
		SideNavPage.validateShoppingCart(driver);
	}
	
	@Test(priority=3, dataProvider="deleteProductData", dataProviderClass=DataProvider.class)
	public void deleteItemsFromCart(String product) throws IOException {
		DeleteItemFromCartPage.addProductToShoppingCart(driver, product);
	}
	
}