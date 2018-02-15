package pages;

import com.webtestsbase.BasePage;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pages.issue.IssueDetailsPage;

import java.util.List;

public abstract class MenuPage extends BasePage {
    //=== Main Menu Sections ===========================================================================================
    @FindBy(xpath = ".//div[.= 'PUBLISHER']")
    @CacheLookup
    private Button publisherMainMenu;

    @FindBy(xpath = ".//div[.= 'JOURNAL']")
    @CacheLookup
    private Button journalMainMenu;

    @FindBy(xpath = ".//div[.= 'ISSUE']")
    @CacheLookup
    private Button issueMainMenu;

    @FindBy(xpath = ".//div[.= 'Conf.']")
    @CacheLookup
    private Button confMainMenu;

    @FindBy(xpath = ".//div[.= 'Misc.']")
    @CacheLookup
    private Button miscMainMenu;

    @FindBy(xpath = ".//div[.= 'Search']")
    @CacheLookup
    private Button searchMainMenu;

    @FindBy(xpath = ".//div[.= 'Logoff']")
    @CacheLookup
    private Button logoffMainMenu;

    //=== Sub Menu Sections ==============
    @FindBy(xpath = ".//div[contains(@style, 'position: absolute; padding: 3px;')]")
    private List<WebElement> subMenuList;

    public MenuPage() {
        super(false);
    }

    public MenuPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    //===== Set methods ================================================================================================
    public boolean clickPublisher() {
        return publisherMainMenu.click();
    }
    public boolean clickJournal() {
        return journalMainMenu.click();
    }
    public boolean clickIssue() {
        return issueMainMenu.click();
    }
    public boolean clickConf() {
        return confMainMenu.click();
    }
    public boolean clickMisc() {
        return miscMainMenu.click();
    }
    public boolean clickSearch() {
        return searchMainMenu.click();
    }
    public boolean clickLogoff() {
        return logoffMainMenu.click();
    }

    public Object clickIssueSubMenu(String sMenu) {
        boolean bResult = false;
        WebElement webElement = WebDriverFactory.getItemContainsText(subMenuList, sMenu);
        if (webElement != null) {
            bResult = WebDriverFactory.clickElement(webElement);
        }
        if (bResult) {
            switch (sMenu) {
                case "Issue Details":
                    return new IssueDetailsPage();
            }
        }
        return null;
    }
}
