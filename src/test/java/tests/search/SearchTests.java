package tests.search;

import com.reporting.ExtentManager;
import tests.OCS_Test;

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
        ExtentManager.createNode("Search -> Publishers Page.", "Verify Search Publishers Page.");

        PublishersTests publishersTests = new PublishersTests(eReports, prop);
        publishersTests.FullPublishersTests();
    }

    public void issuesTest() {
        ExtentManager.createNode("Search -> Issues Page.", "Verify Search Issues Page.");
    }
    public void conferencesTest() {
        ExtentManager.createNode("Search -> Conferences Page.", "Verify Search Conferences Page.");
    }
    public void productCodesTest() {
        ExtentManager.createNode("Search -> Product Codes Page.", "Verify Search Product Codes Page.");
    }
}
