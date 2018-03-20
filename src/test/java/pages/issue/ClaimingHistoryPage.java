package pages.issue;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.FindBy;

public class ClaimingHistoryPage extends BaseIssuePage {
    @FindBy(name = "publNo")
    public TextInput publNo;

    @FindBy(name = "publSequenceNumber")
    public TextInput publSequenceNumber;

    @FindBy(name = "submit")
    public Button submitBtn;

    @FindBy(name = "button")
    public Button button;

    //====== Constructor ==============================
    public ClaimingHistoryPage() {
        super(true);
    }
    public ClaimingHistoryPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickIssue();
        clickSubMenu("Claiming");
        clickSubMenu("History");
        */
        String subURL = "Business/Issue/Claiming/History/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return submitBtn.isDisplayed()
                && publNo.isDisplayed()
                && publSequenceNumber.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Claiming History");
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Claiming History")
                    && WebDriverFactory.waitElementIsVisible(button.asWebElement());
        }
        return false;
    }

}
