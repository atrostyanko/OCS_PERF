package pages.journal.EditSubjectCategories;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.journal.EditCoveredJournalPage;
import pages.journal.JournalInquiryPage;
import pages.journal.MainJournalPage;

import java.util.List;

public class EditSubjectCategoriesForJournalsPage extends MainJournalPage {
    @FindBy (name = "addButton")
    public Button addButton;

    @FindBy (name = "journal_book_inquiry_form")
    private WebElement journal_book_inquiry_form;

    //====== Constructor ==============================
    public EditSubjectCategoriesForJournalsPage() {
        super(true);
    }
    public EditSubjectCategoriesForJournalsPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Edit Subject Categories");
        clickSubMenu("For Journals");
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public JournalInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new JournalInquiryPage(false)
                : null;
    }

    public EditCoveredJournalPage clickConfirmAddingSubjectCategoriesButton() {
        return confirmButton.click()
                ? new EditCoveredJournalPage(false)
                : null;
    }

    public boolean clickAddSubjectCodesButton() {
        return addButton.click() && WebDriverFactory.waitElementIsVisible(confirmButton.asWebElement());
    }

    //===== Set methods ================================================================================================
    public boolean selectSubjectCategory(String productionCode, String category) {
        WebElement webElement = WebDriverFactory.getChildElement(journal_book_inquiry_form, By.linkText(productionCode));
        if (webElement != null) {
            WebElement parent = WebDriverFactory.getParentUntilTagName(webElement, "tr");
            WebElement child = WebDriverFactory.getChildElement(parent, By.linkText(category));
            if (child != null) {
                parent = WebDriverFactory.getParentUntilTagName(child, "tr");
                List<WebElement> list = WebDriverFactory.getChildElements(parent, By.tagName("td"));
                int i = 1;
                while (i <= list.size()) {
                    if (WebDriverFactory.getWebElementText(list.get(i)).equals(category)) {
                        return WebDriverFactory.clickElement(list.get(i - 1));
                    }
                    i++;
                }
            }
        }
        return false;
    }
}
