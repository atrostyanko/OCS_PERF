package pages.misc;

import com.reporting.ExtentManager;
import com.webtestsbase.Browser;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class StatisticsByAllPage extends MainPage {
    @FindBy(css = "table#Gridid")
    private WebElement resultsGrid;

    //====== Constructor ==============================
    public StatisticsByAllPage(WebDriverFactory webDriverFactory, ExtentManager eReport) {
        super(webDriverFactory, eReport, true);
    }

    public StatisticsByAllPage(WebDriverFactory webDriverFactory, ExtentManager eReport, boolean openFromMenu) {
        super(webDriverFactory, eReport, openFromMenu);
    }

    @Override
    public void openPage() {
        if (webDriverFactory.getBrowser() == Browser.PHANTOMJS) {
            String subURL = "StatsAll.do";
            webDriverFactory.navigateTo(subURL);
        } else {
            clickMiscMainMenu();
            clickSubMenu("Statistics");
            clickSubMenu("All");
        }
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Statistics By All")
                && webDriverFactory.isElementDisplayed(resultsGrid);
    }

    @Override
    public boolean isSearchPageOpened() {
        return isPageOpened();
    }

    //===== Click methods ==============================================================================================
    //===== Check methods ==============================================================================================
}
