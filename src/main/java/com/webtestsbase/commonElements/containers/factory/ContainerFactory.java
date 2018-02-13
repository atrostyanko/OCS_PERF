package com.webtestsbase.commonElements.containers.factory;

import com.webtestsbase.commonElements.containers.Container;
import org.openqa.selenium.WebElement;

public interface ContainerFactory {
    <C extends Container> C create(Class<C> containerClass, WebElement wrappedElement);
}
