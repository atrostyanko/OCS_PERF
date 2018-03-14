package pages.search;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.CheckBox;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.issue.IssueDetailsPage;
import pages.publisher.ArticleSummaryPage;
import pages.publisher.PublisherInquiryPage;

public class IssueSearchPage extends BaseSearchPage {
    @FindBy(name = "issueNo")
    public TextInput issueNumber;

    @FindBy(name = "accession")
    public TextInput accession;

    @FindBy(name = "articleNo")
    public TextInput articleNumber;

    @FindBy(name = "pubYear")
    public TextInput pubYear;

    @Override
    public void openPage() {
        clickSearch();
        clickSubMenu("Issues");
    }

    @Override
    public boolean isSearchPageOpened() {
        return searchButton.isDisplayed() && issueNumber.isDisplayed();
    }

    //===== Set methods ================================================================================================
    public boolean setValue(SearchFields field, String value) {
        TextInput textInput = null;
        switch (field.value()) {
            case "issueNumber":
                textInput = issueNumber;
                break;
            case "accession":
                textInput = accession;
                break;
            case "articleNumber":
                textInput = articleNumber;
                break;
            case "pubYear":
                textInput = pubYear;
                break;
        }
        return textInput != null
                && textInput.setText(value);
    }

    //===== Click methods ==============================================================================================
    public Object clickSearchButton(boolean articleSearch) {
        Object oReturn = null;
        if (searchButton.click()) {
            if (articleSearch) {
                oReturn = new ArticleSummaryPage(false);
            } else {
                oReturn = new IssueDetailsPage(false);
            }
        }
        return oReturn;
    }

    //===== Enums ======================================================================================================
    public enum SearchFields {
        DatafactIssueNumber("issueNumber"),
        Accession("accession"),
        ArticleNumber("articleNumber"),
        PubYear("pubYear");

        private String value;

        SearchFields(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

