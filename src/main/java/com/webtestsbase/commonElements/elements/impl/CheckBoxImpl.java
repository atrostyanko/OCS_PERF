package com.webtestsbase.commonElements.elements.impl;

import org.openqa.selenium.WebElement;

import com.reporting.ExtentManager;
import com.webtestsbase.BasePage;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.CheckBox;

public class CheckBoxImpl extends ElementImpl implements CheckBox {

    protected CheckBoxImpl(WebElement wrappedElement) {
        super(wrappedElement);
    }

    boolean set(boolean flag) {
        return WebDriverFactory.setCheckBox(wrappedElement, flag);
    }

    @Override
    public boolean set() {
        return WebDriverFactory.setCheckBox(wrappedElement, true);
    }

    @Override
    public boolean getValue() {
        return Boolean.valueOf(getAttribute("checked"));
    }

    @Override
    public boolean remove() {
        return WebDriverFactory.setCheckBox(wrappedElement, false);
    }

    @Override
    public <T extends BasePage> T setAndReturnNewInstance(boolean flag, Class<T> t) {
        if (set(flag)) {
            return returnNewInstance(t);
        } else {
            ExtentManager.getCurrentTest().warning("failed to set the value of '" + flag + "' to the current CheckBox");
            return returnNewInstance(t);
        }
    }
}
