package com.webtestsbase;

import com.reporting.ExtentManager;
import com.utils.TimeUtils;

import com.webtestsbase.commonElements.ExtendedFieldDecorator;

import org.openqa.selenium.support.PageFactory;

/**
 * Created by Alexandr Trostyanko
 * This is the main class for pages. When you create your page - you must extend your class from this
 */
public abstract class BasePage {
    private static final int WAIT_FOR_PAGE_LOAD_IN_SECONDS = 60;
    public WebDriverFactory webDriverFactory;
    public ExtentManager extentManager;

    public BasePage(WebDriverFactory webDriverFactory, ExtentManager extentManager) {
        super();
        this.webDriverFactory = webDriverFactory;
        this.extentManager = extentManager;
    }

    /**
     * In subclasses  should be used for page opening
     */
    protected abstract void openPage();

    /**
     * checks is search page opened
     * @return true if opened
     */
    public abstract boolean isSearchPageOpened();

    /**
     * checks is page opened
     * @return true if opened
     */
    public abstract boolean isPageOpened();

    public BasePage(WebDriverFactory webDriverFactory, ExtentManager extentManager, boolean openFromMenu){
        PageFactory.initElements(webDriverFactory.getDriver(), this);
        PageFactory.initElements(new ExtendedFieldDecorator(webDriverFactory.getDriver()), this);
        if (openFromMenu) {
            openPage();
            waitForOpenSearchPage();
        } else {
            waitForOpenPage();
        }
    }

    /**
     * Waiting for page opening
     */
    public void waitForOpenSearchPage(){
        int secondsCount = 0;
        boolean isPageOpenedIndicator = isSearchPageOpened();
        while (!isPageOpenedIndicator && secondsCount < WAIT_FOR_PAGE_LOAD_IN_SECONDS) {
            TimeUtils.waitForSeconds(1);
            secondsCount++;
            isPageOpenedIndicator = isSearchPageOpened();
        }
        if(!isPageOpenedIndicator) {
            extentManager.compareTrue(false, "Page was not opened");
        }
    }

    /**
     * Waiting for page opening
     */
    public void waitForOpenPage(){
        int secondsCount = 0;
        boolean isPageOpenedIndicator = isPageOpened();
        while (!isPageOpenedIndicator && secondsCount < WAIT_FOR_PAGE_LOAD_IN_SECONDS) {
            TimeUtils.waitForSeconds(1);
            secondsCount++;
            isPageOpenedIndicator = isPageOpened();
        }
        if(!isPageOpenedIndicator) {
            //throw new AssertionError("Page was not opened");
            extentManager.compareTrue(false, "Page was not opened");
        }
    }
}
