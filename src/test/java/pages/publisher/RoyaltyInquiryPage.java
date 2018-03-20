package pages.publisher;

import com.webtestsbase.WebDriverFactory;

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
        /*
        clickPublisher();
        clickSubMenu("Royalty");
        clickSubMenu("Royalty Inquiry");
        */
        String subURL = "Business/Publisher/RoyaltyInquiry/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Publisher Royalty Inquiry");
    }
}
