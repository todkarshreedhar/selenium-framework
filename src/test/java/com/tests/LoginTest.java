package com.tests;

import com.framework.base.BaseTest;
import com.framework.pages.HomePage;
import com.framework.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private static final Logger logger =
            LogManager.getLogger(LoginTest.class);
    @Test
    public void verifySuccessfulLogin(){
        logger.info("Starting SauceDemo Login Test");
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        loginPage.login("standard_user", "secret_sauce");
        logger.info("Login Action Completed");
        Assert.assertTrue(homePage.isProductsPageDisplayed(), "Products Page Is Not Displayed");
        Assert.assertEquals(homePage.getProductsPageTitle(), "Products");
        Assert.assertTrue(homePage.isShoppingCartDisplayed(), "Shopping Cart Icon Is Not Displayed");
        logger.info("Login Validation Successful");
    }
}
