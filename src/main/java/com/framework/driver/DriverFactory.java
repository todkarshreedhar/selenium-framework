package com.framework.driver;

import com.framework.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    private static final Logger logger =
            LogManager.getLogger(DriverFactory.class);
    public static void initializeDriver(){

        String browser = ConfigReader.getProperty("browser");
        WebDriver driver;
        logger.info("Initializing Browser: " + browser);

        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-notifications");
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                logger.info("Chrome Browser Launched Successfully");
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                logger.info("Firefox Browser Launched Successfully");
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                logger.info("Edge Browser Launched Successfully");
                break;
            default:
                logger.error("Unsupported Browser: " + browser);
                throw new RuntimeException("Browser not supported: " + browser);
        }
        driver.manage().window().maximize();
        logger.info("Browser Window Maximized");
        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(
                        Long.parseLong(ConfigReader.getProperty("implicit.wait"))
                )
        );
        logger.info("Implicit Wait Applied");

        // IMPORTANT
        DriverManager.setDriver(driver);
        logger.info("Driver Stored In ThreadLocal");

        System.out.println("Driver Initialized Successfully");
    }
}
