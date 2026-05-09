package com.framework.driver;

import com.framework.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverFactory {
    public static void initializeDriver(){

        String browser = ConfigReader.getProperty("browser");
        WebDriver driver;

        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(
                        Long.parseLong(ConfigReader.getProperty("implicit.wait"))
                )
        );

        // IMPORTANT
        DriverManager.setDriver(driver);

        System.out.println("Driver Initialized Successfully");
    }
}
