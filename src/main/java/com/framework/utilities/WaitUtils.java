package com.framework.utilities;

import com.framework.config.ConfigReader;
import com.framework.driver.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static final Logger logger =
            LogManager.getLogger(WaitUtils.class);

    private final WebDriver driver;

    private final WebDriverWait wait;

    public WaitUtils() {

        driver = DriverManager.getDriver();

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(
                        Long.parseLong(
                                ConfigReader.getProperty("explicit.wait")
                        )
                )
        );
    }

    /*
     ============================================
                WAIT FOR VISIBILITY
     ============================================
     */

    public WebElement waitForVisibility(By locator) {

        logger.info("Waiting For Visibility Of Element: " + locator);

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    /*
     ============================================
                WAIT FOR CLICKABLE
     ============================================
     */

    public WebElement waitForClickable(By locator) {

        logger.info("Waiting For Element To Become Clickable: " + locator);

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    /*
     ============================================
                WAIT FOR PRESENCE
     ============================================
     */

    public WebElement waitForPresence(By locator) {

        logger.info("Waiting For Presence Of Element: " + locator);

        return wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );
    }
}