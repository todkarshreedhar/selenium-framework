package com.base;

import com.framework.config.ConfigReader;
import com.framework.driver.DriverFactory;
import com.framework.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        DriverFactory.initializeDriver();
        driver = DriverManager.getDriver();
        driver.get(
                ConfigReader.getProperty("base.url")
        );
    }

    @AfterMethod
    public void tearDown() {
        if(driver != null) {
            driver.quit();
            DriverManager.unload();
        }
    }
}
