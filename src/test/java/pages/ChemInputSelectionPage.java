package pages;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.FindBy;

public class ChemInputSelectionPage extends MenuPage {
    String parentHandle;

    @FindBy(name = "accessionNo")
    public TextInput accessionNo;

    public ChemInputSelectionPage() {
        super(true);
    }

    public ChemInputSelectionPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        parentHandle = WebDriverFactory.getDriver().getWindowHandle();
        inpBtn.click();
        for(String childHandle : WebDriverFactory.getDriver().getWindowHandles()){
            if (!childHandle.equals(parentHandle)){
                WebDriverFactory.getDriver().switchTo().window(childHandle);
            }
        }
    }

    @Override
    public boolean isPageOpened() {
        return WebDriverFactory.getDriver().getTitle().trim().equalsIgnoreCase("Chem Input Selection Page")
                && accessionNo.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public void closeWindow() {
        WebDriverFactory.getDriver().close();
        WebDriverFactory.getDriver().switchTo().window(parentHandle);
    }
}
