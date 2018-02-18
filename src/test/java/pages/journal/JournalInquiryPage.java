package pages.journal;

import com.webtestsbase.BasePage;
import pages.MainPage;

public class JournalInquiryPage extends MainPage {
    //====== Constructor ==============================
    public JournalInquiryPage() {
        super(true);
    }
    public JournalInquiryPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickPublisher();
        clickSubMenu("Add a Serie");
    }

    @Override
    public boolean isPageOpened() {
        return true;
    }

}
