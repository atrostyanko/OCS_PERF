package pages.publisher;

import com.webtestsbase.WebDriverFactory;

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
        /*
        clickPublisher();
        clickSubMenu("List of Journals");
        */
        String subURL = "Business/Publisher/JournalList/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return publisherKey.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Publisher Journal List");
    }
}
