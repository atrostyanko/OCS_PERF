package com.webtestsbase.commonElements;

import com.webtestsbase.commonElements.containers.Container;
import com.webtestsbase.commonElements.containers.factory.ContainerFactory;
import com.webtestsbase.commonElements.containers.factory.DefaultContainerFactory;
import com.webtestsbase.commonElements.elements.Element;
import com.webtestsbase.commonElements.elements.factory.ElementFactory;
import com.webtestsbase.commonElements.elements.impl.DefaultElementFactory;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * Created by Alexandr Tsyhankou.
 */
public class ExtendedFieldDecorator extends DefaultFieldDecorator {
    private ElementFactory elementFactory = new DefaultElementFactory();
    private ContainerFactory containerFactory = new DefaultContainerFactory();
    private WebDriver driver;

    public ExtendedFieldDecorator(final WebDriver driver) {
        super(new DefaultElementLocatorFactory(driver));
        this.driver = driver;
    }

    public ExtendedFieldDecorator(final WebDriver driver, final SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
        this.driver = driver;
    }

    public ExtendedFieldDecorator(ElementLocatorFactory elementLocatorFactory) {
        super(elementLocatorFactory);
    }

    @Override
    public Object decorate(final ClassLoader loader, final Field field) {
        try {
            if (Container.class.isAssignableFrom(field.getType())) {
                return decorateContainer(loader, field);
            }
            if (Element.class.isAssignableFrom(field.getType())) {
                return decorateElement(loader, field);
            }
            if (List.class.isAssignableFrom(field.getType())) {
                ParameterizedType listType = (ParameterizedType) field.getGenericType();
                Class<?> listClass = (Class<?>) listType.getActualTypeArguments()[0];
                return decorateList(loader, field, listClass.asSubclass(Element.class));
            }
        } catch (Exception e) {
        }
        return super.decorate(loader, field);
    }

    private <E extends Element> List<E> decorateList(ClassLoader loader, Field field, final Class<E> elementClass) {
        LocationElementListHandler handler = new LocationElementListHandler(driver, field);
        List proxy = (List) Proxy.newProxyInstance(loader, new Class[]{List.class}, handler);
        return proxy;
    }


    private Object decorateElement(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = proxyForLocator(loader, createLocator(field));
        return elementFactory.create((Class<? extends Element>) field.getType(), wrappedElement);
    }

    private ElementLocator createLocator(final Field field) {
        return factory.createLocator(field);
    }

    private Object decorateContainer(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = proxyForLocator(loader, createLocator(field));
        final Container container = containerFactory.create((Class<? extends Container>) field.getType(), wrappedElement);
        PageFactory.initElements(new ExtendedFieldDecorator(driver, wrappedElement), wrappedElement);
        return container;
    }
}