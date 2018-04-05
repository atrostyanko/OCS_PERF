package com.webtestsbase.commonElements.elements.impl;

import com.webtestsbase.WebDriverFactory;
import org.openqa.selenium.WebElement;
import com.webtestsbase.commonElements.elements.Button;

class ButtonImpl extends ElementImpl implements Button {
    protected ButtonImpl(WebDriverFactory webDriverFactory, final WebElement wrappedElement) {
        super(webDriverFactory, wrappedElement);
    }

    @Override
    public boolean click() {
        return webDriverFactory.clickElement(wrappedElement);
    }
}
