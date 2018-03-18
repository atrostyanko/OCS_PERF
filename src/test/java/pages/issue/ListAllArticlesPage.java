package pages.issue;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Label;
import org.openqa.selenium.support.FindBy;

public class ListAllArticlesPage extends BaseIssuePage {
    @FindBy(xpath = ".//span[contains(text(), 'DF Issueno')]")
    public Label issueNoLabel;

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
    public boolean isPageOpened() {
        return pageTitle.getText().equals("List of All Articles for an Issue");
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "List of All Articles for an Issue");
        }
        return false;
    }
}
