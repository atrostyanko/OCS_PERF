package pages.issue;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;

public class LabelReprintPage extends BaseIssuePage {
    @FindBy(name = "submitPrintButton")
    public Button submitPrintButton;

    //====== Constructor ==============================
    public LabelReprintPage() {
        super(true);
    }
    public LabelReprintPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickIssue();
        clickSubMenu("Label Reprint");
        */
        String subURL = "Business/Issue/LabelReprint/prompt_accession_copies.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return submitPrintButton.isDisplayed() && pageTitle.getText().equals("Issue Label Reprint");
    }
}
