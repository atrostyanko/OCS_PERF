package pages.publisher;

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

    @Override
    public boolean isSearchPageOpened() {
        return publisherKey.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Publisher Journal List");
    }
}
