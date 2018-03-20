package pages.issue;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;

public class PrintJournalLabelsPage extends BaseIssuePage {
    @FindBy(name = "submitPrintButton")
    public Button submitPrintButton;

    //====== Constructor ==============================
    public PrintJournalLabelsPage() {
        super(true);
    }
    public PrintJournalLabelsPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickIssue();
        clickSubMenu("Re-Print Journal Labels");
        */
        String subURL = "Business/Journal/LabelPrint/prompt_accession_from_to.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return submitPrintButton.isDisplayed() && pageTitle.getText().equals("Print Journal Labels");
    }
}
