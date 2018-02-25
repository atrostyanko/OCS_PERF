package pages.publisher;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PublisherInquiryPage extends BaseInquiryPage {

    //====== Constructor ==============================
    public PublisherInquiryPage() {
        super(true);
    }
    public PublisherInquiryPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickPublisher();
        clickSubMenu("Publisher Inquiry");
    }

    //===== Get methods ================================================================================================

    public String getElementValue(WebElement webElement) {
        return WebDriverFactory.getElementValue(webElement);
    }
    /*
    public static String getElementValue(WebElement webElement) {
        String sReturn = "";
        if (webElement != null) {
            WebElement eParent = WebDriverFactory.getParentUntilTagName(webElement, "tr");
            if (eParent != null) {
                WebElement eChild = WebDriverFactory.getChildElement(eParent, By.cssSelector("span > span.DataValue"));
                if (eChild != null) {
                    return WebDriverFactory.getWebElementText(eChild);
                }
            }
        }
        return sReturn;
    }
    */
}
