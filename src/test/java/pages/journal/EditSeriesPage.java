package pages.journal;

import com.webtestsbase.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSeriesPage extends MainJournalPage {
    @FindBy(xpath = ".//span[contains(text(), 'Serie Seq. #')]")
    public WebElement SerieSeq;

    //====== Constructor ==============================
    public EditSeriesPage() {
        super(true);
    }
    public EditSeriesPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickJournal();
        clickSubMenu("Edit");
        clickSubMenu("Edit Series");
        */
        String subURL = "Business/Journal/Edit/prompt_series_edit.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Editing a Series");
    }

    //===== Click methods ==============================================================================================
    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitElementIsVisible(SerieSeq);
        }
        return false;
    }
    public JournalInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new JournalInquiryPage(false)
                : null;
    }
}
