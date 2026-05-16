package com.framework.pages;

import com.framework.locators.LoginPageLocators;

public class LoginPage extends BasePage
{
    public void enterUsername(String userName)
    {
        elementActions.type(LoginPageLocators.USERNAME_INPUT,userName);
    }

    public void enterPassword(String password)
    {
        elementActions.type(LoginPageLocators.PASSWORD_INPUT,password);
    }

    public void clickLoginButton()
    {
        elementActions.click(LoginPageLocators.LOGIN_BUTTON);
    }

    public void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getErrorMessage(){
        return elementActions.getText(
                LoginPageLocators.ERROR_MESSAGE
        );
    }

}
