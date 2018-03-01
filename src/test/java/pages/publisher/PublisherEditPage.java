package pages.publisher;

public class PublisherEditPage extends MainPublisherPage {
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

    //===== Click methods ==============================================================================================
    public PublisherInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new PublisherInquiryPage(false)
                : null;
    }
}
