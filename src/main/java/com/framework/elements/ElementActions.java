package com.framework.elements;

import com.framework.driver.DriverManager;
import com.framework.utilities.ScreenshotUtils;
import com.framework.utilities.WaitUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ElementActions {

    private static final Logger logger =
            LogManager.getLogger(ElementActions.class);

    private final WebDriver driver;
    private final WaitUtils waitUtils;
    private final Actions actions;
    public ElementActions(){
        driver = DriverManager.getDriver();
        waitUtils = new WaitUtils();
        actions = new Actions(driver);
    }
    /*
     ============================================
                    GET ELEMENT
     ============================================
     */
    public WebElement getElement(By locator){

        try{

            logger.info("Finding Element: " + locator);
            return waitUtils.waitForVisibility(locator);

        }
        catch (Exception e){
            logger.error("Unable To Find Element: " + locator, e);
            ScreenshotUtils.takeScreenshot("get_element_failure");
            throw new RuntimeException("Failed To Find Element: " + locator);
        }
    }
    /*
     ============================================
                GET CLICKABLE ELEMENT
     ============================================
     */
    public WebElement getClickableElement(By locator){

        try{
            logger.info("Finding Clickable Element: " + locator);
            return waitUtils.waitForClickable(locator);
        }
        catch (Exception e){

            logger.error("Element Not Clickable: " + locator, e);
            ScreenshotUtils.takeScreenshot("clickable_element_failure");
            throw new RuntimeException("Element Not Clickable: " + locator);
        }
    }

    /*
     ============================================
                        CLICK
     ============================================
     */

    public void click(By locator){

        try{
            WebElement element = getClickableElement(locator);
            element.click();
            logger.info("Clicked On Element: " + locator);

        }
        catch (Exception e){

            logger.error("Failed To Click On Element: " + locator, e);
            ScreenshotUtils.takeScreenshot("click_failure");
            throw new RuntimeException("Unable To Click Element: " + locator);
        }
    }

    /*
     ============================================
                        TYPE
     ============================================
     */

    public void type(By locator, String text){

        try{
            WebElement element = getElement(locator);
            element.clear();
            element.sendKeys(text);
            logger.info("Entered Text Into Element: " + locator + " Value: " + text);

        }
        catch (Exception e){
            logger.error("Failed To Enter Text Into Element: " + locator, e);
            ScreenshotUtils.takeScreenshot("type_failure");
            throw new RuntimeException("Unable To Type Into Element: " + locator);
        }
    }

    /*
     ============================================
                    GET TEXT
     ============================================
     */

    public String getText(By locator){

        try{

            WebElement element = getElement(locator);
            String text = element.getText();
            logger.info("Captured Text From Element: " + locator + " Text: " + text);
            return text;

        }
        catch (Exception e){

            logger.error("Failed To Get Text From Element: " + locator, e);
            ScreenshotUtils.takeScreenshot("gettext_failure");
            throw new RuntimeException("Unable To Get Text From Element: " + locator);
        }
    }

    /*
     ============================================
                    IS DISPLAYED
     ============================================
     */

    public boolean isDisplayed(By locator){

        try{

            boolean status = getElement(locator).isDisplayed();
            logger.info("Element Visibility Status: " + locator + " Status: " + status);
            return status;

        }
        catch (Exception e){
            logger.error("Failed To Verify Visibility Of Element: " + locator, e);
            return false;
        }
    }





    /*
     ============================================
                    SCROLL TO ELEMENT
     ============================================
     */

    public void scrollToElement(By locator){

        try{

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
            logger.info("Scrolled To Element: " + locator);

        }
        catch (Exception e){
            logger.error("Failed To Scroll To Element: " + locator, e);
            throw new RuntimeException("Scroll Failed: " + locator);
        }
    }

    /*
     ============================================
                    JAVASCRIPT CLICK
     ============================================
     */

    public void jsClick(By locator){

        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", getElement(locator));
            logger.info("JavaScript Click Performed On: "+ locator);

        }
        catch (Exception e){

            logger.error("JavaScript Click Failed On: " + locator, e);
            throw new RuntimeException("JS Click Failed: " + locator);
        }
    }

    /*
     ============================================
                        HOVER
     ============================================
     */

    public void hover(By locator){

        try{

            actions.moveToElement(getElement(locator)).perform();
            logger.info("Hovered Over Element: " + locator);

        }
        catch (Exception e){
            logger.error("Hover Failed On Element: " + locator, e);
            throw new RuntimeException("Hover Failed: " + locator);
        }
    }


}