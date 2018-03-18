package pages.conference;

import com.webtestsbase.commonElements.elements.Label;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.FindBy;

public class LinkSampleBooksPage extends BaseConferencePage {
    @FindBy(name = "conferenceNumber")
    public TextInput conferenceNumber;

    @FindBy(name = "journalSeqNumber")
    public TextInput bookNumber;

    @FindBy(xpath = ".//b[contains(text(), 'Linking Sample Books to a Conference')]")
    private Label pageTitle;

    //====== Constructor ==============================
    public LinkSampleBooksPage() {
        super(true);
    }

    public LinkSampleBooksPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickConf();
        clickSubMenu("Link Sample Books");
    }

    @Override
    public boolean isSearchPageOpened() {
        return conferenceNumber.isDisplayed() && bookNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.isDisplayed();
    }
}
