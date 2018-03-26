package pages.extraction;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MenuPage;

import java.util.List;

public class ExtractionResultPage extends MenuPage {
    @FindBy(className = "Messages")
    private List<WebElement> extractBtn;

    public ExtractionResultPage() {
        super(false);
    }

    @Override
    public void openPage() {
        extBtn.click();
    }

    @Override
    public boolean isPageOpened() {
        return WebDriverFactory.getDriver().getTitle().trim().equalsIgnoreCase("Extraction Result Page")
                && extractBtn.size() > 0;
    }

    //===== Click methods ==============================================================================================

    //===== Select methods =============================================================================================
}
