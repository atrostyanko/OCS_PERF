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
        clickJournal();
        clickSubMenu("Edit");
        clickSubMenu("Edit Series");
    }

    @Override
    public boolean isPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
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
