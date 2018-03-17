package pages.journal.EditProductCodes;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.journal.EditSubjectCategories.EditSubjectCategoriesForJournalsPage;
import pages.journal.JournalInquiryPage;
import pages.journal.MainJournalPage;

import java.util.List;

public class EditProductCodesForJournalsPage extends MainJournalPage {
    @FindBy (name = "addButton")
    public Button addButton;

    @FindBy (css = "a.ProductCodesAdd")
    private List<WebElement> addProductCodesList;

    //====== Constructor ==============================
    public EditProductCodesForJournalsPage() {
        super(true);
    }
    public EditProductCodesForJournalsPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Edit Product Codes");
        clickSubMenu("For Journals");
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Editing Product Codes");
    }

    //===== Click methods ==============================================================================================
    public JournalInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new JournalInquiryPage(false)
                : null;
    }

    public EditSubjectCategoriesForJournalsPage clickConfirmAddingProductCodesButton() {
        return confirmButton.click()
                ? new EditSubjectCategoriesForJournalsPage(false)
                : null;
    }

    public boolean clickAddProductCodesButton() {
        return addButton.click() && WebDriverFactory.waitElementIsVisible(confirmButton.asWebElement());
    }

    //===== Set methods ================================================================================================
    public boolean addProductionCode(String name) {
        WebElement webElement = WebDriverFactory.getElementWithMatchingText(addProductCodesList, name);
        if (webElement != null) {
            WebElement parent = WebDriverFactory.getParentUntilTagName(webElement, "tr");
            List<WebElement> list = WebDriverFactory.getChildElements(parent, By.tagName("td"));
            int i = 1;
            while (i <= list.size()) {
                if (WebDriverFactory.getWebElementText(list.get(i)).equals(name)) {
                    return WebDriverFactory.clickElement(list.get(i - 1));
                }
            }
        }
        return false;
    }
}
