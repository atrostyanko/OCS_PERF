package pages.publisher;

public class RoyaltyInquiryPage extends BaseInquiryPage {

    //====== Constructor ==============================
    public RoyaltyInquiryPage() {
        super(true);
    }
    public RoyaltyInquiryPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickPublisher();
        clickSubMenu("Royalty");
        clickSubMenu("Royalty Inquiry");
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Publisher Royalty Inquiry");
    }
}
