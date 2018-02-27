package pages.issue;

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
        clickIssue();
        clickSubMenu("Label Reprint");
    }

    @Override
    public boolean isPageOpened() {
        return submitPrintButton.isDisplayed() && pageTitle.getText().equals("Issue Label Reprint");
    }
}
