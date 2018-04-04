package pages.misc;

import com.webtestsbase.Browser;
import com.webtestsbase.WebDriverFactory;
import pages.MainPage;

public class PasswordChangePage extends MainPage {

    //====== Constructor ==============================
    public PasswordChangePage() {
        super(true);
    }

    public PasswordChangePage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        if (WebDriverFactory.getBrowser() == Browser.PHANTOMJS) {
            String subURL = "PasswordDetails.do";
            WebDriverFactory.navigateTo(subURL);
        } else {
            clickMiscMainMenu();
            clickSubMenu("Password Change");
        }
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Password Change");
    }

    @Override
    public boolean isSearchPageOpened() {
        return isPageOpened();
    }
}
