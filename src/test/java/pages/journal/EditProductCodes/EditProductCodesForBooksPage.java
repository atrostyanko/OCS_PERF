package pages.journal.EditProductCodes;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;
import pages.journal.JournalInquiryPage;
import pages.journal.MainJournalPage;

public class EditProductCodesForBooksPage extends MainJournalPage {
    @FindBy (name = "addButton")
    public Button addButton;

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
    public boolean isPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public JournalInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new JournalInquiryPage(false)
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
