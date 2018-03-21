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

    public BasePage() {
        super();
    }

    /**
     * In subclasses  should be used for page opening
     */
    protected abstract void openPage();

    /**
     * checks is page opened
     * @return true if opened
     */
    public abstract boolean isPageOpened();

    public BasePage(boolean openFromMenu){
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
        PageFactory.initElements(new ExtendedFieldDecorator(WebDriverFactory.getDriver()), this);
        if (openFromMenu) {
            openPage();
        }
        waitForOpenPage();
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
            ExtentManager.compareTrue(false, "Page was not opened");
        }
    }
}
