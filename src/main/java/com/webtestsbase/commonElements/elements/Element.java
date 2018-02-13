package com.webtestsbase.commonElements.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Element {

    WebElement asWebElement();

    boolean isDisplayed();

    boolean isEnabled();

    boolean isFocused();

    Button asButton();

    WebElement getParent();

    String getText();

    String getAttribute(String sAttributeName);

    Element getChild(By by);

    void setFocus();

    void  setAttribute(String attName, String attValue);
}
