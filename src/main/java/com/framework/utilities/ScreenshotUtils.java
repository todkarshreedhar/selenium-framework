package com.framework.utilities;

import com.framework.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    private static final Logger logger =
            LogManager.getLogger(ScreenshotUtils.class);

    public static void takeScreenshot(String fileName) {

        WebDriver driver = DriverManager.getDriver();

        try {

            File srcFile =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            File destFile = new File(
                    "screenshots/"
                            + fileName
                            + "_"
                            + System.currentTimeMillis()
                            + ".png"
            );

            FileUtils.copyFile(srcFile, destFile);

            logger.info(
                    "Screenshot Saved At: "
                            + destFile.getAbsolutePath()
            );

        }
        catch (IOException e) {

            logger.error("Failed To Capture Screenshot", e);
        }
    }
}
