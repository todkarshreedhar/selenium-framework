package com.framework.locators;

import org.openqa.selenium.By;

public class LoginPageLocators {

    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.cssSelector("h3[data-test='error']");
}
