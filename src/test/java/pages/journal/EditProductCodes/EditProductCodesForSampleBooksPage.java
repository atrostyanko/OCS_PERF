package pages.journal.EditProductCodes;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;
import pages.journal.JournalInquiryPage;
import pages.journal.MainJournalPage;
import pages.publisher.BookInquiryPage;

public class EditProductCodesForSampleBooksPage extends MainJournalPage {
    @FindBy (name = "addButton")
    public Button addButton;

    //====== Constructor ==============================
    public EditProductCodesForSampleBooksPage() {
        super(true);
    }
    public EditProductCodesForSampleBooksPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Edit Product Codes");
        clickSubMenu("For Sample Books");
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Editing Product Codes");
    }

    //===== Click methods ==============================================================================================
    public EditProductCodesForSampleBooksPage clickConfirmButton() {
        return confirmButton.click()
                ? new EditProductCodesForSampleBooksPage(false)
                : null;
    }

    public boolean clickConfirmAddingProductCodesButton() {
        return confirmButton.click() && WebDriverFactory.waitElementIsVisible(addButton.asWebElement());
    }

    public boolean clickConfirmAddingButton() {
        return confirmButton.click() && WebDriverFactory.waitElementIsVisible(submitChanges.asWebElement());
    }

    public boolean clickAddProductCodesButton() {
        return addButton.click() && WebDriverFactory.waitElementIsVisible(confirmButton.asWebElement());
    }

    public boolean clickAddSubjectCategoriesButton() {
        return addButton.click() && WebDriverFactory.waitElementIsVisible(confirmButton.asWebElement());
    }
}
