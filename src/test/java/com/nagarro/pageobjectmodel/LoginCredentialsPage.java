package com.nagarro.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LoginCredentialsPage {
	public static WebElement element = null;

	public static void enterEmail(WebDriver driver, String email) {
		element = driver.findElement(By.id("ap_email"));
		element.clear();
		element.sendKeys(email);
	}
	
	public static void enterPassword(WebDriver driver, String password) {
		element = driver.findElement(By.id("ap_password"));
		element.clear();
		element.sendKeys(password);
	}
	
	public static void clickSigninButton(WebDriver driver) {
		driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nav-link-accountList\"]")));
        signInLink.click();
//		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
	}
	
	public static void clickSigninSubmit(WebDriver driver) {
		driver.findElement(By.id("signInSubmit")).click();
	}
	
	public static void clickContinue(WebDriver driver) {
		driver.findElement(By.id("continue")).click();

	}
	

	
	public static void userSignin(WebDriver driver, String email, String password ) {
		Reporter.log("Click on Signin", true);
		clickSigninButton(driver);
		enterEmail(driver, email);
		clickContinue(driver);
		enterPassword(driver, password);
		clickSigninSubmit(driver);
		Reporter.log("Entered user email and password ", true);
		
	}

}
