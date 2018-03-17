package pages.publisher;

public class EditSamplePublisherPage extends AddPublisherPage {

    //====== Constructor ==============================
    public EditSamplePublisherPage() {
        super(true);
    }
    public EditSamplePublisherPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickPublisher();
        clickSubMenu("Edit");
        clickSubMenu("Edit Sample Publisher");
    }

    @Override
    public boolean isSearchPageOpened() {
        return publisherKey.isDisplayed() && Journal.isDisplayed() && Book.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Edit Sample Publisher");
    }
}
