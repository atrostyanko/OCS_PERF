package pages.publisher;

import com.webtestsbase.commonElements.elements.Label;
import org.openqa.selenium.support.FindBy;

public class PublisherEditPage extends MainPublisherPage {
    @FindBy(xpath = ".//span[contains(text(), 'Publisher Number')]")
    public Label publisherNumber;

    //====== Constructor ==============================
    public PublisherEditPage() {
        super(true);
    }

    public PublisherEditPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickPublisher();
        clickSubMenu("Edit");
        clickSubMenu("Edit Publisher");
    }

    @Override
    public boolean isSearchPageOpened() {
        return publisherKey.isDisplayed() && journal.isDisplayed() && book.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Edit Publisher");
    }

    //===== Click methods ==============================================================================================
    public PublisherInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new PublisherInquiryPage(false)
                : null;
    }
}
