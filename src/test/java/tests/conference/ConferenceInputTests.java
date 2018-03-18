package tests.conference;

import com.reporting.ExtentManager;
import pages.conference.ConferenceInputPage;

import java.util.Properties;

public class ConferenceInputTests {
    private ExtentManager eReports;
    private Properties prop;

    public ConferenceInputTests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

    public void conferenceInputTest_BVT() {
        eReports.createNode("Conf. -> Conference Input.",
                "Verify Conference Input Page.");

        ConferenceInputPage conferenceInputPage = new ConferenceInputPage();
        if (eReports.compareNotNULL(conferenceInputPage, "Open 'Conf. -> Conference Input' page.")) {
            eReports.compareTrue(conferenceInputPage.isPageOpened(),
                    "Verify that Conference Input page is opened.");
        }
    }
}
