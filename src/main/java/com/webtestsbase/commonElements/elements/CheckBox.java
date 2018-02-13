package com.webtestsbase.commonElements.elements;

import com.webtestsbase.BasePage;

public interface CheckBox extends Element {

    boolean set();

    boolean remove();

    boolean getValue();

    <T extends BasePage> T setAndReturnNewInstance(boolean flag, Class<T> t);
}
