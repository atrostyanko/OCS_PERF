package com.webtestsbase.commonElements.containers.impl;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.containers.Container;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


abstract class AbstractContainerImpl implements Container {
    protected WebElement wrappedElement;
    WebDriverFactory webDriverFactory;

    protected AbstractContainerImpl(WebDriverFactory webDriverFactory, final WebElement wrappedElement) {
        this.webDriverFactory = webDriverFactory;
        this.wrappedElement = wrappedElement;
    }

    @Override
    public final void init(final WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    @Override
    public boolean isDisplayed() {
        return webDriverFactory.isElementDisplayed(wrappedElement);
    }

    @Override
    public boolean isEnabled() {
        try {
            return wrappedElement.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public WebElement asWebElement() {
        return wrappedElement;
    }
}
