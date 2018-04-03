package tests.misc;

import com.reporting.ExtentManager;
import pages.misc.StatisticsByAllPage;
import pages.misc.StatisticsByCorrectionIdPage;
import pages.misc.StatisticsByRequestStatusPage;
import pages.misc.StatisticsByUserIdPage;
import pages.utSequences.ViewDeleteUTSequencesPage;
import pages.utSequences.ViewUTSequencesPage;

import java.util.Properties;

public class MiscTests {
    private ExtentManager eReports;
    private Properties prop;

    public MiscTests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

    public void Statistics_All_BVT() {
        eReports.createNode("Misc. -> Statistics -> All page.", "Verify the Statistics By All page.");

        StatisticsByAllPage statisticsByAllPage = new StatisticsByAllPage();
        eReports.compareNotNULL(statisticsByAllPage, "Open 'Misc. -> Statistics -> All' page.");
    }

    public void Statistics_CorrectionId_BVT() {
        String corrID = prop.getProperty("statisticsByCorrIdPage_corrID");

        eReports.createNode("Misc. -> Statistics -> By Corr Id page.", "Verify the Statistics By Correction Id page.");

        StatisticsByCorrectionIdPage statisticsByCorrectionIdPage = new StatisticsByCorrectionIdPage();
        if (eReports.compareNotNULL(statisticsByCorrectionIdPage, "Open 'Misc. -> Statistics -> By Corr Id' page.")) {

            eReports.compareTrue(statisticsByCorrectionIdPage.corrId.setText(corrID),
                    "Set Corr ID to " + corrID);
            eReports.compareTrue(statisticsByCorrectionIdPage.clickSubmit(),
                    "Click 'Submit' button and verify that the statistic is displayed.");
        }
    }

    public void Statistics_RequestStatus_BVT() {
        eReports.createNode("Misc. -> Statistics -> By Status page.", "Verify the Statistics By Request Status page.");

        StatisticsByRequestStatusPage statisticsByRequestStatusPage = new StatisticsByRequestStatusPage();
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

        StatisticsByUserIdPage statisticsByUserIdPage = new StatisticsByUserIdPage();
        if (eReports.compareNotNULL(statisticsByUserIdPage, "Open 'Misc. -> Statistics -> By User Id' page.")) {

            eReports.compareTrue(statisticsByUserIdPage.selectUser(username),
                    "Select '" + username + "' in the dropdown.");

            eReports.compareTrue(statisticsByUserIdPage.clickSubmit(),
                    "Click 'Submit' button and verify that the requests are displayed.");
        }
    }

}
