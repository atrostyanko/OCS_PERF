package com.webtestsbase.commonElements.elements.impl;

import org.openqa.selenium.WebElement;

import com.reporting.ExtentManager;
import com.webtestsbase.BasePage;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.CheckBox;

public class CheckBoxImpl extends ElementImpl implements CheckBox {
    protected CheckBoxImpl(WebDriverFactory webDriverFactory, WebElement wrappedElement) {
        super(webDriverFactory, wrappedElement);
    }

    boolean set(boolean flag) {
        return webDriverFactory.setCheckBox(wrappedElement, flag);
    }

    @Override
    public boolean set() {
        return webDriverFactory.setCheckBox(wrappedElement, true);
    }

    @Override
    public boolean getValue() {
        return Boolean.valueOf(getAttribute("checked"));
    }

    @Override
    public boolean remove() {
        return webDriverFactory.setCheckBox(wrappedElement, false);
    }

    @Override
    public <T extends BasePage> T setAndReturnNewInstance(boolean flag, Class<T> t) {
        if (set(flag)) {
            return returnNewInstance(t);
        } else {
            return returnNewInstance(t);
        }
    }
}
