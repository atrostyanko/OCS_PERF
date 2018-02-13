package com.webtestsbase.commonElements.elements;

import org.openqa.selenium.Keys;

public interface TextInput extends Element {

    void clear();

    boolean setText(String keys);

    boolean sendKeys(Keys keys);

    String getValue();
}
