package com.webtestsbase.commonElements.elements.impl;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


class TextInputImpl extends ElementImpl implements TextInput {

    protected TextInputImpl(WebDriverFactory webDriverFactory, final WebElement wrappedElement) {
        super(webDriverFactory, wrappedElement);
    }

    @Override
    public boolean setText(final String text) {
        try {
            return webDriverFactory.sendKeys(wrappedElement, text);
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public void clear() {
        wrappedElement.clear();
    }

    @Override
    public boolean sendKeys(Keys keys) {
        try {
            return webDriverFactory.sendKeys(wrappedElement, keys);
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public String getValue() {
        try {
            String text = wrappedElement.getText();
            return !text.equals("") ? text : wrappedElement.getAttribute("value");
        } catch (Exception ex) {
            return null;
        }
    }
}
