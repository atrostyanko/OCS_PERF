package pages.extraction;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;
import pages.MenuPage;

public class ExtractionConfirmPage extends MenuPage {
    @FindBy(name = "extractBtn")
    private Button extractBtn;

    public ExtractionConfirmPage() {
        super(false);
    }

    @Override
    public void openPage() {
        extBtn.click();
    }

    @Override
    public boolean isPageOpened() {
        return WebDriverFactory.getDriver().getTitle().trim().equalsIgnoreCase("Extraction Confirm Page")
                && extractBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public ExtractionResultPage clickExtract() {
        return extractBtn.click()
                ? new ExtractionResultPage()
                : null;
    }

    //===== Select methods =============================================================================================
}
