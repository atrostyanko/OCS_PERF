package tests.publisher;

import com.reporting.ExtentManager;
import pages.publisher.*;
import tests.OCS_Test;

import java.util.Properties;

public class PublisherTests {
    public static ExtentManager eReports = OCS_Test.eReports;
    public static Properties prop = OCS_Test.prop;

    String publisherKey = prop.getProperty("PublisherKey");

    public PublisherTests() {
        //ToDo: REMOVE
        //publisherKey = "SAQEF";
    }

    public void publisherInquiryTest() {
        ExtentManager.createNode("PUBLISHER -> Publisher Inquiry Page.", "Verify Publisher Inquiry Page.");

        PublisherInquiryPage publisherInquiryPage = new PublisherInquiryPage();
        ExtentManager.compareNotNULL(publisherInquiryPage, "Open 'PUBLISHER -> Publisher Inquiry' page.");

        ExtentManager.compareTrue(publisherInquiryPage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        ExtentManager.compareTrue(publisherInquiryPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(publisherInquiryPage.clickJournalListTab(),
                "Open 'journal List' tab.");
        ExtentManager.compareTrue(publisherInquiryPage.clickRoyaltyInquiryTab(),
                "Open 'Royalty Inquiry' tab.");
        ExtentManager.compareTrue(publisherInquiryPage.clickJournalsRoyaltyList(),
                "Open 'Journals Royalty List' tab.");
        ExtentManager.compareTrue(publisherInquiryPage.clickPublisherInquiryTab(),
                "Open 'Publisher Inquiry Tab' tab.");
    }

    public void publisherEditPublisherTest() {
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

    public void publisherAddPublisherTest() {
        String publisherName = prop.getProperty("publisherName");
        String publisherAddressStreet = prop.getProperty("publisherAddressStreet");
        String publisherAddressCity = prop.getProperty("publisherAddressCity");
        String publisherAddressCountry = prop.getProperty("publisherAddressCountry");
        String publisherAddressPostcodes = prop.getProperty("publisherAddressPostcodes");

        ExtentManager.createNode("PUBLISHER -> EDIT -> Add Publisher.", "Verify Add Publisher Page.");

        AddPublisherPage addPublisherPage = new AddPublisherPage();
        ExtentManager.compareNotNULL(addPublisherPage, "Open 'PUBLISHER -> EDIT -> Add Publisher page.");

        ExtentManager.compareTrue(addPublisherPage.Book.set(),
                "Set 'Publisher Type' to: book.");
        ExtentManager.compareTrue(addPublisherPage.publisherName.setText(publisherName),
                "Set 'Publisher Name' to: " + publisherName);
        ExtentManager.compareTrue(addPublisherPage.publisherAddressStreet.setText(publisherAddressStreet),
                "Set 'Publisher Address : Street' to: " + publisherAddressStreet);
        ExtentManager.compareTrue(addPublisherPage.publisherAddressCity.setText(publisherAddressCity),
                "Set 'Publisher Address : City' to: " + publisherAddressCity);
        ExtentManager.compareTrue(addPublisherPage.selectCountry(publisherAddressCountry),
                "Set 'Publisher Address : Country' to: " + publisherAddressCountry);
        ExtentManager.compareTrue(addPublisherPage.publisherAddressZip.setText(publisherAddressPostcodes),
                "Set 'Publisher Address : Postcode' to: " + publisherAddressPostcodes);

        ExtentManager.compareTrue(addPublisherPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        PublisherInquiryPage publisherInquiryPage = addPublisherPage.clickConfirmButton();
        ExtentManager.compareNotNULL(publisherInquiryPage,
                "Click 'Confirm' button and verify Publisher Inquiry page is opened.");

    }

    public void publisherAddSamplePublisherTest() {
        String publisherName = prop.getProperty("samplePublisherName");
        String publisherAddressStreet = prop.getProperty("samplePublisherAddressStreet");
        String publisherAddressCity = prop.getProperty("samplePublisherAddressCity");
        String publisherAddressCountry = prop.getProperty("samplePublisherAddressCountry");
        String publisherAddressPostcodes = prop.getProperty("samplePublisherAddressPostcodes");

        ExtentManager.createNode("PUBLISHER -> EDIT -> Add Sample Publisher.", "Verify Add Sample Publisher Page.");

        AddSamplePublisherPage addSamplePublisherPage = new AddSamplePublisherPage();
        ExtentManager.compareNotNULL(addSamplePublisherPage, "Open 'PUBLISHER -> EDIT -> Add Sample Publisher page.");

        ExtentManager.compareTrue(addSamplePublisherPage.Book.set(),
                "Set 'Publisher Type' to: book.");
        ExtentManager.compareTrue(addSamplePublisherPage.publisherName.setText(publisherName),
                "Set 'Publisher Name' to: " + publisherName);
        ExtentManager.compareTrue(addSamplePublisherPage.publisherAddressStreet.setText(publisherAddressStreet),
                "Set 'Publisher Address : Street' to: " + publisherAddressStreet);
        ExtentManager.compareTrue(addSamplePublisherPage.publisherAddressCity.setText(publisherAddressCity),
                "Set 'Publisher Address : City' to: " + publisherAddressCity);
        ExtentManager.compareTrue(addSamplePublisherPage.selectCountry(publisherAddressCountry),
                "Set 'Publisher Address : Country' to: " + publisherAddressCountry);
        ExtentManager.compareTrue(addSamplePublisherPage.publisherAddressZip.setText(publisherAddressPostcodes),
                "Set 'Publisher Address : Postcode' to: " + publisherAddressPostcodes);

        ExtentManager.compareTrue(addSamplePublisherPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        PublisherInquiryPage publisherInquiryPage = addSamplePublisherPage.clickConfirmButton();
        ExtentManager.compareNotNULL(publisherInquiryPage,
                "Click 'Confirm' button and verify Publisher Inquiry page is opened.");

        publisherKey = publisherInquiryPage.getElementValue(publisherInquiryPage.publisherNumber);
    }

    public void publisherEditSamplePublisherTest() {
        String publisherName = prop.getProperty("samplePublisherName_UPD");
        String publisherAddressStreet = prop.getProperty("samplePublisherAddressStreet_UPD");
        String publisherAddressCity = prop.getProperty("samplePublisherAddressCity_UPD");
        String publisherAddressCountry = prop.getProperty("samplePublisherAddressCountry_UPD");
        String publisherAddressPostcodes = prop.getProperty("samplePublisherAddressPostcodes_UPD");

        ExtentManager.createNode("PUBLISHER -> EDIT -> Edit Sample Publisher.", "Verify Edit Sample Publisher Page.");

        EditSamplePublisherPage editSamplePublisherPage = new EditSamplePublisherPage();
        ExtentManager.compareNotNULL(editSamplePublisherPage, "Open 'PUBLISHER -> EDIT -> Edit Sample Publisher page.");

        ExtentManager.compareTrue(editSamplePublisherPage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        ExtentManager.compareTrue(editSamplePublisherPage.Book.set(),
                "Select 'book' option.");
        ExtentManager.compareTrue(editSamplePublisherPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(editSamplePublisherPage.publisherName.setText(publisherName),
                "Set 'Publisher Name' to: " + publisherName);
        ExtentManager.compareTrue(editSamplePublisherPage.publisherAddressStreet.setText(publisherAddressStreet),
                "Set 'Publisher Address : Street' to: " + publisherAddressStreet);
        ExtentManager.compareTrue(editSamplePublisherPage.publisherAddressCity.setText(publisherAddressCity),
                "Set 'Publisher Address : City' to: " + publisherAddressCity);
        ExtentManager.compareTrue(editSamplePublisherPage.selectCountry(publisherAddressCountry),
                "Set 'Publisher Address : Country' to: " + publisherAddressCountry);
        ExtentManager.compareTrue(editSamplePublisherPage.publisherAddressZip.setText(publisherAddressPostcodes),
                "Set 'Publisher Address : Postcode' to: " + publisherAddressPostcodes);

        ExtentManager.compareTrue(editSamplePublisherPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        PublisherInquiryPage publisherInquiryPage = editSamplePublisherPage.clickConfirmButton();
        ExtentManager.compareNotNULL(publisherInquiryPage,
                "Click 'Confirm' button and verify Publisher Inquiry page is opened.");
    }

    public void publisherJournalListTest() {
        ExtentManager.createNode("PUBLISHER -> EDIT -> Edit Publisher.", "Verify Edit Publisher Page.");

        PublisherJournalListPage publisherJournalListPage = new PublisherJournalListPage();
        ExtentManager.compareNotNULL(publisherJournalListPage, "Open 'PUBLISHER -> EDIT -> Edit Publisher page.");

        ExtentManager.compareTrue(publisherJournalListPage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        ExtentManager.compareTrue(publisherJournalListPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(publisherJournalListPage.clickJournalListTab(),
                "Open 'journal List' tab.");
        ExtentManager.compareTrue(publisherJournalListPage.clickRoyaltyInquiryTab(),
                "Open 'Royalty Inquiry' tab.");
        ExtentManager.compareTrue(publisherJournalListPage.clickJournalsRoyaltyList(),
                "Open 'Journals Royalty List' tab.");
        ExtentManager.compareTrue(publisherJournalListPage.clickPublisherInquiryTab(),
                "Open 'Publisher Inquiry Tab' tab.");

    }

    public void publisherRoyaltyInquiryTest() {
        ExtentManager.createNode("PUBLISHER -> Royalty -> Royalty Inquiry.", "Verify Royalty Inquiry Page.");

        RoyaltyInquiryPage royaltyInquiryPage = new RoyaltyInquiryPage();
        ExtentManager.compareNotNULL(royaltyInquiryPage, "Open 'PUBLISHER -> Royalty -> Royalty Inquiry page.");

        ExtentManager.compareTrue(royaltyInquiryPage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        ExtentManager.compareTrue(royaltyInquiryPage.book.set(),
                "Select book option.");
        ExtentManager.compareTrue(royaltyInquiryPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(royaltyInquiryPage.clickJournalListTab(),
                "Open 'journal List' tab.");
        ExtentManager.compareTrue(royaltyInquiryPage.clickRoyaltyInquiryTab(),
                "Open 'Royalty Inquiry' tab.");
        ExtentManager.compareTrue(royaltyInquiryPage.clickJournalsRoyaltyList(),
                "Open 'Journals Royalty List' tab.");
        ExtentManager.compareTrue(royaltyInquiryPage.clickPublisherInquiryTab(),
                "Open 'Publisher Inquiry Tab' tab.");

    }

    public void publisherEditRoyaltyTest() {
        ExtentManager.createNode("PUBLISHER -> Royalty -> Edit Royalty.", "Verify Edit Royalty Page.");

        EditRoyaltyPage editRoyaltyPage = new EditRoyaltyPage();
        ExtentManager.compareNotNULL(editRoyaltyPage, "Open 'PUBLISHER -> Royalty -> Edit Royalty page.");

        ExtentManager.compareTrue(editRoyaltyPage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        ExtentManager.compareTrue(editRoyaltyPage.book.set(),
                "Select book option.");
        ExtentManager.compareTrue(editRoyaltyPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(editRoyaltyPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        RoyaltyInquiryPage royaltyInquiryPage = editRoyaltyPage.clickConfirmButton();
        ExtentManager.compareNotNULL(royaltyInquiryPage,
                "Click 'Confirm' button and verify Royalty Inquiry page is opened.");
    }

    public void publisherListJournalRoyaltiesTest() {
        ExtentManager.createNode("PUBLISHER -> Royalty -> List Journal Royalties.", "Verify List Journal Royalties Page.");

        ListJournalRoyaltiesPage listJournalRoyaltiesPage = new ListJournalRoyaltiesPage();
        ExtentManager.compareNotNULL(listJournalRoyaltiesPage, "Open 'PUBLISHER -> Royalty -> List Journal Royalties page.");

        ExtentManager.compareTrue(listJournalRoyaltiesPage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        ExtentManager.compareTrue(listJournalRoyaltiesPage.book.set(),
                "Select book option.");
        ExtentManager.compareTrue(listJournalRoyaltiesPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(listJournalRoyaltiesPage.clickJournalListTab(),
                "Open 'journal List' tab.");
        ExtentManager.compareTrue(listJournalRoyaltiesPage.clickRoyaltyInquiryTab(),
                "Open 'Royalty Inquiry' tab.");
        ExtentManager.compareTrue(listJournalRoyaltiesPage.clickJournalsRoyaltyList(),
                "Open 'Journals Royalty List' tab.");
        ExtentManager.compareTrue(listJournalRoyaltiesPage.clickPublisherInquiryTab(),
                "Open 'Publisher Inquiry Tab' tab.");

    }

    public void publisherAddSampleBookTest() {
        int randomNum = (int) (Math.random() * 10000);

        String ISBN = prop.getProperty("ISBN");
        String FullTitle = prop.getProperty("FullTitle");
        String PubYear = prop.getProperty("PubYear");
        String authorAddress0 = prop.getProperty("authorAddress0");
        String SampleSource = prop.getProperty("SampleSource");
        String PubContact = prop.getProperty("PubContact");
        String BookDOI = prop.getProperty("BookDOI");

        ExtentManager.createNode("PUBLISHER -> Add Sample book.", "Verify Add Sample book Page.");

        AddSampleBookPage addSampleBookPage = new AddSampleBookPage();
        ExtentManager.compareNotNULL(addSampleBookPage, "Open 'PUBLISHER -> Add Sample book page.");

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
                "Set 'book DOI' value: " + BookDOI);

        ExtentManager.compareTrue(addSampleBookPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        ExtentManager.compareNotNULL(addSampleBookPage.clickConfirmButton(),
                "Click 'Confirm' button and verify that entity was created.");

    }

    public void publisherAddSampleJournalTest() {
        int randomNum = (int) (Math.random() * 10000);

        String publisherKey = prop.getProperty("PublisherKey");
        String issn = prop.getProperty("journal_issn");
        String isbn = prop.getProperty("journal_isbn");
        String fullTitle = prop.getProperty("journal_fullTitle");
        String country = prop.getProperty("journal_country");
        String frequency = prop.getProperty("journal_frequency");
        String sampleEvalResult = prop.getProperty("journal_sampleEvalResult");

        AddSampleJournalPage addSampleJournalPage = new AddSampleJournalPage();
        ExtentManager.compareNotNULL(addSampleJournalPage, "Open 'PUBLISHER -> Add Sample Journal page.");

        ExtentManager.compareTrue(addSampleJournalPage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        ExtentManager.compareTrue(addSampleJournalPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(addSampleJournalPage.issn.setText(issn),
                "Set 'ISSN' to: " + issn);
        ExtentManager.compareTrue(addSampleJournalPage.isbn.setText(isbn),
                "Set 'ISBN' to: " + issn);
        ExtentManager.compareTrue(addSampleJournalPage.fullTitle.setText(fullTitle + " - " + randomNum),
                "Set 'Series Title' to: " + fullTitle + " - " + randomNum);
        ExtentManager.compareTrue(addSampleJournalPage.selectCountry(country),
                "Set 'Country' to: " + country);
        ExtentManager.compareTrue(addSampleJournalPage.selectFrequency(frequency),
                "Set 'Frequency' to: " + frequency);
        ExtentManager.compareTrue(addSampleJournalPage.selectSampleEvalResult(sampleEvalResult),
                "Set 'Sample Eval Result' to: " + sampleEvalResult);

        ExtentManager.compareTrue(addSampleJournalPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        ExtentManager.compareNotNULL(addSampleJournalPage.clickConfirmButton(),
                "Click 'Confirm' button and verify that entity was created.");
    }

    public void publisherAddNewSerieTest() {
        int randomNum = (int) (Math.random() * 10000);

        String issn = prop.getProperty("issn");
        String title11 = prop.getProperty("title11");
        String title20 = prop.getProperty("title20");
        String title29 = prop.getProperty("title29");
        String fullTitle = prop.getProperty("fullTitle");
        String country = prop.getProperty("country");
        String frequency = prop.getProperty("frequency");

        AddNewSeriePage addNewSeriePage = new AddNewSeriePage();
        ExtentManager.compareNotNULL(addNewSeriePage, "Open 'PUBLISHER -> Add Sample book page.");

        ExtentManager.compareTrue(addNewSeriePage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        ExtentManager.compareTrue(addNewSeriePage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(addNewSeriePage.issn.setText(issn),
                "Set 'ISSN' to: " + issn);
        ExtentManager.compareTrue(addNewSeriePage.title11.setText(title11 + "-" + randomNum),
                "Set 'Title 11' to: " + title11);
        ExtentManager.compareTrue(addNewSeriePage.title20.setText(title20),
                "Set 'Title 20' to: " + title20);
        ExtentManager.compareTrue(addNewSeriePage.title29.setText(title29 + "-" + randomNum),
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
