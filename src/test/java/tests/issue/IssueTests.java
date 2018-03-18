package tests.issue;

import com.reporting.ExtentManager;
import pages.MainPage;
import pages.issue.*;
import tests.OCS_Test;

import java.util.Properties;

public class IssueTests {
    private ExtentManager eReports;
    private Properties prop;

    public IssueTests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

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
    public void issueDetailsTest_BVT() {
        String accession = prop.getProperty("Accession");

        ExtentManager.createNode("ISSUE -> Issue Details Page.",
                "Verify Issue Details Page.");

        IssueDetailsPage issueDetailsPage = new IssueDetailsPage();
        if (ExtentManager.compareNotNULL(issueDetailsPage, "Open 'ISSUE -> Issue Details' page.")) {

            ExtentManager.compareTrue(issueDetailsPage.setAccession(accession),
                    "Set Accession to " + accession);

            ExtentManager.compareTrue(issueDetailsPage.clickSubmit(),
                    "Click 'Submit' button.");

            ExtentManager.compareTrue(issueDetailsPage.issueNoLabel.isDisplayed()
                            && issueDetailsPage.isPageOpened(),
                    "Verify that Issue Details page is opened.");
        }
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
    public void editIssueTest_BVT() {
        String editIssueAccession = prop.getProperty("editIssueAccession");

        ExtentManager.createNode("ISSUE -> Edit Issue Page.",
                "Verify Edit Issue Page.");

        EditIssuePage editIssuePage = new EditIssuePage();
        if (ExtentManager.compareNotNULL(editIssuePage, "Open 'ISSUE -> Edit Issue' page.")) {

            ExtentManager.compareTrue(editIssuePage.setAccession(editIssueAccession),
                    "Set Accession to " + editIssueAccession);

            ExtentManager.compareTrue(editIssuePage.clickSubmit(),
                    "Click 'Submit' button.");

            ExtentManager.compareTrue(editIssuePage.coverDate.isDisplayed()
                            && editIssuePage.isPageOpened(),
                    "Verify that Edit Issue page is opened.");
        }
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
    public void listAllArticlesTest_BVT() {
        String listAllArticlesAccession = prop.getProperty("listAllArticlesAccession");

        ExtentManager.createNode("ISSUE -> List All Articles Page.",
                "Verify List All Articles Page.");

        ListAllArticlesPage listAllArticlesPage = new ListAllArticlesPage();
        if (ExtentManager.compareNotNULL(listAllArticlesPage, "Open 'ISSUE -> List All Articles' page.")) {

            ExtentManager.compareTrue(listAllArticlesPage.setAccession(listAllArticlesAccession),
                    "Set Accession to " + listAllArticlesAccession);

            ExtentManager.compareTrue(listAllArticlesPage.clickSubmit(),
                    "Click 'Submit' button.");

            ExtentManager.compareTrue(listAllArticlesPage.issueNoLabel.isDisplayed()
                            && listAllArticlesPage.isPageOpened(),
                    "Verify that List All Articles is opened.");
        }
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
    public void extractionDetailsTest_BVT() {
        String extractionDetailsAccession = prop.getProperty("extractionDetailsAccession");
        String ISIProdCode = prop.getProperty("ISIProdCode");

        ExtentManager.createNode("ISSUE -> Extraction Details Page.",
                "Verify Extraction Details Page.");

        IssueProductExtractionDetailsPage issueProductExtractionDetailsPage = new IssueProductExtractionDetailsPage();
        if (ExtentManager.compareNotNULL(issueProductExtractionDetailsPage, "Open 'ISSUE -> Extraction Details' page.")) {

            ExtentManager.compareTrue(issueProductExtractionDetailsPage.setAccession(extractionDetailsAccession),
                    "Set Accession to " + extractionDetailsAccession);
            ExtentManager.compareTrue(issueProductExtractionDetailsPage.selectISIProdCode(ISIProdCode),
                    "Set ISI Prod Code to " + ISIProdCode);

            ExtentManager.compareTrue(issueProductExtractionDetailsPage.clickSubmit(),
                    "Click 'Submit' button.");

            ExtentManager.compareTrue(issueProductExtractionDetailsPage.issueNoLabel.isDisplayed()
                            && issueProductExtractionDetailsPage.isPageOpened(),
                    "Verify that Extraction Details page is opened.");
        }
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
    public void viewBiblioTest_BVT() {
        String extractionDetailsAccession = prop.getProperty("extractionDetailsAccession");

        ExtentManager.createNode("ISSUE -> Article -> View Biblio Page.", "Verify View Biblio Page.");

        ViewBiblioPage viewBiblioPage = new ViewBiblioPage();
        if (ExtentManager.compareNotNULL(viewBiblioPage, "Open 'ISSUE -> Article -> View Biblio' page.")) {

            ExtentManager.compareTrue(viewBiblioPage.setAccession(extractionDetailsAccession),
                    "Set Accession to " + extractionDetailsAccession);

            ExtentManager.compareTrue(viewBiblioPage.clickSubmit(),
                    "Click 'Submit' button.");

            ExtentManager.compareTrue(viewBiblioPage.issueNoLabel.isDisplayed()
                            && viewBiblioPage.isPageOpened(),
                    "Verify that View Biblio page is opened.");
        }
    }

    public void labelReprintTest() {
        ExtentManager.createNode("ISSUE -> Label Reprint Page.", "Verify Label Reprint Page.");

        LabelReprintPage labelReprintPage = new LabelReprintPage();
        ExtentManager.compareNotNULL(labelReprintPage, "Open 'ISSUE -> Label Reprint' page.");
    }
    public void labelReprintTest_BVT() {
        ExtentManager.createNode("ISSUE -> Label Reprint Page.", "Verify Label Reprint Page.");

        LabelReprintPage labelReprintPage = new LabelReprintPage();
        ExtentManager.compareNotNULL(labelReprintPage, "Open 'ISSUE -> Label Reprint' page.");
    }

    public void printJournalLabelsTest() {
        ExtentManager.createNode("ISSUE -> Print Journal Labels Page.", "Verify Print Journal Labels Page.");

        PrintJournalLabelsPage printJournalLabelsPage = new PrintJournalLabelsPage();
        ExtentManager.compareNotNULL(printJournalLabelsPage, "Open 'ISSUE -> Print Journal Labels' page.");
    }
    public void printJournalLabelsTest_BVT() {
        ExtentManager.createNode("ISSUE -> Print Journal Labels Page.", "Verify Print Journal Labels Page.");

        PrintJournalLabelsPage printJournalLabelsPage = new PrintJournalLabelsPage();
        ExtentManager.compareNotNULL(printJournalLabelsPage, "Open 'ISSUE -> Print Journal Labels' page.");
    }

    public void sendIssueToImageCaptureTest() {
        ExtentManager.createNode("ISSUE -> Send Issue to Image Capture Page.", "Verify Send Issue to Image Capture Page.");

        ImageCapturePage imageCapturePage = new ImageCapturePage();
        ExtentManager.compareNotNULL(imageCapturePage, "Open 'ISSUE -> Send Issue to Image Capture' page.");
    }
    public void sendIssueToImageCaptureTest_BVT() {
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
    public void issueHoldTest_BVT() {
        String issueHoldProduct = prop.getProperty("issueHoldProduct");

        ExtentManager.createNode("ISSUE -> Issue Hold Page.",
                "Verify Edition Issues List Page.");

        EditionIssuesListPage editionIssuesListPage = new EditionIssuesListPage();
        if (ExtentManager.compareNotNULL(editionIssuesListPage, "Open 'ISSUE -> Issue Hold' page.")) {

            ExtentManager.compareTrue(editionIssuesListPage.selectProduct(issueHoldProduct),
                    "Set Accession to " + issueHoldProduct);

            ExtentManager.compareTrue(editionIssuesListPage.clickSubmit(),
                    "Click 'Submit' button.");

            ExtentManager.compareTrue(editionIssuesListPage.isPageOpened(),
                    "Verify that Edition Issues List page is opened.");
        }
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
    public void issueTrackingPageTest_BVT() {
        String issueTrackingAccession = prop.getProperty("issueTrackingAccession");

        ExtentManager.createNode("ISSUE -> Issue Tracking Page.",
                "Verify Issue Tracking Page.");

        IssueTrackingPage issueTrackingPage = new IssueTrackingPage();
        if (ExtentManager.compareNotNULL(issueTrackingPage, "Open 'ISSUE -> Issue Tracking' page.")) {

            ExtentManager.compareTrue(issueTrackingPage.setAccession(issueTrackingAccession),
                    "Set Accession to " + issueTrackingAccession);

            ExtentManager.compareTrue(issueTrackingPage.clickSubmit(),
                    "Click 'Submit' button.");

            ExtentManager.compareTrue(issueTrackingPage.isPageOpened(),
                    "Verify that Issue Tracking page is opened.");
        }
    }

    public void multipleIssuesTrackingTest() {
        ExtentManager.createNode("ISSUE -> Multiple Issues Tracking Page.", "Verify Multiple Issues Tracking Page.");

        MultipleIssueTrackingPage multipleIssueTrackingPage = new MultipleIssueTrackingPage();
        ExtentManager.compareNotNULL(multipleIssueTrackingPage, "Open 'ISSUE -> Multiple Issues Tracking' page.");
    }
    public void multipleIssuesTrackingTest_BVT() {
        ExtentManager.createNode("ISSUE -> Multiple Issues Tracking Page.", "Verify Multiple Issues Tracking Page.");

        MultipleIssueTrackingPage multipleIssueTrackingPage = new MultipleIssueTrackingPage();
        ExtentManager.compareNotNULL(multipleIssueTrackingPage, "Open 'ISSUE -> Multiple Issues Tracking' page.");
    }

    public void candidatesTest() {
        ExtentManager.createNode("ISSUE -> Claiming -> Candidates Page.", "Verify Candidates Page.");

        ClaimingCandidatesPage claimingCandidatesPage = new ClaimingCandidatesPage();
        ExtentManager.compareNotNULL(claimingCandidatesPage, "Open 'ISSUE -> Claiming -> Candidates' page.");

        ExtentManager.compareTrue(claimingCandidatesPage.clickSubmit(),
                "Click 'Submit' button.");
    }
    public void candidatesTest_BVT() {
        ExtentManager.createNode("ISSUE -> Claiming -> Candidates Page.",
                "Verify Candidates Page.");

        ClaimingCandidatesPage claimingCandidatesPage = new ClaimingCandidatesPage();
        if (ExtentManager.compareNotNULL(claimingCandidatesPage, "Open 'ISSUE -> Claiming -> Candidates' page.")) {

            ExtentManager.compareTrue(claimingCandidatesPage.clickSubmit(),
                    "Click 'Submit' button.");

            ExtentManager.compareTrue(claimingCandidatesPage.isPageOpened(),
                    "Verify that Candidates page is opened.");
        }
    }

    public void activeClaimTest() {
        ExtentManager.createNode("ISSUE -> Claiming -> Active Claim Page.", "Verify Active Claim Page.");

        ClaimingActivePage claimingActivePage = new ClaimingActivePage();
        ExtentManager.compareNotNULL(claimingActivePage, "Open 'ISSUE -> Claiming -> Active Claim' page.");

        ExtentManager.compareTrue(claimingActivePage.clickSubmit(),
                "Click 'Submit' button.");
    }
    public void activeClaimTest_BVT() {
        ExtentManager.createNode("ISSUE -> Claiming -> Active Claim Page.",
                "Verify Active Claim Page.");

        ClaimingActivePage claimingActivePage = new ClaimingActivePage();
        if (ExtentManager.compareNotNULL(claimingActivePage, "Open 'ISSUE -> Claiming -> Active Claim' page.")) {

            ExtentManager.compareTrue(claimingActivePage.clickSubmit(),
                    "Click 'Submit' button.");

            ExtentManager.compareTrue(claimingActivePage.isPageOpened(),
                    "Verify that Active Claim page is opened.");
        }
    }

    public void claimingHistoryTest() {
        ExtentManager.createNode("ISSUE -> Claiming -> History Page.", "Verify Claiming History Page.");

        ClaimingHistoryPage claimingHistoryPage = new ClaimingHistoryPage();
        ExtentManager.compareNotNULL(claimingHistoryPage, "Open 'ISSUE -> Claiming -> History' page.");

        ExtentManager.compareTrue(claimingHistoryPage.clickSubmit(),
                "Click 'Submit' button.");
    }
    public void claimingHistoryTest_BVT() {
        ExtentManager.createNode("ISSUE -> Claiming -> History Page.",
                "Verify History Page.");

        ClaimingHistoryPage claimingHistoryPage = new ClaimingHistoryPage();
        if (ExtentManager.compareNotNULL(claimingHistoryPage, "Open 'ISSUE -> Claiming -> History' page.")) {

            ExtentManager.compareTrue(claimingHistoryPage.clickSubmit(),
                    "Click 'Submit' button.");

            ExtentManager.compareTrue(claimingHistoryPage.isPageOpened(),
                    "Verify that Claiming History page is opened.");
        }
    }

    public void ClaimRequestTest() {
        String claimingAccession = prop.getProperty("claimingAccession");

        ExtentManager.createNode("ISSUE -> Claiming -> Claim Request Page.", "Verify Claiming History Page.");

        ClaimRequestPage claimRequestPage = new ClaimRequestPage();
        ExtentManager.compareNotNULL(claimRequestPage, "Open 'ISSUE -> Claiming -> Claim Request' page.");

        ExtentManager.compareTrue(claimRequestPage.journalSequence.setText(claimingAccession),
                "Set Journal Sequence to " + claimingAccession);
        ExtentManager.compareTrue(claimRequestPage.clickSubmit(),
                "Click 'Submit' button.");
    }
    public void ClaimRequestTest_BVT() {
        String claimingAccession = prop.getProperty("claimingAccession");

        ExtentManager.createNode("ISSUE -> Claiming -> Claim Request Page.",
                "Verify Claiming Request Page.");

        ClaimRequestPage claimRequestPage = new ClaimRequestPage();
        if (ExtentManager.compareNotNULL(claimRequestPage, "Open 'ISSUE -> Claiming -> Claim Request' page.")) {

            ExtentManager.compareTrue(claimRequestPage.journalSequence.setText(claimingAccession),
                    "Set Journal Sequence to " + claimingAccession);

            ExtentManager.compareTrue(claimRequestPage.clickSubmit(),
                    "Click 'Submit' button.");

            ExtentManager.compareTrue(claimRequestPage.isPageOpened(),
                    "Verify that Claiming Request page is opened.");
        }
    }
}
