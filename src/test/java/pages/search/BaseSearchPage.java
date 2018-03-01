package pages.search;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.CheckBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class BaseSearchPage extends MainPage {
    @FindBy(css = "input[name = 'section'][value='all']")
    public CheckBox allOption;

    @FindBy(css = "input[name = 'section'][value='allJournals']")
    public CheckBox allJournalsOption;

    @FindBy(css = "input[name = 'section'][value='journalsActive']")
    public CheckBox journalsActiveOption;

    @FindBy(css = "input[name = 'section'][value='journalsInActive']")
    public CheckBox journalsInActiveOption;

    @FindBy(css = "input[name = 'section'][value='sampleJournals']")
    public CheckBox sampleJournalsOption;

    @FindBy(css = "input[name = 'section'][value='books']")
    public CheckBox booksOption;

    @FindBy(css = "input[name = 'section'][value='sampleBooks']")
    public CheckBox sampleBooksOption;

    @FindBy(css = "input[name = 'section'][value='series']")
    public CheckBox seriesOption;

    @FindBy(css = "input[name = 'section'][value='seriesAllJournals']")
    public CheckBox seriesAllJournalsOption;

    @FindBy(css = "input[name = 'section'][value='allBooks']")
    public CheckBox allBooksOption;

    @FindBy(css = "input[src *= 'search_button.gif']")
    public Button searchButton;

    //====== Constructor ==============================
    public BaseSearchPage() {
        super(true);
    }
    public BaseSearchPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    //====== Get Methods ===============
    public String getSelectedOption() {
        WebElement webElement = WebDriverFactory.findElement(By.cssSelector("input[name='section'][checked='checked']"));
        if (webElement != null) {
            return webElement.getAttribute("value");
        }
        return "";
    }
}
