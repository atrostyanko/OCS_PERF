package pages;

import com.reporting.ExtentManager;
import com.webtestsbase.BasePage;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class MenuPage extends BasePage {
    //=== Main Menu Sections ===========================================================================================
    @FindBy(xpath = ".//div[.= 'REQUEST']")
    private Button requestMainMenu;

    @FindBy(xpath = ".//div[.= 'UT']")
    private Button utMainMenu;

    @FindBy(xpath = ".//div[.= 'UT Sequences']")
    private Button utSequencesMainMenu;

    @FindBy(xpath = ".//div[.= 'Misc.']")
    private Button miscMainMenu;

    @FindBy(xpath = ".//div[.= 'Logoff']")
    private Button logoffMainMenu;

    //=== Sub Menu Sections ==============
    @FindBy(xpath = ".//div[contains(@style, 'position: absolute; padding: 3px;')]")
    private List<WebElement> subMenuList;

    public MenuPage(WebDriverFactory webDriverFactory, ExtentManager extentManager) {
        super(webDriverFactory, extentManager, false);
    }

    public MenuPage(WebDriverFactory webDriverFactory, ExtentManager extentManager, boolean openFromMenu) {
        super(webDriverFactory, extentManager, openFromMenu);
    }

    //===== Set methods ================================================================================================
    public boolean clickRequestMainMenu() {
        return requestMainMenu.click();
    }

    public boolean clickUTMainMenu() {
        return utMainMenu.click();
    }

    public boolean clickUtSequencesMainMenu() {
        return utSequencesMainMenu.click();
    }

    public boolean clickMiscMainMenu() {
        return miscMainMenu.click();
    }

    public boolean clickLogoff() {
        webDriverFactory.navigateTo("logoff.do");
        return true;
    }

    public void clickSubMenu(String sMenu) {
        WebElement webElement = webDriverFactory.getElementWithMatchingText(subMenuList, sMenu);
        if (webElement != null) {
            webDriverFactory.clickElement(webElement);
        }
    }
}