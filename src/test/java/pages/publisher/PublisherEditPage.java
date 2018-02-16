package pages.publisher;

import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;

public class PublisherEditPage extends MainPublisherPage {
    @FindBy(css = "[src *= 'Images/submit_changes.gif']")
    private Button submitChanges;

    @FindBy(name = "confirmButton")
    private Button confirmButton;

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
    public boolean isPageOpened() {
        return publisherKey.isDisplayed() && Journal.isDisplayed() && Book.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmitChanges() {
        return submitChanges.click();
    }
    public PublisherInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new PublisherInquiryPage(false)
                : null;
    }
}
