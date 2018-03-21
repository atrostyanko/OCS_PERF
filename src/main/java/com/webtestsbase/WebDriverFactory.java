package com.webtestsbase;

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

import com.configuration.TestsConfig;
import com.reporting.ExtentManager;
import com.utils.TimeUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Alexandr Trostyanko
 * Base class for web tests. It contains web driver {@link org.openqa.selenium.WebDriver} instance, used in all tests.
 * All communications with driver should be done through this class
 */
public class WebDriverFactory {
    public static final int IMPLICIT_WAIT_TIMEOUT = 10;
    public static final int SLEEP_IN_MILLIS = 50;

    public static final int LONG_TIME_OUT = 60;
    public static final int MEDIUM_TIME_OUT = 10;
    public static final int SHORT_TIME_OUT = 5;

    private static WebDriver driver;

    private static String URL;
    private static String username;
    private static String password;
    private static Browser browser;

    public static void setPassword(String password) {
        WebDriverFactory.password = password;
    }

    public static String getPassword() {
        return password;
    }

    public static String getURL() {
        return URL;
    }

    public static String getUsername() {
        return username;
    }

    public static Browser getBrowser() {
        return browser;
    }

    public static void setURL(String URL) {
        WebDriverFactory.URL = URL;
    }

    public static void setUsername(String username) {
        WebDriverFactory.username = username;
    }

    public static void setBrowser(Browser browser) {
        WebDriverFactory.browser = browser;
    }

    /**
     * Main method of class - it initialize driver and starts browser.
     *
     * @param isLocal - is tests will be started local or not
     */
    public static void startBrowser(boolean isLocal) {
        if (driver == null) {
            setURL(TestsConfig.getConfig().getBrowserURL());
            setUsername(TestsConfig.getConfig().getUsername());
            setPassword(TestsConfig.getConfig().getPassword());
            setBrowser(TestsConfig.getConfig().getBrowser());

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
                        driver.manage().window().setSize(new Dimension(1400,1000));
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
    public static void finishBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void navigateTo(String relativePath) {
        driver.get(WebDriverFactory.getURL() + relativePath);
    }

    //===== Get methods ================================================================================================

    /**
     * Getting of pre-configured {@link org.openqa.selenium.WebDriver} instance.
     * Please use this method only after call {@link #startBrowser(boolean) startBrowser} method
     *
     * @return webdriver object, or throw IllegalStateException, if driver has not been initialized
     */
    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            throw new IllegalStateException("Driver has not been initialized. " +
                    "Please call WebDriverFactory.startBrowser() before use this method");
        }
    }

    public static WebElement getParentElement(WebElement el) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            return (WebElement) executor.executeScript("return arguments[0].parentNode;", el);
        } catch (Exception e) {
            return null;
        }
    }

    public static WebElement getParentUntilTagName(WebElement el, String sTagName) {
        try {
            WebElement elResult = getParentElement(el);
            while (!elResult.getTagName().toLowerCase().equals(sTagName)) {
                elResult = getParentElement(elResult);
            }
            return elResult;
        } catch (Exception e) {
            ExtentManager.getCurrentTest().warning("getParentUntilTagName: Catch an exception: " + e.toString());
            return null;
        }
    }

    public static WebElement getItemContainsText(List<WebElement> webElements, String sValue) {
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

    public static WebElement getElementWithMatchingText(List<WebElement> list, String text) {
        for (WebElement el : list) {
            if (text.trim().equals(getWebElementText(el).trim())) return el;
        }
        return null;
    }

    public static WebElement getChildElement(WebElement parent, By child) {
        try {
            return parent.findElement(child);
        } catch (Exception ex) {
            return null;
        }
    }

    public static List<WebElement> getChildElements(WebElement parent, By child) {
        List<WebElement> list = null;
        if (parent == null) {
            ExtentManager.getCurrentTest().warning("The parent element is null.");
        } else {
            try {
                list = parent.findElements(child);
            } catch (org.openqa.selenium.NoSuchElementException nsee) {
                ExtentManager.getCurrentTest().warning("getChildElements: No child of the WebElement that matches " + child.toString());
            } catch (NullPointerException npe) {
                ExtentManager.getCurrentTest().warning("NPE was catched.");
                return null;
            }
        }
        return list;
    }

    public static String getWebElementText(WebElement webElement) {
        try {
            return webElement.getText();
        } catch (Exception ex) {
            return "";
        }
    }

    public static String getElementValue(WebElement webElement) {
        String sReturn = "";
        if (webElement != null) {
            WebElement eParent = WebDriverFactory.getParentUntilTagName(webElement, "tr");
            if (eParent != null) {
                WebElement eChild = WebDriverFactory.getChildElement(eParent, By.cssSelector(".DataValue"));
                if (eChild != null) {
                    return WebDriverFactory.getWebElementText(eChild).trim();
                }
            }
        }
        return sReturn;
    }

    //===== CheckBox Methods ===========================================================================================
    public static boolean setCheckBox(WebElement el, boolean flag) {
        boolean bResult = false;
        if (el != null) {
            WebDriverFactory.waitElementIsVisible(el);
            if (el.isSelected() != flag) {
                bResult = WebDriverFactory.clickElement(el);
                bResult &= WebDriverFactory.waitForStandardPageNotBusy();
            } else {
                bResult = true;
            }
        }
        return bResult;
    }

    //===== Select methods =============================================================================================
    public static boolean selectByText(WebElement webDropDown, String sText) {
        if (WebDriverFactory.isElementDisplayed(webDropDown)) {
            Select dropdown = new Select(webDropDown);
            if (dropdown != null) {
                dropdown.selectByVisibleText(sText);
                return dropdown.getFirstSelectedOption().getText().equals(sText);
            }
        }
        return false;
    }

    public static boolean selectByValue(WebElement webDropDown, String sText) {
        if (WebDriverFactory.isElementDisplayed(webDropDown)) {
            Select dropdown = new Select(webDropDown);
            if (dropdown != null) {
                dropdown.selectByValue(sText);
                return dropdown.getFirstSelectedOption().getText().equals(sText);
            }
        }
        return false;
    }

    //===== Check methods ==============================================================================================
    public static boolean isElementDisplayed(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    //===== Click methods ==============================================================================================
    public static boolean clickElement(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), SHORT_TIME_OUT, SLEEP_IN_MILLIS);
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
                ExtentManager.getCurrentTest().info("clickElement: Exception was caught: " + ex1.toString());
            }
        }
        return false;
    }

    public static boolean clickElement(By selector) {
        WebElement webElement = findElement(selector);
        if (webElement != null) {
            return clickElement(webElement);
        }
        return false;
    }

    //===== Find methods ===============================================================================================
    public static WebElement findElement(By locator) {
        try {
            return driver.findElement(locator);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            ExtentManager.getCurrentTest().debug("Element with Locator " + locator + " not found");
            return null;
        }
    }
    public static List<WebElement> findElements(By locator) {
        try {
            return driver.findElements(locator);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            ExtentManager.getCurrentTest().debug("Element with Locator " + locator + " not found");
            return null;
        }

    }

    //===== Send Keys methods ==========================================================================================
    public static boolean sendKeys(WebElement el, String keysToSend) {
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
                ExtentManager.getCurrentTest().debug("Exception Throws using native sendKeys. " + wde1.getMessage());
                return false;
            } catch (NullPointerException npe) {
                return false;
            }
        }
    }

    public static boolean sendKeys(WebElement el, Keys keysToSend) {
        boolean bReturn = false;
        try {
            WebDriverWait wait = WebDriverFactory.webDriverWait();
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
                ExtentManager.getCurrentTest().debug("Exception Throws using native sendKeys. " + wde1.getMessage());
                return false;
            }

        }
        return bReturn;
    }

    //===== Wait methods ===============================================================================================
    public static WebDriverWait webDriverWait() {
        return new WebDriverWait(driver, IMPLICIT_WAIT_TIMEOUT, SLEEP_IN_MILLIS);
    }

    public static boolean waitElementIsVisible(WebElement webElement) {
        WebDriverWait wait = webDriverWait();
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static boolean waitTextToBePresentInElement(WebElement webElement, String sText) {
        WebDriverWait wait = webDriverWait();
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(webElement, sText));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static boolean waitForStandardPageNotBusy() {
        return true;
        //return waitForPageNotBusy(standartPage_PageLoadingIcon, 1);
    }

    public static boolean waitForElementInvisible(WebElement element, int timeout, boolean expectedClickable) {
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

    public static boolean waitForElementInvisible(WebElement element) {
        return waitForElementInvisible(element, MEDIUM_TIME_OUT, true);
    }

    public static WebElement waitAndFindDisplayedElement(By locator) {
        return waitAndFindDisplayedElement(locator, SHORT_TIME_OUT);
    }

    public static WebElement waitAndFindDisplayedElement(By locator, int TIMEOUT) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            ExtentManager.getCurrentTest().warning("waitAndFindDisplayedElement: Element " + locator.toString() +
                    " never displayed with in timeout of " + TIMEOUT);
        }
        return null;
    }

/*


    private static List<WebElement> getKendoDropDownItems() {
        List<WebElement> dropdown = new ArrayList<>();
        List<WebElement> list = findElements(By.cssSelector(".k-reset"));
        for (WebElement e : list) {
            String hidden = e.getAttribute("aria-hidden");
            if (hidden != null && hidden.equals("false")) {
                return e.findElements(By.cssSelector("li.k-item"));
            }
        }
        return dropdown;
    }

    private static WebElement getElementEqualsWithText(List<WebElement> list, String sText) {
        Iterator<WebElement> iter = list.iterator();
        while (iter.hasNext()) {
            WebElement el = iter.next();
            String sElementText = el.getText();
            if (sElementText.trim().equals(sText)) {
                return el;
            }
        }
        return null;
    }

    public static String getBoxContentSubElementData(String sBoxContentName, String sSubElementDescription) {
        WebElement boxContent = getBoxContentByName(sBoxContentName);
        return getBoxContentSubElementData(boxContent, sSubElementDescription);
    }

    private static String getBoxContentSubElementData(WebElement boxContent, String sSubElementDescription) {
        String sResult = "";
        WebElement eItem = getChildElementContainsText(boxContent, By.cssSelector("span.label"), sSubElementDescription);
        if (eItem != null) {
            WebElement eParent = getParentElement(eItem);
            if (eParent != null) {
                WebElement eSubItem = getChildElement(eParent, By.cssSelector("span[class^='data']"));
                if (eSubItem != null) {
                    sResult = eSubItem.getText();
                }
            }
        }

        return sResult;
    }

    public static WebElement getChildElementContainsText(WebElement parent, By childBy, String text) {
        List<WebElement> list = getChildElements(parent, childBy);
        if (!list.isEmpty()) {
            for (WebElement child : list) {
                try {
                    if (child.getText().contains(text)) {
                        return child;
                    }
                } catch (org.openqa.selenium.NoSuchElementException nse) {
                    eReports.getCurrentTest().warning("getChildElementContainsText: Parent did not contain Child element: " + childBy.toString());
                }

            }
        } else {
            eReports.getCurrentTest().debug("List of elements to search is empty");
        }
        return null;
    }

    public static WebElement getChildElementMatchText(WebElement parent, By childBy, String text) {
        List<WebElement> list = getChildElements(parent, childBy);
        if (!list.isEmpty()) {
            for (WebElement child : list) {
                try {
                    if (child.getText().trim().equals(text)) {
                        return child;
                    }
                } catch (org.openqa.selenium.NoSuchElementException nse) {
                    eReports.getCurrentTest().warning("getChildElementMatchText: Parent did not contain Child element: " + childBy.toString());
                }

            }
        } else {
            eReports.getCurrentTest().debug("List of elements to search is empty");
        }
        return null;
    }

    public static WebElement getElementWithContainsChildElementText(List<WebElement> list, By childBy, String text) {
        Iterator<WebElement> iter = list.iterator();
        WebElement ret = null;
        while (iter.hasNext()) {
            WebElement el = iter.next();
            try {
                List<WebElement> childList = el.findElements(childBy);
                for (WebElement item : childList) {
                    if (item.getText().contains(text)) {
                        return el;
                    }
                }

            } catch (org.openqa.selenium.NoSuchElementException nse) {
            }
        }
        return ret;
    }

    public static WebElement getBoxContentByName(String sBoxContentName) {
        WebElement eResult = null;
        List<WebElement> list = findElements(By.cssSelector("div.box-content"));
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                WebElement eItem = (WebElement) iterator.next();
                if (getChildElementContainsText(eItem, By.cssSelector("h2"), sBoxContentName) != null) {
                    return eItem;
                }
            }

        }
        return eResult;
    }

    public static WebElement getHeader(String sText) {
        WebElement header = null;
        List<WebElement> ls = findElements(By.cssSelector("span.k-link.k-header"));
        WebElement el = getElementWithMatchingText(ls, sText, false);
        if (el != null) {
            header = getParentElement(el);
        }
        return header;
    }

    public static Date getCurrentDate() {
        Date date = null;
        String sDate = null;
        try {
            SimpleDateFormat calendardate = new SimpleDateFormat("EEE MM/dd/yyyy");
            SimpleDateFormat shortdate = new SimpleDateFormat("MM/dd/yyyy");
            WebElement el = findElement(By.cssSelector("span.k-lg-date-format"));
            if (el != null) {
                sDate = el.getText();
                if (sDate.length() > 0) {
                    int iIndex = sDate.indexOf("-");
                    if (iIndex != -1) {
                        sDate = sDate.substring(0, iIndex).trim();
                    }
                    date = calendardate.parse(sDate);
                } else {
                    el = findElement(By.cssSelector("span.k-sm-date-format"));
                    sDate = el.getText();
                    date = shortdate.parse(sDate);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;

    }


    public static WebElement getVisibleElementFromListOfElements(List<WebElement> list) {
        for (WebElement el : list) {
            if (WebDriverFactory.isElementDisplayed(el)) {
                return el;
            }
        }
        return null;
    }

    public static List<String> getWebElementsText(List<WebElement> webElements) {
        ArrayList listText = new ArrayList();
        for (WebElement el : webElements) {
            listText.add(el.getText().trim());
        }
        return listText;
    }

    public static boolean selectItemFromOpsDropDownMenu(WebElement webElement, String sText) {
        boolean bReturn = false;
        try {
            if (webElement != null) {
                List<WebElement> els = webElement.findElements(By.tagName("option"));
                WebElement item = getElementWithMatchingText(els, sText, false);
                if (item != null) {
                    clickElement(item);
                    //waitForPageNotBusy(SHORT_TIME_OUT);
                    bReturn = true;
                } else {
                    eReports.getCurrentTest().warning("The Item is Null: " + sText);
                }
            }
        } catch (StaleElementReferenceException e) {
            eReports.getCurrentTest().warning("Caught Stale Element Exception!!");
            return selectItemFromOpsDropDownMenu(webElement, sText);
        }
        return bReturn;
    }

    public static boolean selectItemFromDropDown(String sItem) {
        boolean bReturn = false;
        try {
            List<WebElement> items = getKendoDropDownItems();
            //WebElement item = getElementWithMatchingStartsWithText(items, sItem);
            WebElement item = getElementEqualsWithText(items, sItem);
            if (item != null) {
                bReturn = clickElement(item);
                bReturn &= waitForElementInvisible(item);
            } else {

            }

        } catch (StaleElementReferenceException e) {
            return selectItemFromDropDown(sItem);
        }
        return bReturn;
    }

    public static boolean selectItemFromFDD(String sItem) {
        boolean bReturn = false;
        List<WebElement> list = driver.findElements(By.cssSelector(".k-reset"));
        Iterator<WebElement> iter = list.iterator();
        while (iter.hasNext() && !bReturn) {
            WebElement els = iter.next();
            String hidden = els.getAttribute("aria-hidden");
            if (hidden != null && hidden.equals("false")) {
                List<WebElement> items = els.findElements(By.cssSelector("li.k-item"));
                WebElement item = getElementWithMatchingText(items, sItem, false);
                if (item != null) {
                    bReturn = clickElement(item);
                } else {

                }
            }
        }
        return bReturn;
    }


    //===== Find methods ===============================================================================================
    public static WebElement findElementFromElement(WebElement element, By locator) {
        try {
            return element.findElement(locator);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            eReports.getCurrentTest().debug("Element with Locator " + locator + " not found");
            return null;
        }
    }

    public static WebElement waitAndFindDisplayedElement(By locator) {
        return waitAndFindDisplayedElement(locator, SHORT_TIME_OUT);
    }

    public static WebElement waitAndFindDisplayedElement(By locator, int TIMEOUT) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            eReports.getCurrentTest().warning("waitAndFindDisplayedElement: Element " + locator.toString() +
                    " never displayed with in timeout of " + TIMEOUT);
        }
        return null;
    }

    //===== Wait methods ===============================================================================================
    public static WebElement waitDisplayedWebElement(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, IMPLICIT_WAIT_TIMEOUT);
        try {
            return wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (TimeoutException e) {
            eReports.getCurrentTest().warning("Element " + webElement.getTagName() +
                    " never displayed with in timeout of " + IMPLICIT_WAIT_TIMEOUT);
        }
        return null;
    }

    public static boolean waitForAjax() {
        int iTimeout = 0;
        boolean ajaxIsComplete = false;
        while (!ajaxIsComplete && iTimeout < LONG_TIME_OUT) {
            ajaxIsComplete = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
            iTimeout++;
            TimeUtils.waitForMillis(50);
        }
        return iTimeout != LONG_TIME_OUT;
    }

    public static boolean waitInvisibleElement(String cssSelector) {
        int iTimeout = 0;
        while (iTimeout < LONG_TIME_OUT) {
            WebElement element = findElement(By.cssSelector(cssSelector));
            if (element == null) {
                return true;
            }
            iTimeout += 0.5;
            TimeUtils.waitForMillis(200);
        }
        return false;
    }

    public static boolean waitForPageNotBusy(String cssIcon, int timeToWaitIcon) {
        boolean bResult = false;
        if (waitForAjax()) {
            WebDriverWait wait = new WebDriverWait(driver, timeToWaitIcon, 50);
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssIcon)));
            } catch (TimeoutException e) {
                bResult = true;
            }
            if (!bResult) {
                List<WebElement> list = driver.findElements(By.cssSelector(cssIcon));
                wait = new WebDriverWait(driver, LONG_TIME_OUT, 50);
                try {
                    wait.until(ExpectedConditions.invisibilityOfAllElements(list));
                    bResult = true;
                } catch (TimeoutException e) {
                    bResult = false;
                }
            }
        }
        return bResult;
    }

    public static boolean waitElementAttributeContains(WebElement webElement, String attributeName, String value) {
        WebDriverWait wait = new WebDriverWait(driver, LONG_TIME_OUT);
        try {
            wait.until(ExpectedConditions.attributeContains(webElement, attributeName, value));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static boolean waitForTextToBePresentInElement(WebElement element, String sText) {
        boolean bReturn = false;
        if (element != null) {
            try {
                WebDriverWait wait = new WebDriverWait(getDriver(), SHORT_TIME_OUT);
                wait.until(ExpectedConditions.textToBePresentInElement(element, sText));
                bReturn = true;
            } catch (TimeoutException e) {
            }
        }
        return bReturn;
    }

    public static boolean waitForAllElementsInvisible(List<WebElement> elementList) {
        return waitForAllElementsInvisible(elementList, MEDIUM_TIME_OUT);
    }

    public static boolean waitForAllElementsInvisible(List<WebElement> elementList, int timeout) {
        boolean bReturn = false;
        if (elementList != null) {
            try {
                WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
                wait.until(ExpectedConditions.invisibilityOfAllElements(elementList));
                bReturn = true;
            } catch (TimeoutException e) {
            }
        }
        return bReturn;
    }

    public static boolean waitForAllElementaVisible(List<WebElement> elementList) {
        boolean bResult;
        bResult = WebDriverFactory.waitForAjax();
        WebDriverWait wait = WebDriverFactory.webDriverWait();
        try {
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(elementList)));
        } catch (TimeoutException e) {
            bResult = false;
        }
        return bResult;
    }

    public static boolean waitForProcessingMessage() {
        boolean bResult = true;
        WebDriverWait wait = WebDriverFactory.webDriverWait();
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#ProcessingMessage1")));
        } catch (TimeoutException e) {
            bResult = false;
        }
        return bResult;
    }



    //===== Alert methods ==============================================================================================
    public static void safeAlertAccept() {
        try {
            String originalWindow = driver.getWindowHandle();
            driver.switchTo().alert().accept();
            driver.switchTo().window(originalWindow);
        } catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                alert.accept();
            } catch (NoAlertPresentException ignored) {
            }
        } catch (NoAlertPresentException ignored) {

        }
    }
   */
}
