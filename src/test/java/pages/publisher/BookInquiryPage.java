package pages.publisher;

import com.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookInquiryPage extends BasePage {
    @FindBy(css = ".BackgroundBigHeader td[align='center'] b")
    public WebElement pageTitle;

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
    public boolean isSearchPageOpened() {
        return pageTitle.getText().equals("Book Inquiry");
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Book Inquiry");
    }
}
