package pages.publisher;

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
    public boolean isSearchPageOpened() {
        return publisherKey.isDisplayed() && journal.isDisplayed() && book.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Editing Publisher Royalty");
    }

    //===== Click methods ==============================================================================================
    public RoyaltyInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new RoyaltyInquiryPage(false)
                : null;
    }
}
