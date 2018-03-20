package pages.conference;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.FindBy;

public class LinkArticlesPage extends BaseConferencePage {
    @FindBy (name="conferenceNumber")
    public TextInput conferenceNumber;

    @FindBy (name="accession")
    public TextInput accession;

    @FindBy (name="submit")
    public TextInput submitBtn;

    //====== Constructor ==============================
    public LinkArticlesPage() {
        super(true);
    }
    public LinkArticlesPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickConf();
        clickSubMenu("Link Articles");
        */
        String subURL = "Business/Conference/LinkArticles/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return conferenceNumber.isDisplayed() && accession.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Linking Articles to a Conference");
    }
}
