package tests.publisher;

import com.reporting.ExtentManager;
import pages.publisher.*;

import java.util.Properties;

public class PublisherTests {
    private ExtentManager eReports;
    private Properties prop;

    String publisherKey = "";
    String samplePublisherKey = "";

    public PublisherTests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
        this.publisherKey = prop.getProperty("PublisherKey");
        this.samplePublisherKey = prop.getProperty("SamplePublisherKey");
    }

    public void publisherInquiryTest() {
        eReports.createNode("PUBLISHER -> Publisher Inquiry Page.", "Verify Publisher Inquiry Page.");

        PublisherInquiryPage publisherInquiryPage = new PublisherInquiryPage();
        eReports.compareNotNULL(publisherInquiryPage, "Open 'PUBLISHER -> Publisher Inquiry' page.");

        eReports.compareTrue(publisherInquiryPage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        eReports.compareTrue(publisherInquiryPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(publisherInquiryPage.clickJournalListTab(),
                "Open 'journal List' tab.");
        eReports.compareTrue(publisherInquiryPage.clickRoyaltyInquiryTab(),
                "Open 'Royalty Inquiry' tab.");
        eReports.compareTrue(publisherInquiryPage.clickJournalsRoyaltyList(),
                "Open 'Journals Royalty List' tab.");
        eReports.compareTrue(publisherInquiryPage.clickPublisherInquiryTab(),
                "Open 'Publisher Inquiry Tab' tab.");
    }
    public void publisherInquiryTest_BVT() {
        eReports.createNode("PUBLISHER -> Publisher Inquiry Page.", "Verify Publisher Inquiry Page.");

        PublisherInquiryPage publisherInquiryPage = new PublisherInquiryPage();
        if (eReports.compareNotNULL(publisherInquiryPage, "Open 'PUBLISHER -> Publisher Inquiry' page.")) {

            eReports.compareTrue(publisherInquiryPage.setPublisherKey(publisherKey),
                    "Set Publisher Key to " + publisherKey);
            eReports.compareTrue(publisherInquiryPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(publisherInquiryPage.publisherNumber.isDisplayed() && publisherInquiryPage.isPageOpened(),
                    "Verify that Publisher Inquiry page is displayed.");
        }
    }

    public void publisherEditPublisherTest() {
        eReports.createNode("PUBLISHER -> EDIT -> Edit Publisher.", "Verify Edit Publisher Page.");

        PublisherEditPage publisherEditPage = new PublisherEditPage();
        eReports.compareNotNULL(publisherEditPage, "Open 'PUBLISHER -> EDIT -> Edit Publisher page.");

        eReports.compareTrue(publisherEditPage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        eReports.compareTrue(publisherEditPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(publisherEditPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        PublisherInquiryPage publisherInquiryPage = publisherEditPage.clickConfirmButton();
        eReports.compareNotNULL(publisherInquiryPage,
                "Click 'Confirm' button and verify Publisher Inquiry page is opened.");
    }
    public void publisherEditPublisherTest_BVT() {
        eReports.createNode("PUBLISHER -> EDIT -> Edit Publisher.", "Verify Edit Publisher Page.");

        PublisherEditPage publisherEditPage = new PublisherEditPage();
        if (eReports.compareNotNULL(publisherEditPage, "Open 'PUBLISHER -> EDIT -> Edit Publisher page.")) {

            eReports.compareTrue(publisherEditPage.setPublisherKey(publisherKey),
                    "Set Publisher Key to " + publisherKey);
            eReports.compareTrue(publisherEditPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(publisherEditPage.publisherNumber.isDisplayed() && publisherEditPage.isPageOpened(),
                    "Verify that Edit Publisher page is displayed.");
        }
    }

    public void publisherAddPublisherTest() {
        String publisherName = prop.getProperty("publisherName");
        String publisherAddressStreet = prop.getProperty("publisherAddressStreet");
        String publisherAddressCity = prop.getProperty("publisherAddressCity");
        String publisherAddressCountry = prop.getProperty("publisherAddressCountry");
        String publisherAddressPostcodes = prop.getProperty("publisherAddressPostcodes");

        eReports.createNode("PUBLISHER -> EDIT -> Add Publisher.", "Verify Add Publisher Page.");

        AddPublisherPage addPublisherPage = new AddPublisherPage();
        eReports.compareNotNULL(addPublisherPage, "Open 'PUBLISHER -> EDIT -> Add Publisher page.");

        eReports.compareTrue(addPublisherPage.Book.set(),
                "Set 'Publisher Type' to: book.");
        eReports.compareTrue(addPublisherPage.publisherName.setText(publisherName),
                "Set 'Publisher Name' to: " + publisherName);
        eReports.compareTrue(addPublisherPage.publisherAddressStreet.setText(publisherAddressStreet),
                "Set 'Publisher Address : Street' to: " + publisherAddressStreet);
        eReports.compareTrue(addPublisherPage.publisherAddressCity.setText(publisherAddressCity),
                "Set 'Publisher Address : City' to: " + publisherAddressCity);
        eReports.compareTrue(addPublisherPage.selectCountry(publisherAddressCountry),
                "Set 'Publisher Address : Country' to: " + publisherAddressCountry);
        eReports.compareTrue(addPublisherPage.publisherAddressZip.setText(publisherAddressPostcodes),
                "Set 'Publisher Address : Postcode' to: " + publisherAddressPostcodes);

        eReports.compareTrue(addPublisherPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        PublisherInquiryPage publisherInquiryPage = addPublisherPage.clickConfirmButton();
        eReports.compareNotNULL(publisherInquiryPage,
                "Click 'Confirm' button and verify Publisher Inquiry page is opened.");

    }
    public void publisherAddPublisherTest_BVT() {
        eReports.createNode("PUBLISHER -> EDIT -> Add Publisher.", "Verify Add Publisher Page.");

        AddPublisherPage addPublisherPage = new AddPublisherPage();
        if (eReports.compareNotNULL(addPublisherPage, "Open 'PUBLISHER -> EDIT -> Add Publisher page.")) {
            eReports.compareTrue(addPublisherPage.publisherName.isDisplayed() && addPublisherPage.isPageOpened(),
                    "Verify that Add Publisher page is displayed.");
        }
    }

    public void publisherAddSamplePublisherTest() {
        String publisherName = prop.getProperty("samplePublisherName");
        String publisherAddressStreet = prop.getProperty("samplePublisherAddressStreet");
        String publisherAddressCity = prop.getProperty("samplePublisherAddressCity");
        String publisherAddressCountry = prop.getProperty("samplePublisherAddressCountry");
        String publisherAddressPostcodes = prop.getProperty("samplePublisherAddressPostcodes");

        eReports.createNode("PUBLISHER -> EDIT -> Add Sample Publisher.", "Verify Add Sample Publisher Page.");

        AddSamplePublisherPage addSamplePublisherPage = new AddSamplePublisherPage();
        eReports.compareNotNULL(addSamplePublisherPage, "Open 'PUBLISHER -> EDIT -> Add Sample Publisher page.");

        eReports.compareTrue(addSamplePublisherPage.Book.set(),
                "Set 'Publisher Type' to: book.");
        eReports.compareTrue(addSamplePublisherPage.publisherName.setText(publisherName),
                "Set 'Publisher Name' to: " + publisherName);
        eReports.compareTrue(addSamplePublisherPage.publisherAddressStreet.setText(publisherAddressStreet),
                "Set 'Publisher Address : Street' to: " + publisherAddressStreet);
        eReports.compareTrue(addSamplePublisherPage.publisherAddressCity.setText(publisherAddressCity),
                "Set 'Publisher Address : City' to: " + publisherAddressCity);
        eReports.compareTrue(addSamplePublisherPage.selectCountry(publisherAddressCountry),
                "Set 'Publisher Address : Country' to: " + publisherAddressCountry);
        eReports.compareTrue(addSamplePublisherPage.publisherAddressZip.setText(publisherAddressPostcodes),
                "Set 'Publisher Address : Postcode' to: " + publisherAddressPostcodes);

        eReports.compareTrue(addSamplePublisherPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        PublisherInquiryPage publisherInquiryPage = addSamplePublisherPage.clickConfirmButton();
        eReports.compareNotNULL(publisherInquiryPage,
                "Click 'Confirm' button and verify Publisher Inquiry page is opened.");

        publisherKey = publisherInquiryPage.getElementValue(publisherInquiryPage.publisherNumber.asWebElement());
    }
    public void publisherAddSamplePublisherTest_BVT() {
        eReports.createNode("PUBLISHER -> EDIT -> Add Sample Publisher.", "Verify Add Sample Publisher Page.");

        AddSamplePublisherPage addSamplePublisherPage = new AddSamplePublisherPage();
        if (eReports.compareNotNULL(addSamplePublisherPage, "Open 'PUBLISHER -> EDIT -> Add Sample Publisher page.")) {
            eReports.compareTrue(addSamplePublisherPage.publisherName.isDisplayed() && addSamplePublisherPage.isPageOpened(),
                    "Verify that Add Sample Publisher page is displayed.");
        }
    }

    public void publisherEditSamplePublisherTest() {
        String publisherName = prop.getProperty("samplePublisherName_UPD");
        String publisherAddressStreet = prop.getProperty("samplePublisherAddressStreet_UPD");
        String publisherAddressCity = prop.getProperty("samplePublisherAddressCity_UPD");
        String publisherAddressCountry = prop.getProperty("samplePublisherAddressCountry_UPD");
        String publisherAddressPostcodes = prop.getProperty("samplePublisherAddressPostcodes_UPD");

        eReports.createNode("PUBLISHER -> EDIT -> Edit Sample Publisher.", "Verify Edit Sample Publisher Page.");

        EditSamplePublisherPage editSamplePublisherPage = new EditSamplePublisherPage();
        eReports.compareNotNULL(editSamplePublisherPage, "Open 'PUBLISHER -> EDIT -> Edit Sample Publisher page.");

        eReports.compareTrue(editSamplePublisherPage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        eReports.compareTrue(editSamplePublisherPage.Book.set(),
                "Select 'book' option.");
        eReports.compareTrue(editSamplePublisherPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(editSamplePublisherPage.publisherName.setText(publisherName),
                "Set 'Publisher Name' to: " + publisherName);
        eReports.compareTrue(editSamplePublisherPage.publisherAddressStreet.setText(publisherAddressStreet),
                "Set 'Publisher Address : Street' to: " + publisherAddressStreet);
        eReports.compareTrue(editSamplePublisherPage.publisherAddressCity.setText(publisherAddressCity),
                "Set 'Publisher Address : City' to: " + publisherAddressCity);
        eReports.compareTrue(editSamplePublisherPage.selectCountry(publisherAddressCountry),
                "Set 'Publisher Address : Country' to: " + publisherAddressCountry);
        eReports.compareTrue(editSamplePublisherPage.publisherAddressZip.setText(publisherAddressPostcodes),
                "Set 'Publisher Address : Postcode' to: " + publisherAddressPostcodes);

        eReports.compareTrue(editSamplePublisherPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        PublisherInquiryPage publisherInquiryPage = editSamplePublisherPage.clickConfirmButton();
        eReports.compareNotNULL(publisherInquiryPage,
                "Click 'Confirm' button and verify Publisher Inquiry page is opened.");
    }
    public void publisherEditSamplePublisherTest_BVT() {
        eReports.createNode("PUBLISHER -> EDIT -> Edit Sample Publisher.", "Verify Edit Sample Publisher Page.");

        EditSamplePublisherPage editSamplePublisherPage = new EditSamplePublisherPage();
        if (eReports.compareNotNULL(editSamplePublisherPage, "Open 'PUBLISHER -> EDIT -> Edit Sample Publisher page.")) {

            eReports.compareTrue(editSamplePublisherPage.setPublisherKey(samplePublisherKey),
                    "Set Publisher Key to " + publisherKey);
            eReports.compareTrue(editSamplePublisherPage.Book.set(),
                    "Select 'book' option.");
            eReports.compareTrue(editSamplePublisherPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editSamplePublisherPage.publisherName.isDisplayed() && editSamplePublisherPage.isPageOpened(),
                    "Verify that Edit Sample Publisher page is displayed.");
        }
    }

    public void publisherJournalListTest() {
        eReports.createNode("PUBLISHER -> List of Journals.", "Verify List of Journals Page.");

        PublisherJournalListPage publisherJournalListPage = new PublisherJournalListPage();
        eReports.compareNotNULL(publisherJournalListPage, "Open 'PUBLISHER -> List of Journals page.");

        eReports.compareTrue(publisherJournalListPage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        eReports.compareTrue(publisherJournalListPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(publisherJournalListPage.clickJournalListTab(),
                "Open 'journal List' tab.");
        eReports.compareTrue(publisherJournalListPage.clickRoyaltyInquiryTab(),
                "Open 'Royalty Inquiry' tab.");
        eReports.compareTrue(publisherJournalListPage.clickJournalsRoyaltyList(),
                "Open 'Journals Royalty List' tab.");
        eReports.compareTrue(publisherJournalListPage.clickPublisherInquiryTab(),
                "Open 'Publisher Inquiry Tab' tab.");
    }
    public void publisherJournalListTest_BVT() {
        eReports.createNode("PUBLISHER -> List of Journals.", "Verify List of Journals Page.");

        PublisherJournalListPage publisherJournalListPage = new PublisherJournalListPage();
        if (eReports.compareNotNULL(publisherJournalListPage, "Open 'PUBLISHER -> List of Journals page.")) {

            eReports.compareTrue(publisherJournalListPage.setPublisherKey(publisherKey),
                    "Set Publisher Key to " + publisherKey);
            eReports.compareTrue(publisherJournalListPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(publisherJournalListPage.publisherNumber.isDisplayed() && publisherJournalListPage.isPageOpened(),
                    "Verify that List of Journals page is displayed.");
        }
    }

    public void publisherRoyaltyInquiryTest() {
        eReports.createNode("PUBLISHER -> Royalty -> Royalty Inquiry.", "Verify Royalty Inquiry Page.");

        RoyaltyInquiryPage royaltyInquiryPage = new RoyaltyInquiryPage();
        eReports.compareNotNULL(royaltyInquiryPage, "Open 'PUBLISHER -> Royalty -> Royalty Inquiry page.");

        eReports.compareTrue(royaltyInquiryPage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        eReports.compareTrue(royaltyInquiryPage.book.set(),
                "Select book option.");
        eReports.compareTrue(royaltyInquiryPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(royaltyInquiryPage.clickJournalListTab(),
                "Open 'journal List' tab.");
        eReports.compareTrue(royaltyInquiryPage.clickRoyaltyInquiryTab(),
                "Open 'Royalty Inquiry' tab.");
        eReports.compareTrue(royaltyInquiryPage.clickJournalsRoyaltyList(),
                "Open 'Journals Royalty List' tab.");
        eReports.compareTrue(royaltyInquiryPage.clickPublisherInquiryTab(),
                "Open 'Publisher Inquiry Tab' tab.");

    }
    public void publisherRoyaltyInquiryTest_BVT() {
        eReports.createNode("PUBLISHER -> Royalty -> Royalty Inquiry.", "Verify Royalty Inquiry Page.");

        RoyaltyInquiryPage royaltyInquiryPage = new RoyaltyInquiryPage();
        if (eReports.compareNotNULL(royaltyInquiryPage, "Open 'PUBLISHER -> Royalty -> Royalty Inquiry page.")) {

            eReports.compareTrue(royaltyInquiryPage.setPublisherKey(publisherKey),
                    "Set Publisher Key to " + publisherKey);
            eReports.compareTrue(royaltyInquiryPage.book.set(),
                    "Select book option.");
            eReports.compareTrue(royaltyInquiryPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(royaltyInquiryPage.publisherNumber.isDisplayed() && royaltyInquiryPage.isPageOpened(),
                    "Verify that Royalty Inquiry page is displayed.");
        }
    }

    public void publisherEditRoyaltyTest() {
        eReports.createNode("PUBLISHER -> Royalty -> Edit Royalty.", "Verify Edit Royalty Page.");

        EditRoyaltyPage editRoyaltyPage = new EditRoyaltyPage();
        eReports.compareNotNULL(editRoyaltyPage, "Open 'PUBLISHER -> Royalty -> Edit Royalty page.");

        eReports.compareTrue(editRoyaltyPage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        eReports.compareTrue(editRoyaltyPage.book.set(),
                "Select book option.");
        eReports.compareTrue(editRoyaltyPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(editRoyaltyPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        RoyaltyInquiryPage royaltyInquiryPage = editRoyaltyPage.clickConfirmButton();
        eReports.compareNotNULL(royaltyInquiryPage,
                "Click 'Confirm' button and verify Royalty Inquiry page is opened.");
    }
    public void publisherEditRoyaltyTest_BVT() {
        eReports.createNode("PUBLISHER -> Royalty -> Edit Royalty.", "Verify Edit Royalty Page.");

        EditRoyaltyPage editRoyaltyPage = new EditRoyaltyPage();
        if (eReports.compareNotNULL(editRoyaltyPage, "Open 'PUBLISHER -> Royalty -> Edit Royalty page.")) {

            eReports.compareTrue(editRoyaltyPage.setPublisherKey(publisherKey),
                    "Set Publisher Key to " + publisherKey);
            eReports.compareTrue(editRoyaltyPage.book.set(),
                    "Select book option.");
            eReports.compareTrue(editRoyaltyPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editRoyaltyPage.submitChanges.isDisplayed() && editRoyaltyPage.isPageOpened(),
                    "Verify that Edit Royalty page is displayed.");
        }
    }

    public void publisherListJournalRoyaltiesTest() {
        eReports.createNode("PUBLISHER -> Royalty -> List Journal Royalties.", "Verify List Journal Royalties Page.");

        ListJournalRoyaltiesPage listJournalRoyaltiesPage = new ListJournalRoyaltiesPage();
        eReports.compareNotNULL(listJournalRoyaltiesPage, "Open 'PUBLISHER -> Royalty -> List Journal Royalties page.");

        eReports.compareTrue(listJournalRoyaltiesPage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        eReports.compareTrue(listJournalRoyaltiesPage.book.set(),
                "Select book option.");
        eReports.compareTrue(listJournalRoyaltiesPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(listJournalRoyaltiesPage.clickJournalListTab(),
                "Open 'journal List' tab.");
        eReports.compareTrue(listJournalRoyaltiesPage.clickRoyaltyInquiryTab(),
                "Open 'Royalty Inquiry' tab.");
        eReports.compareTrue(listJournalRoyaltiesPage.clickJournalsRoyaltyList(),
                "Open 'Journals Royalty List' tab.");
        eReports.compareTrue(listJournalRoyaltiesPage.clickPublisherInquiryTab(),
                "Open 'Publisher Inquiry Tab' tab.");

    }
    public void publisherListJournalRoyaltiesTest_BVT() {
        eReports.createNode("PUBLISHER -> Royalty -> List Journal Royalties.", "Verify List Journal Royalties Page.");

        ListJournalRoyaltiesPage listJournalRoyaltiesPage = new ListJournalRoyaltiesPage();
        if (eReports.compareNotNULL(listJournalRoyaltiesPage, "Open 'PUBLISHER -> Royalty -> List Journal Royalties page.")) {

            eReports.compareTrue(listJournalRoyaltiesPage.setPublisherKey(publisherKey),
                    "Set Publisher Key to " + publisherKey);
            eReports.compareTrue(listJournalRoyaltiesPage.book.set(),
                    "Select book option.");
            eReports.compareTrue(listJournalRoyaltiesPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(listJournalRoyaltiesPage.publisherNumber.isDisplayed() && listJournalRoyaltiesPage.isPageOpened(),
                    "Verify that List Journal Royalties page is displayed.");
        }
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

        eReports.createNode("PUBLISHER -> Add Sample book.", "Verify Add Sample book Page.");

        AddSampleBookPage addSampleBookPage = new AddSampleBookPage();
        eReports.compareNotNULL(addSampleBookPage, "Open 'PUBLISHER -> Add Sample book page.");

        eReports.compareTrue(addSampleBookPage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        eReports.compareTrue(addSampleBookPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(addSampleBookPage.requestedOrdered.set(),
                "Set 'Requested/Ordered' option.");
        eReports.compareTrue(addSampleBookPage.isbn.setText(ISBN),
                "Set 'ISBN' value: " + ISBN);
        eReports.compareTrue(addSampleBookPage.fullTitle.setText(FullTitle + " - " + randomNum),
                "Set 'Full Title' value: " + FullTitle);
        eReports.compareTrue(addSampleBookPage.pubYear.setText(PubYear),
                "Set 'PubYear' value: " + PubYear);
        eReports.compareTrue(addSampleBookPage.authorAddress0.setText(authorAddress0),
                "Set 'Author Address' value: " + authorAddress0);
        eReports.compareTrue(addSampleBookPage.sampleSource.setText(SampleSource),
                "Set 'Sample Source' value: " + SampleSource);
        eReports.compareTrue(addSampleBookPage.pubContact.setText(PubContact),
                "Set 'Sample Source' value: " + SampleSource);
        eReports.compareTrue(addSampleBookPage.bookDOI.setText(BookDOI),
                "Set 'book DOI' value: " + BookDOI);

        eReports.compareTrue(addSampleBookPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        eReports.compareNotNULL(addSampleBookPage.clickConfirmButton(),
                "Click 'Confirm' button and verify that entity was created.");

    }
    public void publisherAddSampleBookTest_BVT() {
        eReports.createNode("PUBLISHER -> Add Sample Book.", "Verify Add Sample Book Page.");

        AddSampleBookPage addSampleBookPage = new AddSampleBookPage();
        if (eReports.compareNotNULL(addSampleBookPage, "Open 'PUBLISHER -> Add Sample Book page.")) {

            eReports.compareTrue(addSampleBookPage.setPublisherKey(publisherKey),
                    "Set Publisher Key to " + publisherKey);
            eReports.compareTrue(addSampleBookPage.clickSubmit(),
                    "Click 'Submit' button.");
            eReports.compareTrue(addSampleBookPage.submitChanges.isDisplayed() && addSampleBookPage.isPageOpened(),
                    "Verify that Add Sample Book page is displayed.");
        }
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

        eReports.createNode("PUBLISHER -> Add Sample Journal.", "Verify Add Sample Journal page.");

        AddSampleJournalPage addSampleJournalPage = new AddSampleJournalPage();
        eReports.compareNotNULL(addSampleJournalPage, "Open 'PUBLISHER -> Add Sample Journal page.");

        eReports.compareTrue(addSampleJournalPage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        eReports.compareTrue(addSampleJournalPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(addSampleJournalPage.issn.setText(issn),
                "Set 'ISSN' to: " + issn);
        eReports.compareTrue(addSampleJournalPage.isbn.setText(isbn),
                "Set 'ISBN' to: " + issn);
        eReports.compareTrue(addSampleJournalPage.fullTitle.setText(fullTitle + " - " + randomNum),
                "Set 'Series Title' to: " + fullTitle + " - " + randomNum);
        eReports.compareTrue(addSampleJournalPage.selectCountry(country),
                "Set 'Country' to: " + country);
        eReports.compareTrue(addSampleJournalPage.selectFrequency(frequency),
                "Set 'Frequency' to: " + frequency);
        eReports.compareTrue(addSampleJournalPage.selectSampleEvalResult(sampleEvalResult),
                "Set 'Sample Eval Result' to: " + sampleEvalResult);

        eReports.compareTrue(addSampleJournalPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        eReports.compareNotNULL(addSampleJournalPage.clickConfirmButton(),
                "Click 'Confirm' button and verify that entity was created.");
    }
    public void publisherAddSampleJournalTest_BVT() {
        eReports.createNode("PUBLISHER -> Add Sample Journal.", "Verify Add Sample Journal page.");

        AddSampleJournalPage addSampleJournalPage = new AddSampleJournalPage();
        if (eReports.compareNotNULL(addSampleJournalPage, "Open 'PUBLISHER -> Add Sample Journal page.")) {

            eReports.compareTrue(addSampleJournalPage.setPublisherKey(publisherKey),
                    "Set Publisher Key to " + publisherKey);
            eReports.compareTrue(addSampleJournalPage.clickSubmit(),
                    "Click 'Submit' button.");
            eReports.compareTrue(addSampleJournalPage.submitChanges.isDisplayed() && addSampleJournalPage.isPageOpened(),
                    "Verify that Add Sample Journal page is displayed.");
        }
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

        eReports.createNode("PUBLISHER -> Add a Serie.", "Verify Add a Serie page.");

        AddNewSeriePage addNewSeriePage = new AddNewSeriePage();
        eReports.compareNotNULL(addNewSeriePage, "Open 'PUBLISHER -> Add a Serie page.");

        eReports.compareTrue(addNewSeriePage.setPublisherKey(publisherKey),
                "Set Publisher Key to " + publisherKey);
        eReports.compareTrue(addNewSeriePage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(addNewSeriePage.issn.setText(issn),
                "Set 'ISSN' to: " + issn);
        eReports.compareTrue(addNewSeriePage.title11.setText(title11 + "-" + randomNum),
                "Set 'Title 11' to: " + title11);
        eReports.compareTrue(addNewSeriePage.title20.setText(title20),
                "Set 'Title 20' to: " + title20);
        eReports.compareTrue(addNewSeriePage.title29.setText(title29 + "-" + randomNum),
                "Set 'Title 29' to: " + title29);
        eReports.compareTrue(addNewSeriePage.fullTitle.setText(fullTitle + " - " + randomNum),
                "Set 'Series Title' to: " + fullTitle + " - " + randomNum);
        eReports.compareTrue(addNewSeriePage.selectCountry(country),
                "Set 'Country' to: " + country);
        eReports.compareTrue(addNewSeriePage.selectFrequency(frequency),
                "Set 'Frequency' to: " + frequency);

        eReports.compareTrue(addNewSeriePage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        eReports.compareNotNULL(addNewSeriePage.clickConfirmButton(),
                "Click 'Confirm' button and verify that entity was created.");
    }
    public void publisherAddNewSerieTest_BVT() {
        eReports.createNode("PUBLISHER -> Add a Serie.", "Verify Add a Serie page.");

        AddNewSeriePage addNewSeriePage = new AddNewSeriePage();
        if (eReports.compareNotNULL(addNewSeriePage, "Open 'PUBLISHER -> Add a Serie page.")) {

            eReports.compareTrue(addNewSeriePage.setPublisherKey(publisherKey),
                    "Set Publisher Key to " + publisherKey);
            eReports.compareTrue(addNewSeriePage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(addNewSeriePage.submitChanges.isDisplayed() && addNewSeriePage.isPageOpened(),
                    "Verify that Add Sample Journal page is displayed.");
        }
    }
}
