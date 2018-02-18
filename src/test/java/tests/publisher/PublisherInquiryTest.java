package tests.publisher;

import com.reporting.ExtentManager;
import pages.publisher.*;
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

        ExtentManager.compareTrue(publisherInquiryPage.clickJournalListTab(),
                "Open 'Journal List' tab.");
        ExtentManager.compareTrue(publisherInquiryPage.clickRoyaltyInquiryTab(),
                "Open 'Royalty Inquiry' tab.");
        ExtentManager.compareTrue(publisherInquiryPage.clickJournalsRoyaltyList(),
                "Open 'Journals Royalty List' tab.");
        ExtentManager.compareTrue(publisherInquiryPage.clickPublisherInquiryTab(),
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
    public void publisherJournalListTest() {
        String publisherKey = prop.getProperty("PublisherKey");

        ExtentManager.createNode("PUBLISHER -> EDIT -> Edit Publisher.", "Verify Edit Publisher Page.");

        PublisherJournalListPage publisherJournalListPage = new PublisherJournalListPage();
        ExtentManager.compareNotNULL(publisherJournalListPage, "Open 'PUBLISHER -> EDIT -> Edit Publisher page.");

        ExtentManager.compareTrue(publisherJournalListPage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        ExtentManager.compareTrue(publisherJournalListPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(publisherJournalListPage.clickJournalListTab(),
                "Open 'Journal List' tab.");
        ExtentManager.compareTrue(publisherJournalListPage.clickRoyaltyInquiryTab(),
                "Open 'Royalty Inquiry' tab.");
        ExtentManager.compareTrue(publisherJournalListPage.clickJournalsRoyaltyList(),
                "Open 'Journals Royalty List' tab.");
        ExtentManager.compareTrue(publisherJournalListPage.clickPublisherInquiryTab(),
                "Open 'Publisher Inquiry Tab' tab.");

    }
    public void publisherAddSampleBookTest() {
        int randomNum = (int) (Math.random() * 10000);

        String publisherKey = prop.getProperty("PublisherKey");
        String ISBN = prop.getProperty("ISBN");
        String FullTitle = prop.getProperty("FullTitle");
        String PubYear = prop.getProperty("PubYear");
        String authorAddress0 = prop.getProperty("authorAddress0");
        String SampleSource = prop.getProperty("SampleSource");
        String PubContact = prop.getProperty("PubContact");
        String BookDOI = prop.getProperty("BookDOI");

        ExtentManager.createNode("PUBLISHER -> Add Sample Book.", "Verify Add Sample Book Page.");

        AddSampleBookPage addSampleBookPage = new AddSampleBookPage();
        ExtentManager.compareNotNULL(addSampleBookPage, "Open 'PUBLISHER -> Add Sample Book page.");

        ExtentManager.compareTrue(addSampleBookPage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        ExtentManager.compareTrue(addSampleBookPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(addSampleBookPage.requestedOrdered.set(),
                "Set 'Requested/Ordered' option.");
        ExtentManager.compareTrue(addSampleBookPage.isbn.setText(ISBN),
                "Set 'ISBN' value: " + ISBN);
        ExtentManager.compareTrue(addSampleBookPage.fullTitle.setText(FullTitle + " - " + randomNum),
                "Set 'Full Title' value: " + FullTitle);
        ExtentManager.compareTrue(addSampleBookPage.pubYear.setText(PubYear),
                "Set 'PubYear' value: " + PubYear);
        ExtentManager.compareTrue(addSampleBookPage.authorAddress0.setText(authorAddress0),
                "Set 'Author Address' value: " + authorAddress0);
        ExtentManager.compareTrue(addSampleBookPage.sampleSource.setText(SampleSource),
                "Set 'Sample Source' value: " + SampleSource);
        ExtentManager.compareTrue(addSampleBookPage.pubContact.setText(PubContact),
                "Set 'Sample Source' value: " + SampleSource);
        ExtentManager.compareTrue(addSampleBookPage.bookDOI.setText(BookDOI),
                "Set 'Book DOI' value: " + BookDOI);

        ExtentManager.compareTrue(addSampleBookPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        ExtentManager.compareNotNULL(addSampleBookPage.clickConfirmButton(),
                "Click 'Confirm' button and verify that entity was created.");

    }
    public void publisherAddNewSerieTest() {
        int randomNum = (int) (Math.random() * 10000);

        String publisherKey = prop.getProperty("PublisherKey");
        String issn = prop.getProperty("issn");
        String title11 = prop.getProperty("title11");
        String title20 = prop.getProperty("title20");
        String title29 = prop.getProperty("title29");
        String fullTitle = prop.getProperty("fullTitle");
        String country = prop.getProperty("country");
        String frequency = prop.getProperty("frequency");

        AddNewSeriePage addNewSeriePage = new AddNewSeriePage();
        ExtentManager.compareNotNULL(addNewSeriePage, "Open 'PUBLISHER -> Add Sample Book page.");

        ExtentManager.compareTrue(addNewSeriePage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        ExtentManager.compareTrue(addNewSeriePage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(addNewSeriePage.issn.setText(issn),
                "Set 'ISSN' to: " + issn);
        ExtentManager.compareTrue(addNewSeriePage.title11.setText(title11),
                "Set 'Title 11' to: " + title11);
        ExtentManager.compareTrue(addNewSeriePage.title20.setText(title20),
                "Set 'Title 20' to: " + title20);
        ExtentManager.compareTrue(addNewSeriePage.title29.setText(title29),
                "Set 'Title 29' to: " + title29);
        ExtentManager.compareTrue(addNewSeriePage.fullTitle.setText(fullTitle + " - " + randomNum),
                "Set 'Series Title' to: " + fullTitle + " - " + randomNum);
        ExtentManager.compareTrue(addNewSeriePage.selectCountry(country),
                "Set 'Country' to: " + country);
        ExtentManager.compareTrue(addNewSeriePage.selectFrequency(frequency),
                "Set 'Frequency' to: " + frequency);

        ExtentManager.compareTrue(addNewSeriePage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        ExtentManager.compareNotNULL(addNewSeriePage.clickConfirmButton(),
                "Click 'Confirm' button and verify that entity was created.");

    }
}
