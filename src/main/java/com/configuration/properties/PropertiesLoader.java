package com.configuration.properties;

import com.exceptions.TestsConfigurationException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Created by Alexandr Trostyanko
 * Class for loading base tests properties. It gets properties - system or from file (by specified names) and sets it to fields of TestConfig object
 */
public class PropertiesLoader {

    /**
     * Sets TestConfig object fields values to specified properties values
     *
     * @param config {@link com.configuration.TestsConfig} object
     */
    public static void populate(Object config) {
        Properties properties = null;
        PropertyFile propertyFileAnnotation = config.getClass().getAnnotation(PropertyFile.class);
        if (propertyFileAnnotation != null) {
            String propertyFileName = propertyFileAnnotation.value();
            if (propertyFileName == null) {
                throw new TestsConfigurationException("Property file name cannot be empty. Class name : " + config.getClass().getName());
            } else {
                properties = new Properties();
                try {
                    InputStream stream = PropertiesLoader.class.getClassLoader().getResourceAsStream(propertyFileName);
                    if(stream != null) {
                        properties.load(stream);
                    } else {
                        throw new TestsConfigurationException("Unable to read property file with name '" + propertyFileName + "' - file not found");
                    }
                } catch (IOException e) {
                    throw new TestsConfigurationException("Error while reading property file with name '" + propertyFileName + "' : " + e.getMessage(), e);
                }
            }
        } else {
            properties = System.getProperties();
        }
        Field[] fields = config.getClass().getDeclaredFields();
        for (Field field : fields) {
            Property propertyAnnotation = field.getAnnotation(Property.class);
            AllProperties allPropertiesAnnotation = field.getAnnotation(AllProperties.class);

            if (propertyAnnotation != null) {
                String propertyName = propertyAnnotation.value();
                if (propertyName == null) {
                    throw new TestsConfigurationException("Property value cannot be empty. Field name : " + field.getName());
                }
                String propertyValue = properties.getProperty(propertyName);
                fieldInit(field, config, propertyValue);
            }


            if (allPropertiesAnnotation != null) {
                fieldInit(field, config, properties);
            }
        }
    }

    private static void fieldInit(Field field, Object config, Object value) {
        try {
            field.setAccessible(true);
            field.set(config, value);
        } catch (IllegalAccessException e) {
            throw new TestsConfigurationException("Field cannot be set...", e);
        }
    }
}
