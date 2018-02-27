package pages.issue;

import com.webtestsbase.WebDriverFactory;
import pages.journal.BaseJournalInquiryPage;

public class ListAllArticlesPage extends BaseIssuePage {
    //====== Constructor ==============================
    public ListAllArticlesPage() {
        super(true);
    }
    public ListAllArticlesPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickIssue();
        clickSubMenu("List All Articles");
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "List of All Articles for an Issue");
        }
        return false;
    }
}
