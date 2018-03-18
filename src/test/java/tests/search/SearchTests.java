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
    public void publicationsTest_BVT() {
        PublicationsTests publicationsTests = new PublicationsTests(eReports, prop);
        publicationsTests.PublicationsTest_BVT();
    }

    public void publishersTest() {
        PublishersTests publishersTests = new PublishersTests(eReports, prop);
        publishersTests.FullPublishersTests();
    }
    public void publishersTest_BVT() {
        PublishersTests publishersTests = new PublishersTests(eReports, prop);
        publishersTests.PublishersTest_BVT();
    }

    public void issuesTest() {
        IssueTests issueTests = new IssueTests(eReports, prop);
        issueTests.FullIssueTests();
    }
    public void issuesTest_BVT() {
        IssueTests issueTests = new IssueTests(eReports, prop);
        issueTests.IssueTest_BVT();
    }

    public void conferencesTest() {
        SearchConferenceTests conferenceTests = new SearchConferenceTests(eReports, prop);
        conferenceTests.FullConferenceTests();
    }
    public void conferencesTest_BVT() {
        SearchConferenceTests searchConferenceTests = new SearchConferenceTests(eReports, prop);
        searchConferenceTests.ConferenceTest_BVT();
    }

    public void productCodesTest() {
        ProductCodesTests productCodesTests = new ProductCodesTests(eReports, prop);
        productCodesTests.FullProductCodesTests();
    }
    public void productCodesTest_BVT() {
        ProductCodesTests productCodesTests = new ProductCodesTests(eReports, prop);
        productCodesTests.ProductCodesTest_BVT();
    }
}
