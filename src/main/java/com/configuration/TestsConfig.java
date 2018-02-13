package com.configuration;

import com.configuration.properties.PropertiesLoader;
import com.configuration.properties.Property;
import com.configuration.properties.PropertyFile;
import com.webtestsbase.Browser;

/**
 * Created by Alexandr Trostyanko
 * Class for base tests properties - urls for test, browser name and version
 */
@PropertyFile("config.properties")
public class TestsConfig {

    private static TestsConfig config;

    public static TestsConfig getConfig() {
        if (config == null) {
            config = new TestsConfig();
        }
        return config;
    }

    public TestsConfig() {
        PropertiesLoader.populate(this);
    }

    @Property("browser.name")
    private String browser = "firefox";

    @Property("browser.version")
    private String version = "";

    @Property("browser.URL")
    private String URL = "";

    @Property("drivers.path")
    private String driverPath = "";

    @Property("reports.path")
    private String reportsPath = "";


    /**
     * getting browser object
     * @return browser object
     */
    public Browser getBrowser() {
        Browser browserForTests = Browser.getByName(browser);
        if (browserForTests != null) {
            return browserForTests;
        } else {
            throw new IllegalStateException("Browser name '" + browser + "' is not valid");
        }
    }

    /**
     * getting browser version
     * @return browser version
     */
    public String getBrowserVersion() {
        return version;
    }

    public String getBrowserURL() {
        return URL;
    }

    /**
     * getting drivers path
     * @return drivers path
     */
    public String getDriversPath() {
        return driverPath;
    }

    /**
     * getting reports path
     * @return reports path
     */
    public String getReportsPath() {
        return reportsPath;
    }
}
