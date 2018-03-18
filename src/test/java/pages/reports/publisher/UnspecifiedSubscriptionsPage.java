package pages.reports.publisher;

import com.webtestsbase.commonElements.elements.Label;
import org.openqa.selenium.support.FindBy;
import pages.reports.BaseReportsPage;

public class UnspecifiedSubscriptionsPage extends BaseReportsPage {
    @FindBy (xpath = ".//nobr[contains(text() ,'DAILY Reports for')][contains(text(), 'JOURNALS THAT HAVE UNSPECIFIED SUBSCRIPTION ARRANGEMENTS')]")
    public Label reportTitle;

    //====== Constructor ==============================
    public UnspecifiedSubscriptionsPage() {
        super(true);
    }
    public UnspecifiedSubscriptionsPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickMisc();
        clickSubMenu("Reports");
        clickSubMenu("Publisher");
        clickSubMenu("Unspecified subscriptions");
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("OCS Reports") && reportTitle.isDisplayed();
    }

    //===== Click methods ==============================================================================================

}
