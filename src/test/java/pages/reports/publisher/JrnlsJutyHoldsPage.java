package pages.reports.publisher;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Label;
import org.openqa.selenium.support.FindBy;
import pages.reports.BaseReportsPage;

public class JrnlsJutyHoldsPage extends BaseReportsPage {
    @FindBy(xpath = ".//nobr[contains(text() ,'DAILY Reports for')][contains(text(), 'JOURNALS ON JUTY HOLDS FOR ALL PRODUCT CODES')]")
    public Label reportTitle;

    //====== Constructor ==============================
    public JrnlsJutyHoldsPage() {
        super(true);
    }
    public JrnlsJutyHoldsPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickMisc();
        clickSubMenu("Reports");
        clickSubMenu("Publisher");
        clickSubMenu("Jrnls on juty holds");
        */
        String subURL = "Business/Reports/Common/prompt.jsp?key=publjutyhold";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isPageOpened() {
        return WebDriverFactory.waitElementIsVisible(reportTitle.asWebElement())
                && pageTitle.getText().equals("OCS Reports");
    }

    //===== Click methods ==============================================================================================

}
