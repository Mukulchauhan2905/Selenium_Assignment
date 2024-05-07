package com.nagarro.testclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.nagarro.basicsetup.BaseClass;
import com.nagarro.pageobjectmodel.AddToShoppingCartPage;
import com.nagarro.pageobjectmodel.LoginCredentialsPage;
import com.nagarro.pageobjectmodel.UpdateLocationPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestClass1 extends BaseClass {
	
	@AfterMethod
    public void applyWaits() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
    }
	
	@Test(priority=1, dataProvider="productData", dataProviderClass=DataProvider.class)
	public void addProductsToShoppingCart(String product1, String product2) throws IOException {
		AddToShoppingCartPage.addProductToShoppingCart(driver, product1, product2);
	}
	
	@Test(priority=2)
	public void validateShoppingCartItems() throws IOException {
		AddToShoppingCartPage.validateShoppingCart(driver);
	}
	
	@Test(priority=3, dataProvider="locationData", dataProviderClass=DataProvider.class)
	public void updateLocationPin(String pin) throws IOException {
		UpdateLocationPage.updateLocation(driver, pin);
	}
	
	@Test(priority=4)
	public void validatesUpdatedLocation() throws IOException {
		UpdateLocationPage.validateUpdatedLocation(driver);
	}
	
	@Test(priority=5, dataProvider="userData", dataProviderClass=DataProvider.class)
	public void usersSignin(String email, String password) throws IOException {
		LoginCredentialsPage.userSignin(driver, email, password);
	}
	
}