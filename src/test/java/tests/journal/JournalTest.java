package tests.journal;

import com.reporting.ExtentManager;
import pages.journal.*;
import pages.journal.EditProductCodes.EditProductCodesForJournalsPage;
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
}
