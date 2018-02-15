package tests.publisher;

import com.reporting.ExtentManager;
import pages.publisher.PublisherInquiryPage;
import tests.OCS_Test;

import java.util.Properties;

public class PublisherInquiryTest {
    public static ExtentManager eReports = OCS_Test.eReports;
    public static Properties prop = OCS_Test.prop;

    public void publisherInquiryTest() {
        String publisherKey = prop.getProperty("PublisherKey");

        ExtentManager.createNode("PUBLISHER -> Publisher Inquiry Page.", "Verify Publisher Inquiry Page.");

        PublisherInquiryPage publisherInquiryPage = new PublisherInquiryPage();
        ExtentManager.compareNotNULL(publisherInquiryPage, "Open 'PUBLISHER -> Publisher Inquiry' page.");

        ExtentManager.compareTrue(publisherInquiryPage.setPublisherKey(publisherKey), "Set Publisher Key to " + publisherKey);
        ExtentManager.compareTrue(publisherInquiryPage.clickSubmit(), "Click 'Submit' button.");

        ExtentManager.compareTrue(publisherInquiryPage.clickJournalListTab(), "Open 'Journal List' tab.");
    }
}
