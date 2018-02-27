package tests.issue;

import com.reporting.ExtentManager;
import pages.MainPage;
import pages.issue.EditIssuePage;
import pages.issue.IssueDetailsPage;
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
}
