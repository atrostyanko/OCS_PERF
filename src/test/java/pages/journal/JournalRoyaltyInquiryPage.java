package pages.journal;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class JournalRoyaltyInquiryPage extends BaseJournalInquiryPage {
    @FindBy(xpath = ".//span[contains(text(), 'Publisher Number')]")
    public Label publisherNumber;

    //====== Constructor ==============================
    public JournalRoyaltyInquiryPage() {
        super(true);
    }
    public JournalRoyaltyInquiryPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickJournal();
        clickSubMenu("Royalty");
        clickSubMenu("Royalty Inquiry");
        */
        String subURL = "Business/Journal/RoyaltyInquiry/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Journal Royalty Inquiry");
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Royalty Inquiry");
        }
        return false;
    }
}
