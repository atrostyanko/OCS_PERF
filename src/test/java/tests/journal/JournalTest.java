package tests.journal;

import com.reporting.ExtentManager;
import pages.journal.*;
import pages.journal.EditProductCodes.*;
import pages.journal.EditSubjectCategories.*;
import tests.OCS_Test;

import java.util.Properties;

public class JournalTest {
    public static ExtentManager eReports = OCS_Test.eReports;
    public static Properties prop = OCS_Test.prop;

    String journalSequenceNumber = prop.getProperty("journalSequenceNumber");

    public JournalTest() {
    }

    public void journalInquiryTest() {
        ExtentManager.createNode("JOURNAL -> Journal Inquiry Page.", "Verify Journal Inquiry Page.");

        JournalInquiryPage journalInquiryPage = new JournalInquiryPage();
        ExtentManager.compareNotNULL(journalInquiryPage, "Open 'JOURNAL -> Journal Inquiry' page.");

        ExtentManager.compareTrue(journalInquiryPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        ExtentManager.compareTrue(journalInquiryPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(journalInquiryPage.clickCDRXTab(),
                "Open 'Journal Issues List' tab.");
        ExtentManager.compareTrue(journalInquiryPage.clickJrnlXRefTab(),
                "Open 'Journal Changes' tab.");
        ExtentManager.compareTrue(journalInquiryPage.clickPCSCTab(),
                "Open 'Journal Product Codes Inquiry' tab.");
        ExtentManager.compareTrue(journalInquiryPage.clickPCHistTab(),
                "Open 'Journal Product Code History' tab.");
        ExtentManager.compareTrue(journalInquiryPage.clickSCHistTab(),
                "Open 'Journal Subject Catagory History' tab.");
        ExtentManager.compareTrue(journalInquiryPage.clickRoyInqTab(),
                "Open 'Journal Royalty Inquiry' tab.");
        ExtentManager.compareTrue(journalInquiryPage.clickSubsHistTab(),
                "Open 'Journal Subscription History' tab.");
        ExtentManager.compareTrue(journalInquiryPage.clickIssueLoginTab(),
                "Open 'Issue Login for a Journal' tab.");
        ExtentManager.compareTrue(journalInquiryPage.clickJrnlInqTab(),
                "Open 'Journal Inquiry' tab.");

    }

    public void journalEditCoveredJournalTest() {
        ExtentManager.createNode("JOURNAL -> EDIT -> Edit Covered Journal.", "Verify Edit Covered Journal Page.");

        EditCoveredJournalPage editCoveredJournalPage = new EditCoveredJournalPage();
        ExtentManager.compareNotNULL(editCoveredJournalPage, "Open 'JOURNAL -> EDIT -> Edit Covered Journal page.");

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

    public void journalEditSampleJournalTest() {
        String journalSequenceNumber_ESJ = prop.getProperty("journalSequenceNumber_ESJ");

        ExtentManager.createNode("JOURNAL -> EDIT -> Edit Sample Journal.", "Verify Edit Sample Journal Page.");

        EditSampleJournalPage editSampleJournalPage = new EditSampleJournalPage();
        ExtentManager.compareNotNULL(editSampleJournalPage, "Open 'JOURNAL -> EDIT -> Edit Sample Journal page.");

        ExtentManager.compareTrue(editSampleJournalPage.setJournalSequence(journalSequenceNumber_ESJ),
                "Set Journal Sequence number to " + journalSequenceNumber_ESJ);
        ExtentManager.compareTrue(editSampleJournalPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(editSampleJournalPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalInquiryPage journalInquiryPage = editSampleJournalPage.clickConfirmButton();
        ExtentManager.compareNotNULL(journalInquiryPage,
                "Click 'Confirm' button and verify Journal Inquiry page is opened.");
    }

    public void journalEditBookTest() {
        String bookNumber = prop.getProperty("bookNumber");

        ExtentManager.createNode("JOURNAL -> EDIT -> Edit Book.", "Verify Edit Book Page.");

        EditBookPage editBookPage = new EditBookPage();
        ExtentManager.compareNotNULL(editBookPage, "Open 'JOURNAL -> EDIT -> Edit Book page.");

        ExtentManager.compareTrue(editBookPage.setJournalSequence(bookNumber),
                "Set Journal Sequence number to " + bookNumber);
        ExtentManager.compareTrue(editBookPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(editBookPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalInquiryPage journalInquiryPage = editBookPage.clickConfirmButton();
        ExtentManager.compareNotNULL(journalInquiryPage,
                "Click 'Confirm' button and verify Journal Inquiry page is opened.");
    }

    public void journalEditSampleBookTest() {
        String sampleBookNumber = prop.getProperty("sampleBookNumber");

        ExtentManager.createNode("JOURNAL -> EDIT -> Edit Sample Book.", "Verify Edit Sample Book Page.");

        EditSampleBookPage editSampleBookPage = new EditSampleBookPage();
        ExtentManager.compareNotNULL(editSampleBookPage, "Open 'JOURNAL -> EDIT -> Edit Sample Book page.");

        ExtentManager.compareTrue(editSampleBookPage.setJournalSequence(sampleBookNumber),
                "Set Journal Sequence number to " + sampleBookNumber);
        ExtentManager.compareTrue(editSampleBookPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(editSampleBookPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalInquiryPage journalInquiryPage = editSampleBookPage.clickConfirmButton();
        ExtentManager.compareNotNULL(journalInquiryPage,
                "Click 'Confirm' button and verify Journal Inquiry page is opened.");
    }

    public void journalEditSeriesTest() {
        String seriesNumber = prop.getProperty("seriesNumber");

        ExtentManager.createNode("JOURNAL -> EDIT -> Edit Series.", "Verify Edit Series Page.");

        EditSeriesPage editSeriesPage = new EditSeriesPage();
        ExtentManager.compareNotNULL(editSeriesPage, "Open 'JOURNAL -> EDIT -> Edit Series page.");

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

    public void JournalProductCodesInquiryTest() {
        ExtentManager.createNode("JOURNAL -> Journal Inquiry Page.", "Verify Journal Inquiry Page.");

        JournalProductCodesInquiryPage journalProductCodesInquiryPage = new JournalProductCodesInquiryPage();
        ExtentManager.compareNotNULL(journalProductCodesInquiryPage, "Open 'JOURNAL -> Journal Inquiry' page.");

        ExtentManager.compareTrue(journalProductCodesInquiryPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        ExtentManager.compareTrue(journalProductCodesInquiryPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(journalProductCodesInquiryPage.clickCDRXTab(),
                "Open 'Journal Issues List' tab.");
        ExtentManager.compareTrue(journalProductCodesInquiryPage.clickJrnlXRefTab(),
                "Open 'Journal Changes' tab.");
        ExtentManager.compareTrue(journalProductCodesInquiryPage.clickPCSCTab(),
                "Open 'Journal Product Codes Inquiry' tab.");
        ExtentManager.compareTrue(journalProductCodesInquiryPage.clickPCHistTab(),
                "Open 'Journal Product Code History' tab.");
        ExtentManager.compareTrue(journalProductCodesInquiryPage.clickSCHistTab(),
                "Open 'Journal Subject Catagory History' tab.");
        ExtentManager.compareTrue(journalProductCodesInquiryPage.clickRoyInqTab(),
                "Open 'Journal Royalty Inquiry' tab.");
        ExtentManager.compareTrue(journalProductCodesInquiryPage.clickSubsHistTab(),
                "Open 'Journal Subscription History' tab.");
        ExtentManager.compareTrue(journalProductCodesInquiryPage.clickIssueLoginTab(),
                "Open 'Issue Login for a Journal' tab.");
        ExtentManager.compareTrue(journalProductCodesInquiryPage.clickJrnlInqTab(),
                "Open 'Journal Inquiry' tab.");

    }

    public void journalEditProductCodesForJournalsTest() {
        ExtentManager.createNode("JOURNAL -> Edit Product Codes -> For Journals.", "Verify Edit Product Codes For Journals Page.");

        EditProductCodesForJournalsPage editProductCodesForJournalsPage = new EditProductCodesForJournalsPage();
        ExtentManager.compareNotNULL(editProductCodesForJournalsPage, "Open 'JOURNAL -> Edit Product Codes -> For Journals page.");

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

    public void journalEditProductCodesForSampleJournalsTest() {
        ExtentManager.createNode("JOURNAL -> Edit Product Codes -> For Sample Journals.",
                "Verify Edit Product Codes For Sample Journals Page.");

        EditProductCodesForSampleJournalsPage editProductCodesForSampleJournalsPage = new EditProductCodesForSampleJournalsPage();
        ExtentManager.compareNotNULL(editProductCodesForSampleJournalsPage,
                "Open 'JOURNAL -> Edit Product Codes -> For Sample Journals page.");

        ExtentManager.compareTrue(editProductCodesForSampleJournalsPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        ExtentManager.compareTrue(editProductCodesForSampleJournalsPage.clickSubmit(),
                "Click 'Submit' button.");


        ExtentManager.compareTrue(editProductCodesForSampleJournalsPage.clickAddProductCodesButton(),
                "Click 'Add' button.");

        ExtentManager.compareTrue(editProductCodesForSampleJournalsPage.clickConfirmAddingProductCodesButton(),
                "Click 'Confirm' button to complete adding product codes.");

        ExtentManager.compareTrue(editProductCodesForSampleJournalsPage.clickAddSubjectCategoriesButton(),
                "Click 'Add' button to add Subject Categories.");

        ExtentManager.compareTrue(editProductCodesForSampleJournalsPage.clickConfirmAddingButton(),
                "Click 'Confirm' button to add Subject Categories.");

        ExtentManager.compareTrue(editProductCodesForSampleJournalsPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalInquiryPage journalInquiryPage = editProductCodesForSampleJournalsPage.clickConfirmButton();
        ExtentManager.compareNotNULL(journalInquiryPage,
                "Click 'Confirm' button and verify Journal Inquiry page is opened.");
    }

    public void journalEditProductCodesForBooksTest() {
        ExtentManager.createNode("JOURNAL -> Edit Product Codes -> For Books.",
                "Verify Edit Product Codes For Books Page.");

        EditProductCodesForBooksPage editProductCodesForBooksPage = new EditProductCodesForBooksPage();
        ExtentManager.compareNotNULL(editProductCodesForBooksPage,
                "Open 'JOURNAL -> Edit Product Codes -> For Books page.");

        ExtentManager.compareTrue(editProductCodesForBooksPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        ExtentManager.compareTrue(editProductCodesForBooksPage.clickSubmit(),
                "Click 'Submit' button.");


        ExtentManager.compareTrue(editProductCodesForBooksPage.clickAddProductCodesButton(),
                "Click 'Add' button.");

        ExtentManager.compareTrue(editProductCodesForBooksPage.clickConfirmAddingProductCodesButton(),
                "Click 'Confirm' button to complete adding product codes.");

        ExtentManager.compareTrue(editProductCodesForBooksPage.clickAddSubjectCategoriesButton(),
                "Click 'Add' button to add Subject Categories.");

        ExtentManager.compareTrue(editProductCodesForBooksPage.clickConfirmAddingButton(),
                "Click 'Confirm' button to add Subject Categories.");

        ExtentManager.compareTrue(editProductCodesForBooksPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalInquiryPage journalInquiryPage = editProductCodesForBooksPage.clickConfirmButton();
        ExtentManager.compareNotNULL(journalInquiryPage,
                "Click 'Confirm' button and verify Journal Inquiry page is opened.");
    }

    public void journalEditProductCodesForSampleBooksTest() {
        ExtentManager.createNode("JOURNAL -> Edit Product Codes -> For Sample Books.",
                "Verify Edit Product Codes For Sample Books Page.");

        EditProductCodesForSampleBooksPage editProductCodesForSampleBooksPage = new EditProductCodesForSampleBooksPage();
        ExtentManager.compareNotNULL(editProductCodesForSampleBooksPage,
                "Open 'JOURNAL -> Edit Product Codes -> For Sample Books page.");

        ExtentManager.compareTrue(editProductCodesForSampleBooksPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        ExtentManager.compareTrue(editProductCodesForSampleBooksPage.clickSubmit(),
                "Click 'Submit' button.");


        ExtentManager.compareTrue(editProductCodesForSampleBooksPage.clickAddProductCodesButton(),
                "Click 'Add' button.");

        ExtentManager.compareTrue(editProductCodesForSampleBooksPage.clickConfirmAddingProductCodesButton(),
                "Click 'Confirm' button to complete adding product codes.");

        ExtentManager.compareTrue(editProductCodesForSampleBooksPage.clickAddSubjectCategoriesButton(),
                "Click 'Add' button to add Subject Categories.");

        ExtentManager.compareTrue(editProductCodesForSampleBooksPage.clickConfirmAddingButton(),
                "Click 'Confirm' button to add Subject Categories.");

        ExtentManager.compareTrue(editProductCodesForSampleBooksPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalInquiryPage journalInquiryPage = editProductCodesForSampleBooksPage.clickConfirmButton();
        ExtentManager.compareNotNULL(journalInquiryPage,
                "Click 'Confirm' button and verify Journal Inquiry page is opened.");
    }

    public void journalEditProductCodesForSeriesTest() {
        ExtentManager.createNode("JOURNAL -> Edit Product Codes -> For Series.",
                "Verify Edit Product Codes For Series Page.");

        EditProductCodesForSeriesPage editProductCodesForSeriesPage = new EditProductCodesForSeriesPage();
        ExtentManager.compareNotNULL(editProductCodesForSeriesPage,
                "Open 'JOURNAL -> Edit Product Codes -> For Series page.");

        ExtentManager.compareTrue(editProductCodesForSeriesPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        ExtentManager.compareTrue(editProductCodesForSeriesPage.clickSubmit(),
                "Click 'Submit' button.");


        ExtentManager.compareTrue(editProductCodesForSeriesPage.clickAddProductCodesButton(),
                "Click 'Add' button.");

        ExtentManager.compareTrue(editProductCodesForSeriesPage.clickConfirmAddingProductCodesButton(),
                "Click 'Confirm' button to complete adding product codes.");

        ExtentManager.compareTrue(editProductCodesForSeriesPage.clickAddSubjectCategoriesButton(),
                "Click 'Add' button to add Subject Categories.");

        ExtentManager.compareTrue(editProductCodesForSeriesPage.clickConfirmAddingButton(),
                "Click 'Confirm' button to add Subject Categories.");

        ExtentManager.compareTrue(editProductCodesForSeriesPage.clickSubmitChanges(),
                "Click 'Submit Changes' button.");

        JournalInquiryPage journalInquiryPage = editProductCodesForSeriesPage.clickConfirmButton();
        ExtentManager.compareNotNULL(journalInquiryPage,
                "Click 'Confirm' button and verify Journal Inquiry page is opened.");
    }

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

    public void journalJournalProductCodeHistoryTest() {
        ExtentManager.createNode("JOURNAL -> Journal Product Code History.",
                "Verify Journal Product Code History Page.");

        JournalProductCodeHistoryPage journalProductCodeHistoryPage = new JournalProductCodeHistoryPage();
        ExtentManager.compareNotNULL(journalProductCodeHistoryPage,
                "Open 'JOURNAL -> Journal Product Code History page.");

        ExtentManager.compareTrue(journalProductCodeHistoryPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        ExtentManager.compareTrue(journalProductCodeHistoryPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(journalProductCodeHistoryPage.clickCDRXTab(),
                "Open 'Journal Issues List' tab.");
        ExtentManager.compareTrue(journalProductCodeHistoryPage.clickJrnlXRefTab(),
                "Open 'Journal Changes' tab.");
        ExtentManager.compareTrue(journalProductCodeHistoryPage.clickPCSCTab(),
                "Open 'Journal Product Codes Inquiry' tab.");
        ExtentManager.compareTrue(journalProductCodeHistoryPage.clickPCHistTab(),
                "Open 'Journal Product Code History' tab.");
        ExtentManager.compareTrue(journalProductCodeHistoryPage.clickSCHistTab(),
                "Open 'Journal Subject Catagory History' tab.");
        ExtentManager.compareTrue(journalProductCodeHistoryPage.clickRoyInqTab(),
                "Open 'Journal Royalty Inquiry' tab.");
        ExtentManager.compareTrue(journalProductCodeHistoryPage.clickSubsHistTab(),
                "Open 'Journal Subscription History' tab.");
        ExtentManager.compareTrue(journalProductCodeHistoryPage.clickIssueLoginTab(),
                "Open 'Issue Login for a Journal' tab.");
        ExtentManager.compareTrue(journalProductCodeHistoryPage.clickJrnlInqTab(),
                "Open 'Journal Inquiry' tab.");
    }

    public void journalJournalSubjectCatagoryHistoryTest() {
        ExtentManager.createNode("JOURNAL -> Subject Category History.",
                "Verify Journal Subject Catagory History Page.");

        JournalSubjectCatagoryHistoryPage journalSubjectCatagoryHistoryPage = new JournalSubjectCatagoryHistoryPage();
        ExtentManager.compareNotNULL(journalSubjectCatagoryHistoryPage,
                "Open 'JOURNAL -> Journal Subject Catagory History page.");

        ExtentManager.compareTrue(journalSubjectCatagoryHistoryPage.setJournalSequence(journalSequenceNumber),
                "Set Journal Sequence number to " + journalSequenceNumber);
        ExtentManager.compareTrue(journalSubjectCatagoryHistoryPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(journalSubjectCatagoryHistoryPage.clickCDRXTab(),
                "Open 'Journal Issues List' tab.");
        ExtentManager.compareTrue(journalSubjectCatagoryHistoryPage.clickJrnlXRefTab(),
                "Open 'Journal Changes' tab.");
        ExtentManager.compareTrue(journalSubjectCatagoryHistoryPage.clickPCSCTab(),
                "Open 'Journal Product Codes Inquiry' tab.");
        ExtentManager.compareTrue(journalSubjectCatagoryHistoryPage.clickPCHistTab(),
                "Open 'Journal Product Code History' tab.");
        ExtentManager.compareTrue(journalSubjectCatagoryHistoryPage.clickSCHistTab(),
                "Open 'Journal Subject Catagory History' tab.");
        ExtentManager.compareTrue(journalSubjectCatagoryHistoryPage.clickRoyInqTab(),
                "Open 'Journal Royalty Inquiry' tab.");
        ExtentManager.compareTrue(journalSubjectCatagoryHistoryPage.clickSubsHistTab(),
                "Open 'Journal Subscription History' tab.");
        ExtentManager.compareTrue(journalSubjectCatagoryHistoryPage.clickIssueLoginTab(),
                "Open 'Issue Login for a Journal' tab.");
        ExtentManager.compareTrue(journalSubjectCatagoryHistoryPage.clickJrnlInqTab(),
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

        ExtentManager.compareTrue(journalIssuesListPage.clickCDRXTab(),
                "Open 'Journal Issues List' tab.");
        ExtentManager.compareTrue(journalIssuesListPage.clickJrnlXRefTab(),
                "Open 'Journal Changes' tab.");
        ExtentManager.compareTrue(journalIssuesListPage.clickPCSCTab(),
                "Open 'Journal Product Codes Inquiry' tab.");
        ExtentManager.compareTrue(journalIssuesListPage.clickPCHistTab(),
                "Open 'Journal Product Code History' tab.");
        ExtentManager.compareTrue(journalIssuesListPage.clickSCHistTab(),
                "Open 'Journal Subject Catagory History' tab.");
        ExtentManager.compareTrue(journalIssuesListPage.clickRoyInqTab(),
                "Open 'Journal Royalty Inquiry' tab.");
        ExtentManager.compareTrue(journalIssuesListPage.clickSubsHistTab(),
                "Open 'Journal Subscription History' tab.");
        ExtentManager.compareTrue(journalIssuesListPage.clickIssueLoginTab(),
                "Open 'Issue Login for a Journal' tab.");
        ExtentManager.compareTrue(journalIssuesListPage.clickJrnlInqTab(),
                "Open 'Journal Inquiry' tab.");
    }
}
