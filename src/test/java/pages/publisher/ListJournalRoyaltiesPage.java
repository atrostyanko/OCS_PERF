package pages.publisher;

public class ListJournalRoyaltiesPage extends BaseInquiryPage {

    //====== Constructor ==============================
    public ListJournalRoyaltiesPage() {
        super(true);
    }
    public ListJournalRoyaltiesPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickPublisher();
        clickSubMenu("Royalty");
        clickSubMenu("List Journal Royalties");
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Publisher Royalty Inquiry");
    }
}
