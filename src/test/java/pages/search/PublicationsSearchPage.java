package pages.search;

import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.FindBy;
import pages.journal.JournalInquiryPage;
import pages.publisher.BookInquiryPage;

public class PublicationsSearchPage extends BaseSearchPage {
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
}

