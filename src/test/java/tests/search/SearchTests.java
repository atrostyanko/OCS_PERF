package tests.search;

import com.reporting.ExtentManager;

import java.util.Properties;

public class SearchTests {
    private ExtentManager eReports;
    private Properties prop;

    public SearchTests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

    public void publicationsTest() {
        PublicationsTests publicationsTests = new PublicationsTests(eReports, prop);
        publicationsTests.FullPublicationsTests();
    }

    public void publishersTest() {
        PublishersTests publishersTests = new PublishersTests(eReports, prop);
        publishersTests.FullPublishersTests();
    }

    public void issuesTest() {
        IssueTests issueTests = new IssueTests(eReports, prop);
        issueTests.FullIssueTests();
    }
    public void conferencesTest() {
        ConferenceTests conferenceTests = new ConferenceTests(eReports, prop);
        conferenceTests.FullConferenceTests();
    }
    public void productCodesTest() {

    }
}
