package com.epam.lab.control;

import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

public class CustomFieldDecorator extends DefaultFieldDecorator {
    public CustomFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        ElementLocator locator = factory.createLocator(field);
        if (PageElement.class.isAssignableFrom(field.getType())) {
            final PageElement pageElement = new PageElement(proxyForLocator(loader, locator));
            return pageElement;
        } else {
            return super.decorate(loader, field);
        }
    }
}