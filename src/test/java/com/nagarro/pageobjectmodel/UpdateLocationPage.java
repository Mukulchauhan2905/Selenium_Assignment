package com.nagarro.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class UpdateLocationPage {
	public static WebElement element = null;

	public static void enterLocationPin(WebDriver driver, String pin) {
		element = driver.findElement(By.id("GLUXZipUpdateInput"));
		element.clear();
		element.sendKeys(pin);
	}
	
	public static void clickOnUpdateLocation(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10); 
	    WebElement updateLocationButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nav-global-location-popover-link\"]")));
	    updateLocationButton.click();
	}
	
	public static void clickOnApplyButton(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"GLUXZipUpdate\"]/span/input")).click();
	}
	
	public static String getContentOfUpdatedLocation(WebDriver driver) {
	    WebElement UpdatedLocation = driver.findElement(By.xpath("//*[@id=\"glow-ingress-line2\"]"));
	    return UpdatedLocation.getText();
	}

	

	
	public static void updateLocation(WebDriver driver, String pin ) {
		Reporter.log("Click on Signin", true);
		clickOnUpdateLocation(driver);
		enterLocationPin(driver, pin);
		clickOnApplyButton(driver);
		Reporter.log("Entered pin to update location", true);
	}
	
	public static void validateUpdatedLocation(WebDriver driver) {
		Reporter.log("Checking for Updated Location", true);
		String location = "Meerut";
		String updatedLocation = getContentOfUpdatedLocation(driver);
		System.out.println(updatedLocation);
		if (updatedLocation.contains(location)) {
			Reporter.log("found that location is updated successfully", true);
        } else {
			Reporter.log("found that location is not updated", true);
        }
	}
}
