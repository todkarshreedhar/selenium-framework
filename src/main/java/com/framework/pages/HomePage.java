package com.framework.pages;

import com.framework.locators.HomePageLocators;

public class HomePage extends BasePage {

    public boolean isProductsPageDisplayed(){

        return elementActions.isDisplayed(
                HomePageLocators.PRODUCTS_TITLE
        );
    }

    public String getProductsPageTitle(){

        return elementActions.getText(
                HomePageLocators.PRODUCTS_TITLE
        );
    }

    public boolean isShoppingCartDisplayed(){

        return elementActions.isDisplayed(
                HomePageLocators.SHOPPING_CART_ICON
        );
    }

    public void clickMenuButton(){

        elementActions.click(
                HomePageLocators.MENU_BUTTON
        );
    }



}
