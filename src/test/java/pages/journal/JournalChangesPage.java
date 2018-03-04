package pages.journal;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class JournalChangesPage extends BaseJournalInquiryPage {
    @FindBy(css = "div.IndentLevel1")
    public List<WebElement> actionsList;

    @FindBy(xpath = ".//span[contains(text(), 'Notes')]")
    public Label actionPerformedNotes;

    @FindBy(xpath = ".//li[contains(text(), 'Notes information has been sucessfully updated.')]")
    public Label updateMessage;

    //====== Constructor ==============================
    public JournalChangesPage() {
        super(true);
    }
    public JournalChangesPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Journal Changes");
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Journal Changes");
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Changes");
        }
        return false;
    }

    //===== Get methods ================================================================================================
    public String getElementValue(WebElement webElement) {
        return WebDriverFactory.getElementValue(webElement);
    }

    //===== Get methods ================================================================================================
    public boolean isMessageDisplayed(String message) {
        return WebDriverFactory.waitAndFindDisplayedElement(By.xpath(".//li[contains(text(), '" + message + "')]")) != null;
    }
}
