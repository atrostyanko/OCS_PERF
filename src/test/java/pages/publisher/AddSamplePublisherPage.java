package pages.publisher;

public class AddSamplePublisherPage extends AddPublisherPage {
    //====== Constructor ==============================
    public AddSamplePublisherPage() {
        super(true);
    }
    public AddSamplePublisherPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickPublisher();
        clickSubMenu("Edit");
        clickSubMenu("Add Sample Publisher");
    }

    @Override
    public boolean isSearchPageOpened() {
        return submitChanges.isDisplayed();
    }

}
