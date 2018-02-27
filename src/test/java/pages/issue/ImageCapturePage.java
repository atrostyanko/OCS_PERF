package pages.issue;

import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;

public class ImageCapturePage extends BaseIssuePage {
    //====== Constructor ==============================
    public ImageCapturePage() {
        super(true);
    }
    public ImageCapturePage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickIssue();
        clickSubMenu("Send Issue to Image Capture");
    }

    @Override
    public boolean isPageOpened() {
        return submitChanges.isDisplayed() && pageTitle.getText().equals("Send Issue to Image Capture");
    }
}
