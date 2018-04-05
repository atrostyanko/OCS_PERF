package pages.misc;

import com.webtestsbase.Browser;
import com.webtestsbase.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class EditGCSFieldsPage extends MainPage {
    @FindBy(css = "table#Gridid")
    private WebElement gridid;

    //====== Constructor ==============================
    public EditGCSFieldsPage() {
        super(true);
    }

    public EditGCSFieldsPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        if (webDriverFactory.getBrowser() == Browser.PHANTOMJS) {
            String subURL = "GetEditGcsFields.do";
            webDriverFactory.navigateTo(subURL);
        } else {
            clickMiscMainMenu();
            clickSubMenu("Admin");
            clickSubMenu("Edit GCS_Fields");
        }
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Edit GCS Fields");
    }

    @Override
    public boolean isSearchPageOpened() {
        return isPageOpened() && webDriverFactory.isElementDisplayed(gridid);
    }
}
