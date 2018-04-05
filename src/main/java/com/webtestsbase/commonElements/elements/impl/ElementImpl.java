package com.webtestsbase.commonElements.elements.impl;

import com.reporting.ExtentManager;
import com.webtestsbase.BasePage;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.webtestsbase.commonElements.elements.Element;
import org.openqa.selenium.interactions.Actions;

import java.lang.reflect.InvocationTargetException;

public class ElementImpl implements Element {
    protected final WebElement wrappedElement;
    public WebDriverFactory webDriverFactory;

    protected ElementImpl(WebDriverFactory webDriverFactory, final WebElement wrappedElement) {
        this.webDriverFactory = webDriverFactory;
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

    @Override
    public Button asButton(){
        return new DefaultElementFactory().create(Button.class, wrappedElement);
    }

    @Override
    public WebElement getParent(){
        try {
            return webDriverFactory.getParentElement(wrappedElement);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getText(){
        try {
            return wrappedElement.getText();
        } catch (Exception e){
            return null;
        }
    }

    public <T extends BasePage> T  returnNewInstance(Class<T> t) {
        try {
            return t.getDeclaredConstructor(boolean.class).newInstance(false);
        } catch (NoSuchMethodException ex) {
            try {
                return t.newInstance();
            } catch (IllegalAccessException | InstantiationException e) {
                return null;
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            return null;
        }
    }

    @Override
    public String getAttribute(String sAttributeName) {
        try {
            return wrappedElement.getAttribute(sAttributeName);
        } catch (Exception ex) {
            return "";
        }
    }

    @Override
    public boolean isFocused() {
        boolean isFocused = wrappedElement.equals(webDriverFactory.getDriver().switchTo().activeElement());
        webDriverFactory.getDriver().switchTo().defaultContent();
        return isFocused;
    }

    @Override
    public Element getChild(By by){
        try {
            return new DefaultElementFactory().create(Element.class, wrappedElement.findElement(by));
        } catch (Exception ex){
            return null;
        }
    }

    @Override
    public void setFocus() {
        new Actions(webDriverFactory.getDriver()).moveToElement(wrappedElement).perform();
    }

    @Override
    public void setAttribute(String attName, String attValue) {
        JavascriptExecutor js = (JavascriptExecutor) webDriverFactory.getDriver();
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                wrappedElement, attName, attValue);
    }

    private boolean click() {
        try {
            return webDriverFactory.clickElement(wrappedElement);
        } catch (Exception e) {
            return false;
        }
    }

}
