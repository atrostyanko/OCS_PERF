package pages.misc;

import com.webtestsbase.Browser;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class EditGCSLimitsPage extends MainPage {

    //====== Constructor ==============================
    public EditGCSLimitsPage() {
        super(true);
    }

    public EditGCSLimitsPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        if (webDriverFactory.getBrowser() == Browser.PHANTOMJS) {
            String subURL = "GetEditGcsLimits.do";
            webDriverFactory.navigateTo(subURL);
        } else {
            clickMiscMainMenu();
            clickSubMenu("Admin");
            clickSubMenu("Edit GCS_Limits");
        }
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Edit GCS Limits");
    }

    @Override
    public boolean isSearchPageOpened() {
        return isPageOpened();
    }
}
