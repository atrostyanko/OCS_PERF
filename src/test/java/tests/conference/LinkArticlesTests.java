package tests.conference;

import com.reporting.ExtentManager;
import pages.conference.ConferenceDetailsPage;
import pages.conference.LinkArticlesPage;

import java.util.Properties;

public class LinkArticlesTests {
    private ExtentManager eReports;
    private Properties prop;

    public LinkArticlesTests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

    public void linkArticlesTest_BVT() {
        String conferenceNumber = prop.getProperty("linkArticlesConferenceNumber");
        String accessionNumber = prop.getProperty("linkArticlesAccessionNumber");

        eReports.createNode("Conf. -> Link Articles.",
                "Verify Linking Articles to a Conference Page.");

        LinkArticlesPage linkArticlesPage = new LinkArticlesPage();
        if (eReports.compareNotNULL(linkArticlesPage, "Open 'Conf. -> Link Articles' page.")) {

            eReports.compareTrue(linkArticlesPage.conferenceNumber.setText(conferenceNumber),
                    "Set Conference to " + conferenceNumber);

            eReports.compareTrue(linkArticlesPage.accession.setText(accessionNumber),
                    "Set Accession to " + accessionNumber);

            eReports.compareTrue(linkArticlesPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(linkArticlesPage.submitChanges.isDisplayed()
                            && linkArticlesPage.isPageOpened(),
                    "Verify that Linking Articles to a Conference page is opened.");
        }
    }
}
