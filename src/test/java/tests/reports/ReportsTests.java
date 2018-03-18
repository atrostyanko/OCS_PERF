package tests.reports;

import com.reporting.ExtentManager;
import tests.reports.conference.ReportsConferenceTests;
import tests.reports.issue.ReportsIssueTests;
import tests.reports.journal.ReportsJournalTests;
import tests.reports.productCodes.ReportsProductCodesTests;
import tests.reports.publisher.ReportsPublisherTests;
import tests.reports.royalty.ReportsRoyaltyTests;

import java.util.Properties;

public class ReportsTests {
    private ExtentManager eReports;
    private Properties prop;

    public ReportsTests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

    public void publisherTest_BVT() {
        ReportsPublisherTests publisherTests = new ReportsPublisherTests(eReports, prop);

        publisherTests.journalsCoveredTest_BVT();

        publisherTests.publDiscListTest_BVT();

        publisherTests.jrnlsOnJutyHolds_BVT();

        publisherTests.unspecifiedSubscriptions_BVT();

        publisherTests.withoutEvaluationDate_BVT();
    }

    public void journalTest_BVT() {
        ReportsJournalTests reportsJournalTests = new ReportsJournalTests(eReports, prop);

        reportsJournalTests.journalListingTest_BVT();

        reportsJournalTests.journalChangesTest_BVT();

        reportsJournalTests.journalReevaluationTest_BVT();
    }

    public void issueTest_BVT() {
        ReportsIssueTests reportsIssueTests = new ReportsIssueTests(eReports, prop);

        reportsIssueTests.issuesDeletedModifiedTest_BVT();

        reportsIssueTests.issuesKeyedTest_BVT();

        reportsIssueTests.trackingIssuesProcessTest_BVT();
    }

    public void conferenceTest_BVT() {
        ReportsConferenceTests reportsConferenceTests = new ReportsConferenceTests(eReports, prop);

        reportsConferenceTests.articlesNotLinkedConfTest_BVT();

        reportsConferenceTests.confSponsorsDictListTest_BVT();
    }

    public void productCodesTest_BVT() {
        ReportsProductCodesTests reportsProductCodesTests = new ReportsProductCodesTests(eReports, prop);

        reportsProductCodesTests.missingProductCodesTest_BVT();

        reportsProductCodesTests.productOverrLapTest_BVT();

    }

    public void royaltyTest_BVT() {
        ReportsRoyaltyTests reportsRoyaltyTests = new ReportsRoyaltyTests(eReports, prop);

        reportsRoyaltyTests.royaltyCodesBlankTest_BVT();

        reportsRoyaltyTests.updatedRoyaltyExpDatesTest_BVT();
    }


}
