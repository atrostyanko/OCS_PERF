package pages.issue;

import com.webtestsbase.WebDriverFactory;

public class ViewBiblioPage extends BaseIssuePage {
    //====== Constructor ==============================
    public ViewBiblioPage() {
        super(true);
    }
    public ViewBiblioPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickIssue();
        clickSubMenu("Article");
        clickSubMenu("View Biblio");
        */
        String subURL = "Business/Article/Summary/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Article Summary");
        }
        return false;
    }
}
