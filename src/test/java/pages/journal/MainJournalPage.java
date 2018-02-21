package pages.journal;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.CheckBox;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public abstract class MainJournalPage extends MainPage {

    @FindBy(name = "journalSequenceNumber")
    public TextInput journalSequenceNumber;

    @FindBy(css = "[src *= 'Images/submit_changes.gif']")
    public Button submitChanges;

    @FindBy(name = "confirmButton")
    public Button confirmButton;

    @FindBy (xpath = ".//span[contains(text(), 'Jrnl / Book Seq. #')]")
    public WebElement jrnlBookSeq;

    //====== Constructor ==============================
    public MainJournalPage() {
        super(true);
    }

    public MainJournalPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    //===== Set methods ================================================================================================
    public boolean setJournalSequence(String sValue) {
        return journalSequenceNumber.setText(sValue);
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitElementIsVisible(jrnlBookSeq);
        }
        return false;
    }
    public boolean clickSubmitChanges() {
        return submitChanges.click();
    }
}
