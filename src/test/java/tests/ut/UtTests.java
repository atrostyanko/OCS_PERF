package tests.ut;

import com.reporting.ExtentManager;
import com.webtestsbase.WebDriverFactory;
import pages.request.*;
import pages.ut.AddDeleteUTPage;
import pages.ut.UTDetailsPage;

import java.util.Properties;

public class UtTests {
    private ExtentManager eReports;
    private Properties prop;
    private WebDriverFactory webDriverFactory;

    public UtTests(WebDriverFactory webDriverFactory, ExtentManager eReports, Properties prop) {
        this.webDriverFactory = webDriverFactory;
        this.eReports = eReports;
        this.prop = prop;
    }

    public void UtDetails_BVT() {
        String corrID = prop.getProperty("utDetailsPage_corrID");

        eReports.createNode("UT -> UT Details page.", "Verify the UT Details page.");

        UTDetailsPage utDetailsPage = new UTDetailsPage();
        if (eReports.compareNotNULL(utDetailsPage, "Open 'UT -> UT Details' page.")) {

            eReports.compareTrue(utDetailsPage.corrId.setText(corrID),
                    "Set Corr ID to " + corrID);
            eReports.compareTrue(utDetailsPage.clickSubmit(),
                    "Click 'Submit' button and verify that UT Details are displayed.");
        }
    }

    public void AddDeleteUT_BVT() {
        String corrID = prop.getProperty("addDeleteUTPage_corrID");

        eReports.createNode("UT -> Add/Delete UTs page.", "Verify the Add/Delete UTs page.");

        AddDeleteUTPage addDeleteUTPage = new AddDeleteUTPage(webDriverFactory, eReports);
        if (eReports.compareNotNULL(addDeleteUTPage, "Open 'UT -> Add/Delete UTs' page.")) {

            eReports.compareTrue(addDeleteUTPage.corrId.setText(corrID),
                    "Set Corr ID to " + corrID);
            eReports.compareTrue(addDeleteUTPage.clickSubmit(),
                    "Click 'Submit' button and verify that the Correction is displayed.");
        }
    }
}
