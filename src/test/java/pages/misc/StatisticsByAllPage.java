package pages.misc;

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
    public StatisticsByAllPage() {
        super(true);
    }

    public StatisticsByAllPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        if (WebDriverFactory.getBrowser() == Browser.PHANTOMJS) {
            String subURL = "StatsAll.do";
            WebDriverFactory.navigateTo(subURL);
        } else {
            clickMiscMainMenu();
            clickSubMenu("Statistics");
            clickSubMenu("All");
        }
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Statistics By All")
                && WebDriverFactory.isElementDisplayed(resultsGrid);
    }

    @Override
    public boolean isSearchPageOpened() {
        return isPageOpened();
    }

    //===== Click methods ==============================================================================================
    //===== Check methods ==============================================================================================
}
