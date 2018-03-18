package tests.conference;

import com.reporting.ExtentManager;
import pages.conference.ConferenceEditPage;
import pages.conference.ConferenceInputPage;

import java.util.Properties;

public class ConferenceEditTests {
    private ExtentManager eReports;
    private Properties prop;

    public ConferenceEditTests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

    public void conferenceEditTest_BVT() {
        String conferenceNumber = prop.getProperty("conferenceNumber");

        eReports.createNode("Conf. -> Conference Edit.",
                "Verify Conference Input Page.");

        ConferenceEditPage conferenceEditPage = new ConferenceEditPage();
        if (eReports.compareNotNULL(conferenceEditPage, "Open 'Conf. -> Conference Edit' page.")) {

            eReports.compareTrue(conferenceEditPage.conferenceNumber.setText(conferenceNumber),
                    "Set Conference to " + conferenceNumber);

            eReports.compareTrue(conferenceEditPage.submitBtn.click(),
                    "Click 'Submit' button.");

            eReports.compareTrue(conferenceEditPage.isPageOpened(),
                    "Verify that Conference Edit page is opened.");
        }
    }
}
