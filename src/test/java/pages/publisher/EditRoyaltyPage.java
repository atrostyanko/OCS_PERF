package pages.publisher;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class EditRoyaltyPage extends MainPublisherPage {
    //====== Constructor ==============================
    public EditRoyaltyPage() {
        super(true);
    }
    public EditRoyaltyPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickPublisher();
        clickSubMenu("Royalty");
        clickSubMenu("Edit Royalty");
    }

    @Override
    public boolean isPageOpened() {
        return publisherKey.isDisplayed() && journal.isDisplayed() && book.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public RoyaltyInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new RoyaltyInquiryPage(false)
                : null;
    }
}
