package tests.utSequences;

import com.reporting.ExtentManager;
import pages.ut.AddDeleteUTPage;
import pages.ut.UTDetailsPage;
import pages.utSequences.ViewDeleteUTSequencesPage;
import pages.utSequences.ViewUTSequencesPage;

import java.util.Properties;

public class UTSequencesTests {
    private ExtentManager eReports;
    private Properties prop;

    public UTSequencesTests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

    public void ViewUTSequences_BVT() {
        String corrID = prop.getProperty("viewUTSequencesPage_corrID");

        eReports.createNode("UT Sequences -> View UT Sequences page.", "Verify the View UT Sequences page.");

        ViewUTSequencesPage viewUTSequencesPage = new ViewUTSequencesPage();
        if (eReports.compareNotNULL(viewUTSequencesPage, "Open 'UT Sequences -> View UT Sequences' page.")) {

            eReports.compareTrue(viewUTSequencesPage.corrId.setText(corrID),
                    "Set Corr ID to " + corrID);
            eReports.compareTrue(viewUTSequencesPage.clickSubmit(),
                    "Click 'Submit' button and verify that 'View UT Sequences' are displayed.");
        }
    }

    public void ViewDeleteUTSequences_BVT() {
        String corrID = prop.getProperty("addDeleteUTPage_corrID");

        eReports.createNode("UT Sequences -> View/Delete UT Sequences page.", "Verify the View/Delete UT Sequences page.");

        ViewDeleteUTSequencesPage viewDeleteUTSequencesPage = new ViewDeleteUTSequencesPage();
        if (eReports.compareNotNULL(viewDeleteUTSequencesPage, "Open 'UT Sequences -> View/Delete UT Sequences' page.")) {

            eReports.compareTrue(viewDeleteUTSequencesPage.corrId.setText(corrID),
                    "Set Corr ID to " + corrID);
            eReports.compareTrue(viewDeleteUTSequencesPage.clickSubmit(),
                    "Click 'Submit' button and verify that the 'View/Delete UT Sequences' page is displayed.");
        }
    }
}
