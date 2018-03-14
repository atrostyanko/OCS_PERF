package pages.publisher;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pages.search.PublisherSearchPage;

public class PublisherInquiryPage extends BaseInquiryPage {

    //====== Constructor ==============================
    public PublisherInquiryPage() {
        super(true);
    }
    public PublisherInquiryPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickPublisher();
        clickSubMenu("Publisher Inquiry");
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Publisher Inquiry");
    }

    //===== Get methods ================================================================================================
    public String getElementValue(WebElement webElement) {
        return WebDriverFactory.getElementValue(webElement);
    }

    //===== Check methods ==============================================================================================
    public boolean checkValue(PublisherSearchPage.SearchFields field, String value) {
        String fieldValue = "";
        switch (field.value()) {
            case "publisherName":
                fieldValue = WebDriverFactory.getElementValue(publisherName);
                break;
            case "publisherNo":
                fieldValue = WebDriverFactory.getElementValue(publisherNumber);
                break;
            case "publisherAddress":
                fieldValue = WebDriverFactory.getElementValue(street);
                break;
        }
        return fieldValue.equals(value);
    }
}
