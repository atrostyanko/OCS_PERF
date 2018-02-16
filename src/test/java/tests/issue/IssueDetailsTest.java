package tests.issue;

import com.reporting.ExtentManager;
import pages.MainPage;
import pages.issue.IssueDetailsPage;
import tests.OCS_Test;

import java.util.Properties;

public class IssueDetailsTest {
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
}