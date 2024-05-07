package com.nagarro.basicsetup;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
    public WebDriver driver;

    @BeforeTest
    public WebDriver setUp() throws IOException {

        // Properties file path
        String path = "C:/Users/mukulchauhan/OneDrive - Nagarro/Desktop/Automation Fresher Training/Assignment 3/TestingAmazon/src/test/java/testdata.properties";
        // Creating object of Properties class
        Properties prop = new Properties();
        FileInputStream fs = new FileInputStream(path);
        prop.load(fs);

        // Use WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();

        if (prop.getProperty("browser").equals("firefox")) {
            driver = new FirefoxDriver();
            Reporter.log("Running test on Firefox browser");
        } else if (prop.getProperty("browser").equals("chrome")) {
            driver = new ChromeDriver();
            Reporter.log("Running test on chrome browser");
        } else {
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        return driver;
    }

    @AfterTest
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (UnreachableBrowserException e) {
            System.out.println("Error communicating with the remote browser: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error during teardown: " + e.getMessage());
        }
    }
}
