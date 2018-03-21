package com.webtestsbase.commonElements.elements.impl;

import com.webtestsbase.Browser;
import com.webtestsbase.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.webtestsbase.commonElements.elements.Button;

class ButtonImpl extends ElementImpl implements Button {

    protected ButtonImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public boolean click() {
        if (WebDriverFactory.getBrowser() == Browser.PHANTOMJS) {
            mouseHoverJScript();
            wrappedElement.click();
            return true;
        }
        return WebDriverFactory.clickElement(wrappedElement);
    }

    private void mouseHoverJScript() {
        String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj." +
                    "initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
        ((JavascriptExecutor) driver).executeScript(mouseOverScript, wrappedElement);
    }
}
