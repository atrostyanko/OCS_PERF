package tests.publisher;

import com.reporting.ExtentManager;
import pages.publisher.PublisherEditPage;
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

        ExtentManager.compareTrue(publisherInquiryPage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        ExtentManager.compareTrue(publisherInquiryPage.clickSubmit(),
                "Click 'Submit' button.");
/*
        ExtentManager.compareTrue(publisherInquiryPage.clickJournalListTab(),
                "Open 'Journal List' tab.");
        ExtentManager.compareTrue(publisherInquiryPage.clickRoyaltyInquiryTab(),
                "Open 'Royalty Inquiry' tab.");
        ExtentManager.compareTrue(publisherInquiryPage.clickJournalsRoyaltyList(),
                "Open 'Journals Royalty List' tab.");
        ExtentManager.compareTrue(publisherInquiryPage.clickPublisherInquiryTab(),
                "Open 'Publisher Inquiry Tab' tab.");
*/
        ExtentManager.compareTrue(publisherInquiryPage.journalListTab.click(),
                "Open 'Journal List' tab.");
        ExtentManager.compareTrue(publisherInquiryPage.royaltyInquiryTab.click(),
                "Open 'Royalty Inquiry' tab.");
        ExtentManager.compareTrue(publisherInquiryPage.journalsRoyaltyList.click(),
                "Open 'Journals Royalty List' tab.");
        ExtentManager.compareTrue(publisherInquiryPage.publisherInquiryTab.click(),
                "Open 'Publisher Inquiry Tab' tab.");
    }
    public void publisherEditPublisherTest() {
        String publisherKey = prop.getProperty("PublisherKey");

        ExtentManager.createNode("PUBLISHER -> EDIT -> Edit Publisher.", "Verify Edit Publisher Page.");

        PublisherEditPage publisherEditPage = new PublisherEditPage();
        ExtentManager.compareNotNULL(publisherEditPage, "Open 'PUBLISHER -> EDIT -> Edit Publisher page.");

        ExtentManager.compareTrue(publisherEditPage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        ExtentManager.compareTrue(publisherEditPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(publisherEditPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        PublisherInquiryPage publisherInquiryPage = publisherEditPage.clickConfirmButton();
        ExtentManager.compareNotNULL(publisherInquiryPage,
                "Click 'Confirm' button and verify Publisher Inquiry page is opened.");
    }
}
