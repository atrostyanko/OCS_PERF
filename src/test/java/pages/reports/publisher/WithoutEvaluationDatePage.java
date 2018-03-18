package pages.reports.publisher;

import com.webtestsbase.commonElements.elements.Label;
import org.openqa.selenium.support.FindBy;
import pages.reports.BaseReportsPage;

public class WithoutEvaluationDatePage extends BaseReportsPage {
    @FindBy (xpath = ".//nobr[contains(text() ,'DAILY Reports for')]" +
            "[contains(text(), 'SAMPLES WITHOUT EVALUATION DATE')]")
    public Label reportTitle;

    //====== Constructor ==============================
    public WithoutEvaluationDatePage() {
        super(true);
    }
    public WithoutEvaluationDatePage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickMisc();
        clickSubMenu("Reports");
        clickSubMenu("Publisher");
        clickSubMenu("Without evaluation date");
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("OCS Reports") && reportTitle.isDisplayed();
    }

    //===== Click methods ==============================================================================================

}
