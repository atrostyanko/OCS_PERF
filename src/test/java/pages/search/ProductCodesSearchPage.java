package pages.search;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.CheckBox;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.journal.JournalInquiryPage;
import pages.publisher.BookInquiryPage;

public class ProductCodesSearchPage extends BaseSearchPage {
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


    @FindBy(name = "productCode")
    public WebElement productCode;

    @FindBy(name = "subjectCategory")
    public WebElement subjectCategory;

    @Override
    public void openPage() {
        clickSearch();
        clickSubMenu("Product Codes");
    }

    @Override
    public boolean isSearchPageOpened() {
        return searchButton.isDisplayed() && allOption.isDisplayed();
    }

    //===== Set methods ================================================================================================
    public boolean setValue(SearchFields field, String value) {
        WebElement webElement = null;
        switch (field.value()) {
            case "productCode":
                webElement = productCode;
                break;
            case "subjectCategory":
                webElement = subjectCategory;
                break;
        }
        if (webElement != null) {
            Select dropDown = new Select(webElement);
            dropDown.selectByVisibleText(value);
            return WebDriverFactory.getWebElementText(dropDown.getFirstSelectedOption()).equals(value);
        }
        return false;
    }

    //===== Click methods ==============================================================================================
    public SearchOCSPage clickSearchButton(SearchOptions option) {
        return searchButton.click()
                ? new SearchOCSPage(false)
                : null;
    }

    //===== Select methods =============================================================================================
    public boolean selectSearchOption(SearchOptions option) {
        WebElement webElement = WebDriverFactory.waitAndFindDisplayedElement(By.cssSelector("input[name = 'section'][value='" + option.value() + "']"));
        return webElement != null
                && WebDriverFactory.clickElement(webElement);
    }

    //===== Enums ======================================================================================================
    public enum SearchOptions {
        ALL("all"),
        JOURNALS("allJournals"),
        ACTIVEJOURNALS("journalsActive"),
        INACTIVEJOURNALS("journalsInActive"),
        SAMPLEJOURNALS("sampleJournals"),
        BOOKS("books"),
        SAMPLEBOOKS("sampleBooks"),
        SERIES("series"),
        ALLJOURNALS("seriesAllJournals"),
        ALLBOOKS("allBooks");

        private String value;

        SearchOptions(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
    public enum SearchFields {
        ProductCode("productCode"),
        SubjectCategory("subjectCategory");

        private String value;

        SearchFields(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

