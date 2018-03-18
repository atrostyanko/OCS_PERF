package pages.issue;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.FindBy;

public class EditIssuePage extends BaseIssuePage {
    @FindBy(name = "coverDate")
    public TextInput coverDate;

    //====== Constructor ==============================
    public EditIssuePage() {
        super(true);
    }
    public EditIssuePage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickIssue();
        clickSubMenu("Edit Issue");
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Edit Issue Details");
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Edit Issue Details");
        }
        return false;
    }

    public IssueDetailsPage clickConfirmButton() {
        return confirmButton.click()
                ? new IssueDetailsPage(false)
                : null;
    }
}
