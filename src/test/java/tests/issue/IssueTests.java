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

        eReports.createNode("ISSUE -> Issue Details Page.", "Verify Issue Details Page.");

        IssueDetailsPage issueDetailsPage = new IssueDetailsPage();
        eReports.compareNotNULL(issueDetailsPage, "Open 'ISSUE -> Issue Details' page.");

        eReports.compareTrue(issueDetailsPage.setAccession(accession),
                "Set Accession to " + accession);
        eReports.compareTrue(issueDetailsPage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(issueDetailsPage.openListArticlesTab(),
                "Open 'List Articles' tab.");
        eReports.compareTrue(issueDetailsPage.openIssueTrackingRetrieveTab(),
                "Open 'Issue Tracking' tab.");
        eReports.compareTrue(issueDetailsPage.openIssueDetailsTab(),
                "Open 'Issue Details' tab.");
    }
    public void issueDetailsTest_BVT() {
        String accession = prop.getProperty("Accession");

        eReports.createNode("ISSUE -> Issue Details Page.",
                "Verify Issue Details Page.");

        IssueDetailsPage issueDetailsPage = new IssueDetailsPage();
        if (eReports.compareNotNULL(issueDetailsPage, "Open 'ISSUE -> Issue Details' page.")) {

            eReports.compareTrue(issueDetailsPage.setAccession(accession),
                    "Set Accession to " + accession);

            eReports.compareTrue(issueDetailsPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(issueDetailsPage.issueNoLabel.isDisplayed()
                            && issueDetailsPage.isPageOpened(),
                    "Verify that Issue Details page is opened.");
        }
    }

    public void editIssueTest() {
        String editIssueAccession = prop.getProperty("editIssueAccession");
        String editCoverDate = prop.getProperty("editCoverDate");

        eReports.createNode("ISSUE -> Edit Issue Page.", "Verify Edit Issue Page.");

        EditIssuePage editIssuePage = new EditIssuePage();
        eReports.compareNotNULL(editIssuePage, "Open 'ISSUE -> Edit Issue' page.");

        eReports.compareTrue(editIssuePage.setAccession(editIssueAccession),
                "Set Accession to " + editIssueAccession);
        eReports.compareTrue(editIssuePage.clickSubmit(),
                "Click 'Submit' button.");

        eReports.compareTrue(editIssuePage.coverDate.setText(editCoverDate),
                "Set '" + editCoverDate + "' to Cover Date.");
        eReports.compareTrue(editIssuePage.submitChanges.click(),
                "Click 'Submit' button.");
        IssueDetailsPage issueDetailsPage = editIssuePage.clickConfirmButton();
        eReports.compareNotNULL(issueDetailsPage,
                "Click 'Confirm' button and verify Issue Details page is opened.");
    }
    public void editIssueTest_BVT() {
        String editIssueAccession = prop.getProperty("editIssueAccession");

        eReports.createNode("ISSUE -> Edit Issue Page.",
                "Verify Edit Issue Page.");

        EditIssuePage editIssuePage = new EditIssuePage();
        if (eReports.compareNotNULL(editIssuePage, "Open 'ISSUE -> Edit Issue' page.")) {

            eReports.compareTrue(editIssuePage.setAccession(editIssueAccession),
                    "Set Accession to " + editIssueAccession);

            eReports.compareTrue(editIssuePage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editIssuePage.coverDate.isDisplayed()
                            && editIssuePage.isPageOpened(),
                    "Verify that Edit Issue page is opened.");
        }
    }

    public void listAllArticlesTest() {
        String listAllArticlesAccession = prop.getProperty("listAllArticlesAccession");

        eReports.createNode("ISSUE -> List All Articles Page.", "Verify List All Articles Page.");

        ListAllArticlesPage listAllArticlesPage = new ListAllArticlesPage();
        eReports.compareNotNULL(listAllArticlesPage, "Open 'ISSUE -> List All Articles' page.");

        eReports.compareTrue(listAllArticlesPage.setAccession(listAllArticlesAccession),
                "Set Accession to " + listAllArticlesAccession);
        eReports.compareTrue(listAllArticlesPage.clickSubmit(),
                "Click 'Submit' button.");
    }
    public void listAllArticlesTest_BVT() {
        String listAllArticlesAccession = prop.getProperty("listAllArticlesAccession");

        eReports.createNode("ISSUE -> List All Articles Page.",
                "Verify List All Articles Page.");

        ListAllArticlesPage listAllArticlesPage = new ListAllArticlesPage();
        if (eReports.compareNotNULL(listAllArticlesPage, "Open 'ISSUE -> List All Articles' page.")) {

            eReports.compareTrue(listAllArticlesPage.setAccession(listAllArticlesAccession),
                    "Set Accession to " + listAllArticlesAccession);

            eReports.compareTrue(listAllArticlesPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(listAllArticlesPage.issueNoLabel.isDisplayed()
                            && listAllArticlesPage.isPageOpened(),
                    "Verify that List All Articles is opened.");
        }
    }

    public void extractionDetailsTest() {
        String extractionDetailsAccession = prop.getProperty("extractionDetailsAccession");
        String ISIProdCode = prop.getProperty("ISIProdCode");

        eReports.createNode("ISSUE -> Extraction Details Page.", "Verify Extraction Details Page.");

        IssueProductExtractionDetailsPage issueProductExtractionDetailsPage = new IssueProductExtractionDetailsPage();
        eReports.compareNotNULL(issueProductExtractionDetailsPage, "Open 'ISSUE -> Extraction Details' page.");

        eReports.compareTrue(issueProductExtractionDetailsPage.setAccession(extractionDetailsAccession),
                "Set Accession to " + extractionDetailsAccession);
        eReports.compareTrue(issueProductExtractionDetailsPage.selectISIProdCode(ISIProdCode),
                "Set ISI Prod Code to " + ISIProdCode);

        eReports.compareTrue(issueProductExtractionDetailsPage.clickSubmit(),
                "Click 'Submit' button.");
    }
    public void extractionDetailsTest_BVT() {
        String extractionDetailsAccession = prop.getProperty("extractionDetailsAccession");
        String ISIProdCode = prop.getProperty("ISIProdCode");

        eReports.createNode("ISSUE -> Extraction Details Page.",
                "Verify Extraction Details Page.");

        IssueProductExtractionDetailsPage issueProductExtractionDetailsPage = new IssueProductExtractionDetailsPage();
        if (eReports.compareNotNULL(issueProductExtractionDetailsPage, "Open 'ISSUE -> Extraction Details' page.")) {

            eReports.compareTrue(issueProductExtractionDetailsPage.setAccession(extractionDetailsAccession),
                    "Set Accession to " + extractionDetailsAccession);
            eReports.compareTrue(issueProductExtractionDetailsPage.selectISIProdCode(ISIProdCode),
                    "Set ISI Prod Code to " + ISIProdCode);

            eReports.compareTrue(issueProductExtractionDetailsPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(issueProductExtractionDetailsPage.issueNoLabel.isDisplayed()
                            && issueProductExtractionDetailsPage.isPageOpened(),
                    "Verify that Extraction Details page is opened.");
        }
    }

    public void viewBiblioTest() {
        String extractionDetailsAccession = prop.getProperty("extractionDetailsAccession");

        eReports.createNode("ISSUE -> Article -> View Biblio Page.", "Verify View Biblio Page.");

        ViewBiblioPage viewBiblioPage = new ViewBiblioPage();
        eReports.compareNotNULL(viewBiblioPage, "Open 'ISSUE -> Article -> View Biblio' page.");

        eReports.compareTrue(viewBiblioPage.setAccession(extractionDetailsAccession),
                "Set Accession to " + extractionDetailsAccession);

        eReports.compareTrue(viewBiblioPage.clickSubmit(),
                "Click 'Submit' button.");
    }
    public void viewBiblioTest_BVT() {
        String extractionDetailsAccession = prop.getProperty("extractionDetailsAccession");

        eReports.createNode("ISSUE -> Article -> View Biblio Page.", "Verify View Biblio Page.");

        ViewBiblioPage viewBiblioPage = new ViewBiblioPage();
        if (eReports.compareNotNULL(viewBiblioPage, "Open 'ISSUE -> Article -> View Biblio' page.")) {

            eReports.compareTrue(viewBiblioPage.setAccession(extractionDetailsAccession),
                    "Set Accession to " + extractionDetailsAccession);

            eReports.compareTrue(viewBiblioPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(viewBiblioPage.issueNoLabel.isDisplayed()
                            && viewBiblioPage.isPageOpened(),
                    "Verify that View Biblio page is opened.");
        }
    }

    public void labelReprintTest() {
        eReports.createNode("ISSUE -> Label Reprint Page.", "Verify Label Reprint Page.");

        LabelReprintPage labelReprintPage = new LabelReprintPage();
        eReports.compareNotNULL(labelReprintPage, "Open 'ISSUE -> Label Reprint' page.");
    }
    public void labelReprintTest_BVT() {
        eReports.createNode("ISSUE -> Label Reprint Page.", "Verify Label Reprint Page.");

        LabelReprintPage labelReprintPage = new LabelReprintPage();
        eReports.compareNotNULL(labelReprintPage, "Open 'ISSUE -> Label Reprint' page.");
    }

    public void printJournalLabelsTest() {
        eReports.createNode("ISSUE -> Print Journal Labels Page.", "Verify Print Journal Labels Page.");

        PrintJournalLabelsPage printJournalLabelsPage = new PrintJournalLabelsPage();
        eReports.compareNotNULL(printJournalLabelsPage, "Open 'ISSUE -> Print Journal Labels' page.");
    }
    public void printJournalLabelsTest_BVT() {
        eReports.createNode("ISSUE -> Print Journal Labels Page.", "Verify Print Journal Labels Page.");

        PrintJournalLabelsPage printJournalLabelsPage = new PrintJournalLabelsPage();
        eReports.compareNotNULL(printJournalLabelsPage, "Open 'ISSUE -> Print Journal Labels' page.");
    }

    public void sendIssueToImageCaptureTest() {
        eReports.createNode("ISSUE -> Send Issue to Image Capture Page.", "Verify Send Issue to Image Capture Page.");

        ImageCapturePage imageCapturePage = new ImageCapturePage();
        eReports.compareNotNULL(imageCapturePage, "Open 'ISSUE -> Send Issue to Image Capture' page.");
    }
    public void sendIssueToImageCaptureTest_BVT() {
        eReports.createNode("ISSUE -> Send Issue to Image Capture Page.", "Verify Send Issue to Image Capture Page.");

        ImageCapturePage imageCapturePage = new ImageCapturePage();
        eReports.compareNotNULL(imageCapturePage, "Open 'ISSUE -> Send Issue to Image Capture' page.");
    }

    public void issueHoldTest() {
        String issueHoldProduct = prop.getProperty("issueHoldProduct");

        eReports.createNode("ISSUE -> Issue Hold Page.", "Verify Edition Issues List Page.");

        EditionIssuesListPage editionIssuesListPage = new EditionIssuesListPage();
        eReports.compareNotNULL(editionIssuesListPage, "Open 'ISSUE -> Issue Hold' page.");

        eReports.compareTrue(editionIssuesListPage.selectProduct(issueHoldProduct),
                "Set Accession to " + issueHoldProduct);
        eReports.compareTrue(editionIssuesListPage.clickSubmit(),
                "Click 'Submit' button.");
    }
    public void issueHoldTest_BVT() {
        String issueHoldProduct = prop.getProperty("issueHoldProduct");

        eReports.createNode("ISSUE -> Issue Hold Page.",
                "Verify Edition Issues List Page.");

        EditionIssuesListPage editionIssuesListPage = new EditionIssuesListPage();
        if (eReports.compareNotNULL(editionIssuesListPage, "Open 'ISSUE -> Issue Hold' page.")) {

            eReports.compareTrue(editionIssuesListPage.selectProduct(issueHoldProduct),
                    "Set Accession to " + issueHoldProduct);

            eReports.compareTrue(editionIssuesListPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(editionIssuesListPage.isPageOpened(),
                    "Verify that Edition Issues List page is opened.");
        }
    }

    public void issueTrackingPageTest() {
        String issueTrackingAccession = prop.getProperty("issueTrackingAccession");

        eReports.createNode("ISSUE -> Issue Tracking Page.", "Verify Issue Tracking Page.");

        IssueTrackingPage issueTrackingPage = new IssueTrackingPage();
        eReports.compareNotNULL(issueTrackingPage, "Open 'ISSUE -> Issue Tracking' page.");

        eReports.compareTrue(issueTrackingPage.setAccession(issueTrackingAccession),
                "Set Accession to " + issueTrackingAccession);
        eReports.compareTrue(issueTrackingPage.clickSubmit(),
                "Click 'Submit' button.");
    }
    public void issueTrackingPageTest_BVT() {
        String issueTrackingAccession = prop.getProperty("issueTrackingAccession");

        eReports.createNode("ISSUE -> Issue Tracking Page.",
                "Verify Issue Tracking Page.");

        IssueTrackingPage issueTrackingPage = new IssueTrackingPage();
        if (eReports.compareNotNULL(issueTrackingPage, "Open 'ISSUE -> Issue Tracking' page.")) {

            eReports.compareTrue(issueTrackingPage.setAccession(issueTrackingAccession),
                    "Set Accession to " + issueTrackingAccession);

            eReports.compareTrue(issueTrackingPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(issueTrackingPage.isPageOpened(),
                    "Verify that Issue Tracking page is opened.");
        }
    }

    public void multipleIssuesTrackingTest() {
        eReports.createNode("ISSUE -> Multiple Issues Tracking Page.", "Verify Multiple Issues Tracking Page.");

        MultipleIssueTrackingPage multipleIssueTrackingPage = new MultipleIssueTrackingPage();
        eReports.compareNotNULL(multipleIssueTrackingPage, "Open 'ISSUE -> Multiple Issues Tracking' page.");
    }
    public void multipleIssuesTrackingTest_BVT() {
        eReports.createNode("ISSUE -> Multiple Issues Tracking Page.", "Verify Multiple Issues Tracking Page.");

        MultipleIssueTrackingPage multipleIssueTrackingPage = new MultipleIssueTrackingPage();
        eReports.compareNotNULL(multipleIssueTrackingPage, "Open 'ISSUE -> Multiple Issues Tracking' page.");
    }

    public void candidatesTest() {
        eReports.createNode("ISSUE -> Claiming -> Candidates Page.", "Verify Candidates Page.");

        ClaimingCandidatesPage claimingCandidatesPage = new ClaimingCandidatesPage();
        eReports.compareNotNULL(claimingCandidatesPage, "Open 'ISSUE -> Claiming -> Candidates' page.");

        eReports.compareTrue(claimingCandidatesPage.clickSubmit(),
                "Click 'Submit' button.");
    }
    public void candidatesTest_BVT() {
        eReports.createNode("ISSUE -> Claiming -> Candidates Page.",
                "Verify Candidates Page.");

        ClaimingCandidatesPage claimingCandidatesPage = new ClaimingCandidatesPage();
        if (eReports.compareNotNULL(claimingCandidatesPage, "Open 'ISSUE -> Claiming -> Candidates' page.")) {

            eReports.compareTrue(claimingCandidatesPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(claimingCandidatesPage.isPageOpened(),
                    "Verify that Candidates page is opened.");
        }
    }

    public void activeClaimTest() {
        eReports.createNode("ISSUE -> Claiming -> Active Claim Page.", "Verify Active Claim Page.");

        ClaimingActivePage claimingActivePage = new ClaimingActivePage();
        eReports.compareNotNULL(claimingActivePage, "Open 'ISSUE -> Claiming -> Active Claim' page.");

        eReports.compareTrue(claimingActivePage.clickSubmit(),
                "Click 'Submit' button.");
    }
    public void activeClaimTest_BVT() {
        eReports.createNode("ISSUE -> Claiming -> Active Claim Page.",
                "Verify Active Claim Page.");

        ClaimingActivePage claimingActivePage = new ClaimingActivePage();
        if (eReports.compareNotNULL(claimingActivePage, "Open 'ISSUE -> Claiming -> Active Claim' page.")) {

            eReports.compareTrue(claimingActivePage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(claimingActivePage.isPageOpened(),
                    "Verify that Active Claim page is opened.");
        }
    }

    public void claimingHistoryTest() {
        eReports.createNode("ISSUE -> Claiming -> History Page.", "Verify Claiming History Page.");

        ClaimingHistoryPage claimingHistoryPage = new ClaimingHistoryPage();
        eReports.compareNotNULL(claimingHistoryPage, "Open 'ISSUE -> Claiming -> History' page.");

        eReports.compareTrue(claimingHistoryPage.clickSubmit(),
                "Click 'Submit' button.");
    }
    public void claimingHistoryTest_BVT() {
        eReports.createNode("ISSUE -> Claiming -> History Page.",
                "Verify History Page.");

        ClaimingHistoryPage claimingHistoryPage = new ClaimingHistoryPage();
        if (eReports.compareNotNULL(claimingHistoryPage, "Open 'ISSUE -> Claiming -> History' page.")) {

            eReports.compareTrue(claimingHistoryPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(claimingHistoryPage.isPageOpened(),
                    "Verify that Claiming History page is opened.");
        }
    }

    public void ClaimRequestTest() {
        String claimingAccession = prop.getProperty("claimingAccession");

        eReports.createNode("ISSUE -> Claiming -> Claim Request Page.", "Verify Claiming History Page.");

        ClaimRequestPage claimRequestPage = new ClaimRequestPage();
        eReports.compareNotNULL(claimRequestPage, "Open 'ISSUE -> Claiming -> Claim Request' page.");

        eReports.compareTrue(claimRequestPage.journalSequence.setText(claimingAccession),
                "Set Journal Sequence to " + claimingAccession);
        eReports.compareTrue(claimRequestPage.clickSubmit(),
                "Click 'Submit' button.");
    }
    public void ClaimRequestTest_BVT() {
        String claimingAccession = prop.getProperty("claimingAccession");

        eReports.createNode("ISSUE -> Claiming -> Claim Request Page.",
                "Verify Claiming Request Page.");

        ClaimRequestPage claimRequestPage = new ClaimRequestPage();
        if (eReports.compareNotNULL(claimRequestPage, "Open 'ISSUE -> Claiming -> Claim Request' page.")) {

            eReports.compareTrue(claimRequestPage.journalSequence.setText(claimingAccession),
                    "Set Journal Sequence to " + claimingAccession);

            eReports.compareTrue(claimRequestPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(claimRequestPage.isPageOpened(),
                    "Verify that Claiming Request page is opened.");
        }
    }
}
