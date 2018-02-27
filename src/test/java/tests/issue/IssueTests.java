package tests.issue;

import com.reporting.ExtentManager;
import pages.MainPage;
import pages.issue.*;
import tests.OCS_Test;

import java.util.Properties;

public class IssueTests {
    public static ExtentManager eReports = OCS_Test.eReports;
    public static Properties prop = OCS_Test.prop;

    public void issueDetailsTest() {
        String accession = prop.getProperty("Accession");

        ExtentManager.createNode("ISSUE -> Issue Details Page.", "Verify Issue Details Page.");

        IssueDetailsPage issueDetailsPage = new IssueDetailsPage();
        ExtentManager.compareNotNULL(issueDetailsPage, "Open 'ISSUE -> Issue Details' page.");

        ExtentManager.compareTrue(issueDetailsPage.setAccession(accession),
                "Set Accession to " + accession);
        ExtentManager.compareTrue(issueDetailsPage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(issueDetailsPage.openListArticlesTab(),
                "Open 'List Articles' tab.");
        ExtentManager.compareTrue(issueDetailsPage.openIssueTrackingRetrieveTab(),
                "Open 'Issue Tracking' tab.");
        ExtentManager.compareTrue(issueDetailsPage.openIssueDetailsTab(),
                "Open 'Issue Details' tab.");
    }

    public void editIssueTest() {
        String editIssueAccession = prop.getProperty("editIssueAccession");
        String editCoverDate = prop.getProperty("editCoverDate");

        ExtentManager.createNode("ISSUE -> Edit Issue Page.", "Verify Edit Issue Page.");

        EditIssuePage editIssuePage = new EditIssuePage();
        ExtentManager.compareNotNULL(editIssuePage, "Open 'ISSUE -> Edit Issue' page.");

        ExtentManager.compareTrue(editIssuePage.setAccession(editIssueAccession),
                "Set Accession to " + editIssueAccession);
        ExtentManager.compareTrue(editIssuePage.clickSubmit(),
                "Click 'Submit' button.");

        ExtentManager.compareTrue(editIssuePage.coverDate.setText(editCoverDate),
                "Set '" + editCoverDate + "' to Cover Date.");
        ExtentManager.compareTrue(editIssuePage.submitChanges.click(),
                "Click 'Submit' button.");
        IssueDetailsPage issueDetailsPage = editIssuePage.clickConfirmButton();
        ExtentManager.compareNotNULL(issueDetailsPage,
                "Click 'Confirm' button and verify Issue Details page is opened.");
    }

    public void listAllArticlesTest() {
        String listAllArticlesAccession = prop.getProperty("listAllArticlesAccession");

        ExtentManager.createNode("ISSUE -> List All Articles Page.", "Verify List All Articles Page.");

        ListAllArticlesPage listAllArticlesPage = new ListAllArticlesPage();
        ExtentManager.compareNotNULL(listAllArticlesPage, "Open 'ISSUE -> List All Articles' page.");

        ExtentManager.compareTrue(listAllArticlesPage.setAccession(listAllArticlesAccession),
                "Set Accession to " + listAllArticlesAccession);
        ExtentManager.compareTrue(listAllArticlesPage.clickSubmit(),
                "Click 'Submit' button.");
    }

    public void extractionDetailsTest() {
        String extractionDetailsAccession = prop.getProperty("extractionDetailsAccession");
        String ISIProdCode = prop.getProperty("ISIProdCode");

        ExtentManager.createNode("ISSUE -> Extraction Details Page.", "Verify Extraction Details Page.");

        IssueProductExtractionDetailsPage issueProductExtractionDetailsPage = new IssueProductExtractionDetailsPage();
        ExtentManager.compareNotNULL(issueProductExtractionDetailsPage, "Open 'ISSUE -> Extraction Details' page.");

        ExtentManager.compareTrue(issueProductExtractionDetailsPage.setAccession(extractionDetailsAccession),
                "Set Accession to " + extractionDetailsAccession);
        ExtentManager.compareTrue(issueProductExtractionDetailsPage.selectISIProdCode(ISIProdCode),
                "Set ISI Prod Code to " + ISIProdCode);

        ExtentManager.compareTrue(issueProductExtractionDetailsPage.clickSubmit(),
                "Click 'Submit' button.");
    }

    public void viewBiblioTest() {
        String extractionDetailsAccession = prop.getProperty("extractionDetailsAccession");

        ExtentManager.createNode("ISSUE -> Article -> View Biblio Page.", "Verify View Biblio Page.");

        ViewBiblioPage viewBiblioPage = new ViewBiblioPage();
        ExtentManager.compareNotNULL(viewBiblioPage, "Open 'ISSUE -> Article -> View Biblio' page.");

        ExtentManager.compareTrue(viewBiblioPage.setAccession(extractionDetailsAccession),
                "Set Accession to " + extractionDetailsAccession);

        ExtentManager.compareTrue(viewBiblioPage.clickSubmit(),
                "Click 'Submit' button.");
    }

    public void labelReprintTest() {
        ExtentManager.createNode("ISSUE -> Label Reprint Page.", "Verify Label Reprint Page.");

        LabelReprintPage labelReprintPage = new LabelReprintPage();
        ExtentManager.compareNotNULL(labelReprintPage, "Open 'ISSUE -> Label Reprint' page.");
    }

    public void printJournalLabelsTest() {
        ExtentManager.createNode("ISSUE -> Print Journal Labels Page.", "Verify Print Journal Labels Page.");

        PrintJournalLabelsPage printJournalLabelsPage = new PrintJournalLabelsPage();
        ExtentManager.compareNotNULL(printJournalLabelsPage, "Open 'ISSUE -> Print Journal Labels' page.");
    }

    public void sendIssueToImageCaptureTest() {
        ExtentManager.createNode("ISSUE -> Send Issue to Image Capture Page.", "Verify Send Issue to Image Capture Page.");

        ImageCapturePage imageCapturePage = new ImageCapturePage();
        ExtentManager.compareNotNULL(imageCapturePage, "Open 'ISSUE -> Send Issue to Image Capture' page.");
    }

    public void issueHoldTest() {
        String issueHoldProduct = prop.getProperty("issueHoldProduct");

        ExtentManager.createNode("ISSUE -> Issue Hold Page.", "Verify Edition Issues List Page.");

        EditionIssuesListPage editionIssuesListPage = new EditionIssuesListPage();
        ExtentManager.compareNotNULL(editionIssuesListPage, "Open 'ISSUE -> Issue Hold' page.");

        ExtentManager.compareTrue(editionIssuesListPage.selectProduct(issueHoldProduct),
                "Set Accession to " + issueHoldProduct);
        ExtentManager.compareTrue(editionIssuesListPage.clickSubmit(),
                "Click 'Submit' button.");
    }

    public void issueTrackingPageTest() {
        String issueTrackingAccession = prop.getProperty("issueTrackingAccession");

        ExtentManager.createNode("ISSUE -> Issue Tracking Page.", "Verify Issue Tracking Page.");

        IssueTrackingPage issueTrackingPage = new IssueTrackingPage();
        ExtentManager.compareNotNULL(issueTrackingPage, "Open 'ISSUE -> Issue Tracking' page.");

        ExtentManager.compareTrue(issueTrackingPage.setAccession(issueTrackingAccession),
                "Set Accession to " + issueTrackingAccession);
        ExtentManager.compareTrue(issueTrackingPage.clickSubmit(),
                "Click 'Submit' button.");
    }
}
