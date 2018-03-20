package pages.search;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.CheckBox;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.journal.JournalInquiryPage;
import pages.publisher.BookInquiryPage;
import pages.publisher.PublisherInquiryPage;

public class PublisherSearchPage extends BaseSearchPage {
    @FindBy(css = "input[name = 'section'][value='publBooksJournals']")
    public CheckBox allPublishersOption;

    @FindBy(name = "publisherName")
    public TextInput publisherName;

    @FindBy(name = "publisherNo")
    public TextInput publisherNo;

    @FindBy(name = "publisherAddress")
    public TextInput publisherAddress;

    @Override
    public void openPage() {
        /*
        clickSearch();
        clickSubMenu("Publishers");
        */
        String subURL = "Business/MainSearch/prompt.jsp?_psegment=1&beginsWith=1";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return searchButton.isDisplayed() && allPublishersOption.isDisplayed();
    }

    //===== Set methods ================================================================================================
    public boolean setValue(SearchFields field, String value) {
        TextInput textInput = null;
        switch (field.value()) {
            case "publisherName":
                textInput = publisherName;
                break;
            case "publisherNo":
                textInput = publisherNo;
                break;
            case "publisherAddress":
                textInput = publisherAddress;
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
                case "publBooksJournals":
                    oReturn = new PublisherInquiryPage(false);
                    break;
                case "publJournals":
                    oReturn = new PublisherInquiryPage(false);
                    break;
                case "publBooks":
                    oReturn = new PublisherInquiryPage(false);
                    break;
                case "publSampleJournals":
                    oReturn = new PublisherInquiryPage(false);
                    break;
                case "publCoverJournals":
                    oReturn = new PublisherInquiryPage(false);
                    break;
                case "publSampleBooks":
                    oReturn = new PublisherInquiryPage(false);
                    break;
                case "publCoverBooks":
                    oReturn = new PublisherInquiryPage(false);
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
        AllPublishers("publBooksJournals"),
        JournalPublishers("publJournals"),
        BookPublishers("publBooks"),
        SampleJournalPublishers("publSampleJournals"),
        CoveredJournalPublishers("publCoverJournals"),
        SampleBookPublishers("publSampleBooks"),
        CoveredBookPublishers("publCoverBooks");

        private String value;

        SearchOptions(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
    public enum SearchFields {
        PublName("publisherName"),
        PublNumber("publisherNo"),
        Address("publisherAddress");

        private String value;

        SearchFields(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

