package pages.reports.publisher;

import com.webtestsbase.WebDriverFactory;
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
        /*
        clickMisc();
        clickSubMenu("Reports");
        clickSubMenu("Publisher");
        clickSubMenu("Without evaluation date");
        */
        String subURL = "Business/Reports/Common/prompt.jsp?key=publsamplnoevaldate";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isPageOpened() {
        return WebDriverFactory.waitElementIsVisible(reportTitle.asWebElement())
                && pageTitle.getText().equals("OCS Reports");
    }

    //===== Click methods ==============================================================================================

}
