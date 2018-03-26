package pages.extraction;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MenuPage;

public class ExtractionSearchPage extends MenuPage {
    @FindBy(name = "prdListNum")
    private WebElement productList;

    @FindBy(name = "yearNum")
    public TextInput yearNum;

    @FindBy(name = "bgnWeekNum")
    public TextInput bgnWeekNum;

    @FindBy(name = "endWeekNum")
    public TextInput endWeekNum;

    @FindBy(name = "submitBtn")
    private Button submitBtn;

    public ExtractionSearchPage() {
        super(true);
    }

    public ExtractionSearchPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        extBtn.click();
    }

    @Override
    public boolean isPageOpened() {
        return WebDriverFactory.getDriver().getTitle().trim().equalsIgnoreCase("Extraction")
                && WebDriverFactory.isElementDisplayed(productList);
    }

    //===== Click methods ==============================================================================================
    public ExtractionConfirmPage clickSubmit() {
        return submitBtn.click()
                ? new ExtractionConfirmPage()
                : null;
    }

    //===== Select methods =============================================================================================
    public boolean selectProduct(String value) {
        return WebDriverFactory.selectByText(productList, value);
    }
}
