package pages.misc;

import com.webtestsbase.Browser;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class StatisticsByCorrectionIdPage extends MainPage {
    @FindBy(name = "corrId")
    public TextInput corrId;

    @FindBy(id = "Gridid")
    public WebElement grid;

    //====== Constructor ==============================
    public StatisticsByCorrectionIdPage() {
        super(true);
    }

    public StatisticsByCorrectionIdPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        if (webDriverFactory.getBrowser() == Browser.PHANTOMJS) {
            String subURL = "Business/Misc/Statistics/ByCorrId/prompt.jsp";
            webDriverFactory.navigateTo(subURL);
        } else {
            clickMiscMainMenu();
            clickSubMenu("Statistics");
            clickSubMenu("By Corr Id");
        }
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Statistics By Correction Id");
    }

    @Override
    public boolean isSearchPageOpened() {
        return isPageOpened() && corrId.isDisplayed() && submitBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        return submitBtn.click()
                && webDriverFactory.waitElementIsVisible(grid)
                && isPageOpened();
    }

    //===== Check methods ==============================================================================================
}
