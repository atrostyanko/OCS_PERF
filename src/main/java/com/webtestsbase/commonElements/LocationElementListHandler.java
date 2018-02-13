package com.webtestsbase.commonElements;

import com.webtestsbase.commonElements.containers.Container;
import com.webtestsbase.commonElements.containers.factory.ContainerFactory;
import com.webtestsbase.commonElements.containers.factory.DefaultContainerFactory;
import com.webtestsbase.commonElements.elements.Element;
import com.webtestsbase.commonElements.elements.factory.ElementFactory;
import com.webtestsbase.commonElements.elements.impl.DefaultElementFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr Tsyhankou.
 */
public class LocationElementListHandler implements InvocationHandler {
    private WebDriver webDriver;
    private Field field;
    private ElementLocatorFactory elementLocatorFactory;
    private ElementFactory elementFactory = new DefaultElementFactory();
    private ContainerFactory containerFactory = new DefaultContainerFactory();

    public LocationElementListHandler(WebDriver webDriver, Field field) {
        this.webDriver = webDriver;
        this.field = field;
        this.elementLocatorFactory = new DefaultElementLocatorFactory(webDriver);
    }

    private ElementLocator createLocator(final Field field) {
        return elementLocatorFactory.createLocator(field);
    }

    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        List wrappedElements = createLocator(field).findElements();
        ParameterizedType listType = (ParameterizedType) field.getGenericType();
        Class<?> listClass = (Class<?>) listType.getActualTypeArguments()[0];
        List elements = new ArrayList<>();
        if (Container.class.isAssignableFrom(listClass)) {
            for (WebElement wrappedElement : (List<WebElement>) wrappedElements) {
                Container container = containerFactory.create((Class<? extends Container>) listClass, wrappedElement);
                PageFactory.initElements(new ExtendedFieldDecorator(webDriver, wrappedElement), wrappedElement);
                elements.add(container);
            }
        } else if (Element.class.isAssignableFrom(listClass)) {
            for (WebElement wrappedElement : (List<WebElement>) wrappedElements) {
                elements.add(elementFactory.create(listClass.asSubclass(Element.class), wrappedElement));
            }
        }
        try {
            return method.invoke(elements, objects);
        } catch (InvocationTargetException var6) {
            throw var6.getCause();
        }
    }
}
