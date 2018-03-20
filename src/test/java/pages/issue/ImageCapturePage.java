package pages.issue;

import com.webtestsbase.WebDriverFactory;

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
        /*
        clickIssue();
        clickSubMenu("Send Issue to Image Capture");
        */
        String subURL = "Business/Issue/PreProcessing/pre_processing.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return submitChanges.isDisplayed() && pageTitle.getText().equals("Send Issue to Image Capture");
    }
}
