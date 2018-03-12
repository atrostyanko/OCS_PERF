package pages.search;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.CheckBox;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.journal.JournalInquiryPage;
import pages.publisher.BookInquiryPage;

public class PublicationsSearchPage extends BaseSearchPage {
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


    @FindBy(name = "jrnlSeqNo")
    public TextInput journalSequenceNo;

    @FindBy(name = "issnNo")
    public TextInput issnNo;

    @FindBy(name = "isbnNo")
    public TextInput isbnNo;

    @FindBy(name = "fullTitle")
    public TextInput fullTitle;

    @FindBy(name = "title29")
    public TextInput title29;

    @FindBy(name = "title20")
    public TextInput title20;

    @FindBy(name = "title11")
    public TextInput title11;

    @FindBy(name = "isoTitle")
    public TextInput isoTitle;

    @Override
    public void openPage() {
        clickSearch();
        clickSubMenu("Publications");
    }

    @Override
    public boolean isSearchPageOpened() {
        return searchButton.isDisplayed() && allOption.isDisplayed();
    }

    //===== Set methods ================================================================================================
    public boolean setValue(SearchFields field, String value) {
        TextInput textInput = null;
        switch (field.value()) {
            case "jrnlSeqNo":
                textInput = journalSequenceNo;
                break;
            case "issnNo":
                textInput = issnNo;
                break;
            case "isbnNo":
                textInput = isbnNo;
                break;
            case "fullTitle":
                textInput = fullTitle;
                break;
            case "title29":
                textInput = title29;
                break;
            case "title20":
                textInput = title20;
                break;
            case "title11":
                textInput = title11;
                break;
            case "isoTitle":
                textInput = isoTitle;
                break;
        }
        return textInput != null
                && textInput.setText(value);
    }

    //===== Click methods ==============================================================================================
    public Object clickSearchButton(SearchOptions option) {
        Object oReturn = null;
        if (searchButton.click()) {
            switch (option.value()) {
                case "all":
                    oReturn = new JournalInquiryPage(false);
                    break;
                case "allJournals":
                    oReturn = new JournalInquiryPage(false);
                    break;
                case "journalsActive":
                    oReturn = new JournalInquiryPage(false);
                    break;
                case "journalsInActive":
                    oReturn = new JournalInquiryPage(false);
                    break;
                case "sampleJournals":
                    oReturn = new JournalInquiryPage(false);
                    break;
                case "books":
                    oReturn = new BookInquiryPage(false);
                    break;
                case "sampleBooks":
                    oReturn = new BookInquiryPage(false);
                    break;
                case "series":
                    oReturn = new JournalInquiryPage(false);
                    break;
                case "seriesAllJournals":
                    oReturn = new JournalInquiryPage(false);
                    break;
                case "allBooks":
                        oReturn = new BookInquiryPage(false);
                    break;
            }

        }
        return oReturn;
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
        JournalSequence("jrnlSeqNo"),
        ISSN("issnNo"),
        ISBN("isbnNo"),
        FullTitle("fullTitle"),
        Title29("title29"),
        Title20("title20"),
        Title11("title11"),
        ISOTitle("isoTitle");

        private String value;

        SearchFields(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

