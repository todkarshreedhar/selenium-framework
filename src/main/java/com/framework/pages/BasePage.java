package com.framework.pages;

import com.framework.elements.ElementActions;

public class BasePage {
    protected ElementActions elementActions;
    public BasePage() {
        elementActions = new ElementActions();
    }
}
