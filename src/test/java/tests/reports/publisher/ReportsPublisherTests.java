package tests.reports.publisher;

import com.reporting.ExtentManager;
import pages.reports.publisher.*;

import java.util.Properties;

public class ReportsPublisherTests {
    private ExtentManager eReports;
    private Properties prop;

    public ReportsPublisherTests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

    public void journalsCoveredTest_BVT() {
        eReports.createNode("Misc. -> Reports -> Publisher - > Jrnls by 3 or more edts.",
                "Verify 'Jrnls by 3 or more edts' Page.");

        JrnlsMoreEdtsPage reportsPage = new JrnlsMoreEdtsPage();
        if (eReports.compareNotNULL(reportsPage, "Open 'Jrnls by 3 or more edts' page.")) {

            eReports.compareTrue(reportsPage.clickSubmit(), "Click 'Submit' button.");

            eReports.compareTrue(reportsPage.isPageOpened(), "Verify that 'Jrnls by 3 or more edts' page is opened.");
        }
    }

    public void publDiscListTest_BVT() {
        eReports.createNode("Misc. -> Reports -> Publisher - > Publ disc list.",
                "Verify 'Publ disc list' Page.");

        PublDiscListPage reportsPage = new PublDiscListPage();
        if (eReports.compareNotNULL(reportsPage, "Open 'Publ disc list' page.")) {

            eReports.compareTrue(reportsPage.clickSubmit(), "Click 'Submit' button.");

            eReports.compareTrue(reportsPage.isPageOpened(), "Verify that 'Publ disc list' page is opened.");
        }
    }

    public void jrnlsOnJutyHolds_BVT() {
        eReports.createNode("Misc. -> Reports -> Publisher - > Jrnls on juty holds.",
                "Verify 'Jrnls on juty holds' Page.");

        JrnlsJutyHoldsPage reportsPage = new JrnlsJutyHoldsPage();
        if (eReports.compareNotNULL(reportsPage, "Open 'Jrnls on juty holds' page.")) {

            eReports.compareTrue(reportsPage.clickSubmit(), "Click 'Submit' button.");

            eReports.compareTrue(reportsPage.isPageOpened(), "Verify that 'Jrnls on juty holds' page is opened.");
        }
    }

    public void unspecifiedSubscriptions_BVT() {
        eReports.createNode("Misc. -> Reports -> Publisher - > UnspecifiedSubscriptionsPage.",
                "Verify 'UnspecifiedSubscriptionsPage' Page.");

        UnspecifiedSubscriptionsPage reportsPage = new UnspecifiedSubscriptionsPage();
        if (eReports.compareNotNULL(reportsPage, "Open 'UnspecifiedSubscriptionsPage' page.")) {

            eReports.compareTrue(reportsPage.clickSubmit(), "Click 'Submit' button.");

            eReports.compareTrue(reportsPage.isPageOpened(), "Verify that 'UnspecifiedSubscriptionsPage' page is opened.");
        }
    }

    public void withoutEvaluationDate_BVT() {
        eReports.createNode("Misc. -> Reports -> Publisher - > UnspecifiedSubscriptionsPage.",
                "Verify 'UnspecifiedSubscriptionsPage' Page.");

        WithoutEvaluationDatePage reportsPage = new WithoutEvaluationDatePage();
        if (eReports.compareNotNULL(reportsPage, "Open 'UnspecifiedSubscriptionsPage' page.")) {

            eReports.compareTrue(reportsPage.clickSubmit(), "Click 'Submit' button.");

            eReports.compareTrue(reportsPage.isPageOpened(), "Verify that 'UnspecifiedSubscriptionsPage' page is opened.");
        }
    }
}
