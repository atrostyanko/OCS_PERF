package pages.reports.publisher;

import com.webtestsbase.commonElements.elements.Label;
import org.openqa.selenium.support.FindBy;
import pages.reports.BaseReportsPage;

public class PublDiscListPage extends BaseReportsPage {
    @FindBy(xpath = ".//nobr[contains(text() ,'DAILY Reports for')][contains(text(), 'PUBL DISC LIST')]")
    public Label reportTitle;

    //====== Constructor ==============================
    public PublDiscListPage() {
        super(true);
    }
    public PublDiscListPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickMisc();
        clickSubMenu("Reports");
        clickSubMenu("Publisher");
        clickSubMenu("Publ disc list");
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("OCS Reports") && reportTitle.isDisplayed();
    }

    //===== Click methods ==============================================================================================

}
