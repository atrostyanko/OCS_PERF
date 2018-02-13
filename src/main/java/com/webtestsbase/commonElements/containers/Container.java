package com.webtestsbase.commonElements.containers;

import org.openqa.selenium.WebElement;

public interface Container {

    void init(WebElement wrappedElement);

    boolean isDisplayed();

    boolean isEnabled();

    WebElement asWebElement();
}
