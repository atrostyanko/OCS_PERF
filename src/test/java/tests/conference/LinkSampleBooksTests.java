package tests.conference;

import com.reporting.ExtentManager;
import pages.conference.LinkArticlesPage;
import pages.conference.LinkSampleBooksPage;

import java.util.Properties;

public class LinkSampleBooksTests {
    private ExtentManager eReports;
    private Properties prop;

    public LinkSampleBooksTests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

    public void linkSampleBooksTest_BVT() {
        String conferenceNumber = prop.getProperty("linkSampleConferenceNumber");
        String bookNumber = prop.getProperty("linkSampleBookNumber");

        eReports.createNode("Conf. -> Link Sample Books.",
                "Verify Link Sample Books Page.");

        LinkSampleBooksPage linkSampleBooksPage = new LinkSampleBooksPage();
        if (eReports.compareNotNULL(linkSampleBooksPage, "Open 'Conf. -> Link Sample Books' page.")) {

            eReports.compareTrue(linkSampleBooksPage.conferenceNumber.setText(conferenceNumber),
                    "Set Conference to " + conferenceNumber);

            eReports.compareTrue(linkSampleBooksPage.bookNumber.setText(bookNumber),
                    "Set Book Number to " + bookNumber);

            eReports.compareTrue(linkSampleBooksPage.clickSubmit(),
                    "Click 'Submit' button.");

            eReports.compareTrue(linkSampleBooksPage.isPageOpened(),
                    "Verify that Linking Sample Books to a Conference page is opened.");
        }
    }
}
