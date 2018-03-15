package pages.search;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.issue.BaseIssuePage;

public class SearchOCSPage extends BaseIssuePage {
    @FindBy(name = "submit")
    public Button goButton;

    //====== Constructor ==============================
    public SearchOCSPage() {
        super(true);
    }
    public SearchOCSPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Search OCS");
    }

    //===== Check methods ==============================================================================================
    public boolean isPublNoDisplayed(String publNo) {
        WebElement webElement = WebDriverFactory.findElement(By.cssSelector("a[href*='?publisherKey=" + publNo + "']"));
        return WebDriverFactory.isElementDisplayed(webElement);
    }
    public boolean isSeqNoDisplayed(String seqNo) {
        WebElement webElement = WebDriverFactory.findElement(By.cssSelector("a[href*='?journalSequenceNumber=" + seqNo + "']"));
        return WebDriverFactory.isElementDisplayed(webElement);
    }
    public boolean isFullTitileDisplayed(String fullTitle) {
        WebElement webElement = WebDriverFactory.findElement(By.xpath(".//nobr[contains(text(), '" + fullTitle + "')]"));
        return WebDriverFactory.isElementDisplayed(webElement);
    }
}
