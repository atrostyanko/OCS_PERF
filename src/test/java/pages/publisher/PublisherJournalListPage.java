package pages.publisher;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PublisherJournalListPage extends BaseInquiryPage {

    //====== Constructor ==============================
    public PublisherJournalListPage() {
        super(true);
    }
    public PublisherJournalListPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickPublisher();
        clickSubMenu("List of Journals");
    }
}
