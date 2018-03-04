package tests.journal;

import com.reporting.ExtentManager;
import pages.issue.IssueDetailsPage;
import pages.journal.*;
import pages.journal.EditProductCodes.*;
import pages.journal.EditSubjectCategories.*;
import pages.publisher.BookInquiryPage;
import tests.OCS_Test;

import java.util.Properties;

public class JournalTests {
    public static ExtentManager eReports = OCS_Test.eReports;
    public static Properties prop = OCS_Test.prop;

    //String journalSequenceNumber = prop.getProperty("journalSequenceNumber");
    String dfIssueNo = "";

    public JournalTests() {
    }

    public void journalInquiryTest() {
        String journalSequenceNumber = prop.getProperty("journalSequenceNumber");

        ExtentManager.createNode("JOURNAL -> Journal Inquiry Page.", "Verify Journal Inquiry Page.");

        JournalInquiryPage journalInquiryPage = new JournalInquiryPage();
        if (ExtentManager.compareNotNULL(journalInquiryPage, "Open 'JOURNAL -> Journal Inquiry' page.")) {

            ExtentManager.compareTrue(journalInquiryPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            ExtentManager.compareTrue(journalInquiryPage.clickSubmit(),
                    "Click 'Submit' button.");

            ExtentManager.compareNotNULL(journalInquiryPage.clickCDRXTab(),
                    "Open 'Journal Issues List' tab.");
            ExtentManager.compareNotNULL(journalInquiryPage.clickJrnlXRefTab(),
                    "Open 'Journal Changes' tab.");
            ExtentManager.compareNotNULL(journalInquiryPage.clickPCSCTab(),
                    "Open 'Journal Product Codes Inquiry' tab.");
            ExtentManager.compareNotNULL(journalInquiryPage.clickPCHistTab(),
                    "Open 'Journal Product Code History' tab.");
            ExtentManager.compareNotNULL(journalInquiryPage.clickSCHistTab(),
                    "Open 'Journal Subject Catagory History' tab.");
            ExtentManager.compareNotNULL(journalInquiryPage.clickRoyInqTab(),
                    "Open 'Journal Royalty Inquiry' tab.");
            ExtentManager.compareNotNULL(journalInquiryPage.clickSubsHistTab(),
                    "Open 'Journal Subscription History' tab.");
            ExtentManager.compareNotNULL(journalInquiryPage.clickIssueLoginTab(),
                    "Open 'Issue Login for a Journal' tab.");
            ExtentManager.compareNotNULL(journalInquiryPage.clickJrnlInqTab(),
                    "Open 'Journal Inquiry' tab.");
        }
    }

    public void journalEditCoveredJournalTest() {
        String journalSequenceNumber = prop.getProperty("editCoveredJournal_journalSequenceNumber");

        ExtentManager.createNode("JOURNAL -> EDIT -> Edit Covered Journal.", "Verify Edit Covered Journal Page.");

        EditCoveredJournalPage editCoveredJournalPage = new EditCoveredJournalPage();
        if (ExtentManager.compareNotNULL(editCoveredJournalPage,
                "Open 'JOURNAL -> EDIT -> Edit Covered Journal page.")) {

            ExtentManager.compareTrue(editCoveredJournalPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            ExtentManager.compareTrue(editCoveredJournalPage.clickSubmit(),
                    "Click 'Submit' button.");

            ExtentManager.compareTrue(editCoveredJournalPage.clickSubmitChanges(),
                    "Click 'Submit Changes' button.");

            JournalInquiryPage journalInquiryPage = editCoveredJournalPage.clickConfirmButton();
            ExtentManager.compareNotNULL(journalInquiryPage,
                    "Click 'Confirm' button and verify Journal Inquiry page is opened.");
        }
    }

    public void journalEditSampleJournalTest() {
        String journalSequenceNumber = prop.getProperty("editSampleJournal_journalSequenceNumber");

        ExtentManager.createNode("JOURNAL -> EDIT -> Edit Sample Journal.", "Verify Edit Sample Journal Page.");

        EditSampleJournalPage editSampleJournalPage = new EditSampleJournalPage();
        if (ExtentManager.compareNotNULL(editSampleJournalPage,
                "Open 'JOURNAL -> EDIT -> Edit Sample Journal page.")) {

            ExtentManager.compareTrue(editSampleJournalPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            ExtentManager.compareTrue(editSampleJournalPage.clickSubmit(),
                    "Click 'Submit' button.");

            ExtentManager.compareTrue(editSampleJournalPage.clickSubmitChanges(),
                    "Click 'Submit Changes' button.");

            JournalInquiryPage journalInquiryPage = editSampleJournalPage.clickConfirmButton();
            ExtentManager.compareNotNULL(journalInquiryPage,
                    "Click 'Confirm' button and verify Journal Inquiry page is opened.");
        }
    }

    public void journalEditBookTest() {
        String bookNumber = prop.getProperty("editBook_bookNumber");

        ExtentManager.createNode("JOURNAL -> EDIT -> Edit Book.", "Verify Edit Book Page.");

        EditBookPage editBookPage = new EditBookPage();
        if (ExtentManager.compareNotNULL(editBookPage,
                "Open 'JOURNAL -> EDIT -> Edit Book page.")) {

            ExtentManager.compareTrue(editBookPage.setJournalSequence(bookNumber),
                    "Set Journal Sequence number to " + bookNumber);
            ExtentManager.compareTrue(editBookPage.clickSubmit(),
                    "Click 'Submit' button.");

            ExtentManager.compareTrue(editBookPage.clickSubmitChanges(),
                    "Click 'Submit Changes' button.");

            BookInquiryPage bookInquiryPage = editBookPage.clickConfirmButton();
            ExtentManager.compareNotNULL(bookInquiryPage,
                    "Click 'Confirm' button and verify Book Inquiry page is opened.");
        }
    }

    public void journalEditSampleBookTest() {
        String sampleBookNumber = prop.getProperty("editSampleBook_sampleBookNumber");

        ExtentManager.createNode("JOURNAL -> EDIT -> Edit Sample Book.", "Verify Edit Sample Book Page.");

        EditSampleBookPage editSampleBookPage = new EditSampleBookPage();
        if (ExtentManager.compareNotNULL(editSampleBookPage,
                "Open 'JOURNAL -> EDIT -> Edit Sample Book page.")) {

            ExtentManager.compareTrue(editSampleBookPage.setJournalSequence(sampleBookNumber),
                    "Set Journal Sequence number to " + sampleBookNumber);
            ExtentManager.compareTrue(editSampleBookPage.clickSubmit(),
                    "Click 'Submit' button.");

            ExtentManager.compareTrue(editSampleBookPage.clickSubmitChanges(),
                    "Click 'Submit Changes' button.");

            BookInquiryPage bookInquiryPage = editSampleBookPage.clickConfirmButton();
            ExtentManager.compareNotNULL(bookInquiryPage,
                    "Click 'Confirm' button and verify Book Inquiry page is opened.");
        }
    }

    public void journalEditSeriesTest() {
        String seriesNumber = prop.getProperty("editSeries_seriesNumber");

        ExtentManager.createNode("JOURNAL -> EDIT -> Edit Series.", "Verify Edit Series Page.");

        EditSeriesPage editSeriesPage = new EditSeriesPage();
        if (ExtentManager.compareNotNULL(editSeriesPage,
                "Open 'JOURNAL -> EDIT -> Edit Series page.")) {

            ExtentManager.compareTrue(editSeriesPage.setJournalSequence(seriesNumber),
                    "Set Journal Sequence number to " + seriesNumber);
            ExtentManager.compareTrue(editSeriesPage.clickSubmit(),
                    "Click 'Submit' button.");

            ExtentManager.compareTrue(editSeriesPage.clickSubmitChanges(),
                    "Click 'Submit Changes' button.");

            JournalInquiryPage journalInquiryPage = editSeriesPage.clickConfirmButton();
            ExtentManager.compareNotNULL(journalInquiryPage,
                    "Click 'Confirm' button and verify Journal Inquiry page is opened.");
        }
    }

    public void JournalProductCodesInquiryTest() {
        String journalSequenceNumber = prop.getProperty("journalProductCodesInquiry_journalSequenceNumber");

        ExtentManager.createNode("JOURNAL -> Prod. Codes - Subj. Categories Page.", "Verify Journal Product Codes Inquiry Page.");

        JournalProductCodesInquiryPage journalProductCodesInquiryPage = new JournalProductCodesInquiryPage();
        if (ExtentManager.compareNotNULL(journalProductCodesInquiryPage,
                "Open 'JOURNAL -> Journal Product Codes Inquiry' page.")) {

            ExtentManager.compareTrue(journalProductCodesInquiryPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            ExtentManager.compareTrue(journalProductCodesInquiryPage.clickSubmit(),
                    "Click 'Submit' button.");

            ExtentManager.compareNotNULL(journalProductCodesInquiryPage.clickCDRXTab(),
                    "Open 'Journal Issues List' tab.");
            ExtentManager.compareNotNULL(journalProductCodesInquiryPage.clickJrnlXRefTab(),
                    "Open 'Journal Changes' tab.");
            ExtentManager.compareNotNULL(journalProductCodesInquiryPage.clickPCSCTab(),
                    "Open 'Journal Product Codes Inquiry' tab.");
            ExtentManager.compareNotNULL(journalProductCodesInquiryPage.clickPCHistTab(),
                    "Open 'Journal Product Code History' tab.");
            ExtentManager.compareNotNULL(journalProductCodesInquiryPage.clickSCHistTab(),
                    "Open 'Journal Subject Catagory History' tab.");
            ExtentManager.compareNotNULL(journalProductCodesInquiryPage.clickRoyInqTab(),
                    "Open 'Journal Royalty Inquiry' tab.");
            ExtentManager.compareNotNULL(journalProductCodesInquiryPage.clickSubsHistTab(),
                    "Open 'Journal Subscription History' tab.");
            ExtentManager.compareNotNULL(journalProductCodesInquiryPage.clickIssueLoginTab(),
                    "Open 'Issue Login for a Journal' tab.");
            ExtentManager.compareNotNULL(journalProductCodesInquiryPage.clickJrnlInqTab(),
                    "Open 'Journal Inquiry' tab.");
        }
    }

    public void journalEditProductCodesForJournalsTest() {
        String journalSequenceNumber = prop.getProperty("editingProductCodesForJournals_JournalSequence");

        ExtentManager.createNode("JOURNAL -> Edit Product Codes -> For Journals.", "Verify Edit Product Codes For Journals Page.");

        EditProductCodesForJournalsPage editProductCodesForJournalsPage = new EditProductCodesForJournalsPage();
        if (ExtentManager.compareNotNULL(editProductCodesForJournalsPage,
                "Open 'JOURNAL -> Edit Product Codes -> For Journals page.")) {

            ExtentManager.compareTrue(editProductCodesForJournalsPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            ExtentManager.compareTrue(editProductCodesForJournalsPage.clickSubmit(),
                    "Click 'Submit' button.");

            ExtentManager.compareTrue(editProductCodesForJournalsPage.clickAddProductCodesButton(),
                    "Click 'Add' button.");

            ExtentManager.compareTrue(editProductCodesForJournalsPage.clickConfirmAddingProductCodesButton(),
                    "Click 'Confirm' button to complete adding product codes.");

            ExtentManager.compareTrue(editProductCodesForJournalsPage.clickAddSubjectCategoriesButton(),
                    "Click 'Add' button to add Subject Categories.");

            ExtentManager.compareTrue(editProductCodesForJournalsPage.clickConfirmAddingButton(),
                    "Click 'Confirm' button to add Subject Categories.");

            ExtentManager.compareTrue(editProductCodesForJournalsPage.clickSubmitChanges(),
                    "Click 'Submit Changes' button.");

            JournalInquiryPage journalInquiryPage = editProductCodesForJournalsPage.clickConfirmButton();
            ExtentManager.compareNotNULL(journalInquiryPage,
                    "Click 'Confirm' button and verify Journal Inquiry page is opened.");
        }
    }

    public void journalEditProductCodesForSampleJournalsTest() {
        String journalSequenceNumber = prop.getProperty("journalEditProductCodesForSampleJournals_JournalSequence");

        ExtentManager.createNode("JOURNAL -> Edit Product Codes -> For Sample Journals.",
                "Verify Edit Product Codes For Sample Journals Page.");

        EditProductCodesForSampleJournalsPage editProductCodesForSampleJournalsPage = new EditProductCodesForSampleJournalsPage();
        if (ExtentManager.compareNotNULL(editProductCodesForSampleJournalsPage,
                "Open 'JOURNAL -> Edit Product Codes -> For Sample Journals page.")) {

            ExtentManager.compareTrue(editProductCodesForSampleJournalsPage.setJournalSequence(journalSequenceNumber),
                    "Set Journal Sequence number to " + journalSequenceNumber);
            ExtentManager.compareTrue(editProductCodesForSampleJournalsPage.clickSubmit(),
                    "Click 'Submit' button.");

            ExtentManager.compareTrue(editProductCodesForSampleJournalsPage.clickAddProductCodesButton(),
                    "Click 'Add' button.");

            ExtentManager.compareTrue(editProductCodesForSampleJournalsPage.clickConfirmAddingProductCodesButton(),
                    "Click 'Confirm' button to complete adding product codes.");

            ExtentManager.compareTrue(editProductCodesForSampleJournalsPage.updateMessage.isDisplayed(),
                    "Verify that 'Product code(s) :  has/have been successfully added.' message is displayed.");
}
    }

    public void journalEditProductCodesForBooksTest() {
        String bookNumber = prop.getProperty("editingProductCodesForBooks_bookNumber");

        ExtentManager.createNode("JOURNAL -> Edit Product Codes -> For Books.",
                "Verify Edit Product Codes For Books Page.");

        EditProductCodesForBooksPage editProductCodesForBooksPage = new EditProductCodesForBooksPage();
        if (ExtentManager.compareNotNULL(editProductCodesForBooksPage,
                "Open 'JOURNAL -> Edit Product Codes -> For Books page.")) {

            ExtentManager.compareTrue(editProductCodesForBooksPage.setJournalSequence(bookNumber),
                    "Set Journal Sequence number to " + bookNumber);
            ExtentManager.compareTrue(editProductCodesForBooksPage.clickSubmit(),
                    "Click 'Submit' button.");

            ExtentManager.compareTrue(editProductCodesForBooksPage.clickAddProductCodesButton(),
                    "Click 'Add' button.");

            ExtentManager.compareTrue(editProductCodesForBooksPage.clickConfirmAddingProductCodesButton(),
                    "Click 'Confirm' button to complete adding product codes.");

            ExtentManager.compareTrue(editProductCodesForBooksPage.updateMessage.isDisplayed(),
                    "Verify that 'Product code(s) :  has/have been successfully added.' message is displayed.");
        }
    }

    public void journalEditProductCodesForSampleBooksTest() {
        String bookNumber = prop.getProperty("editingProductCodesForSampleBooks_bookNumber");

        ExtentManager.createNode("JOURNAL -> Edit Product Codes -> For Sample Books.",
                "Verify Edit Product Codes For Sample Books Page.");

        EditProductCodesForSampleBooksPage editProductCodesForSampleBooksPage = new EditProductCodesForSampleBooksPage();
        if (ExtentManager.compareNotNULL(editProductCodesForSampleBooksPage,
                "Open 'JOURNAL -> Edit Product Codes -> For Sample Books page.")) {

            ExtentManager.compareTrue(editProductCodesForSampleBooksPage.setJournalSequence(bookNumber),
                    "Set Journal Sequence number to " + bookNumber);
            ExtentManager.compareTrue(editProductCodesForSampleBooksPage.clickSubmit(),
                    "Click 'Submit' button.");


            ExtentManager.compareTrue(editProductCodesForSampleBooksPage.clickAddProductCodesButton(),
                    "Click 'Add' button.");

            ExtentManager.compareTrue(editProductCodesForSampleBooksPage.clickConfirmAddingProductCodesButton(),
                    "Click 'Confirm' button to complete adding product codes.");

            ExtentManager.compareTrue(editProductCodesForSampleBooksPage.updateMessage.isDisplayed(),
                    "Verify that 'Product code(s) :  has/have been successfully added.' message is displayed.");
        }
    }

    public void journalEditProductCodesForSeriesTest() {
        String seriesNumber = prop.getProperty("editProductCodesForSeries_seriesNumber");

            ExtentManager.createNode("JOURNAL -> Edit Product Codes -> For Series.",
                    "Verify Edit Product Codes For Series Page.");

        EditProductCodesForSeriesPage editProductCodesForSeriesPage = new EditProductCodesForSeriesPage();
        if (ExtentManager.compareNotNULL(editProductCodesForSeriesPage,
                "Open 'JOURNAL -> Edit Product Codes -> For Series page.")) {

            ExtentManager.compareTrue(editProductCodesForSeriesPage.setJournalSequence(seriesNumber),
                    "Set Journal Sequence number to " + seriesNumber);
            ExtentManager.compareTrue(editProductCodesForSeriesPage.clickSubmit(),
                    "Click 'Submit' button.");


            ExtentManager.compareTrue(editProductCodesForSeriesPage.clickAddProductCodesButton(),
                    "Click 'Add' button.");

            ExtentManager.compareTrue(editProductCodesForSeriesPage.clickConfirmAddingProductCodesButton(),
                    "Click 'Confirm' button to complete adding product codes.");

            ExtentManager.compareTrue(editProductCodesForSeriesPage.updateMessage.isDisplayed(),
                    "Verify that 'Product code(s) :  has/have been successfully added.' message is displayed.");
        }
    }
/*
    public void journalEditSubjectCategoriesForJournalsTest() {
        ExtentManager.createNode("JOURNAL -> Edit Subject Categories -> For Journals.",
                "Verify Edit Subject Categories For Journals Page.");

        EditSubjectCategoriesForJournalsPage editSubjectCategoriesForJournalsPage = new EditSubjectCategoriesForJournalsPage();
        ExtentManager.compareNotNULL(editSubjectCategoriesForJournalsPage,
                "Open 'JOURNAL -> Edit Subject Categories -> For Journals page.");

        ExtentManager.compareTrue(editSubjectCategoriesForJournalsPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        ExtentManager.compareTrue(editSubjectCategoriesForJournalsPage.clickSubmit(),
                "Click 'Submit' button.");


        ExtentManager.compareTrue(editSubjectCategoriesForJournalsPage.clickAddProductCodesButton(),
                "Click 'Add' button.");

        ExtentManager.compareTrue(editSubjectCategoriesForJournalsPage.clickConfirmAddingSubjectCategoriesButton(),
                "Click 'Confirm' button to complete adding product codes.");

        ExtentManager.compareTrue(editSubjectCategoriesForJournalsPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalInquiryPage journalInquiryPage = editSubjectCategoriesForJournalsPage.clickConfirmButton();
        ExtentManager.compareNotNULL(journalInquiryPage,
                "Click 'Confirm' button and verify Journal Inquiry page is opened.");
    }

    public void journalEditSubjectCategoriesForSampleJournalsTest() {
        ExtentManager.createNode("JOURNAL -> Edit Subject Categories -> For Sample Journals.",
                "Verify Edit Subject Categories For Sample Journals Page.");

        EditSubjectCategoriesForSampleJournalsPage editSubjectCategoriesForSampleJournalsPage = new EditSubjectCategoriesForSampleJournalsPage();
        ExtentManager.compareNotNULL(editSubjectCategoriesForSampleJournalsPage,
                "Open 'JOURNAL -> Edit Subject Categories -> For Sample Journals page.");

        ExtentManager.compareTrue(editSubjectCategoriesForSampleJournalsPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        ExtentManager.compareTrue(editSubjectCategoriesForSampleJournalsPage.clickSubmit(),
                "Click 'Submit' button.");


        ExtentManager.compareTrue(editSubjectCategoriesForSampleJournalsPage.clickAddProductCodesButton(),
                "Click 'Add' button.");

        ExtentManager.compareTrue(editSubjectCategoriesForSampleJournalsPage.clickConfirmAddingSubjectCategoriesButton(),
                "Click 'Confirm' button to complete adding product codes.");

        ExtentManager.compareTrue(editSubjectCategoriesForSampleJournalsPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalInquiryPage journalInquiryPage = editSubjectCategoriesForSampleJournalsPage.clickConfirmButton();
        ExtentManager.compareNotNULL(journalInquiryPage,
                "Click 'Confirm' button and verify Journal Inquiry page is opened.");
    }

    public void journalEditSubjectCategoriesForBooksTest() {
        ExtentManager.createNode("JOURNAL -> Edit Subject Categories -> For Books.",
                "Verify Edit Subject Categories For Books Page.");

        EditSubjectCategoriesForBooksPage editSubjectCategoriesForBooksPage = new EditSubjectCategoriesForBooksPage();
        ExtentManager.compareNotNULL(editSubjectCategoriesForBooksPage,
                "Open 'JOURNAL -> Edit Subject Categories -> For Books page.");

        ExtentManager.compareTrue(editSubjectCategoriesForBooksPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        ExtentManager.compareTrue(editSubjectCategoriesForBooksPage.clickSubmit(),
                "Click 'Submit' button.");


        ExtentManager.compareTrue(editSubjectCategoriesForBooksPage.clickAddProductCodesButton(),
                "Click 'Add' button.");

        ExtentManager.compareTrue(editSubjectCategoriesForBooksPage.clickConfirmAddingSubjectCategoriesButton(),
                "Click 'Confirm' button to complete adding product codes.");

        ExtentManager.compareTrue(editSubjectCategoriesForBooksPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalInquiryPage journalInquiryPage = editSubjectCategoriesForBooksPage.clickConfirmButton();
        ExtentManager.compareNotNULL(journalInquiryPage,
                "Click 'Confirm' button and verify Journal Inquiry page is opened.");
    }

    public void journalEditSubjectCategoriesForSampleBooksTest() {
        ExtentManager.createNode("JOURNAL -> Edit Subject Categories -> For Sample Books.",
                "Verify Edit Subject Categories For For Sample Books.");

        EditSubjectCategoriesForSampleBooksPage editSubjectCategoriesForSampleBooksPage = new EditSubjectCategoriesForSampleBooksPage();
        ExtentManager.compareNotNULL(editSubjectCategoriesForSampleBooksPage,
                "Open 'JOURNAL -> Edit Subject Categories -> For Sample Books page.");

        ExtentManager.compareTrue(editSubjectCategoriesForSampleBooksPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        ExtentManager.compareTrue(editSubjectCategoriesForSampleBooksPage.clickSubmit(),
                "Click 'Submit' button.");


        ExtentManager.compareTrue(editSubjectCategoriesForSampleBooksPage.clickAddProductCodesButton(),
                "Click 'Add' button.");

        ExtentManager.compareTrue(editSubjectCategoriesForSampleBooksPage.clickConfirmAddingSubjectCategoriesButton(),
                "Click 'Confirm' button to complete adding product codes.");

        ExtentManager.compareTrue(editSubjectCategoriesForSampleBooksPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalInquiryPage journalInquiryPage = editSubjectCategoriesForSampleBooksPage.clickConfirmButton();
        ExtentManager.compareNotNULL(journalInquiryPage,
                "Click 'Confirm' button and verify Journal Inquiry page is opened.");
    }

    public void journalEditSubjectCategoriesForSeriesTest() {
        ExtentManager.createNode("JOURNAL -> Edit Subject Categories -> For Series.",
                "Verify Edit Subject Categories For Series Page.");

        EditSubjectCategoriesForSeriesPage editSubjectCategoriesForSeriesPage = new EditSubjectCategoriesForSeriesPage();
        ExtentManager.compareNotNULL(editSubjectCategoriesForSeriesPage,
                "Open 'JOURNAL -> Edit Subject Categories -> For Series page.");

        ExtentManager.compareTrue(editSubjectCategoriesForSeriesPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        ExtentManager.compareTrue(editSubjectCategoriesForSeriesPage.clickSubmit(),
                "Click 'Submit' button.");


        ExtentManager.compareTrue(editSubjectCategoriesForSeriesPage.clickAddProductCodesButton(),
                "Click 'Add' button.");

        ExtentManager.compareTrue(editSubjectCategoriesForSeriesPage.clickConfirmAddingSubjectCategoriesButton(),
                "Click 'Confirm' button to complete adding product codes.");

        ExtentManager.compareTrue(editSubjectCategoriesForSeriesPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalInquiryPage journalInquiryPage = editSubjectCategoriesForSeriesPage.clickConfirmButton();
        ExtentManager.compareNotNULL(journalInquiryPage,
                "Click 'Confirm' button and verify Journal Inquiry page is opened.");
    }

    public void journalProductCodeHistoryTest() {
        ExtentManager.createNode("JOURNAL -> Journal Product Code History.",
                "Verify Journal Product Code History Page.");

        JournalProductCodeHistoryPage journalProductCodeHistoryPage = new JournalProductCodeHistoryPage();
        ExtentManager.compareNotNULL(journalProductCodeHistoryPage,
                "Open 'JOURNAL -> Journal Product Code History page.");

        ExtentManager.compareTrue(journalProductCodeHistoryPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        ExtentManager.compareTrue(journalProductCodeHistoryPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareNotNULL(journalProductCodeHistoryPage.clickCDRXTab(),
                "Open 'Journal Issues List' tab.");
        ExtentManager.compareNotNULL(journalProductCodeHistoryPage.clickJrnlXRefTab(),
                "Open 'Journal Changes' tab.");
        ExtentManager.compareNotNULL(journalProductCodeHistoryPage.clickPCSCTab(),
                "Open 'Journal Product Codes Inquiry' tab.");
        ExtentManager.compareNotNULL(journalProductCodeHistoryPage.clickPCHistTab(),
                "Open 'Journal Product Code History' tab.");
        ExtentManager.compareNotNULL(journalProductCodeHistoryPage.clickSCHistTab(),
                "Open 'Journal Subject Catagory History' tab.");
        ExtentManager.compareNotNULL(journalProductCodeHistoryPage.clickRoyInqTab(),
                "Open 'Journal Royalty Inquiry' tab.");
        ExtentManager.compareNotNULL(journalProductCodeHistoryPage.clickSubsHistTab(),
                "Open 'Journal Subscription History' tab.");
        ExtentManager.compareNotNULL(journalProductCodeHistoryPage.clickIssueLoginTab(),
                "Open 'Issue Login for a Journal' tab.");
        ExtentManager.compareNotNULL(journalProductCodeHistoryPage.clickJrnlInqTab(),
                "Open 'Journal Inquiry' tab.");
    }

    public void journalSubjectCatagoryHistoryTest() {
        ExtentManager.createNode("JOURNAL -> Subject Category History.",
                "Verify Journal Subject Catagory History Page.");

        JournalSubjectCategoryHistoryPage journalSubjectCatagoryHistoryPage = new JournalSubjectCategoryHistoryPage();
        ExtentManager.compareNotNULL(journalSubjectCatagoryHistoryPage,
                "Open 'JOURNAL -> Journal Subject Catagory History page.");

        ExtentManager.compareTrue(journalSubjectCatagoryHistoryPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        ExtentManager.compareTrue(journalSubjectCatagoryHistoryPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareNotNULL(journalSubjectCatagoryHistoryPage.clickCDRXTab(),
                "Open 'Journal Issues List' tab.");
        ExtentManager.compareNotNULL(journalSubjectCatagoryHistoryPage.clickJrnlXRefTab(),
                "Open 'Journal Changes' tab.");
        ExtentManager.compareNotNULL(journalSubjectCatagoryHistoryPage.clickPCSCTab(),
                "Open 'Journal Product Codes Inquiry' tab.");
        ExtentManager.compareNotNULL(journalSubjectCatagoryHistoryPage.clickPCHistTab(),
                "Open 'Journal Product Code History' tab.");
        ExtentManager.compareNotNULL(journalSubjectCatagoryHistoryPage.clickSCHistTab(),
                "Open 'Journal Subject Catagory History' tab.");
        ExtentManager.compareNotNULL(journalSubjectCatagoryHistoryPage.clickRoyInqTab(),
                "Open 'Journal Royalty Inquiry' tab.");
        ExtentManager.compareNotNULL(journalSubjectCatagoryHistoryPage.clickSubsHistTab(),
                "Open 'Journal Subscription History' tab.");
        ExtentManager.compareNotNULL(journalSubjectCatagoryHistoryPage.clickIssueLoginTab(),
                "Open 'Issue Login for a Journal' tab.");
        ExtentManager.compareNotNULL(journalSubjectCatagoryHistoryPage.clickJrnlInqTab(),
                "Open 'Journal Inquiry' tab.");
    }

    public void journalViewIssuesTest() {
        ExtentManager.createNode("JOURNAL -> View Issues (CRDX).",
                "Verify Journal Issues List Page.");

        JournalIssuesListPage journalIssuesListPage = new JournalIssuesListPage();
        ExtentManager.compareNotNULL(journalIssuesListPage,
                "Open 'JOURNAL -> Journal Issues List page.");

        ExtentManager.compareTrue(journalIssuesListPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        ExtentManager.compareTrue(journalIssuesListPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareNotNULL(journalIssuesListPage.clickCDRXTab(),
                "Open 'Journal Issues List' tab.");
        ExtentManager.compareNotNULL(journalIssuesListPage.clickJrnlXRefTab(),
                "Open 'Journal Changes' tab.");
        ExtentManager.compareNotNULL(journalIssuesListPage.clickPCSCTab(),
                "Open 'Journal Product Codes Inquiry' tab.");
        ExtentManager.compareNotNULL(journalIssuesListPage.clickPCHistTab(),
                "Open 'Journal Product Code History' tab.");
        ExtentManager.compareNotNULL(journalIssuesListPage.clickSCHistTab(),
                "Open 'Journal Subject Catagory History' tab.");
        ExtentManager.compareNotNULL(journalIssuesListPage.clickRoyInqTab(),
                "Open 'Journal Royalty Inquiry' tab.");
        ExtentManager.compareNotNULL(journalIssuesListPage.clickSubsHistTab(),
                "Open 'Journal Subscription History' tab.");
        ExtentManager.compareNotNULL(journalIssuesListPage.clickIssueLoginTab(),
                "Open 'Issue Login for a Journal' tab.");
        ExtentManager.compareNotNULL(journalIssuesListPage.clickJrnlInqTab(),
                "Open 'Journal Inquiry' tab.");
    }

    public void journalRoyaltyInquiryTest() {
        ExtentManager.createNode("JOURNAL -> Royalty -> Royalty Inquiry.",
                "Verify Journal Royalty Inquiry Page.");

        JournalRoyaltyInquiryPage royaltyInquiryPage = new JournalRoyaltyInquiryPage();
        ExtentManager.compareNotNULL(royaltyInquiryPage,
                "Open 'JOURNAL -> Journal Royalty Inquiry page.");

        ExtentManager.compareTrue(royaltyInquiryPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        ExtentManager.compareTrue(royaltyInquiryPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareNotNULL(royaltyInquiryPage.clickCDRXTab(),
                "Open 'Journal Issues List' tab.");
        ExtentManager.compareNotNULL(royaltyInquiryPage.clickJrnlXRefTab(),
                "Open 'Journal Changes' tab.");
        ExtentManager.compareNotNULL(royaltyInquiryPage.clickPCSCTab(),
                "Open 'Journal Product Codes Inquiry' tab.");
        ExtentManager.compareNotNULL(royaltyInquiryPage.clickPCHistTab(),
                "Open 'Journal Product Code History' tab.");
        ExtentManager.compareNotNULL(royaltyInquiryPage.clickSCHistTab(),
                "Open 'Journal Subject Catagory History' tab.");
        ExtentManager.compareNotNULL(royaltyInquiryPage.clickRoyInqTab(),
                "Open 'Journal Royalty Inquiry' tab.");
        ExtentManager.compareNotNULL(royaltyInquiryPage.clickSubsHistTab(),
                "Open 'Journal Subscription History' tab.");
        ExtentManager.compareNotNULL(royaltyInquiryPage.clickIssueLoginTab(),
                "Open 'Issue Login for a Journal' tab.");
        ExtentManager.compareNotNULL(royaltyInquiryPage.clickJrnlInqTab(),
                "Open 'Journal Inquiry' tab.");
    }

    public void journalEditRoyaltyTest() {
        ExtentManager.createNode("JOURNAL -> Royalty -> Edit Royalty.",
                "Verify Edit Royalty Page.");

        EditJournalRoyaltyPage editingJournalRoyaltyPage = new EditJournalRoyaltyPage();
        ExtentManager.compareNotNULL(editingJournalRoyaltyPage, "JOURNAL -> Royalty -> Edit Royalty page.");

        ExtentManager.compareTrue(editingJournalRoyaltyPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        ExtentManager.compareTrue(editingJournalRoyaltyPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(editingJournalRoyaltyPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalInquiryPage journalInquiryPage = editingJournalRoyaltyPage.clickConfirmButton();
        ExtentManager.compareNotNULL(journalInquiryPage,
                "Click 'Confirm' button and verify Journal Inquiry page is opened.");
    }

    public void journalSubscriptionDetailsTest() {
        ExtentManager.createNode("JOURNAL -> Subscriptions -> Subscription Details.",
                "Journal Subscription Details Page.");

        JournalSubscriptionDetailsPage journalSubscriptionDetailsPage = new JournalSubscriptionDetailsPage();
        ExtentManager.compareNotNULL(journalSubscriptionDetailsPage, "JOURNAL -> Subscriptions -> Subscription Details page.");

        ExtentManager.compareTrue(journalSubscriptionDetailsPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        ExtentManager.compareTrue(journalSubscriptionDetailsPage.clickSubmit(),
                "Click 'Submit' button.");
    }

    public void journalSubscriptionHistoryTest() {
        ExtentManager.createNode("JOURNAL -> Subscriptions -> View History.",
                "Verify View History Page.");

        JournalSubscriptionHistoryPage journalSubscriptionHistoryPage = new JournalSubscriptionHistoryPage();
        ExtentManager.compareNotNULL(journalSubscriptionHistoryPage,
                "Open 'JOURNAL -> Subscriptions -> View History page.");

        ExtentManager.compareTrue(journalSubscriptionHistoryPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        ExtentManager.compareTrue(journalSubscriptionHistoryPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareNotNULL(journalSubscriptionHistoryPage.clickCDRXTab(),
                "Open 'Journal Issues List' tab.");
        ExtentManager.compareNotNULL(journalSubscriptionHistoryPage.clickJrnlXRefTab(),
                "Open 'Journal Changes' tab.");
        ExtentManager.compareNotNULL(journalSubscriptionHistoryPage.clickPCSCTab(),
                "Open 'Journal Product Codes Inquiry' tab.");
        ExtentManager.compareNotNULL(journalSubscriptionHistoryPage.clickPCHistTab(),
                "Open 'Journal Product Code History' tab.");
        ExtentManager.compareNotNULL(journalSubscriptionHistoryPage.clickSCHistTab(),
                "Open 'Journal Subject Catagory History' tab.");
        ExtentManager.compareNotNULL(journalSubscriptionHistoryPage.clickRoyInqTab(),
                "Open 'Journal Royalty Inquiry' tab.");
        ExtentManager.compareNotNULL(journalSubscriptionHistoryPage.clickSubsHistTab(),
                "Open 'Journal Subscription History' tab.");
        ExtentManager.compareNotNULL(journalSubscriptionHistoryPage.clickIssueLoginTab(),
                "Open 'Issue Login for a Journal' tab.");
        ExtentManager.compareNotNULL(journalSubscriptionHistoryPage.clickJrnlInqTab(),
                "Open 'Journal Inquiry' tab.");
    }

    public void journalSubscriptionViewEditHistoryTest() {
        ExtentManager.createNode("JOURNAL -> Subscriptions -> View History.",
                "Verify View History Page.");

        JournalSubscriptionHistoryEditViewPage journalSubscriptionHistoryEditViewPage = new JournalSubscriptionHistoryEditViewPage();
        ExtentManager.compareNotNULL(journalSubscriptionHistoryEditViewPage,
                "Open 'JOURNAL -> Subscriptions -> View History page.");

        ExtentManager.compareTrue(journalSubscriptionHistoryEditViewPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        ExtentManager.compareTrue(journalSubscriptionHistoryEditViewPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareNotNULL(journalSubscriptionHistoryEditViewPage.clickCDRXTab(),
                "Open 'Journal Issues List' tab.");
        ExtentManager.compareNotNULL(journalSubscriptionHistoryEditViewPage.clickJrnlXRefTab(),
                "Open 'Journal Changes' tab.");
        ExtentManager.compareNotNULL(journalSubscriptionHistoryEditViewPage.clickPCSCTab(),
                "Open 'Journal Product Codes Inquiry' tab.");
        ExtentManager.compareNotNULL(journalSubscriptionHistoryEditViewPage.clickPCHistTab(),
                "Open 'Journal Product Code History' tab.");
        ExtentManager.compareNotNULL(journalSubscriptionHistoryEditViewPage.clickSCHistTab(),
                "Open 'Journal Subject Catagory History' tab.");
        ExtentManager.compareNotNULL(journalSubscriptionHistoryEditViewPage.clickRoyInqTab(),
                "Open 'Journal Royalty Inquiry' tab.");
        ExtentManager.compareNotNULL(journalSubscriptionHistoryEditViewPage.clickSubsHistTab(),
                "Open 'Journal Subscription History' tab.");
        ExtentManager.compareNotNULL(journalSubscriptionHistoryEditViewPage.clickIssueLoginTab(),
                "Open 'Issue Login for a Journal' tab.");
        ExtentManager.compareNotNULL(journalSubscriptionHistoryEditViewPage.clickJrnlInqTab(),
                "Open 'Journal Inquiry' tab.");
        //ToDo: Add edit button verifications
    }

    public void journalChangesTest() {
        String journalChangesNumber = prop.getProperty("journalChangesNumber");

        ExtentManager.createNode("JOURNAL -> Journal Changes.",
                "Verify Journal Changes Page.");

        JournalChangesPage journalChangesPage = new JournalChangesPage();
        ExtentManager.compareNotNULL(journalChangesPage,
                "Open 'JOURNAL -> Journal Changes page.");

        ExtentManager.compareTrue(journalChangesPage.setJournalSequence(journalChangesNumber),
                "Set Journal Sequence number to " + journalChangesNumber);
        ExtentManager.compareTrue(journalChangesPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareNotNULL(journalChangesPage.clickCDRXTab(),
                "Open 'Journal Issues List' tab.");
        ExtentManager.compareNotNULL(journalChangesPage.clickJrnlXRefTab(),
                "Open 'Journal Changes' tab.");
        ExtentManager.compareNotNULL(journalChangesPage.clickPCSCTab(),
                "Open 'Journal Product Codes Inquiry' tab.");
        ExtentManager.compareNotNULL(journalChangesPage.clickPCHistTab(),
                "Open 'Journal Product Code History' tab.");
        ExtentManager.compareNotNULL(journalChangesPage.clickSCHistTab(),
                "Open 'Journal Subject Catagory History' tab.");
        ExtentManager.compareNotNULL(journalChangesPage.clickRoyInqTab(),
                "Open 'Journal Royalty Inquiry' tab.");
        ExtentManager.compareNotNULL(journalChangesPage.clickSubsHistTab(),
                "Open 'Journal Subscription History' tab.");
        ExtentManager.compareNotNULL(journalChangesPage.clickIssueLoginTab(),
                "Open 'Issue Login for a Journal' tab.");
        ExtentManager.compareNotNULL(journalChangesPage.clickJrnlInqTab(),
                "Open 'Journal Inquiry' tab.");
    }

    public void journalEditXRefNotesTest() {
        String journalNumberForXRefNotes = prop.getProperty("journalNumberForXRefNotes");
        String updateNotes = prop.getProperty("updateNotes");

        ExtentManager.createNode("JOURNAL -> Edit XRef Notes.",
                "Verify Edit XRef Notes Page.");

        EditXRefNotesPage editXRefNotesPage = new EditXRefNotesPage();
        ExtentManager.compareNotNULL(editXRefNotesPage,
                "Open 'JOURNAL -> Edit XRef Notes page.");

        ExtentManager.compareTrue(editXRefNotesPage.setJournalSequence(journalNumberForXRefNotes),
                "Set Journal Sequence number to " + journalNumberForXRefNotes);
        ExtentManager.compareTrue(editXRefNotesPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(editXRefNotesPage.notes.setText(updateNotes),
                "Set '" + updateNotes + "' to notes field.");

        JournalChangesPage journalChangesPage = editXRefNotesPage.clickUpdateButton();
        if (ExtentManager.compareNotNULL(journalChangesPage,
                "Click 'Update' button.")) {
            ExtentManager.compare(updateNotes, journalChangesPage.getElementValue(journalChangesPage.actionPerformedNotes.asWebElement()),
                    "Verify the notes field was updated.");

            ExtentManager.compareNotNULL(journalChangesPage.clickCDRXTab(),
                    "Open 'Journal Issues List' tab.");
            ExtentManager.compareNotNULL(journalChangesPage.clickJrnlXRefTab(),
                    "Open 'Journal Changes' tab.");
            ExtentManager.compareNotNULL(journalChangesPage.clickPCSCTab(),
                    "Open 'Journal Product Codes Inquiry' tab.");
            ExtentManager.compareNotNULL(journalChangesPage.clickPCHistTab(),
                    "Open 'Journal Product Code History' tab.");
            ExtentManager.compareNotNULL(journalChangesPage.clickSCHistTab(),
                    "Open 'Journal Subject Catagory History' tab.");
            ExtentManager.compareNotNULL(journalChangesPage.clickRoyInqTab(),
                    "Open 'Journal Royalty Inquiry' tab.");
            ExtentManager.compareNotNULL(journalChangesPage.clickSubsHistTab(),
                    "Open 'Journal Subscription History' tab.");
            ExtentManager.compareNotNULL(journalChangesPage.clickIssueLoginTab(),
                    "Open 'Issue Login for a Journal' tab.");
            ExtentManager.compareNotNULL(journalChangesPage.clickJrnlInqTab(),
                    "Open 'Journal Inquiry' tab.");
        }
    }

    public void journalIssueLoginTest() {
        String journalNumberForIssueLogin = prop.getProperty("journalNumberForIssueLogin");
        String media = prop.getProperty("media");
        String pubYearRange = prop.getProperty("pubYearRange");

        ExtentManager.createNode("JOURNAL -> Issue Login.",
                "Verify Issue Login for a Journal Page.");

        JournalIssueLoginPage journalIssueLoginPage = new JournalIssueLoginPage();
        ExtentManager.compareNotNULL(journalIssueLoginPage,
                "Open 'JOURNAL -> Issue Login for a Journal page.");

        ExtentManager.compareTrue(journalIssueLoginPage.setJournalSequence(journalNumberForIssueLogin),
                "Set Journal Sequence number to " + journalNumberForIssueLogin);
        ExtentManager.compareTrue(journalIssueLoginPage.clickSubmit(),
                "Click 'Submit' button.");


        ExtentManager.compareTrue(journalIssueLoginPage.selectMedia(media),
                "Set 'Media' to " + media);
        ExtentManager.compareTrue(journalIssueLoginPage.pubYearRange.setText(pubYearRange),
                "Set 'PubYear Range' to " + pubYearRange);

        ExtentManager.compareTrue(journalIssueLoginPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        IssueDetailsPage issueDetailsPage = journalIssueLoginPage.clickConfirmButton();
        if (ExtentManager.compareNotNULL(issueDetailsPage,
                "Click 'Confirm' button and verify Issue Details page is opened.")) {

            ExtentManager.compare(journalNumberForIssueLogin,
                    issueDetailsPage.getElementValue(issueDetailsPage.JournalSeq.asWebElement()),
                    "Verify that Journal Seq. # is " + journalNumberForIssueLogin);
        }
        //dfIssueNo = issueDetailsPage.getElementValue(issueDetailsPage.DFIssueno.asWebElement());
    }

    public void journalTransformingBookTest() {
        String sampleBookNumber = prop.getProperty("sampleBookNumber");

        ExtentManager.createNode("JOURNAL -> Transform a Sample Book.", "Verify Transforming a Book Page.");

        TransformingBookPage transformingBookPage = new TransformingBookPage();
        ExtentManager.compareNotNULL(transformingBookPage,
                "Open 'JOURNAL -> Transforming a Book page.");

        ExtentManager.compareTrue(transformingBookPage.setJournalSequence(sampleBookNumber),
                "Set Journal Sequence number to " + sampleBookNumber);
        ExtentManager.compareTrue(transformingBookPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(transformingBookPage.transformBookButton.isDisplayed(),
                "Verify that 'Transform Book' button is displayed.");

        //ToDo: Закончить, когда пойму как выставить разрешение на трансформацию книги
    }

    public void journalTransformingSampleJournalTest() {
        String sampleJournalNumber = prop.getProperty("sampleJournalNumber");

        ExtentManager.createNode("JOURNAL -> Transforming a Sample Journal.",
                "Verify Transforming a Sample Journal Page.");

        TransformingSampleJournalPage transformingSampleJournalPage = new TransformingSampleJournalPage();
        ExtentManager.compareNotNULL(transformingSampleJournalPage,
                "Open 'JOURNAL -> Transforming a Sample Journal page.");

        ExtentManager.compareTrue(transformingSampleJournalPage.setJournalSequence(sampleJournalNumber),
                "Set Journal Sequence number to " + sampleJournalNumber);
        ExtentManager.compareTrue(transformingSampleJournalPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(transformingSampleJournalPage.submitChanges.isDisplayed(),
                "Verify that 'Submit Changes' button is displayed.");

        //ToDo: Закончить, когда пойму как выставить разрешение на трансформацию журнала
    }

    public void journalAlterTitlesTest() {
        String journalSequenceAlterTitles = prop.getProperty("journalSequenceAlterTitles");

        ExtentManager.createNode("JOURNAL -> Journal XRef -> Alter Titles.",
                "Verify Alter Titles Page.");

        AlterTitlesPage alterTitlesPage = new AlterTitlesPage();
        ExtentManager.compareNotNULL(alterTitlesPage,
                "Open 'JOURNAL -> Journal XRef -> Alter Titles page.");

        ExtentManager.compareTrue(alterTitlesPage.setJournalSequence(journalSequenceAlterTitles),
                "Set Journal Sequence number to " + journalSequenceAlterTitles);
        ExtentManager.compareTrue(alterTitlesPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(alterTitlesPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalChangesPage journalChangesPage = alterTitlesPage.clickConfirmButton();
        ExtentManager.compareNotNULL(journalChangesPage,
                "Click 'Confirm' button and verify Journal Changes page is opened.");

    }

    public void dropSuspendCeaseTest() {
        String journalSequenceDropSuspendCease = prop.getProperty("journalSequenceDropSuspendCease");

        ExtentManager.createNode("JOURNAL -> Journal XRef -> Drop Suspend Cease.",
                "Verify Drop Suspend Cease Page.");

        DropSuspendCeasePage dropSuspendCeasePage = new DropSuspendCeasePage();
        ExtentManager.compareNotNULL(dropSuspendCeasePage,
                "Open 'JOURNAL -> Journal XRef -> Drop Suspend Cease page.");

        ExtentManager.compareTrue(dropSuspendCeasePage.setJournalSequence(journalSequenceDropSuspendCease),
                "Set Journal Sequence number to " + journalSequenceDropSuspendCease);
        ExtentManager.compareTrue(dropSuspendCeasePage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(dropSuspendCeasePage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        ExtentManager.compareTrue(dropSuspendCeasePage.suspendOption.set(),
                "Select 'Suspend' option.");

        JournalChangesPage journalChangesPage = dropSuspendCeasePage.clickConfirmButton();
        ExtentManager.compareNotNULL(journalChangesPage,
                "Click 'Confirm' button and verify Journal Changes page is opened.");
    }

    public void reactivateTest() {
        String journalSequenceDropSuspendCease = prop.getProperty("journalSequenceDropSuspendCease");

        ExtentManager.createNode("JOURNAL -> Journal XRef -> Drop Suspend Cease.",
                "Verify Drop Suspend Cease Page.");

        DropSuspendCeasePage dropSuspendCeasePage = new DropSuspendCeasePage();
        ExtentManager.compareNotNULL(dropSuspendCeasePage,
                "Open 'JOURNAL -> Journal XRef -> Drop Suspend Cease page.");

        ExtentManager.compareTrue(dropSuspendCeasePage.setJournalSequence(journalSequenceDropSuspendCease),
                "Set Journal Sequence number to " + journalSequenceDropSuspendCease);
        ExtentManager.compareTrue(dropSuspendCeasePage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(dropSuspendCeasePage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        ExtentManager.compareTrue(dropSuspendCeasePage.reactivateOption.set(),
                "Select 'Suspend' option.");

        JournalChangesPage journalChangesPage = dropSuspendCeasePage.clickConfirmButton();
        ExtentManager.compareNotNULL(journalChangesPage,
                "Click 'Confirm' button and verify Journal Changes page is opened.");
    }

    public void absorbTest() {
        String journalSequenceDropSuspendCease = prop.getProperty("journalSequenceDropSuspendCease");

        ExtentManager.createNode("JOURNAL -> Journal XRef -> Absorb.",
                "Verify Absorb Page.");

        AbsorbPage absorbPage = new AbsorbPage();
        ExtentManager.compareNotNULL(absorbPage,
                "Open 'JOURNAL -> Journal XRef -> Absorb page.");

        ExtentManager.compareTrue(absorbPage.setJournalSequence(journalSequenceDropSuspendCease),
                "Set Journal Sequence number to " + journalSequenceDropSuspendCease);
        ExtentManager.compareTrue(absorbPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(absorbPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalChangesPage journalChangesPage = absorbPage.clickConfirmButton();
        ExtentManager.compareNotNULL(journalChangesPage,
                "Click 'Confirm' button and verify Journal Changes page is opened.");
    }

    public void mergeTest() {
        String journalSequenceDropSuspendCease = prop.getProperty("journalSequenceDropSuspendCease");

        ExtentManager.createNode("JOURNAL -> Journal XRef -> Merge.",
                "Verify Merge Page.");

        MergePage mergePage = new MergePage();
        ExtentManager.compareNotNULL(mergePage,
                "Open 'JOURNAL -> Journal XRef -> Merge page.");

        ExtentManager.compareTrue(mergePage.setJournalSequence(journalSequenceDropSuspendCease),
                "Set Journal Sequence number to " + journalSequenceDropSuspendCease);
        ExtentManager.compareTrue(mergePage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(mergePage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalChangesPage journalChangesPage = mergePage.clickConfirmButton();
        ExtentManager.compareNotNULL(journalChangesPage,
                "Click 'Confirm' button and verify Journal Changes page is opened.");
    }

    public void splitTest() {
        String journalSplitNumber = prop.getProperty("journalSplitNumber");

        ExtentManager.createNode("JOURNAL -> Journal XRef -> Split.",
                "Verify Split Page.");

        SplitPage splitPage = new SplitPage();
        ExtentManager.compareNotNULL(splitPage,
                "Open 'JOURNAL -> Journal XRef -> Split page.");

        ExtentManager.compareTrue(splitPage.setJournalSequence(journalSplitNumber),
                "Set Journal Sequence number to " + journalSplitNumber);
        ExtentManager.compareTrue(splitPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(splitPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalChangesPage journalChangesPage = splitPage.clickConfirmButton();
        ExtentManager.compareNotNULL(journalChangesPage,
                "Click 'Confirm' button and verify Journal Changes page is opened.");
    }

    public void titleChangesTest() {
        String journalTitleChangesSequenceNumber = prop.getProperty("journalTitleChangesSequenceNumber");

        ExtentManager.createNode("JOURNAL -> Journal XRef -> Title Changes.",
                "Verify Title Changes Page.");

        TitleChangesPage titleChangesPage = new TitleChangesPage();
        ExtentManager.compareNotNULL(titleChangesPage,
                "Open 'JOURNAL -> Journal XRef -> Title Changes page.");

        ExtentManager.compareTrue(titleChangesPage.setJournalSequence(journalTitleChangesSequenceNumber),
                "Set Journal Sequence number to " + journalTitleChangesSequenceNumber);
        ExtentManager.compareTrue(titleChangesPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(titleChangesPage.submitChanges.isDisplayed(),
                "Verify that 'Submit Changes' button is displayed.");
    }

    public void addVariantsTest() {
        String journalAddVariantsSequenceNumber = prop.getProperty("journalAddVariantsSequenceNumber");

        ExtentManager.createNode("JOURNAL -> Journal XRef -> Add Variants.",
                "Verify Add Variants Page.");

        VariantsPage variantsPage = new VariantsPage();
        ExtentManager.compareNotNULL(variantsPage,
                "Open 'JOURNAL -> Journal XRef -> Add Variants page.");

        ExtentManager.compareTrue(variantsPage.setJournalSequence(journalAddVariantsSequenceNumber),
                "Set Journal Sequence number to " + journalAddVariantsSequenceNumber);
        ExtentManager.compareTrue(variantsPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(variantsPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalChangesPage journalChangesPage = variantsPage.clickConfirmButton();
        ExtentManager.compareNotNULL(journalChangesPage,
                "Click 'Confirm' button and verify Journal Changes page is opened.");
    }
*/
}
