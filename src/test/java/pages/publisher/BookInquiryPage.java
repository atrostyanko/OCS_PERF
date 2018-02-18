package pages.publisher;

import com.webtestsbase.BasePage;

public class BookInquiryPage extends BasePage {

    //====== Constructor ==============================
    public BookInquiryPage() {
        super(true);
    }
    public BookInquiryPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return true;
    }
}
