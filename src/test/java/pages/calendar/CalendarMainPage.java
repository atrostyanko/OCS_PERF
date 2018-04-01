package pages.calendar;

import com.webtestsbase.BasePage;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.Label;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarMainPage extends BasePage {
    @FindBy (name = "frbody")
    private WebElement frameBody;

    @FindBy (name = "frmenu")
    private WebElement frameMenu;

    @FindBy(css = "h2")
    private Label openIndicator;

    //=== Menu
    @FindBy(linkText = "Edit Calendar")
    private WebElement editCalendarLink;

    //=== Calendar Elements
    @FindBy(css = "input[name='date']")
    private Button startDateCheckbox;

    @FindBy(css = "a[href='/Calendar/jsp/isical/logout.jsp']")
    private Button logoffButton;

    public CalendarMainPage() {
        super(false);
    }

    public CalendarMainPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return selectBodyFrame() && openIndicator.getText().equalsIgnoreCase("ISIDB CALENDAR EDITOR");
    }

    //===== Click methods ==============================================================================================
    public boolean selectMenuFrame() {
        return WebDriverFactory.switchToFrame("frmenu");
    }
    public boolean selectBodyFrame() {
        return WebDriverFactory.switchToFrame("frbody");
    }
    public boolean clickEditCalendarLink() {
        selectMenuFrame();
        return WebDriverFactory.clickElement(editCalendarLink);
    }
    public boolean logout() {
        selectMenuFrame();
        return logoffButton.click();
    }
}
