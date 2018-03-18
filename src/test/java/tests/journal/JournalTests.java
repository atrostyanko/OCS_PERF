package tests.journal;

import com.reporting.ExtentManager;

import pages.issue.IssueDetailsPage;
import pages.journal.*;
import pages.journal.Delete.DeleteSampleBookPage;
import pages.journal.Delete.DeleteSampleJournalPage;
import pages.journal.EditProductCodes.*;
import pages.journal.EditSubjectCategories.*;
import pages.journal.Subscriptions.JournalSubscriptionDetailsPage;
import pages.journal.Subscriptions.JournalSubscriptionHistoryEditPage;
import pages.journal.Subscriptions.JournalSubscriptionHistoryEditViewPage;
import pages.journal.Subscriptions.JournalSubscriptionHistoryPage;
import pages.journal.Transforming.TransformingBookPage;
import pages.journal.Transforming.TransformingSampleJournalPage;
import pages.publisher.BookInquiryPage;

import java.util.Properties;

public class JournalTests {
    private ExtentManager eReports;
    private Properties prop;

    String dfIssueNo = "";

    public JournalTests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

    public void journalInquiryTest() {
        String journalSequenceNumber = prop.getProperty("journalSequenceNumber");

        eReports.createNode("JOURNAL -> Journal Inquiry Page.", "Verify Journal Inquiry Page.");

        JournalInquiryPage journalInquiryPage = new JournalInquiryPage();
        if (eReports.compareNotNULL(journalInquiryPage, "Open 'JOURNAL -> Journal Inquiry' page.")) {

            eReports.compareTrue(journalInquiryPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            eReports.compareTrue(journalInquiryPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareNotNULL(journalInquiryPage.clickCDRXTab(),
                    "Open 'Journal Issues List' tab.");
            eReports.compareNotNULL(journalInquiryPage.clickJrnlXRefTab(),
                    "Open 'Journal Changes' tab.");
            eReports.compareNotNULL(journalInquiryPage.clickPCSCTab(),
                    "Open 'Journal Product Codes Inquiry' tab.");
            eReports.compareNotNULL(journalInquiryPage.clickPCHistTab(),
                    "Open 'Journal Product Code History' tab.");
            eReports.compareNotNULL(journalInquiryPage.clickSCHistTab(),
                    "Open 'Journal Subject Catagory History' tab.");
            eReports.compareNotNULL(journalInquiryPage.clickRoyInqTab(),
                    "Open 'Journal Royalty Inquiry' tab.");
            eReports.compareNotNULL(journalInquiryPage.clickSubsHistTab(),
                    "Open 'Journal Subscription History' tab.");
            eReports.compareNotNULL(journalInquiryPage.clickIssueLoginTab(),
                    "Open 'Issue Login for a Journal' tab.");
            eReports.compareNotNULL(journalInquiryPage.clickJrnlInqTab(),
                    "Open 'Journal Inquiry' tab.");
        }
    }
    public void journalInquiryTest_BVT() {
        String journalSequenceNumber = prop.getProperty("journalSequenceNumber");

        eReports.createNode("JOURNAL -> Journal Inquiry Page.", "Verify Journal Inquiry Page.");

        JournalInquiryPage journalInquiryPage = new JournalInquiryPage();
        if (eReports.compareNotNULL(journalInquiryPage, "Open 'JOURNAL -> Journal Inquiry' page.")) {

            eReports.compareTrue(journalInquiryPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            eReports.compareTrue(journalInquiryPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(journalInquiryPage.jrnlBookSeq.isDisplayed() && journalInquiryPage.isPageOpened(),
                    "Verify that Journal Inquiry page is opened.");
        }
    }

    public void journalEditCoveredJournalTest() {
        String journalSequenceNumber = prop.getProperty("editCoveredJournal_journalSequenceNumber");

        eReports.createNode("JOURNAL -> EDIT -> Edit Covered Journal.", "Verify Edit Covered Journal Page.");

        EditCoveredJournalPage editCoveredJournalPage = new EditCoveredJournalPage();
        if (eReports.compareNotNULL(editCoveredJournalPage,
                "Open 'JOURNAL -> EDIT -> Edit Covered Journal page.")) {

            eReports.compareTrue(editCoveredJournalPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            eReports.compareTrue(editCoveredJournalPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editCoveredJournalPage.clickSubmitChanges(),
                    "Click 'Submit Changes' button.");

            JournalInquiryPage journalInquiryPage = editCoveredJournalPage.clickConfirmButton();
            eReports.compareNotNULL(journalInquiryPage,
                    "Click 'Confirm' button and verify Journal Inquiry page is opened.");
        }
    }
    public void journalEditCoveredJournalTest_BVT() {
        String journalSequenceNumber = prop.getProperty("editCoveredJournal_journalSequenceNumber");
        eReports.createNode("JOURNAL -> EDIT -> Edit Covered Journal.", "Verify Edit Covered Journal Page.");

        EditCoveredJournalPage editCoveredJournalPage = new EditCoveredJournalPage();
        if (eReports.compareNotNULL(editCoveredJournalPage,
                "Open 'JOURNAL -> EDIT -> Edit Covered Journal page.")) {

            eReports.compareTrue(editCoveredJournalPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            eReports.compareTrue(editCoveredJournalPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editCoveredJournalPage.submitChanges.isDisplayed() && editCoveredJournalPage.isPageOpened(),
                    "Verify that Editing Covered Journal page is opened.");
        }
    }

    public void journalEditSampleJournalTest() {
        String journalSequenceNumber = prop.getProperty("editSampleJournal_journalSequenceNumber");

        eReports.createNode("JOURNAL -> EDIT -> Edit Sample Journal.", "Verify Edit Sample Journal Page.");

        EditSampleJournalPage editSampleJournalPage = new EditSampleJournalPage();
        if (eReports.compareNotNULL(editSampleJournalPage,
                "Open 'JOURNAL -> EDIT -> Edit Sample Journal page.")) {

            eReports.compareTrue(editSampleJournalPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            eReports.compareTrue(editSampleJournalPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editSampleJournalPage.clickSubmitChanges(),
                    "Click 'Submit Changes' button.");

            JournalInquiryPage journalInquiryPage = editSampleJournalPage.clickConfirmButton();
            eReports.compareNotNULL(journalInquiryPage,
                    "Click 'Confirm' button and verify Journal Inquiry page is opened.");
        }
    }
    public void journalEditSampleJournalTest_BVT() {
        String journalSequenceNumber = prop.getProperty("editSampleJournal_journalSequenceNumber");

        eReports.createNode("JOURNAL -> EDIT -> Edit Sample Journal.", "Verify Edit Sample Journal Page.");

        EditSampleJournalPage editSampleJournalPage = new EditSampleJournalPage();
        if (eReports.compareNotNULL(editSampleJournalPage,
                "Open 'JOURNAL -> EDIT -> Edit Sample Journal page.")) {

            eReports.compareTrue(editSampleJournalPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            eReports.compareTrue(editSampleJournalPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editSampleJournalPage.submitChanges.isDisplayed() && editSampleJournalPage.isPageOpened(),
                    "Verify that Editing Sample Journal page is opened.");
        }
    }

    public void journalEditBookTest() {
        String bookNumber = prop.getProperty("editBook_bookNumber");

        eReports.createNode("JOURNAL -> EDIT -> Edit Book.", "Verify Edit Book Page.");

        EditBookPage editBookPage = new EditBookPage();
        if (eReports.compareNotNULL(editBookPage,
                "Open 'JOURNAL -> EDIT -> Edit Book page.")) {

            eReports.compareTrue(editBookPage.setJournalSequence(bookNumber),
                    "Set Journal Sequence number to " + bookNumber);
            eReports.compareTrue(editBookPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editBookPage.clickSubmitChanges(),
                    "Click 'Submit Changes' button.");

            BookInquiryPage bookInquiryPage = editBookPage.clickConfirmButton();
            eReports.compareNotNULL(bookInquiryPage,
                    "Click 'Confirm' button and verify Book Inquiry page is opened.");
        }
    }
    public void journalEditBookTest_BVT() {
        String bookNumber = prop.getProperty("editBook_bookNumber");

        eReports.createNode("JOURNAL -> EDIT -> Edit Book.",
                "Verify Edit Book Page.");

        EditBookPage editBookPage = new EditBookPage();
        if (eReports.compareNotNULL(editBookPage,
                "Open 'JOURNAL -> EDIT -> Edit Book page.")) {

            eReports.compareTrue(editBookPage.setJournalSequence(bookNumber),
                    "Set Journal Sequence number to " + bookNumber);
            eReports.compareTrue(editBookPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editBookPage.submitChanges.isDisplayed() && editBookPage.isPageOpened(),
                    "Verify that Edit Book page is opened.");
        }
    }

    public void journalEditSampleBookTest() {
        String sampleBookNumber = prop.getProperty("editSampleBook_sampleBookNumber");

        eReports.createNode("JOURNAL -> EDIT -> Edit Sample Book.", "Verify Edit Sample Book Page.");

        EditSampleBookPage editSampleBookPage = new EditSampleBookPage();
        if (eReports.compareNotNULL(editSampleBookPage,
                "Open 'JOURNAL -> EDIT -> Edit Sample Book page.")) {

            eReports.compareTrue(editSampleBookPage.setJournalSequence(sampleBookNumber),
                    "Set Journal Sequence number to " + sampleBookNumber);
            eReports.compareTrue(editSampleBookPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editSampleBookPage.clickSubmitChanges(),
                    "Click 'Submit Changes' button.");

            BookInquiryPage bookInquiryPage = editSampleBookPage.clickConfirmButton();
            eReports.compareNotNULL(bookInquiryPage,
                    "Click 'Confirm' button and verify Book Inquiry page is opened.");
        }
    }
    public void journalEditSampleBookTest_BVT() {
        String sampleBookNumber = prop.getProperty("editSampleBook_sampleBookNumber");

        eReports.createNode("JOURNAL -> EDIT -> Edit Sample Book.",
                "Verify Edit Sample Book Page.");

        EditSampleBookPage editSampleBookPage = new EditSampleBookPage();
        if (eReports.compareNotNULL(editSampleBookPage,
                "Open 'JOURNAL -> EDIT -> Edit Sample Book page.")) {

            eReports.compareTrue(editSampleBookPage.setJournalSequence(sampleBookNumber),
                    "Set Journal Sequence number to " + sampleBookNumber);
            eReports.compareTrue(editSampleBookPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editSampleBookPage.submitChanges.isDisplayed() && editSampleBookPage.isPageOpened(),
                    "Verify that Edit Sample Book page is opened.");
        }
    }

    public void journalEditSeriesTest() {
        String seriesNumber = prop.getProperty("editSeries_seriesNumber");

        eReports.createNode("JOURNAL -> EDIT -> Edit Series.", "Verify Edit Series Page.");

        EditSeriesPage editSeriesPage = new EditSeriesPage();
        if (eReports.compareNotNULL(editSeriesPage,
                "Open 'JOURNAL -> EDIT -> Edit Series page.")) {

            eReports.compareTrue(editSeriesPage.setJournalSequence(seriesNumber),
                    "Set Journal Sequence number to " + seriesNumber);
            eReports.compareTrue(editSeriesPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editSeriesPage.clickSubmitChanges(),
                    "Click 'Submit Changes' button.");

            JournalInquiryPage journalInquiryPage = editSeriesPage.clickConfirmButton();
            eReports.compareNotNULL(journalInquiryPage,
                    "Click 'Confirm' button and verify Journal Inquiry page is opened.");
        }
    }
    public void journalEditSeriesTest_BVT() {
        String seriesNumber = prop.getProperty("editSeries_seriesNumber");

        eReports.createNode("JOURNAL -> EDIT -> Edit Series.",
                "Verify Edit Series Page.");

        EditSeriesPage editSeriesPage = new EditSeriesPage();
        if (eReports.compareNotNULL(editSeriesPage,
                "Open 'JOURNAL -> EDIT -> Edit Series page.")) {

            eReports.compareTrue(editSeriesPage.setJournalSequence(seriesNumber),
                    "Set Journal Sequence number to " + seriesNumber);
            eReports.compareTrue(editSeriesPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editSeriesPage.submitChanges.isDisplayed() && editSeriesPage.isPageOpened(),
                    "Verify that Edit Series page is opened.");
        }
    }

    //ToDo: Delete Journal
    public void deleteSampleJournalTest_BVT() {
        String seriesNumber = prop.getProperty("deleteSampleJournal_journalSequenceNumber");

        eReports.createNode("JOURNAL -> DELETE -> Delete Sample Journal.",
                "Verify Delete Sample Journal Page.");

        DeleteSampleJournalPage deleteSampleJournalPage = new DeleteSampleJournalPage();
        if (eReports.compareNotNULL(deleteSampleJournalPage,
                "Open 'JOURNAL -> DELETE -> Delete Sample Journal page.")) {

            eReports.compareTrue(deleteSampleJournalPage.setJournalSequence(seriesNumber),
                    "Set Journal Sequence number to " + seriesNumber);

            eReports.compareTrue(deleteSampleJournalPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(deleteSampleJournalPage.deleteButton.isDisplayed()
                    && deleteSampleJournalPage.isPageOpened(),
                    "Verify that Delete Sample Journal page is opened.");
        }
    }
    public void deleteSampleBookTest_BVT() {
        String seriesNumber = prop.getProperty("deleteSampleBook_sampleBookNumber");

        eReports.createNode("JOURNAL -> DELETE -> Delete Sample Book.",
                "Verify Delete Sample Book Page.");

        DeleteSampleBookPage deleteSampleBookPage = new DeleteSampleBookPage();
        if (eReports.compareNotNULL(deleteSampleBookPage,
                "Open 'JOURNAL -> DELETE -> Delete Sample Book page.")) {

            eReports.compareTrue(deleteSampleBookPage.setJournalSequence(seriesNumber),
                    "Set Journal Sequence number to " + seriesNumber);

            eReports.compareTrue(deleteSampleBookPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(deleteSampleBookPage.deleteButton.isDisplayed()
                            && deleteSampleBookPage.isPageOpened(),
                    "Verify that Delete Sample Book page is opened.");
        }
    }
    //ToDo: Delete Series

    public void JournalProductCodesInquiryTest() {
        String journalSequenceNumber = prop.getProperty("journalProductCodesInquiry_journalSequenceNumber");

        eReports.createNode("JOURNAL -> Prod. Codes - Subj. Categories Page.", "Verify Journal Product Codes Inquiry Page.");

        JournalProductCodesInquiryPage journalProductCodesInquiryPage = new JournalProductCodesInquiryPage();
        if (eReports.compareNotNULL(journalProductCodesInquiryPage,
                "Open 'JOURNAL -> Journal Product Codes Inquiry' page.")) {

            eReports.compareTrue(journalProductCodesInquiryPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            eReports.compareTrue(journalProductCodesInquiryPage.clickSubmit(),
                    "Click 'Submit' button.");
            /*
            eReports.compareNotNULL(journalProductCodesInquiryPage.clickCDRXTab(),
                    "Open 'Journal Issues List' tab.");
            eReports.compareNotNULL(journalProductCodesInquiryPage.clickJrnlXRefTab(),
                    "Open 'Journal Changes' tab.");
            eReports.compareNotNULL(journalProductCodesInquiryPage.clickPCSCTab(),
                    "Open 'Journal Product Codes Inquiry' tab.");
            eReports.compareNotNULL(journalProductCodesInquiryPage.clickPCHistTab(),
                    "Open 'Journal Product Code History' tab.");
            eReports.compareNotNULL(journalProductCodesInquiryPage.clickSCHistTab(),
                    "Open 'Journal Subject Catagory History' tab.");
            eReports.compareNotNULL(journalProductCodesInquiryPage.clickRoyInqTab(),
                    "Open 'Journal Royalty Inquiry' tab.");
            eReports.compareNotNULL(journalProductCodesInquiryPage.clickSubsHistTab(),
                    "Open 'Journal Subscription History' tab.");
            eReports.compareNotNULL(journalProductCodesInquiryPage.clickIssueLoginTab(),
                    "Open 'Issue Login for a Journal' tab.");
            eReports.compareNotNULL(journalProductCodesInquiryPage.clickJrnlInqTab(),
                    "Open 'Journal Inquiry' tab.");
                   */
        }
    }
    public void JournalProductCodesInquiryTest_BVT() {
        String journalSequenceNumber = prop.getProperty("journalProductCodesInquiry_journalSequenceNumber");

        eReports.createNode("JOURNAL -> Prod. Codes - Subj. Categories Page.",
                "Verify Journal Product Codes Inquiry Page.");

        JournalProductCodesInquiryPage journalProductCodesInquiryPage = new JournalProductCodesInquiryPage();
        if (eReports.compareNotNULL(journalProductCodesInquiryPage,
                "Open 'JOURNAL -> Journal Product Codes Inquiry' page.")) {

            eReports.compareTrue(journalProductCodesInquiryPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            eReports.compareTrue(journalProductCodesInquiryPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(journalProductCodesInquiryPage.jrnlBookSeq.isDisplayed()
                            && journalProductCodesInquiryPage.isPageOpened(),
                    "Verify that Journal Product Codes Inquiry page is opened.");
        }
    }

    public void journalEditProductCodesForJournalsTest() {
        String journalSequenceNumber = prop.getProperty("editingProductCodesForJournals_JournalSequence");
        String productCode = prop.getProperty("editingProductCodesForJournals_ProductCode");
        String subjectCode = prop.getProperty("editingProductCodesForJournals_SubjectCode");

        eReports.createNode("JOURNAL -> Edit Product Codes -> For Journals.", "Verify Edit Product Codes For Journals Page.");

        EditProductCodesForJournalsPage editProductCodesForJournalsPage = new EditProductCodesForJournalsPage();
        if (eReports.compareNotNULL(editProductCodesForJournalsPage,
                "Open 'JOURNAL -> Edit Product Codes -> For Journals page.")) {

            eReports.compareTrue(editProductCodesForJournalsPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            eReports.compareTrue(editProductCodesForJournalsPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editProductCodesForJournalsPage.addProductionCode(productCode),
                    "Set '" + productCode + "' production code option.");

            eReports.compareTrue(editProductCodesForJournalsPage.clickAddProductCodesButton(),
                    "Click 'Add' button.");

            EditSubjectCategoriesForJournalsPage editSubjectCategoriesForJournalsPage =
                    editProductCodesForJournalsPage.clickConfirmAddingProductCodesButton();
            if (eReports.compareNotNULL(editSubjectCategoriesForJournalsPage,
                    "Click 'Confirm' button to complete adding product codes.")) {

                eReports.compareTrue(editSubjectCategoriesForJournalsPage.selectSubjectCategory(productCode, subjectCode),
                        "Set '" + subjectCode + "' subject code for '" + productCode + "' the production code.");

                eReports.compareTrue(editSubjectCategoriesForJournalsPage.clickAddSubjectCodesButton(),
                        "Click 'Confirm' button to add Subject Categories.");

                EditCoveredJournalPage editCoveredJournalPage = editSubjectCategoriesForJournalsPage.clickConfirmAddingSubjectCategoriesButton();
                if (eReports.compareNotNULL(editCoveredJournalPage,
                        "Click 'Confirm' button to add Subject Categories.")) {

                    eReports.compareTrue(editCoveredJournalPage.clickSubmitChanges(),
                            "Click 'Submit Changes' button.");

                    JournalInquiryPage journalInquiryPage = editCoveredJournalPage.clickConfirmButton();
                    if (eReports.compareNotNULL(journalInquiryPage,
                            "Click 'Confirm' button and verify Journal Inquiry page is opened.")) {

                    }
                }
            }
        }
    }
    public void journalEditProductCodesForJournalsTest_BVT() {
        String journalSequenceNumber = prop.getProperty("editingProductCodesForJournals_JournalSequence");

        eReports.createNode("JOURNAL -> Edit Product Codes -> For Journals.",
                "Verify Edit Product Codes For Journals Page.");

        EditProductCodesForJournalsPage editProductCodesForJournalsPage = new EditProductCodesForJournalsPage();
        if (eReports.compareNotNULL(editProductCodesForJournalsPage,
                "Open 'JOURNAL -> Edit Product Codes -> For Journals page.")) {

            eReports.compareTrue(editProductCodesForJournalsPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            eReports.compareTrue(editProductCodesForJournalsPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editProductCodesForJournalsPage.addButton.isDisplayed()
                            && editProductCodesForJournalsPage.isPageOpened(),
                    "Verify that Edit Product Codes For Journals page is opened.");
        }
    }

    public void journalEditProductCodesForSampleJournalsTest() {
        String journalSequenceNumber = prop.getProperty("journalEditProductCodesForSampleJournals_JournalSequence");

        eReports.createNode("JOURNAL -> Edit Product Codes -> For Sample Journals.",
                "Verify Edit Product Codes For Sample Journals Page.");

        EditProductCodesForSampleJournalsPage editProductCodesForSampleJournalsPage = new EditProductCodesForSampleJournalsPage();
        if (eReports.compareNotNULL(editProductCodesForSampleJournalsPage,
                "Open 'JOURNAL -> Edit Product Codes -> For Sample Journals page.")) {

            eReports.compareTrue(editProductCodesForSampleJournalsPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            eReports.compareTrue(editProductCodesForSampleJournalsPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editProductCodesForSampleJournalsPage.clickAddProductCodesButton(),
                    "Click 'Add' button.");

            eReports.compareTrue(editProductCodesForSampleJournalsPage.clickConfirmAddingProductCodesButton(),
                    "Click 'Confirm' button to complete adding product codes.");

            eReports.compareTrue(editProductCodesForSampleJournalsPage.updateMessage.isDisplayed(),
                    "Verify that 'Product code(s) :  has/have been successfully added.' message is displayed.");
}
    }
    public void journalEditProductCodesForSampleJournalsTest_BVT() {
        String journalSequenceNumber = prop.getProperty("journalEditProductCodesForSampleJournals_JournalSequence");

        eReports.createNode("JOURNAL -> Edit Product Codes -> For Sample Journals.",
                "Verify Edit Product Codes For Sample Journals Page.");

        EditProductCodesForSampleJournalsPage editProductCodesForSampleJournalsPage = new EditProductCodesForSampleJournalsPage();
        if (eReports.compareNotNULL(editProductCodesForSampleJournalsPage,
                "Open 'JOURNAL -> Edit Product Codes -> For Sample Journals page.")) {

            eReports.compareTrue(editProductCodesForSampleJournalsPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            eReports.compareTrue(editProductCodesForSampleJournalsPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editProductCodesForSampleJournalsPage.addButton.isDisplayed()
                            && editProductCodesForSampleJournalsPage.isPageOpened(),
                    "Verify that Edit Product Codes For Sample Journals page is opened.");
        }
    }

    public void journalEditProductCodesForBooksTest() {
        String bookNumber = prop.getProperty("editingProductCodesForBooks_bookNumber");

        eReports.createNode("JOURNAL -> Edit Product Codes -> For Books.",
                "Verify Edit Product Codes For Books Page.");

        EditProductCodesForBooksPage editProductCodesForBooksPage = new EditProductCodesForBooksPage();
        if (eReports.compareNotNULL(editProductCodesForBooksPage,
                "Open 'JOURNAL -> Edit Product Codes -> For Books page.")) {

            eReports.compareTrue(editProductCodesForBooksPage.setJournalSequence(bookNumber),
                    "Set Journal Sequence number to " + bookNumber);
            eReports.compareTrue(editProductCodesForBooksPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editProductCodesForBooksPage.clickAddProductCodesButton(),
                    "Click 'Add' button.");

            eReports.compareTrue(editProductCodesForBooksPage.clickConfirmAddingProductCodesButton(),
                    "Click 'Confirm' button to complete adding product codes.");

            eReports.compareTrue(editProductCodesForBooksPage.updateMessage.isDisplayed(),
                    "Verify that 'Product code(s) :  has/have been successfully added.' message is displayed.");
        }
    }
    public void journalEditProductCodesForBooksTest_BVT() {
        String bookNumber = prop.getProperty("editingProductCodesForBooks_bookNumber");

        eReports.createNode("JOURNAL -> Edit Product Codes -> For Books.",
                "Verify Edit Product Codes For Books Page.");

        EditProductCodesForBooksPage editProductCodesForBooksPage = new EditProductCodesForBooksPage();
        if (eReports.compareNotNULL(editProductCodesForBooksPage,
                "Open 'JOURNAL -> Edit Product Codes -> For Books page.")) {

            eReports.compareTrue(editProductCodesForBooksPage.setJournalSequence(bookNumber),
                    "Set Journal Sequence number to " + bookNumber);
            eReports.compareTrue(editProductCodesForBooksPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editProductCodesForBooksPage.addButton.isDisplayed()
                            && editProductCodesForBooksPage.isPageOpened(),
                    "Verify that Edit Product Codes For Books page is opened.");
        }
    }

    public void journalEditProductCodesForSampleBooksTest() {
        String bookNumber = prop.getProperty("editingProductCodesForSampleBooks_bookNumber");

        eReports.createNode("JOURNAL -> Edit Product Codes -> For Sample Books.",
                "Verify Edit Product Codes For Sample Books Page.");

        EditProductCodesForSampleBooksPage editProductCodesForSampleBooksPage = new EditProductCodesForSampleBooksPage();
        if (eReports.compareNotNULL(editProductCodesForSampleBooksPage,
                "Open 'JOURNAL -> Edit Product Codes -> For Sample Books page.")) {

            eReports.compareTrue(editProductCodesForSampleBooksPage.setJournalSequence(bookNumber),
                    "Set Journal Sequence number to " + bookNumber);
            eReports.compareTrue(editProductCodesForSampleBooksPage.clickSubmit(),
                    "Click 'Submit' button.");


            eReports.compareTrue(editProductCodesForSampleBooksPage.clickAddProductCodesButton(),
                    "Click 'Add' button.");

            eReports.compareTrue(editProductCodesForSampleBooksPage.clickConfirmAddingProductCodesButton(),
                    "Click 'Confirm' button to complete adding product codes.");

            eReports.compareTrue(editProductCodesForSampleBooksPage.updateMessage.isDisplayed(),
                    "Verify that 'Product code(s) :  has/have been successfully added.' message is displayed.");
        }
    }
    public void journalEditProductCodesForSampleBooksTest_BVT() {
        String bookNumber = prop.getProperty("editingProductCodesForSampleBooks_bookNumber");

        eReports.createNode("JOURNAL -> Edit Product Codes -> For Sample Books.",
                "Verify Edit Product Codes For Sample Books Page.");

        EditProductCodesForSampleBooksPage editProductCodesForSampleBooksPage = new EditProductCodesForSampleBooksPage();
        if (eReports.compareNotNULL(editProductCodesForSampleBooksPage,
                "Open 'JOURNAL -> Edit Product Codes -> For Sample Books page.")) {

            eReports.compareTrue(editProductCodesForSampleBooksPage.setJournalSequence(bookNumber),
                    "Set Journal Sequence number to " + bookNumber);
            eReports.compareTrue(editProductCodesForSampleBooksPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editProductCodesForSampleBooksPage.addButton.isDisplayed()
                            && editProductCodesForSampleBooksPage.isPageOpened(),
                    "Verify that Edit Product Codes For Sample Books page is opened.");
        }
    }

    public void journalEditProductCodesForSeriesTest() {
        String seriesNumber = prop.getProperty("editProductCodesForSeries_seriesNumber");

        eReports.createNode("JOURNAL -> Edit Product Codes -> For Series.",
                    "Verify Edit Product Codes For Series Page.");

        EditProductCodesForSeriesPage editProductCodesForSeriesPage = new EditProductCodesForSeriesPage();
        if (eReports.compareNotNULL(editProductCodesForSeriesPage,
                "Open 'JOURNAL -> Edit Product Codes -> For Series page.")) {

            eReports.compareTrue(editProductCodesForSeriesPage.setJournalSequence(seriesNumber),
                    "Set Journal Sequence number to " + seriesNumber);
            eReports.compareTrue(editProductCodesForSeriesPage.clickSubmit(),
                    "Click 'Submit' button.");


            eReports.compareTrue(editProductCodesForSeriesPage.clickAddProductCodesButton(),
                    "Click 'Add' button.");

            eReports.compareTrue(editProductCodesForSeriesPage.clickConfirmAddingProductCodesButton(),
                    "Click 'Confirm' button to complete adding product codes.");

            eReports.compareTrue(editProductCodesForSeriesPage.updateMessage.isDisplayed(),
                    "Verify that 'Product code(s) :  has/have been successfully added.' message is displayed.");
        }
    }
    public void journalEditProductCodesForSeriesTest_BVT() {
        String seriesNumber = prop.getProperty("editProductCodesForSeries_seriesNumber");

        eReports.createNode("JOURNAL -> Edit Product Codes -> For Series.",
                    "Verify Edit Product Codes For Series Page.");

        EditProductCodesForSeriesPage editProductCodesForSeriesPage = new EditProductCodesForSeriesPage();
        if (eReports.compareNotNULL(editProductCodesForSeriesPage,
                "Open 'JOURNAL -> Edit Product Codes -> For Series page.")) {

            eReports.compareTrue(editProductCodesForSeriesPage.setJournalSequence(seriesNumber),
                    "Set Journal Sequence number to " + seriesNumber);
            eReports.compareTrue(editProductCodesForSeriesPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editProductCodesForSeriesPage.addButton.isDisplayed()
                            && editProductCodesForSeriesPage.isPageOpened(),
                    "Verify that Edit Product Codes For Series page is opened.");
        }
    }

    public void journalEditSubjectCategoriesForJournalsTest() {
        String journalSequenceNumber = prop.getProperty("editingCategoriesCodesForJournals_JournalSequence");

        eReports.createNode("JOURNAL -> Edit Subject Categories -> For Journals.",
                "Verify Edit Subject Categories For Journals Page.");

        EditSubjectCategoriesForJournalsPage editSubjectCategoriesForJournalsPage = new EditSubjectCategoriesForJournalsPage();
        eReports.compareNotNULL(editSubjectCategoriesForJournalsPage,
                "Open 'JOURNAL -> Edit Subject Categories -> For Journals page.");

        eReports.compareTrue(editSubjectCategoriesForJournalsPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);

        eReports.compareTrue(editSubjectCategoriesForJournalsPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(editSubjectCategoriesForJournalsPage.clickAddSubjectCodesButton(),
                "Click 'Add' button.");

        EditCoveredJournalPage editCoveredJournalPage = editSubjectCategoriesForJournalsPage.clickConfirmAddingSubjectCategoriesButton();
        if (eReports.compareNotNULL(editCoveredJournalPage,
                "Click 'Confirm' button to complete adding product codes.")) {

            eReports.compareTrue(editCoveredJournalPage.clickSubmitChanges(),
                    "Click 'Submit Changes' button.");

            JournalInquiryPage journalInquiryPage = editCoveredJournalPage.clickConfirmButton();
            eReports.compareNotNULL(journalInquiryPage,
                    "Click 'Confirm' button and verify Journal Inquiry page is opened.");
        }
    }
    public void journalEditSubjectCategoriesForJournalsTest_BVT() {
        String journalSequenceNumber = prop.getProperty("editingCategoriesCodesForJournals_JournalSequence");

        eReports.createNode("JOURNAL -> Edit Subject Categories -> For Journals.",
                "Verify Edit Subject Categories For Journals Page.");

        EditSubjectCategoriesForJournalsPage editSubjectCategoriesForJournalsPage = new EditSubjectCategoriesForJournalsPage();
        if (eReports.compareNotNULL(editSubjectCategoriesForJournalsPage,
                "Open 'JOURNAL -> Edit Subject Categories -> For Journals page.")) {

            eReports.compareTrue(editSubjectCategoriesForJournalsPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);

            eReports.compareTrue(editSubjectCategoriesForJournalsPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editSubjectCategoriesForJournalsPage.addButton.isDisplayed()
                            && editSubjectCategoriesForJournalsPage.isPageOpened(),
                    "Verify that Edit Subject Categories For Journals page is opened.");
        }
    }

    public void journalEditSubjectCategoriesForSampleJournalsTest() {
        String journalSequenceNumber = prop.getProperty("journalEditCategoriesCodesForSampleJournals_JournalSequence");
        eReports.createNode("JOURNAL -> Edit Subject Categories -> For Sample Journals.",
                "Verify Edit Subject Categories For Sample Journals Page.");

        EditSubjectCategoriesForSampleJournalsPage editSubjectCategoriesForSampleJournalsPage = new EditSubjectCategoriesForSampleJournalsPage();
        eReports.compareNotNULL(editSubjectCategoriesForSampleJournalsPage,
                "Open 'JOURNAL -> Edit Subject Categories -> For Sample Journals page.");

        eReports.compareTrue(editSubjectCategoriesForSampleJournalsPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        eReports.compareTrue(editSubjectCategoriesForSampleJournalsPage.clickSubmit(),
                "Click 'Submit' button.");


        eReports.compareTrue(editSubjectCategoriesForSampleJournalsPage.clickAddProductCodesButton(),
                "Click 'Add' button.");

        eReports.compareTrue(editSubjectCategoriesForSampleJournalsPage.clickConfirmAddingSubjectCategoriesButton(),
                "Click 'Confirm' button to complete adding product codes.");

        eReports.compareTrue(editSubjectCategoriesForSampleJournalsPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalInquiryPage journalInquiryPage = editSubjectCategoriesForSampleJournalsPage.clickConfirmButton();
        eReports.compareNotNULL(journalInquiryPage,
                "Click 'Confirm' button and verify Journal Inquiry page is opened.");
    }
    public void journalEditSubjectCategoriesForSampleJournalsTest_BVT() {
        String journalSequenceNumber = prop.getProperty("journalEditCategoriesCodesForSampleJournals_JournalSequence");

        eReports.createNode("JOURNAL -> Edit Subject Categories -> For Sample Journals.",
                "Verify Edit Subject Categories For Sample Journals Page.");

        EditSubjectCategoriesForSampleJournalsPage editSubjectCategoriesForSampleJournalsPage = new EditSubjectCategoriesForSampleJournalsPage();
        if (eReports.compareNotNULL(editSubjectCategoriesForSampleJournalsPage,
                "Open 'JOURNAL -> Edit Subject Categories -> For Sample Journals page.")) {

            eReports.compareTrue(editSubjectCategoriesForSampleJournalsPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            eReports.compareTrue(editSubjectCategoriesForSampleJournalsPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editSubjectCategoriesForSampleJournalsPage.addButton.isDisplayed()
                            && editSubjectCategoriesForSampleJournalsPage.isPageOpened(),
                    "Verify that Edit Subject Categories For Sample Journals page is opened.");
        }
    }

    public void journalEditSubjectCategoriesForBooksTest() {
        String bookNumber = prop.getProperty("editingCategoriesCodesForBooks_bookNumber");

        eReports.createNode("JOURNAL -> Edit Subject Categories -> For Books.",
                "Verify Edit Subject Categories For Books Page.");

        EditSubjectCategoriesForBooksPage editSubjectCategoriesForBooksPage = new EditSubjectCategoriesForBooksPage();
        eReports.compareNotNULL(editSubjectCategoriesForBooksPage,
                "Open 'JOURNAL -> Edit Subject Categories -> For Books page.");

        eReports.compareTrue(editSubjectCategoriesForBooksPage.setJournalSequence(bookNumber),
                "Set Journal Sequence number to " + bookNumber);

        eReports.compareTrue(editSubjectCategoriesForBooksPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(editSubjectCategoriesForBooksPage.clickAddProductCodesButton(),
                "Click 'Add' button.");

        eReports.compareTrue(editSubjectCategoriesForBooksPage.clickConfirmAddingSubjectCategoriesButton(),
                "Click 'Confirm' button to complete adding product codes.");

        String message = "Record for Subject Categories for Journal Seq No. " + bookNumber + " successfully updated. Please review below.";
        eReports.compareTrue(editSubjectCategoriesForBooksPage.isMessageDisplayed(message),
                "Verify that '" + message +"' message is displayed.");
    }
    public void journalEditSubjectCategoriesForBooksTest_BVT() {
        String bookNumber = prop.getProperty("editingCategoriesCodesForBooks_bookNumber");

        eReports.createNode("JOURNAL -> Edit Subject Categories -> For Books.",
                "Verify Edit Subject Categories For Books Page.");

        EditSubjectCategoriesForBooksPage editSubjectCategoriesForBooksPage = new EditSubjectCategoriesForBooksPage();
        if (eReports.compareNotNULL(editSubjectCategoriesForBooksPage,
                "Open 'JOURNAL -> Edit Subject Categories -> For Books page.")) {

            eReports.compareTrue(editSubjectCategoriesForBooksPage.setJournalSequence(bookNumber),
                    "Set Journal Sequence number to " + bookNumber);

            eReports.compareTrue(editSubjectCategoriesForBooksPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editSubjectCategoriesForBooksPage.addButton.isDisplayed()
                            && editSubjectCategoriesForBooksPage.isPageOpened(),
                    "Verify that Edit Subject Categories For Books page is opened.");
        }
    }

    public void journalEditSubjectCategoriesForSampleBooksTest() {
        String bookNumber = prop.getProperty("editingCategoriesCodesForSampleBooks_bookNumber");

        eReports.createNode("JOURNAL -> Edit Subject Categories -> For Sample Books.",
                "Verify Edit Subject Categories For For Sample Books.");

        EditSubjectCategoriesForSampleBooksPage editSubjectCategoriesForSampleBooksPage = new EditSubjectCategoriesForSampleBooksPage();
        eReports.compareNotNULL(editSubjectCategoriesForSampleBooksPage,
                "Open 'JOURNAL -> Edit Subject Categories -> For Sample Books page.");

        eReports.compareTrue(editSubjectCategoriesForSampleBooksPage.setJournalSequence(bookNumber),
                "Set Journal Sequence number to " + bookNumber);

        eReports.compareTrue(editSubjectCategoriesForSampleBooksPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(editSubjectCategoriesForSampleBooksPage.clickAddProductCodesButton(),
                "Click 'Add' button.");

        eReports.compareTrue(editSubjectCategoriesForSampleBooksPage.clickConfirmAddingSubjectCategoriesButton(),
                "Click 'Confirm' button to complete adding product codes.");

        String message = "Record for Subject Categories for Journal Seq No. " + bookNumber + " successfully updated. Please review below.";
        eReports.compareTrue(editSubjectCategoriesForSampleBooksPage.isMessageDisplayed(message),
                "Verify that '" + message +"' message is displayed.");
    }
    public void journalEditSubjectCategoriesForSampleBooksTest_BVT() {
        String bookNumber = prop.getProperty("editingCategoriesCodesForSampleBooks_bookNumber");

        eReports.createNode("JOURNAL -> Edit Subject Categories -> For Sample Books.",
                "Verify Edit Subject Categories For For Sample Books.");

        EditSubjectCategoriesForSampleBooksPage editSubjectCategoriesForSampleBooksPage = new EditSubjectCategoriesForSampleBooksPage();
        if (eReports.compareNotNULL(editSubjectCategoriesForSampleBooksPage,
                "Open 'JOURNAL -> Edit Subject Categories -> For Sample Books page.")) {

            eReports.compareTrue(editSubjectCategoriesForSampleBooksPage.setJournalSequence(bookNumber),
                    "Set Journal Sequence number to " + bookNumber);

            eReports.compareTrue(editSubjectCategoriesForSampleBooksPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editSubjectCategoriesForSampleBooksPage.addButton.isDisplayed()
                            && editSubjectCategoriesForSampleBooksPage.isPageOpened(),
                    "Verify that Edit Subject Categories For For Sample page is opened.");
        }
    }

    public void journalEditSubjectCategoriesForSeriesTest() {
        String seriesNumber = prop.getProperty("editCategoriesCodesForSeries_seriesNumber");

        eReports.createNode("JOURNAL -> Edit Subject Categories -> For Series.",
                "Verify Edit Subject Categories For Series Page.");

        EditSubjectCategoriesForSeriesPage editSubjectCategoriesForSeriesPage = new EditSubjectCategoriesForSeriesPage();
        eReports.compareNotNULL(editSubjectCategoriesForSeriesPage,
                "Open 'JOURNAL -> Edit Subject Categories -> For Series page.");

        eReports.compareTrue(editSubjectCategoriesForSeriesPage.setJournalSequence(seriesNumber),
                "Set Journal Sequence number to " + seriesNumber);

        eReports.compareTrue(editSubjectCategoriesForSeriesPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(editSubjectCategoriesForSeriesPage.clickAddProductCodesButton(),
                "Click 'Add' button.");

        eReports.compareTrue(editSubjectCategoriesForSeriesPage.clickConfirmAddingSubjectCategoriesButton(),
                "Click 'Confirm' button to complete adding product codes.");

        String message = "Record for Subject Categories for Journal Seq No. " + seriesNumber + " successfully updated. Please review below.";
        eReports.compareTrue(editSubjectCategoriesForSeriesPage.isMessageDisplayed(message),
                "Verify that '" + message +"' message is displayed.");
    }
    public void journalEditSubjectCategoriesForSeriesTest_BVT() {
        String seriesNumber = prop.getProperty("editCategoriesCodesForSeries_seriesNumber");

        eReports.createNode("JOURNAL -> Edit Subject Categories -> For Series.",
                "Verify Edit Subject Categories For Series Page.");

        EditSubjectCategoriesForSeriesPage editSubjectCategoriesForSeriesPage = new EditSubjectCategoriesForSeriesPage();
        if (eReports.compareNotNULL(editSubjectCategoriesForSeriesPage,
                "Open 'JOURNAL -> Edit Subject Categories -> For Series page.")) {

            eReports.compareTrue(editSubjectCategoriesForSeriesPage.setJournalSequence(seriesNumber),
                    "Set Journal Sequence number to " + seriesNumber);

            eReports.compareTrue(editSubjectCategoriesForSeriesPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editSubjectCategoriesForSeriesPage.addButton.isDisplayed()
                            && editSubjectCategoriesForSeriesPage.isPageOpened(),
                    "Verify that Edit Subject Categories For Series page is opened.");
        }
    }

    public void journalProductCodeHistoryTest() {
        String journalSequenceNumber = prop.getProperty("journalProductCodeHistory_JournalSequence");

        eReports.createNode("JOURNAL -> Journal Product Code History.",
                "Verify Journal Product Code History Page.");

        JournalProductCodeHistoryPage journalProductCodeHistoryPage = new JournalProductCodeHistoryPage();
        eReports.compareNotNULL(journalProductCodeHistoryPage,
                "Open 'JOURNAL -> Journal Product Code History page.");

        eReports.compareTrue(journalProductCodeHistoryPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        eReports.compareTrue(journalProductCodeHistoryPage.clickSubmit(),
                "Click 'Submit' button.");

        /*
        eReports.compareNotNULL(journalProductCodeHistoryPage.clickCDRXTab(),
                "Open 'Journal Issues List' tab.");
        eReports.compareNotNULL(journalProductCodeHistoryPage.clickJrnlXRefTab(),
                "Open 'Journal Changes' tab.");
        eReports.compareNotNULL(journalProductCodeHistoryPage.clickPCSCTab(),
                "Open 'Journal Product Codes Inquiry' tab.");
        eReports.compareNotNULL(journalProductCodeHistoryPage.clickPCHistTab(),
                "Open 'Journal Product Code History' tab.");
        eReports.compareNotNULL(journalProductCodeHistoryPage.clickSCHistTab(),
                "Open 'Journal Subject Catagory History' tab.");
        eReports.compareNotNULL(journalProductCodeHistoryPage.clickRoyInqTab(),
                "Open 'Journal Royalty Inquiry' tab.");
        eReports.compareNotNULL(journalProductCodeHistoryPage.clickSubsHistTab(),
                "Open 'Journal Subscription History' tab.");
        eReports.compareNotNULL(journalProductCodeHistoryPage.clickIssueLoginTab(),
                "Open 'Issue Login for a Journal' tab.");
        eReports.compareNotNULL(journalProductCodeHistoryPage.clickJrnlInqTab(),
                "Open 'Journal Inquiry' tab.");
        */
    }
    public void journalProductCodeHistoryTest_BVT() {
        String journalSequenceNumber = prop.getProperty("journalProductCodeHistory_JournalSequence");

        eReports.createNode("JOURNAL -> Journal Product Code History.",
                "Verify Journal Product Code History Page.");

        JournalProductCodeHistoryPage journalProductCodeHistoryPage = new JournalProductCodeHistoryPage();
        if (eReports.compareNotNULL(journalProductCodeHistoryPage,
                "Open 'JOURNAL -> Journal Product Code History page.")) {

            eReports.compareTrue(journalProductCodeHistoryPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            eReports.compareTrue(journalProductCodeHistoryPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(journalProductCodeHistoryPage.isPageOpened(),
                    "Verify that Journal Product Code History page is opened.");
        }
    }

    //ToDo: Sophia Journal Maintenance

    public void journalSubjectCategoryHistoryTest() {
        String journalSequenceNumber = prop.getProperty("subjectCategoryHistory_JournalSequence");

        eReports.createNode("JOURNAL -> Subject Category History.",
                "Verify Journal Subject Catagory History Page.");

        JournalSubjectCategoryHistoryPage journalSubjectCatagoryHistoryPage = new JournalSubjectCategoryHistoryPage();
        eReports.compareNotNULL(journalSubjectCatagoryHistoryPage,
                "Open 'JOURNAL -> Journal Subject Catagory History page.");

        eReports.compareTrue(journalSubjectCatagoryHistoryPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        eReports.compareTrue(journalSubjectCatagoryHistoryPage.clickSubmit(),
                "Click 'Submit' button.");
/*
        eReports.compareNotNULL(journalSubjectCatagoryHistoryPage.clickCDRXTab(),
                "Open 'Journal Issues List' tab.");
        eReports.compareNotNULL(journalSubjectCatagoryHistoryPage.clickJrnlXRefTab(),
                "Open 'Journal Changes' tab.");
        eReports.compareNotNULL(journalSubjectCatagoryHistoryPage.clickPCSCTab(),
                "Open 'Journal Product Codes Inquiry' tab.");
        eReports.compareNotNULL(journalSubjectCatagoryHistoryPage.clickPCHistTab(),
                "Open 'Journal Product Code History' tab.");
        eReports.compareNotNULL(journalSubjectCatagoryHistoryPage.clickSCHistTab(),
                "Open 'Journal Subject Catagory History' tab.");
        eReports.compareNotNULL(journalSubjectCatagoryHistoryPage.clickRoyInqTab(),
                "Open 'Journal Royalty Inquiry' tab.");
        eReports.compareNotNULL(journalSubjectCatagoryHistoryPage.clickSubsHistTab(),
                "Open 'Journal Subscription History' tab.");
        eReports.compareNotNULL(journalSubjectCatagoryHistoryPage.clickIssueLoginTab(),
                "Open 'Issue Login for a Journal' tab.");
        eReports.compareNotNULL(journalSubjectCatagoryHistoryPage.clickJrnlInqTab(),
                "Open 'Journal Inquiry' tab.");
*/
    }
    public void journalSubjectCategoryHistoryTest_BVT() {
        String journalSequenceNumber = prop.getProperty("subjectCategoryHistory_JournalSequence");

        eReports.createNode("JOURNAL -> Subject Category History.",
                "Verify Journal Subject Category History Page.");

        JournalSubjectCategoryHistoryPage journalSubjectCategoryHistoryPage = new JournalSubjectCategoryHistoryPage();
        if (eReports.compareNotNULL(journalSubjectCategoryHistoryPage,
                "Open 'JOURNAL -> Subject Category History page.")) {

            eReports.compareTrue(journalSubjectCategoryHistoryPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            eReports.compareTrue(journalSubjectCategoryHistoryPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(journalSubjectCategoryHistoryPage.isPageOpened(),
                    "Verify that Journal Subject Category History page is opened.");
        }
    }

    public void journalViewIssuesTest() {
        String journalSequenceNumber = prop.getProperty("viewIssuesCRDX_JournalSequence");

        eReports.createNode("JOURNAL -> View Issues (CRDX).",
                "Verify Journal Issues List Page.");

        JournalIssuesListPage journalIssuesListPage = new JournalIssuesListPage();
        eReports.compareNotNULL(journalIssuesListPage,
                "Open 'JOURNAL -> Journal Issues List page.");

        eReports.compareTrue(journalIssuesListPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        eReports.compareTrue(journalIssuesListPage.clickSubmit(),
                "Click 'Submit' button.");
/*
        eReports.compareNotNULL(journalIssuesListPage.clickCDRXTab(),
                "Open 'Journal Issues List' tab.");
        eReports.compareNotNULL(journalIssuesListPage.clickJrnlXRefTab(),
                "Open 'Journal Changes' tab.");
        eReports.compareNotNULL(journalIssuesListPage.clickPCSCTab(),
                "Open 'Journal Product Codes Inquiry' tab.");
        eReports.compareNotNULL(journalIssuesListPage.clickPCHistTab(),
                "Open 'Journal Product Code History' tab.");
        eReports.compareNotNULL(journalIssuesListPage.clickSCHistTab(),
                "Open 'Journal Subject Catagory History' tab.");
        eReports.compareNotNULL(journalIssuesListPage.clickRoyInqTab(),
                "Open 'Journal Royalty Inquiry' tab.");
        eReports.compareNotNULL(journalIssuesListPage.clickSubsHistTab(),
                "Open 'Journal Subscription History' tab.");
        eReports.compareNotNULL(journalIssuesListPage.clickIssueLoginTab(),
                "Open 'Issue Login for a Journal' tab.");
        eReports.compareNotNULL(journalIssuesListPage.clickJrnlInqTab(),
                "Open 'Journal Inquiry' tab.");
*/
    }
    public void journalViewIssuesTest_BVT() {
        String journalSequenceNumber = prop.getProperty("viewIssuesCRDX_JournalSequence");

        eReports.createNode("JOURNAL -> View Issues (CRDX).",
                "Verify Journal Issues List Page.");

        JournalIssuesListPage journalIssuesListPage = new JournalIssuesListPage();
        if (eReports.compareNotNULL(journalIssuesListPage,
                "Open 'JOURNAL -> Journal Issues List page.")) {

            eReports.compareTrue(journalIssuesListPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            eReports.compareTrue(journalIssuesListPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(journalIssuesListPage.isPageOpened(),
                    "Verify that Journal Issues List page is opened.");
        }
    }

    public void journalRoyaltyInquiryTest() {
        String journalSequenceNumber = prop.getProperty("journalRoyaltyInquiry_JournalSequence");

        eReports.createNode("JOURNAL -> Royalty -> Royalty Inquiry.",
                "Verify Journal Royalty Inquiry Page.");

        JournalRoyaltyInquiryPage royaltyInquiryPage = new JournalRoyaltyInquiryPage();
        eReports.compareNotNULL(royaltyInquiryPage,
                "Open 'JOURNAL -> Journal Royalty Inquiry page.");

        eReports.compareTrue(royaltyInquiryPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        eReports.compareTrue(royaltyInquiryPage.clickSubmit(),
                "Click 'Submit' button.");
/*
        eReports.compareNotNULL(royaltyInquiryPage.clickCDRXTab(),
                "Open 'Journal Issues List' tab.");
        eReports.compareNotNULL(royaltyInquiryPage.clickJrnlXRefTab(),
                "Open 'Journal Changes' tab.");
        eReports.compareNotNULL(royaltyInquiryPage.clickPCSCTab(),
                "Open 'Journal Product Codes Inquiry' tab.");
        eReports.compareNotNULL(royaltyInquiryPage.clickPCHistTab(),
                "Open 'Journal Product Code History' tab.");
        eReports.compareNotNULL(royaltyInquiryPage.clickSCHistTab(),
                "Open 'Journal Subject Catagory History' tab.");
        eReports.compareNotNULL(royaltyInquiryPage.clickRoyInqTab(),
                "Open 'Journal Royalty Inquiry' tab.");
        eReports.compareNotNULL(royaltyInquiryPage.clickSubsHistTab(),
                "Open 'Journal Subscription History' tab.");
        eReports.compareNotNULL(royaltyInquiryPage.clickIssueLoginTab(),
                "Open 'Issue Login for a Journal' tab.");
        eReports.compareNotNULL(royaltyInquiryPage.clickJrnlInqTab(),
                "Open 'Journal Inquiry' tab.");
*/
    }
    public void journalRoyaltyInquiryTest_BVT() {
        String journalSequenceNumber = prop.getProperty("journalRoyaltyInquiry_JournalSequence");

        eReports.createNode("JOURNAL -> Royalty -> Royalty Inquiry.",
                "Verify Journal Royalty Inquiry Page.");

        JournalRoyaltyInquiryPage royaltyInquiryPage = new JournalRoyaltyInquiryPage();
        if (eReports.compareNotNULL(royaltyInquiryPage,
                "Open 'JOURNAL -> Journal Royalty Inquiry page.")) {

            eReports.compareTrue(royaltyInquiryPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            eReports.compareTrue(royaltyInquiryPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(royaltyInquiryPage.publisherNumber.isDisplayed() && royaltyInquiryPage.isPageOpened(),
                    "Verify that Journal Royalty Inquiry page is opened.");
        }
    }

    public void journalEditRoyaltyTest() {
        String journalSequenceNumber = prop.getProperty("journalEditRoyalty_JournalSequence");

        eReports.createNode("JOURNAL -> Royalty -> Edit Royalty.",
                "Verify Edit Royalty Page.");

        EditJournalRoyaltyPage editingJournalRoyaltyPage = new EditJournalRoyaltyPage();
        eReports.compareNotNULL(editingJournalRoyaltyPage, "JOURNAL -> Royalty -> Edit Royalty page.");

        eReports.compareTrue(editingJournalRoyaltyPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        eReports.compareTrue(editingJournalRoyaltyPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(editingJournalRoyaltyPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalRoyaltyInquiryPage journalRoyaltyInquiryPage = editingJournalRoyaltyPage.clickConfirmButton();
        eReports.compareNotNULL(journalRoyaltyInquiryPage,
                "Click 'Confirm' button and verify Journal Inquiry page is opened.");

        String message = "Record for Royalty for Journal # " + journalSequenceNumber + " successfully updated. Please review below.";
        eReports.compareTrue(journalRoyaltyInquiryPage.isMessageDisplayed(message),
                "Verify that '" + message +"' message is displayed.");
    }
    public void journalEditRoyaltyTest_BVT() {
        String journalSequenceNumber = prop.getProperty("journalEditRoyalty_JournalSequence");

        eReports.createNode("JOURNAL -> Royalty -> Edit Royalty.",
                "Verify Edit Royalty Page.");

        EditJournalRoyaltyPage editingJournalRoyaltyPage = new EditJournalRoyaltyPage();
        if (eReports.compareNotNULL(editingJournalRoyaltyPage, "JOURNAL -> Royalty -> Edit Royalty page.")) {

            eReports.compareTrue(editingJournalRoyaltyPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);

            eReports.compareTrue(editingJournalRoyaltyPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editingJournalRoyaltyPage.publisherNumber.isDisplayed()
                            && editingJournalRoyaltyPage.isPageOpened(),
                    "Verify that Edit Royalty page is opened.");
        }
    }

    public void journalSubscriptionDetailsTest() {
        String journalSequenceNumber = prop.getProperty("journalSubscriptionDetails_JournalSequence");

        eReports.createNode("JOURNAL -> Subscriptions -> Subscription Details.",
                "Journal Subscription Details Page.");

        JournalSubscriptionDetailsPage journalSubscriptionDetailsPage = new JournalSubscriptionDetailsPage();
        eReports.compareNotNULL(journalSubscriptionDetailsPage,
                "JOURNAL -> Subscriptions -> Subscription Details page.");

        eReports.compareTrue(journalSubscriptionDetailsPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);

        eReports.compareTrue(journalSubscriptionDetailsPage.clickSubmit(),
                "Click 'Submit' button.");
    }
    public void journalSubscriptionDetailsTest_BVT() {
        String journalSequenceNumber = prop.getProperty("journalSubscriptionDetails_JournalSequence");

        eReports.createNode("JOURNAL -> Subscriptions -> Subscription Details.",
                "Journal Subscription Details Page.");

        JournalSubscriptionDetailsPage journalSubscriptionDetailsPage = new JournalSubscriptionDetailsPage();
        if (eReports.compareNotNULL(journalSubscriptionDetailsPage,
                "JOURNAL -> Subscriptions -> Subscription Details page.")) {

            eReports.compareTrue(journalSubscriptionDetailsPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);

            eReports.compareTrue(journalSubscriptionDetailsPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(journalSubscriptionDetailsPage.journalSeqNo.isDisplayed()
                            && journalSubscriptionDetailsPage.isPageOpened(),
                    "Verify that Journal Subscription Details page is opened.");
        }
    }

    public void journalSubscriptionHistoryTest() {
        String journalSequenceNumber = prop.getProperty("journalViewHistory_JournalSequence");

        eReports.createNode("JOURNAL -> Subscriptions -> View History.",
                "Verify View History Page.");

        JournalSubscriptionHistoryPage journalSubscriptionHistoryPage = new JournalSubscriptionHistoryPage();
        eReports.compareNotNULL(journalSubscriptionHistoryPage,
                "Open 'JOURNAL -> Subscriptions -> View History page.");

        eReports.compareTrue(journalSubscriptionHistoryPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        eReports.compareTrue(journalSubscriptionHistoryPage.clickSubmit(),
                "Click 'Submit' button.");
/*
        eReports.compareNotNULL(journalSubscriptionHistoryPage.clickCDRXTab(),
                "Open 'Journal Issues List' tab.");
        eReports.compareNotNULL(journalSubscriptionHistoryPage.clickJrnlXRefTab(),
                "Open 'Journal Changes' tab.");
        eReports.compareNotNULL(journalSubscriptionHistoryPage.clickPCSCTab(),
                "Open 'Journal Product Codes Inquiry' tab.");
        eReports.compareNotNULL(journalSubscriptionHistoryPage.clickPCHistTab(),
                "Open 'Journal Product Code History' tab.");
        eReports.compareNotNULL(journalSubscriptionHistoryPage.clickSCHistTab(),
                "Open 'Journal Subject Catagory History' tab.");
        eReports.compareNotNULL(journalSubscriptionHistoryPage.clickRoyInqTab(),
                "Open 'Journal Royalty Inquiry' tab.");
        eReports.compareNotNULL(journalSubscriptionHistoryPage.clickSubsHistTab(),
                "Open 'Journal Subscription History' tab.");
        eReports.compareNotNULL(journalSubscriptionHistoryPage.clickIssueLoginTab(),
                "Open 'Issue Login for a Journal' tab.");
        eReports.compareNotNULL(journalSubscriptionHistoryPage.clickJrnlInqTab(),
                "Open 'Journal Inquiry' tab.");
*/
    }
    public void journalSubscriptionHistoryTest_BVT() {
        String journalSequenceNumber = prop.getProperty("journalViewHistory_JournalSequence");

        eReports.createNode("JOURNAL -> Subscriptions -> View History.",
                "Verify View History Page.");

        JournalSubscriptionHistoryPage journalSubscriptionHistoryPage = new JournalSubscriptionHistoryPage();
        if (eReports.compareNotNULL(journalSubscriptionHistoryPage,
                "Open 'JOURNAL -> Subscriptions -> View History page.")) {

            eReports.compareTrue(journalSubscriptionHistoryPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            eReports.compareTrue(journalSubscriptionHistoryPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(journalSubscriptionHistoryPage.journalSeqNo.isDisplayed()
                            && journalSubscriptionHistoryPage.isPageOpened(),
                    "Verify that View History page is opened.");
        }
    }

    public void journalSubscriptionViewEditHistoryTest() {
        String journalSequenceNumber = prop.getProperty("journalEditHistory_JournalSequence");
        String seqNo = prop.getProperty("journalEditHistory_seqNo");

        eReports.createNode("JOURNAL -> Subscriptions -> View History.",
                "Verify View Edit History Page.");

        JournalSubscriptionHistoryEditViewPage journalSubscriptionHistoryEditViewPage = new JournalSubscriptionHistoryEditViewPage();
        if (eReports.compareNotNULL(journalSubscriptionHistoryEditViewPage,
                "Open 'JOURNAL -> Subscriptions -> View History' page.")) {

            eReports.compareTrue(journalSubscriptionHistoryEditViewPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);

            eReports.compareTrue(journalSubscriptionHistoryEditViewPage.clickSubmit(),
                    "Click 'Submit' button.");

            JournalSubscriptionHistoryEditPage journalSubscriptionHistoryEditPage = journalSubscriptionHistoryEditViewPage.clickEditButton(seqNo);
            if (eReports.compareNotNULL(journalSubscriptionHistoryEditPage,
                    "Click 'edit' button and verify that the edit page is opened.")) {

                eReports.compareTrue(journalSubscriptionHistoryEditPage.clickSubmitChanges(),
                        "Click 'Submit Changes' button.");

                JournalSubscriptionDetailsPage journalSubscriptionDetailsPage = journalSubscriptionHistoryEditPage.clickConfirmButton();
                eReports.compareNotNULL(journalSubscriptionDetailsPage,
                        "Click 'Confirm' button and verify Journal Inquiry page is opened.");

                String message = "Record for Journal Seq# " + journalSequenceNumber + " successfully updated. Please review below.";
                eReports.compareTrue(journalSubscriptionDetailsPage.isMessageDisplayed(message),
                        "Verify that '" + message + "' message is displayed.");
            }
        }
    }
    public void journalSubscriptionViewEditHistoryTest_BVT() {
        String journalSequenceNumber = prop.getProperty("journalEditHistory_JournalSequence");

        eReports.createNode("JOURNAL -> Subscriptions -> View History.",
                "Verify View Edit History Page.");

        JournalSubscriptionHistoryEditViewPage journalSubscriptionHistoryEditViewPage = new JournalSubscriptionHistoryEditViewPage();
        if (eReports.compareNotNULL(journalSubscriptionHistoryEditViewPage,
                "Open 'JOURNAL -> Subscriptions -> View History' page.")) {

            eReports.compareTrue(journalSubscriptionHistoryEditViewPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);

            eReports.compareTrue(journalSubscriptionHistoryEditViewPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(journalSubscriptionHistoryEditViewPage.journalSeqNo.isDisplayed()
                            && journalSubscriptionHistoryEditViewPage.isPageOpened(),
                    "Verify that View Edit History page is opened.");
        }
    }

    public void journalChangesTest() {
        String journalChangesNumber = prop.getProperty("journalChangesNumber");

        eReports.createNode("JOURNAL -> Journal Changes.",
                "Verify Journal Changes Page.");

        JournalChangesPage journalChangesPage = new JournalChangesPage();
        eReports.compareNotNULL(journalChangesPage,
                "Open 'JOURNAL -> Journal Changes page.");

        eReports.compareTrue(journalChangesPage.setJournalSequence(journalChangesNumber),
                "Set Journal Sequence number to " + journalChangesNumber);
        eReports.compareTrue(journalChangesPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(journalChangesPage.actionsList.size() > 0,
                "Verify that Journal Changes are displayed on the page.");
    }
    public void journalChangesTest_BVT() {
        String journalChangesNumber = prop.getProperty("journalChangesNumber");

        eReports.createNode("JOURNAL -> Journal Changes.",
                "Verify Journal Changes Page.");

        JournalChangesPage journalChangesPage = new JournalChangesPage();
        if (eReports.compareNotNULL(journalChangesPage,
                "Open 'JOURNAL -> Journal Changes page.")) {

            eReports.compareTrue(journalChangesPage.setJournalSequence(journalChangesNumber),
                    "Set Journal Sequence number to " + journalChangesNumber);
            eReports.compareTrue(journalChangesPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(journalChangesPage.jrnlBookSeq.isDisplayed()
                            && journalChangesPage.isPageOpened(),
                    "Verify that View Edit History page is opened.");
        }
    }

    public void journalEditXRefNotesTest() {
        String journalNumberForXRefNotes = prop.getProperty("journalNumberForXRefNotes");
        String updateNotes = prop.getProperty("updateNotes");

        eReports.createNode("JOURNAL -> Edit XRef Notes.",
                "Verify Edit XRef Notes Page.");

        EditXRefNotesPage editXRefNotesPage = new EditXRefNotesPage();
        eReports.compareNotNULL(editXRefNotesPage,
                "Open 'JOURNAL -> Edit XRef Notes page.");

        eReports.compareTrue(editXRefNotesPage.setJournalSequence(journalNumberForXRefNotes),
                "Set Journal Sequence number to " + journalNumberForXRefNotes);
        eReports.compareTrue(editXRefNotesPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(editXRefNotesPage.notes.setText(updateNotes),
                "Set '" + updateNotes + "' to notes field.");

        JournalChangesPage journalChangesPage = editXRefNotesPage.clickUpdateButton();
        if (eReports.compareNotNULL(journalChangesPage,
                "Click 'Update' button.")) {

            eReports.compare(updateNotes, journalChangesPage.getElementValue(journalChangesPage.actionPerformedNotes.asWebElement()),
                    "Verify the notes field was updated.");

            eReports.compareTrue(journalChangesPage.updateMessage.isDisplayed(),
                    "Verify the 'Notes information has been successfully updated'.");
        }
    }
    public void journalEditXRefNotesTest_BVT() {
        String journalNumberForXRefNotes = prop.getProperty("journalNumberForXRefNotes");

        eReports.createNode("JOURNAL -> Edit XRef Notes.",
                "Verify Edit XRef Notes Page.");

        EditXRefNotesPage editXRefNotesPage = new EditXRefNotesPage();
        if (eReports.compareNotNULL(editXRefNotesPage,
                "Open 'JOURNAL -> Edit XRef Notes page.")) {

            eReports.compareTrue(editXRefNotesPage.setJournalSequence(journalNumberForXRefNotes),
                    "Set Journal Sequence number to " + journalNumberForXRefNotes);

            eReports.compareTrue(editXRefNotesPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editXRefNotesPage.jrnlBookSeq.isDisplayed()
                            && editXRefNotesPage.isPageOpened(),
                    "Verify that Edit XRef Notes page is opened.");
        }
    }

    public void journalIssueLoginTest() {
        String journalSequence = prop.getProperty("journalNumberForIssueLogin");
        String media = prop.getProperty("media");
        String pubYearRange = prop.getProperty("pubYearRange");

        eReports.createNode("JOURNAL -> Issue Login.",
                "Verify Issue Login for a Journal Page.");

        JournalIssueLoginPage journalIssueLoginPage = new JournalIssueLoginPage();
        eReports.compareNotNULL(journalIssueLoginPage,
                "Open 'JOURNAL -> Issue Login for a Journal page.");

        eReports.compareTrue(journalIssueLoginPage.setJournalSequence(journalSequence),
                "Set Journal Sequence number to " + journalSequence);
        eReports.compareTrue(journalIssueLoginPage.clickSubmit(),
                "Click 'Submit' button.");


        eReports.compareTrue(journalIssueLoginPage.selectMedia(media),
                "Set 'Media' to " + media);
        eReports.compareTrue(journalIssueLoginPage.pubYearRange.setText(pubYearRange),
                "Set 'PubYear Range' to " + pubYearRange);

        eReports.compareTrue(journalIssueLoginPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        IssueDetailsPage issueDetailsPage = journalIssueLoginPage.clickConfirmButton();
        if (eReports.compareNotNULL(issueDetailsPage,
                "Click 'Confirm' button and verify Issue Details page is opened.")) {

            eReports.compare(journalSequence,
                    issueDetailsPage.getElementValue(issueDetailsPage.journalSeq.asWebElement()),
                    "Verify that Journal Seq. # is " + journalSequence);
        }
        dfIssueNo = issueDetailsPage.getElementValue(issueDetailsPage.issueNoLabel.asWebElement());
    }
    public void journalIssueLoginTest_BVT() {
        String journalSequence = prop.getProperty("journalNumberForIssueLogin");

        eReports.createNode("JOURNAL -> Issue Login.",
                "Verify Issue Login for a Journal Page.");

        JournalIssueLoginPage journalIssueLoginPage = new JournalIssueLoginPage();
        if (eReports.compareNotNULL(journalIssueLoginPage,
                "Open 'JOURNAL -> Issue Login for a Journal page.")) {

            eReports.compareTrue(journalIssueLoginPage.setJournalSequence(journalSequence),
                    "Set Journal Sequence number to " + journalSequence);

            eReports.compareTrue(journalIssueLoginPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(journalIssueLoginPage.jrnlBookSeq.isDisplayed()
                            && journalIssueLoginPage.isPageOpened(),
                    "Verify that Issue Login page is opened.");
        }
    }

    public void journalTransformingBookTest() {
        String sampleBookNumber = prop.getProperty("sampleBookNumber");

        eReports.createNode("JOURNAL -> Transform a Sample Book.",
                "Verify Transforming a Book Page.");

        TransformingBookPage transformingBookPage = new TransformingBookPage();
        eReports.compareNotNULL(transformingBookPage,
                "Open 'JOURNAL -> Transforming a Book page.");

        eReports.compareTrue(transformingBookPage.setJournalSequence(sampleBookNumber),
                "Set Journal Sequence number to " + sampleBookNumber);
        eReports.compareTrue(transformingBookPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(transformingBookPage.transformBookButton.isDisplayed(),
                "Verify that 'Transform Book' button is displayed.");

        eReports.compareTrue(transformingBookPage.transformBookButton.isDisplayed(),
                "Verify that 'Transform Book' button is displayed.");

        BookInquiryPage bookInquiryPage = transformingBookPage.clickTransformButton();
        eReports.compareNotNULL(bookInquiryPage,
                "Click 'Transform' button and verify that the book was transformed.");
    }
    public void journalTransformingBookTest_BVT() {
        String sampleBookNumber = prop.getProperty("sampleBookNumber");

        eReports.createNode("JOURNAL -> Transform a Sample Book.",
                "Verify Transforming a Book Page.");

        TransformingBookPage transformingBookPage = new TransformingBookPage();
        if (eReports.compareNotNULL(transformingBookPage,
                "Open 'JOURNAL -> Transforming a Book page.")) {

            eReports.compareTrue(transformingBookPage.setJournalSequence(sampleBookNumber),
                    "Set Journal Sequence number to " + sampleBookNumber);

            eReports.compareTrue(transformingBookPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(transformingBookPage.jrnlBookSeq.isDisplayed()
                            && transformingBookPage.isPageOpened(),
                    "Verify that Transforming a Book page is opened.");
        }
    }

    public void journalTransformingSampleJournalTest() {
        String sampleJournalNumber = prop.getProperty("sampleJournalNumber");

        eReports.createNode("JOURNAL -> Transforming a Sample Journal.",
                "Verify Transforming a Sample Journal Page.");

        TransformingSampleJournalPage transformingSampleJournalPage = new TransformingSampleJournalPage();
        eReports.compareNotNULL(transformingSampleJournalPage,
                "Open 'JOURNAL -> Transforming a Sample Journal page.");

        eReports.compareTrue(transformingSampleJournalPage.setJournalSequence(sampleJournalNumber),
                "Set Journal Sequence number to " + sampleJournalNumber);
        eReports.compareTrue(transformingSampleJournalPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(transformingSampleJournalPage.submitChanges.isDisplayed(),
                "Verify that 'Submit Changes' button is displayed.");

        //ToDo: Закончить, когда пойму как выставить разрешение на трансформацию журнала
    }
    public void journalTransformingSampleJournalTest_BVT() {
        String sampleJournalNumber = prop.getProperty("sampleJournalNumber");

        eReports.createNode("JOURNAL -> Transforming a Sample Journal.",
                "Verify Transforming a Sample Journal Page.");

        TransformingSampleJournalPage transformingSampleJournalPage = new TransformingSampleJournalPage();
        if (eReports.compareNotNULL(transformingSampleJournalPage,
                "Open 'JOURNAL -> Transforming a Sample Journal page.")) {

            eReports.compareTrue(transformingSampleJournalPage.setJournalSequence(sampleJournalNumber),
                    "Set Journal Sequence number to " + sampleJournalNumber);
            eReports.compareTrue(transformingSampleJournalPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(transformingSampleJournalPage.jrnlBookSeq.isDisplayed()
                            && transformingSampleJournalPage.isPageOpened(),
                    "Verify that Transforming a Sample Journal page is opened.");
        }
    }

    public void journalAlterTitlesTest(String journalSequence) {
        eReports.createNode("JOURNAL -> Journal XRef -> Alter Titles.",
                "Verify Alter Titles Page.");

        AlterTitlesPage alterTitlesPage = new AlterTitlesPage();
        eReports.compareNotNULL(alterTitlesPage,
                "Open 'JOURNAL -> Journal XRef -> Alter Titles page.");

        eReports.compareTrue(alterTitlesPage.setJournalSequence(journalSequence),
                "Set Journal Sequence number to " + journalSequence);
        eReports.compareTrue(alterTitlesPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(alterTitlesPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalChangesPage journalChangesPage = alterTitlesPage.clickConfirmButton();
        eReports.compareNotNULL(journalChangesPage,
                "Click 'Confirm' button and verify Journal Changes page is opened.");

        String message = "Record for Publication Titles for Journal Seq No. " + journalSequence + " successfully updated. Please review below.";
        eReports.compareTrue(journalChangesPage.isMessageDisplayed(message),
                "Verify that '" + message +"' message is displayed.");
    }
    public void journalAlterTitlesTest_BVT(String journalSequence) {
        eReports.createNode("JOURNAL -> Journal XRef -> Alter Titles.",
                "Verify Alter Titles Page.");

        AlterTitlesPage alterTitlesPage = new AlterTitlesPage();
        if (eReports.compareNotNULL(alterTitlesPage,
                "Open 'JOURNAL -> Journal XRef -> Alter Titles page.")) {

            eReports.compareTrue(alterTitlesPage.setJournalSequence(journalSequence),
                    "Set Journal Sequence number to " + journalSequence);

            eReports.compareTrue(alterTitlesPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(alterTitlesPage.submitChanges.isDisplayed()
                            && alterTitlesPage.isPageOpened(),
                    "Verify that Alter Titles page is opened.");
        }
    }

    public void dropSuspendCeaseTest(String journalSequence) {
        eReports.createNode("JOURNAL -> Journal XRef -> Drop Suspend Cease.",
                "Verify Drop Suspend Cease Page.");

        DropSuspendCeasePage dropSuspendCeasePage = new DropSuspendCeasePage();
        eReports.compareNotNULL(dropSuspendCeasePage,
                "Open 'JOURNAL -> Journal XRef -> Drop Suspend Cease page.");

        eReports.compareTrue(dropSuspendCeasePage.setJournalSequence(journalSequence),
                "Set Journal Sequence number to " + journalSequence);
        eReports.compareTrue(dropSuspendCeasePage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(dropSuspendCeasePage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        eReports.compareTrue(dropSuspendCeasePage.suspendOption.set(),
                "Select 'Suspend' option.");

        JournalChangesPage journalChangesPage = dropSuspendCeasePage.clickConfirmButton();
        eReports.compareNotNULL(journalChangesPage,
                "Click 'Confirm' button and verify Journal Changes page is opened.");
    }
    public void dropSuspendCeaseTest_BVT(String journalSequence) {
        eReports.createNode("JOURNAL -> Journal XRef -> Drop Suspend Cease.",
                "Verify Drop Suspend Cease Page.");

        DropSuspendCeasePage dropSuspendCeasePage = new DropSuspendCeasePage();
        if (eReports.compareNotNULL(dropSuspendCeasePage,
                "Open 'JOURNAL -> Journal XRef -> Drop Suspend Cease page.")) {

            eReports.compareTrue(dropSuspendCeasePage.setJournalSequence(journalSequence),
                    "Set Journal Sequence number to " + journalSequence);

            eReports.compareTrue(dropSuspendCeasePage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(dropSuspendCeasePage.submitChanges.isDisplayed()
                            && dropSuspendCeasePage.isPageOpened(),
                    "Verify that Alter Titles page is opened.");
        }
    }

    public void reactivateTest(String journalSequence) {
        eReports.createNode("JOURNAL -> Journal XRef -> Drop Suspend Cease.",
                "Verify Drop Suspend Cease Page.");

        DropSuspendCeasePage dropSuspendCeasePage = new DropSuspendCeasePage();
        eReports.compareNotNULL(dropSuspendCeasePage,
                "Open 'JOURNAL -> Journal XRef -> Drop Suspend Cease' page.");

        eReports.compareTrue(dropSuspendCeasePage.setJournalSequence(journalSequence),
                "Set Journal Sequence number to " + journalSequence);
        eReports.compareTrue(dropSuspendCeasePage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(dropSuspendCeasePage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        eReports.compareTrue(dropSuspendCeasePage.reactivateOption.set(),
                "Select 'Suspend' option.");

        JournalChangesPage journalChangesPage = dropSuspendCeasePage.clickConfirmButton();
        eReports.compareNotNULL(journalChangesPage,
                "Click 'Confirm' button and verify Journal Changes page is opened.");

        String message = "Record for Journal Seq No. " + journalSequence + " has been reactivateed. successfully updated. Please review below.";
        eReports.compareTrue(journalChangesPage.isMessageDisplayed(message),
                "Verify that '" + message +"' message is displayed.");
    }

    public void absorbTest(String journalSequence) {
        eReports.createNode("JOURNAL -> Journal XRef -> Absorb.",
                "Verify Absorb Page.");

        AbsorbPage absorbPage = new AbsorbPage();
        eReports.compareNotNULL(absorbPage,
                "Open 'JOURNAL -> Journal XRef -> Absorb page.");

        eReports.compareTrue(absorbPage.setJournalSequence(journalSequence),
                "Set Journal Sequence number to " + journalSequence);
        eReports.compareTrue(absorbPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(absorbPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalChangesPage journalChangesPage = absorbPage.clickConfirmButton();
        eReports.compareNotNULL(journalChangesPage,
                "Click 'Confirm' button and verify Journal Changes page is opened.");

        //ToDo: Доделать когда будет понятна вся функциональность
    }
    public void absorbTest_BVT(String journalSequence) {
        eReports.createNode("JOURNAL -> Journal XRef -> Absorb.",
                "Verify Absorb Page.");

        AbsorbPage absorbPage = new AbsorbPage();
        if (eReports.compareNotNULL(absorbPage,
                "Open 'JOURNAL -> Journal XRef -> Absorb page.")) {

            eReports.compareTrue(absorbPage.setJournalSequence(journalSequence),
                    "Set Journal Sequence number to " + journalSequence);

            eReports.compareTrue(absorbPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(absorbPage.submitChanges.isDisplayed()
                            && absorbPage.isPageOpened(),
                    "Verify that Absorb page is opened.");
        }
    }

    public void mergeTest(String journalSequence) {
        eReports.createNode("JOURNAL -> Journal XRef -> Merge.",
                "Verify Merge Page.");

        MergePage mergePage = new MergePage();
        eReports.compareNotNULL(mergePage,
                "Open 'JOURNAL -> Journal XRef -> Merge page.");

        eReports.compareTrue(mergePage.setJournalSequence(journalSequence),
                "Set Journal Sequence number to " + journalSequence);
        eReports.compareTrue(mergePage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(mergePage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalChangesPage journalChangesPage = mergePage.clickConfirmButton();
        eReports.compareNotNULL(journalChangesPage,
                "Click 'Confirm' button and verify Journal Changes page is opened.");

        //ToDo: Доделать когда будет понятна вся функциональность
    }
    public void mergeTest_BVT(String journalSequence) {
        eReports.createNode("JOURNAL -> Journal XRef -> Merge.",
                "Verify Merge Page.");

        MergePage mergePage = new MergePage();
        if (eReports.compareNotNULL(mergePage,
                "Open 'JOURNAL -> Journal XRef -> Merge page.")) {

            eReports.compareTrue(mergePage.setJournalSequence(journalSequence),
                    "Set Journal Sequence number to " + journalSequence);

            eReports.compareTrue(mergePage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(mergePage.submitChanges.isDisplayed()
                            && mergePage.isPageOpened(),
                    "Verify that Merge page is opened.");
        }
    }

    public void splitTest(String journalSequence) {
        eReports.createNode("JOURNAL -> Journal XRef -> Split.",
                "Verify Split Page.");

        SplitPage splitPage = new SplitPage();
        eReports.compareNotNULL(splitPage,
                "Open 'JOURNAL -> Journal XRef -> Split page.");

        eReports.compareTrue(splitPage.setJournalSequence(journalSequence),
                "Set Journal Sequence number to " + journalSequence);
        eReports.compareTrue(splitPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(splitPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalChangesPage journalChangesPage = splitPage.clickConfirmButton();
        eReports.compareNotNULL(journalChangesPage,
                "Click 'Confirm' button and verify Journal Changes page is opened.");

        //ToDo: Доделать когда будет понятна вся функциональность
    }
    public void splitTest_BVT(String journalSequence) {
        eReports.createNode("JOURNAL -> Journal XRef -> Split.",
                "Verify Split Page.");

        SplitPage splitPage = new SplitPage();
        if (eReports.compareNotNULL(splitPage,
                "Open 'JOURNAL -> Journal XRef -> Split page.")) {

            eReports.compareTrue(splitPage.setJournalSequence(journalSequence),
                    "Set Journal Sequence number to " + journalSequence);

            eReports.compareTrue(splitPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(splitPage.submitChanges.isDisplayed()
                            && splitPage.isPageOpened(),
                    "Verify that Split page is opened.");
        }
    }

    public void titleChangesTest(String journalSequenceFirst, String journalSequenceSecond) {
        eReports.createNode("JOURNAL -> Journal XRef -> Title Changes.",
                "Verify Title Changes Page.");

        TitleChangesPage titleChangesPage = new TitleChangesPage();
        eReports.compareNotNULL(titleChangesPage,
                "Open 'JOURNAL -> Journal XRef -> Title Changes page.");

        eReports.compareTrue(titleChangesPage.setJournalSequence(journalSequenceFirst),
                "Set Journal Sequence number to " + journalSequenceFirst);
        eReports.compareTrue(titleChangesPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(titleChangesPage.acusitionUser.setText(journalSequenceSecond),
                "Set '" + journalSequenceSecond + "' to the 'Change to Jrnl Seq #' field.");

        eReports.compareTrue(titleChangesPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalChangesPage journalChangesPage = titleChangesPage.clickConfirmButton();
        eReports.compareNotNULL(journalChangesPage,
                "Click 'Confirm' button and verify Journal Changes page is opened.");
    }
    public void titleChangesTest_BVT(String journalSequenceFirst) {
        eReports.createNode("JOURNAL -> Journal XRef -> Title Changes.",
                "Verify Title Changes Page.");

        TitleChangesPage titleChangesPage = new TitleChangesPage();
        if (eReports.compareNotNULL(titleChangesPage,
                "Open 'JOURNAL -> Journal XRef -> Title Changes page.")) {

            eReports.compareTrue(titleChangesPage.setJournalSequence(journalSequenceFirst),
                    "Set Journal Sequence number to " + journalSequenceFirst);

            eReports.compareTrue(titleChangesPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(titleChangesPage.submitChanges.isDisplayed()
                            && titleChangesPage.isPageOpened(),
                    "Verify that Title Changes page is opened.");
        }
    }

    public void addVariantsTest(String journalSequence) {
        eReports.createNode("JOURNAL -> Journal XRef -> Add Variants.",
                "Verify Add Variants Page.");

        VariantsPage variantsPage = new VariantsPage();
        eReports.compareNotNULL(variantsPage,
                "Open 'JOURNAL -> Journal XRef -> Add Variants page.");

        eReports.compareTrue(variantsPage.setJournalSequence(journalSequence),
                "Set Journal Sequence number to " + journalSequence);
        eReports.compareTrue(variantsPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(variantsPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalInquiryPage journalInquiryPage = variantsPage.clickConfirmButton();
        if (eReports.compareNotNULL(journalInquiryPage,
                "Click 'Confirm' button and verify Journal Inquiry page is opened.")) {

            String message = "Record for Variants for Journal Seq No. "
                    + journalSequence + " has been processed. successfully updated. Please review below.";
            eReports.compareTrue(journalInquiryPage.isMessageDisplayed(message),
                    "Verify that '" + message + "' message is displayed.");
        }
    }
    public void addVariantsTest_BVT(String journalSequence) {
        eReports.createNode("JOURNAL -> Journal XRef -> Add Variants.",
                "Verify Add Variants Page.");

        VariantsPage variantsPage = new VariantsPage();
        if (eReports.compareNotNULL(variantsPage,
                "Open 'JOURNAL -> Journal XRef -> Add Variants page.")) {

            eReports.compareTrue(variantsPage.setJournalSequence(journalSequence),
                    "Set Journal Sequence number to " + journalSequence);

            eReports.compareTrue(variantsPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(variantsPage.submitChanges.isDisplayed()
                            && variantsPage.isPageOpened(),
                    "Verify that Title Changes page is opened.");
        }
    }
}
