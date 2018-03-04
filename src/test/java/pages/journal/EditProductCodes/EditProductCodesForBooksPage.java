package pages.journal.EditProductCodes;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.Label;
import org.openqa.selenium.support.FindBy;
import pages.journal.EditSubjectCategories.EditSubjectCategoriesForBooksPage;
import pages.journal.JournalInquiryPage;
import pages.journal.MainJournalPage;
import pages.publisher.BookInquiryPage;

public class EditProductCodesForBooksPage extends MainJournalPage {
    @FindBy (name = "addButton")
    public Button addButton;

    @FindBy (xpath = ".//li[contains(text(), 'Product code(s) :  has/have been successfully added.')]")
    public Label updateMessage;

    //====== Constructor ==============================
    public EditProductCodesForBooksPage() {
        super(true);
    }
    public EditProductCodesForBooksPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Edit Product Codes");
        clickSubMenu("For Books");
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public EditSubjectCategoriesForBooksPage clickConfirmButton() {
        return confirmButton.click()
                ? new EditSubjectCategoriesForBooksPage(false)
                : null;
    }

    public boolean clickConfirmAddingProductCodesButton() {
        return confirmButton.click() && WebDriverFactory.waitElementIsVisible(addButton.asWebElement());
    }

    public boolean clickAddProductCodesButton() {
        return addButton.click() && WebDriverFactory.waitElementIsVisible(confirmButton.asWebElement());
    }
}
