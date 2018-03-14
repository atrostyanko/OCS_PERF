package pages.publisher;

import pages.issue.BaseIssuePage;

public class ArticleSummaryPage extends BaseIssuePage {
    //====== Constructor ==============================
    public ArticleSummaryPage() {
        super(true);
    }
    public ArticleSummaryPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Article Summary");
    }

}
