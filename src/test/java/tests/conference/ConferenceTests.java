package tests.conference;

import com.reporting.ExtentManager;
import pages.conference.ConferenceDetailsPage;
import tests.search.*;

import java.util.Properties;

public class ConferenceTests {
    private ExtentManager eReports;
    private Properties prop;

    public ConferenceTests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

    public void conferenceDetailsTest_BVT() {
        ConferenceDetailsTests conferenceDetailsTests = new ConferenceDetailsTests(eReports, prop);
        conferenceDetailsTests.conferenceDetailsTest_BVT();
    }

    public void conferenceInputTest_BVT() {
        ConferenceInputTests conferenceInputTests = new ConferenceInputTests(eReports, prop);
        conferenceInputTests.conferenceInputTest_BVT();
    }

    public void conferenceEditTest_BVT() {
        ConferenceEditTests conferenceEditTests = new ConferenceEditTests(eReports, prop);
        conferenceEditTests.conferenceEditTest_BVT();
    }

    public void linkArticlesTest_BVT() {
        LinkArticlesTests linkArticlesTests = new LinkArticlesTests(eReports, prop);
        linkArticlesTests.linkArticlesTest_BVT();
    }

    public void linkSampleBooksTest_BVT() {
        LinkSampleBooksTests linkSampleBooksTests = new LinkSampleBooksTests(eReports, prop);
        linkSampleBooksTests.linkSampleBooksTest_BVT();
    }
}
