package tests.misc;

import com.reporting.ExtentManager;
import com.webtestsbase.WebDriverFactory;
import pages.misc.*;
import pages.utSequences.ViewDeleteUTSequencesPage;
import pages.utSequences.ViewUTSequencesPage;

import java.util.Properties;

public class MiscTests {
    private ExtentManager eReports;
    private Properties prop;
    private WebDriverFactory webDriverFactory;

    public MiscTests(WebDriverFactory webDriverFactory, ExtentManager eReports, Properties prop) {
        this.webDriverFactory = webDriverFactory;
        this.eReports = eReports;
        this.prop = prop;
    }

    public void Statistics_All_BVT() {
        eReports.createNode("Misc. -> Statistics -> All page.", "Verify the Statistics By All page.");

        StatisticsByAllPage statisticsByAllPage = new StatisticsByAllPage(webDriverFactory, eReports);
        eReports.compareNotNULL(statisticsByAllPage, "Open 'Misc. -> Statistics -> All' page.");
    }

    public void Statistics_CorrectionId_BVT() {
        String corrID = prop.getProperty("statisticsByCorrIdPage_corrID");

        eReports.createNode("Misc. -> Statistics -> By Corr Id page.", "Verify the Statistics By Correction Id page.");

        StatisticsByCorrectionIdPage statisticsByCorrectionIdPage = new StatisticsByCorrectionIdPage(webDriverFactory, eReports);
        if (eReports.compareNotNULL(statisticsByCorrectionIdPage, "Open 'Misc. -> Statistics -> By Corr Id' page.")) {

            eReports.compareTrue(statisticsByCorrectionIdPage.corrId.setText(corrID),
                    "Set Corr ID to " + corrID);
            eReports.compareTrue(statisticsByCorrectionIdPage.clickSubmit(),
                    "Click 'Submit' button and verify that the statistic is displayed.");
        }
    }

    public void Statistics_RequestStatus_BVT() {
        eReports.createNode("Misc. -> Statistics -> By Status page.", "Verify the Statistics By Request Status page.");

        StatisticsByRequestStatusPage statisticsByRequestStatusPage = new StatisticsByRequestStatusPage(webDriverFactory, eReports);
        if (eReports.compareNotNULL(statisticsByRequestStatusPage, "Open 'Misc. -> Statistics -> By Status' page.")) {

            eReports.compareTrue(statisticsByRequestStatusPage.requestsWithStatus_I.set(),
                    "Select View Requests with Status = “I” option.");

            eReports.compareTrue(statisticsByRequestStatusPage.clickSubmit(),
                    "Click 'Submit' button and verify that the requests are displayed.");
        }
    }

    public void Statistics_UserId_BVT() {
        String username = prop.getProperty("statisticsByUserIdPage_username");

        eReports.createNode("Misc. -> Statistics -> By User Id page.", "Verify the Statistics By User Id page.");

        StatisticsByUserIdPage statisticsByUserIdPage = new StatisticsByUserIdPage(webDriverFactory, eReports);
        if (eReports.compareNotNULL(statisticsByUserIdPage, "Open 'Misc. -> Statistics -> By User Id' page.")) {

            eReports.compareTrue(statisticsByUserIdPage.selectUser(username),
                    "Select '" + username + "' in the dropdown.");

            eReports.compareTrue(statisticsByUserIdPage.clickSubmit(),
                    "Click 'Submit' button and verify that the requests are displayed.");
        }
    }

    public void PasswordChange_BVT() {
        eReports.createNode("Misc. -> Password Change page.", "Verify the Password Change page.");

        PasswordChangePage passwordChangePage = new PasswordChangePage(webDriverFactory, eReports);
        eReports.compareNotNULL(passwordChangePage, "Open 'Misc. -> Password Change' page.");
    }

    public void Admin_AddUser_BVT() {
        eReports.createNode("Misc. -> Admin -> Add User page.", "Verify the Add New User page.");

        AddNewUserPage addNewUserPage = new AddNewUserPage(webDriverFactory, eReports);
        eReports.compareNotNULL(addNewUserPage, "Open 'Misc. -> Admin -> Add User' page.");
    }

    public void Admin_EditUser_BVT() {
        String username = prop.getProperty("editUserPage_username");

        eReports.createNode("Misc. -> Admin -> Edit User page.", "Verify the Edit User page.");

        EditUserPage editUserPage = new EditUserPage();
        if (eReports.compareNotNULL(editUserPage, "Open 'Misc. -> Admin -> Edit User' page.")) {

            eReports.compareTrue(editUserPage.selectUser(username),
                    "Select '" + username + "' in the dropdown.");

            eReports.compareTrue(editUserPage.clickSubmit(),
                    "Click 'Submit' button and verify that the Edit User form is displayed.");
        }
    }

    public void Admin_EditGCSLimits_BVT() {
        eReports.createNode("Misc. -> Admin -> Edit GCS_Limits page.", "Verify the Edit GCS_Limits page.");

        EditGCSLimitsPage editGCSLimitsPage = new EditGCSLimitsPage(webDriverFactory, eReports);
        eReports.compareNotNULL(editGCSLimitsPage, "Open 'Misc. -> Admin -> Edit GCS_Limits' page.");
    }

    public void Admin_EditGCSFields_BVT() {
        eReports.createNode("Misc. -> Admin -> Edit GCS_Fields page.", "Verify the Edit GCS Fields page.");

        EditGCSFieldsPage editGCSFieldsPage = new EditGCSFieldsPage(webDriverFactory, eReports);
        eReports.compareNotNULL(editGCSFieldsPage, "Open 'Misc. -> Admin -> Edit GCS_Fields' page.");
    }

    public void Admin_AddGCSField_BVT() {
        eReports.createNode("Misc. -> Admin -> Add GCS Field page.", "Verify the Add GCS Field page.");

        AddGCSFieldPage addGCSFieldPage = new AddGCSFieldPage(webDriverFactory, eReports);
        eReports.compareNotNULL(addGCSFieldPage, "Open 'Misc. -> Admin -> Add GCS Field' page.");
    }
}
