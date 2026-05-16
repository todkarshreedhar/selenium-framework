package com.framework.base;

import com.framework.config.ConfigReader;
import com.framework.driver.DriverFactory;
import com.framework.driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private static final Logger logger =
            LogManager.getLogger(BaseTest.class);
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        logger.info("========= TEST STARTED =========");
        DriverFactory.initializeDriver();
        driver = DriverManager.getDriver();
        driver.get(
                ConfigReader.getProperty("base.url")
        );
        logger.info("Navigated To URL");
    }

    @AfterMethod
    public void tearDown() {
        if(driver != null) {
            logger.info("Closing Browser");
            driver.quit();
            DriverManager.unload();
            logger.info("Driver Removed From ThreadLocal");
            logger.info("========= TEST ENDED =========");
        }
    }
}
