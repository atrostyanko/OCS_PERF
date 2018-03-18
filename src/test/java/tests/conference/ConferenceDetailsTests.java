package tests.conference;

import com.reporting.ExtentManager;
import pages.conference.ConferenceDetailsPage;
import pages.conference.ConferenceInputPage;

import java.util.Properties;

public class ConferenceDetailsTests {
    private ExtentManager eReports;
    private Properties prop;

    public ConferenceDetailsTests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

    public void conferenceDetailsTest_BVT() {
        String conferenceNumber = prop.getProperty("conferenceNumber");

        eReports.createNode("Conf. -> Conference Details.",
                "Verify Conference Details Page.");

        ConferenceDetailsPage conferenceDetailsPage = new ConferenceDetailsPage();
        if (eReports.compareNotNULL(conferenceDetailsPage, "Open 'Conf. -> Conference Details' page.")) {

            eReports.compareTrue(conferenceDetailsPage.conferenceNumber.setText(conferenceNumber),
                    "Set Conference to " + conferenceNumber);

            eReports.compareTrue(conferenceDetailsPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(conferenceDetailsPage.conferenceNoLabel.isDisplayed()
                            && conferenceDetailsPage.isPageOpened(),
                    "Verify that Conference Details page is opened.");
        }
    }
}
