package pages;

import com.webtestsbase.BasePage;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pages.issue.IssueDetailsPage;
import pages.publisher.PublisherInquiryPage;

import java.util.List;

public abstract class MenuPage extends BasePage {
    //=== Main Menu Sections ===========================================================================================
    @FindBy(xpath = ".//div[.= 'PUBLISHER']")
    private Button publisherMainMenu;

    @FindBy(xpath = ".//div[.= 'JOURNAL']")
    private Button journalMainMenu;

    @FindBy(xpath = ".//div[.= 'ISSUE']")
    private Button issueMainMenu;

    @FindBy(xpath = ".//div[.= 'Conf.']")
    private Button confMainMenu;

    @FindBy(xpath = ".//div[.= 'Misc.']")
    private Button miscMainMenu;

    @FindBy(xpath = ".//div[.= 'Search']")
    private Button searchMainMenu;

    @FindBy(xpath = ".//div[.= 'Logoff']")
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

    public void clickSubMenu(String sMenu) {
        WebElement webElement = WebDriverFactory.getItemContainsText(subMenuList, sMenu);
        if (webElement != null) {
            WebDriverFactory.clickElement(webElement);
        }
    }
}
