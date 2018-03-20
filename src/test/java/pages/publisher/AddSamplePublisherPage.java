package pages.publisher;

import com.webtestsbase.WebDriverFactory;

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
        /*
        clickPublisher();
        clickSubMenu("Edit");
        clickSubMenu("Add Sample Publisher");
        */
        String subURL = "PublisherEditRetrieve.do?publisherKey=&action=ADD_SAMPLE_PUBLISHER";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return isPageOpened();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Add Sample Publisher");
    }
}
