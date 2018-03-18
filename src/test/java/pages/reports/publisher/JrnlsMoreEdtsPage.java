package pages.reports.publisher;

import com.webtestsbase.commonElements.elements.Label;
import org.openqa.selenium.support.FindBy;
import pages.reports.BaseReportsPage;

public class JrnlsMoreEdtsPage extends BaseReportsPage {
    @FindBy(xpath = ".//nobr[contains(text() ,'DAILY Reports for')][contains(text(), 'JOURNALS COVERED BY 3 OR MORE CC EDITIONS')]")
    public Label reportTitle;

    //====== Constructor ==============================
    public JrnlsMoreEdtsPage() {
        super(true);
    }
    public JrnlsMoreEdtsPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickMisc();
        clickSubMenu("Reports");
        clickSubMenu("Publisher");
        clickSubMenu("Jrnls by 3 or more edts");
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("OCS Reports") && reportTitle.isDisplayed();
    }

    //===== Click methods ==============================================================================================

}
