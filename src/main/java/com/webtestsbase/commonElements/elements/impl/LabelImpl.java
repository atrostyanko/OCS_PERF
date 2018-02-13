package com.webtestsbase.commonElements.elements.impl;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Label;

import org.openqa.selenium.WebElement;

class LabelImpl extends ElementImpl implements Label {

    protected LabelImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }
}
