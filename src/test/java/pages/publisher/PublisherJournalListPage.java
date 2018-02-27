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
}
