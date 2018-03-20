package pages.journal.EditSubjectCategories;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pages.journal.JournalInquiryPage;
import pages.journal.MainJournalPage;

public class EditSubjectCategoriesForSampleBooksPage extends MainJournalPage {
    @FindBy (name = "addButton")
    public Button addButton;

    //====== Constructor ==============================
    public EditSubjectCategoriesForSampleBooksPage() {
        super(true);
    }
    public EditSubjectCategoriesForSampleBooksPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickJournal();
        clickSubMenu("Edit Subject Categories");
        clickSubMenu("For Sample Books");
        */
        String subURL = "Business/Journal/ProductCodes/Edit/prompt_subject_categories.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Editing Subject Categories");
    }

    //===== Click methods ==============================================================================================
    public JournalInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new JournalInquiryPage(false)
                : null;
    }

    public boolean clickConfirmAddingSubjectCategoriesButton() {
        return confirmButton.click() && WebDriverFactory.waitElementIsVisible(addButton.asWebElement());
    }

    public boolean clickAddProductCodesButton() {
        return addButton.click() && WebDriverFactory.waitElementIsVisible(confirmButton.asWebElement());
    }

    //===== Get methods ================================================================================================
    public boolean isMessageDisplayed(String message) {
        return WebDriverFactory.waitAndFindDisplayedElement(By.xpath(".//li[contains(text(), '" + message + "')]")) != null;
    }
}
