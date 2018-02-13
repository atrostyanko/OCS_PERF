package com.webtestsbase.commonElements.elements.factory;

import com.webtestsbase.commonElements.elements.Element;

import org.openqa.selenium.WebElement;


public interface ElementFactory {
    <E extends Element> E create(Class<E> elementClass, WebElement wrappedElement);
}
