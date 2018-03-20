package pages.publisher;

import com.webtestsbase.WebDriverFactory;

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
        /*
        clickPublisher();
        clickSubMenu("Royalty");
        clickSubMenu("List Journal Royalties");
        */
        String subURL = "Business/Publisher/JournalsRoyalty/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Publisher Royalty Inquiry");
    }
}
