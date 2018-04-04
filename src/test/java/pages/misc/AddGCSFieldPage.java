package pages.misc;

import com.webtestsbase.Browser;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class AddGCSFieldPage extends MainPage {
    @FindBy(css = "input[value='Add']")
    public Button addButton;

    //====== Constructor ==============================
    public AddGCSFieldPage() {
        super(true);
    }

    public AddGCSFieldPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        if (WebDriverFactory.getBrowser() == Browser.PHANTOMJS) {
            String subURL = "Business/Misc/Admin/AddGcsField/gcs_fields_section.jsp";
            WebDriverFactory.navigateTo(subURL);
        } else {
            clickMiscMainMenu();
            clickSubMenu("Admin");
            clickSubMenu("Add GCS Field");
        }
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Add GCS Field")
                && addButton.isDisplayed();
    }

    @Override
    public boolean isSearchPageOpened() {
        return isPageOpened();
    }
}
