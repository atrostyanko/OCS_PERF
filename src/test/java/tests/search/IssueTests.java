package tests.search;

import com.reporting.ExtentManager;
import pages.issue.IssueDetailsPage;
import pages.publisher.ArticleSummaryPage;
import pages.search.IssueSearchPage;
import pages.search.IssueSearchPage.SearchFields;

import java.util.Properties;

public class IssueTests {
    private ExtentManager eReports;
    private Properties prop;

    public IssueTests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

    //=== Tests
    private void searchIssueTest(SearchFields field, String value) {
        ExtentManager.createNode("Search -> Issues -> by " + field + ".",
                "Verify Search Issues by " + field + ".");

        //=== Journal Sequence No.
        IssueSearchPage issueSearchPage = new IssueSearchPage();
        ExtentManager.compareNotNULL(issueSearchPage,
                "Open 'Search -> Issues' search page.");

        ExtentManager.compareTrue(issueSearchPage.setValue(field, value),
                "Set " + value + " to the '" + field + "' field.");

        IssueDetailsPage issueDetailsPage = (IssueDetailsPage) issueSearchPage.clickSearchButton(false);
        ExtentManager.compareNotNULL(issueDetailsPage,
                "Click 'Search' button and verify that Issue Details page was opened.");

        ExtentManager.compareTrue(issueDetailsPage.checkValue(field, value),
                "Verify that " + value + " is displayed in the '" + field + "' field.");
    }
    private void searchArticleTest(SearchFields field, String value, String articleValue) {
        ExtentManager.createNode("Search -> Issues -> by Article + " + field + ".",
                "Verify Search Issues by Article + " + field + ".");

        //=== Journal Sequence No.
        IssueSearchPage issueSearchPage = new IssueSearchPage();
        ExtentManager.compareNotNULL(issueSearchPage,
                "Open 'Search -> Issues' search page.");

        ExtentManager.compareTrue(issueSearchPage.setValue(field, value),
                "Set " + value + " to the '" + field + "' field.");

        ExtentManager.compareTrue(issueSearchPage.setValue(SearchFields.ArticleNumber, articleValue),
                "Set " + value + " to the '" + field + "' field.");

        ArticleSummaryPage articleSummaryPage = (ArticleSummaryPage) issueSearchPage.clickSearchButton(true);
        ExtentManager.compareNotNULL(articleSummaryPage,
                "Click 'Search' button and verify that Article Summary page was opened.");
    }

    public void FullIssueTests() {
        searchIssueTest(SearchFields.DatafactIssueNumber,
                prop.getProperty("issuesSearchIssueNumber"));

        searchIssueTest(SearchFields.Accession,
                prop.getProperty("issuesSearchAccession"));

        searchArticleTest(SearchFields.DatafactIssueNumber,
                prop.getProperty("issuesSearchIssueNumber"), prop.getProperty("issuesSearchArticleNumber"));

        searchArticleTest(SearchFields.Accession,
                prop.getProperty("issuesSearchAccession"), prop.getProperty("issuesSearchArticleNumber"));
    }
}
