package pages;

import com.webtestsbase.BasePage;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;

public abstract class MenuPage extends BasePage {
    //=== Main Menu Sections ===========================================================================================
    @FindBy(name = "tocBtn")
    public Button tocBtn;

    @FindBy(name = "inpBtn")
    public Button inpBtn;

    @FindBy(name = "editBtn")
    public Button editBtn;

    @FindBy(name = "extBtn")
    public Button extBtn;

    @FindBy(name = "repBtn")
    public Button repBtn;

    @FindBy(name = "dictBtn")
    public Button dictBtn;

    @FindBy(name = "nncBtn")
    public Button nncBtn;

    @FindBy(css = "[name='logofBtn']")
    public Button logoffMainMenu;

    //=== Constructor ==================================================================================================
    public MenuPage() {
        super(false);
    }

    public MenuPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    //=== Click methods ================================================================================================
    public MainPage clickToc() {
        return tocBtn.click()
                ? new MainPage()
                : null;
    }
}