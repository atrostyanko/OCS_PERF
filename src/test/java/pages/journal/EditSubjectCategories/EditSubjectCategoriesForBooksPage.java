package pages.journal.EditSubjectCategories;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pages.journal.JournalInquiryPage;
import pages.journal.MainJournalPage;

public class EditSubjectCategoriesForBooksPage extends MainJournalPage {
    @FindBy (name = "addButton")
    public Button addButton;

    //====== Constructor ==============================
    public EditSubjectCategoriesForBooksPage() {
        super(true);
    }
    public EditSubjectCategoriesForBooksPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickJournal();
        clickSubMenu("Edit Subject Categories");
        clickSubMenu("For Books");
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
