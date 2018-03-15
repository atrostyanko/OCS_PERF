package pages.search;

import pages.issue.BaseIssuePage;

public class SearchOCSPage extends BaseIssuePage {
    //====== Constructor ==============================
    public SearchOCSPage() {
        super(true);
    }
    public SearchOCSPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Search OCS");
    }

}
