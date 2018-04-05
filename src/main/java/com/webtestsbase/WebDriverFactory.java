package com.webtestsbase;

import com.configuration.TestsConfig;
import com.reporting.ExtentManager;
import com.utils.TimeUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Alexandr Trostyanko
 * Base class for web tests. It contains web driver {@link org.openqa.selenium.WebDriver} instance, used in all tests.
 * All communications with driver should be done through this class
 */
public class WebDriverFactory {
    private static Browser browser;
    private static String URL;
    private static String username;
    private static String password;
    public final int IMPLICIT_WAIT_TIMEOUT = 10;
    public final int SLEEP_IN_MILLIS = 50;
    public final int LONG_TIME_OUT = 60;
    public final int MEDIUM_TIME_OUT = 10;
    public final int SHORT_TIME_OUT = 5;
    private WebDriver driver;

    //=== Getter
    public Browser getBrowser() {
        return browser;
    }

    //=== Setter
    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Main method of class - it initialize driver and starts browser.
     *
     * @param isLocal - is tests will be started local or not
     */
    public void startBrowser(boolean isLocal) {
        if (driver == null) {
            setBrowser(TestsConfig.getConfig().getBrowser());
            setURL(TestsConfig.getConfig().getBrowserURL());
            setUsername(TestsConfig.getConfig().getUsername());
            setPassword(TestsConfig.getConfig().getPassword());

            if (!isLocal) {
                driver = new RemoteWebDriver(CapabilitiesGenerator.getDefaultCapabilities(browser));
            } else {
                switch (browser) {
                    case FIREFOX:
                        driver = new FirefoxDriver(CapabilitiesGenerator.getDefaultCapabilities(Browser.FIREFOX));
                        break;
                    case CHROME:
                        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
                        break;
                    case IE10:
                        driver = new InternetExplorerDriver(CapabilitiesGenerator.getDefaultCapabilities(Browser.IE10));
                        break;
                    case SAFARI:
                        driver = new SafariDriver(CapabilitiesGenerator.getDefaultCapabilities(Browser.SAFARI));
                        break;
                    case PHANTOMJS:
                        driver = new PhantomJSDriver(CapabilitiesGenerator.getDefaultCapabilities(Browser.PHANTOMJS));
                        driver.manage().window().setSize(new Dimension(1400, 1000));
                        break;
                    default:
                        throw new IllegalStateException("Unsupported browser type");
                }
            }

            driver.get(getURL());

            System.out.println("Browser is started...");
            System.out.println(driver.getTitle());

        } else {
            throw new IllegalStateException("Driver has already been initialized. Quit it before using this method");
        }
    }

    /**
     * Finishes browser
     */
    public void finishBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public void navigateTo(String relativePath) {
        driver.get(getURL() + relativePath);
    }

    //===== Get methods ================================================================================================

    /**
     * Getting of pre-configured {@link org.openqa.selenium.WebDriver} instance.
     * Please use this method only after call {@link #startBrowser(boolean) startBrowser} method
     *
     * @return webdriver object, or throw IllegalStateException, if driver has not been initialized
     */
    public WebDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            throw new IllegalStateException("Driver has not been initialized. " +
                    "Please call startBrowser() before use this method");
        }
    }

    public WebElement getParentElement(WebElement el) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            return (WebElement) executor.executeScript("return arguments[0].parentNode;", el);
        } catch (Exception e) {
            return null;
        }
    }

    public WebElement getParentUntilTagName(WebElement el, String sTagName) {
        try {
            WebElement elResult = getParentElement(el);
            while (!elResult.getTagName().toLowerCase().equals(sTagName)) {
                elResult = getParentElement(elResult);
            }
            return elResult;
        } catch (Exception e) {
            //ExtentManager.getCurrentTest().warning("getParentUntilTagName: Catch an exception: " + e.toString());
            return null;
        }
    }

    public WebElement getItemContainsText(List<WebElement> webElements, String sValue) {
        for (WebElement item : webElements) {
            try {
                if (item.getText().trim().contains(sValue)) {
                    return item;
                }
            } catch (StaleElementReferenceException ex) {

            }
        }
        return null;
    }

    public WebElement getElementWithMatchingText(List<WebElement> list, String text) {
        for (WebElement el : list) {
            if (text.trim().equals(getWebElementText(el).trim())) return el;
        }
        return null;
    }

    public WebElement getChildElement(WebElement parent, By child) {
        try {
            return parent.findElement(child);
        } catch (Exception ex) {
            return null;
        }
    }

    public List<WebElement> getChildElements(WebElement parent, By child) {
        List<WebElement> list = null;
        if (parent == null) {
            //ExtentManager.getCurrentTest().warning("The parent element is null.");
        } else {
            try {
                list = parent.findElements(child);
            } catch (org.openqa.selenium.NoSuchElementException nsee) {
                //ExtentManager.getCurrentTest().warning("getChildElements: No child of the WebElement that matches " + child.toString());
            } catch (NullPointerException npe) {
                //ExtentManager.getCurrentTest().warning("NPE was catched.");
                return null;
            }
        }
        return list;
    }

    public String getWebElementText(WebElement webElement) {
        try {
            return webElement.getText();
        } catch (Exception ex) {
            return "";
        }
    }

    public String getElementValue(WebElement webElement) {
        String sReturn = "";
        if (webElement != null) {
            WebElement eParent = getParentUntilTagName(webElement, "tr");
            if (eParent != null) {
                WebElement eChild = getChildElement(eParent, By.cssSelector(".DataValue"));
                if (eChild != null) {
                    return getWebElementText(eChild).trim();
                }
            }
        }
        return sReturn;
    }

    public String getTitle() {
        return driver.getTitle().trim();
    }

    //===== CheckBox Methods ===========================================================================================
    public boolean setCheckBox(WebElement el, boolean flag) {
        boolean bResult = false;
        if (el != null) {
            waitElementIsVisible(el);
            if (el.isSelected() != flag) {
                bResult = clickElement(el);
                bResult &= waitForStandardPageNotBusy();
            } else {
                bResult = true;
            }
        }
        return bResult;
    }

    //===== Select methods =============================================================================================
    public boolean selectByText(WebElement webDropDown, String sText) {
        if (isElementDisplayed(webDropDown)) {
            Select dropdown = new Select(webDropDown);
            if (dropdown != null) {
                dropdown.selectByVisibleText(sText);
                return dropdown.getFirstSelectedOption().getText().equals(sText);
            }
        }
        return false;
    }

    public boolean selectByValue(WebElement webDropDown, String sText) {
        if (isElementDisplayed(webDropDown)) {
            Select dropdown = new Select(webDropDown);
            if (dropdown != null) {
                dropdown.selectByValue(sText);
                return dropdown.getFirstSelectedOption().getText().equals(sText);
            }
        }
        return false;
    }

    //===== Check methods ==============================================================================================
    public boolean isElementDisplayed(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    //===== Click methods ==============================================================================================
    public boolean clickElement(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(getDriver(), SHORT_TIME_OUT, SLEEP_IN_MILLIS);
        try {
            webElement = wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            return true;
        } catch (Exception ex) {
            try {
                TimeUtils.waitForSeconds(1);
                try {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
                } catch (WebDriverException wde) {

                }
                webElement.click();
                return true;
            } catch (Exception ex1) {
                //ExtentManager.getCurrentTest().info("clickElement: Exception was caught: " + ex1.toString());
            }
        }
        return false;
    }

    public boolean clickElement(By selector) {
        WebElement webElement = findElement(selector);
        if (webElement != null) {
            return clickElement(webElement);
        }
        return false;
    }

    //===== Find methods ===============================================================================================
    public WebElement findElement(By locator) {
        try {
            return driver.findElement(locator);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            //ExtentManager.getCurrentTest().debug("Element with Locator " + locator + " not found");
            return null;
        }
    }

    public List<WebElement> findElements(By locator) {
        try {
            return driver.findElements(locator);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            //ExtentManager.getCurrentTest().debug("Element with Locator " + locator + " not found");
            return null;
        }

    }

    //===== Send Keys methods ==========================================================================================
    public boolean sendKeys(WebElement el, String keysToSend) {
        try {
            el.clear();
            //TimeUtils.waitForMillis(100);
            el.sendKeys(keysToSend);
            return true;
        } catch (WebDriverException wde) {
            TimeUtils.waitForMillis(200);
            try {
                el.clear();
                TimeUtils.waitForMillis(200);
                el.sendKeys(keysToSend);
                return true;
            } catch (WebDriverException wde1) {
                //ExtentManager.getCurrentTest().debug("Exception Throws using native sendKeys. " + wde1.getMessage());
                return false;
            } catch (NullPointerException npe) {
                return false;
            }
        }
    }

    public boolean sendKeys(WebElement el, Keys keysToSend) {
        boolean bReturn = false;
        try {
            WebDriverWait wait = webDriverWait();
            //el.clear();
            try {
                bReturn = wait.until(ExpectedConditions.textToBePresentInElement(el, ""));
            } catch (TimeoutException e) {
                return false;
            }
            el.sendKeys(keysToSend);
            bReturn = true;
        } catch (WebDriverException wde) {
            TimeUtils.waitForMillis(200);
            try {
                el.sendKeys(keysToSend);
            } catch (WebDriverException wde1) {
                //ExtentManager.getCurrentTest().debug("Exception Throws using native sendKeys. " + wde1.getMessage());
                return false;
            }

        }
        return bReturn;
    }

    //===== Wait methods ===============================================================================================
    public WebDriverWait webDriverWait() {
        return new WebDriverWait(driver, IMPLICIT_WAIT_TIMEOUT, SLEEP_IN_MILLIS);
    }

    public boolean waitElementIsVisible(WebElement webElement) {
        WebDriverWait wait = webDriverWait();
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean waitAllElementsVisible(List<WebElement> webElementList) {
        WebDriverWait wait = webDriverWait();
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(webElementList));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean waitTextToBePresentInElement(WebElement webElement, String sText) {
        WebDriverWait wait = webDriverWait();
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(webElement, sText));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean waitForStandardPageNotBusy() {
        return true;
        //return waitForPageNotBusy(standartPage_PageLoadingIcon, 1);
    }

    public boolean waitForElementInvisible(WebElement element, int timeout, boolean expectedClickable) {
        boolean bReturn = false;
        if (element != null) {
            try {
                WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
                wait.until(ExpectedConditions.invisibilityOf(element));
                bReturn = true;
            } catch (TimeoutException e) {
                if (!expectedClickable) {
                    bReturn = true;
                }
            }
        }
        return bReturn;
    }

    public boolean waitForElementInvisible(WebElement element) {
        return waitForElementInvisible(element, MEDIUM_TIME_OUT, true);
    }

    public WebElement waitAndFindDisplayedElement(By locator) {
        return waitAndFindDisplayedElement(locator, SHORT_TIME_OUT);
    }

    public WebElement waitAndFindDisplayedElement(By locator, int TIMEOUT) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            //ExtentManager.getCurrentTest().warning("waitAndFindDisplayedElement: Element " + locator.toString() + " never displayed with in timeout of " + TIMEOUT);
        }
        return null;
    }
}
