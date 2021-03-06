package com.webtestsbase;

import com.configuration.TestsConfig;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Alexandr Trostyanko
 * Class presents functionality for generation of {@link org.openqa.selenium.remote.DesiredCapabilities} object
 * need for some browsers start
 */
public class CapabilitiesGenerator {

    /**
     * getting {@link org.openqa.selenium.remote.DesiredCapabilities} object based on browser
     * ATTENTION: you should specify the path to chrome driver executable file to run tests on it(@see <a href="https://sites.google.com/a/chromium.org/chromedriver/getting-started">here for more info</a>)
     *
     * @param browser {@link }
     * @return capabilites needed for some browsers start
     */
    public static DesiredCapabilities getDefaultCapabilities(Browser browser) {
        String os = System.getProperty("os.name").toLowerCase();
        switch (browser) {
            case FIREFOX:
                if (os.contains("win")) {
                    System.setProperty("webdriver.gecko.driver", TestsConfig.getConfig().getDriversPath() + "/geckodriver.exe");
                } else if (os.contains("mac")) {
                    System.setProperty("webdriver.gecko.driver", TestsConfig.getConfig().getDriversPath() + "/geckodriver");
                } else {

                }
                if (System.getProperty("webdriver.gecko.driver") == null) {
                    throw new IllegalStateException("System variable 'webdriver.gecko.driver' should be set to path for executable driver");
                }
                return DesiredCapabilities.firefox();
            case CHROME:
                if (os.contains("win")) {
                    System.setProperty("webdriver.chrome.driver", TestsConfig.getConfig().getDriversPath() + "/chromedriver.exe");
                } else if (os.contains("mac")) {
                    System.setProperty("webdriver.chrome.driver", TestsConfig.getConfig().getDriversPath() + "/chromedriver");
                } else {

                }
                if (System.getProperty("webdriver.chrome.driver") == null) {
                    throw new IllegalStateException("System variable 'webdriver.chrome.driver' should be set to path for executable driver");
                }

                return DesiredCapabilities.chrome();
            case IE10:
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setVersion("10");
                return caps;
            case SAFARI:
                return new DesiredCapabilities();
            default:
                throw new IllegalStateException("Browser is not supported");
        }
    }

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver", TestsConfig.getConfig().getDriversPath() + "/chromedriver.exe");
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", TestsConfig.getConfig().getDriversPath() + "/chromedriver");
        }
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        return options;
    }
}
