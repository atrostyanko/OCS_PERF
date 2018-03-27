package pages;

import com.reporting.ExtentManager;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.FindBy;

public class TocPage extends MenuPage {
    @FindBy(name = "submBtn")
    private Button openIndicator;

    public TocPage() {
        super(true);
    }

    public TocPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        if (WebDriverFactory.getDriver() instanceof PhantomJSDriver){
            String subURL = "Servlet?AcnVal=ET8DK";
            WebDriverFactory.navigateTo(subURL);
        } else {
            tocBtn.click();
            WebDriverFactory.getDriver().switchTo().alert().sendKeys("ET8DK");
            WebDriverFactory.getDriver().switchTo().alert().accept();
        }
    }

    @Override
    public boolean isPageOpened() {
        return WebDriverFactory.getDriver().getTitle().trim().equalsIgnoreCase("The Toc Page")
                && openIndicator.isDisplayed();
    }

    //===== Click methods ==============================================================================================
}
