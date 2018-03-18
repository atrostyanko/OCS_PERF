package tests.search;

import com.reporting.ExtentManager;
import pages.journal.JournalInquiryPage;
import pages.publisher.BookInquiryPage;
import pages.search.ProductCodesSearchPage;
import pages.search.ProductCodesSearchPage.SearchFields;
import pages.search.ProductCodesSearchPage.SearchOptions;
import pages.search.SearchOCSPage;

import java.util.ArrayList;
import java.util.Properties;

public class ProductCodesTests {
    private ExtentManager eReports;
    private Properties prop;

    public ProductCodesTests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

    //=== Tests
    private void searchByCodeTest(SearchOptions option, SearchFields field, String value,
                                  boolean expectedResultVerification, String expectedPubNo, String expectedSeqNo,
                                  String expectedFullTitle) {

        eReports.createNode("Search -> Product Codes -> " + option + " by " + field + ".",
                "Verify Search " + option + " Publication by " + field + ".");

        ProductCodesSearchPage productCodesSearchPage = new ProductCodesSearchPage();
        eReports.compareNotNULL(productCodesSearchPage,
                "Open 'Search -> Product Codes' search page.");

        eReports.compareTrue(productCodesSearchPage.selectSearchOption(option),
                "Set '" + option + "' search option.");

        eReports.compareTrue(productCodesSearchPage.setValue(field, value),
                "Set " + value + " to the '" + field + "' field.");

        SearchOCSPage searchOCSPage = productCodesSearchPage.clickSearchButton(option);
        if (eReports.compareNotNULL(searchOCSPage,
                "Click 'Search' button and verify that Search OCS page was opened.")) {
            if (expectedResultVerification) {
                eReports.compareTrue(searchOCSPage.isPublNoDisplayed(expectedPubNo),
                        "Verify that expected entity with Pub No:" + expectedPubNo + " is displayed.");
                eReports.compareTrue(searchOCSPage.isSeqNoDisplayed(expectedSeqNo),
                        "Verify that expected entity with Seq No:" + expectedSeqNo + " is displayed.");
                eReports.compareTrue(searchOCSPage.isFullTitileDisplayed(expectedFullTitle),
                        "Verify that expected entity with Full Title:" + expectedFullTitle + " is displayed.");
            }

            eReports.compareTrue(searchOCSPage.goButton.isDisplayed(),
                    "Verify that 'Go' button is displayed.");
        }
    }
    private void searchByCodeAndCategory(SearchOptions option, String productionCode, String subjectCategory,
                                         boolean expectedResultVerification, String expectedPubNo, String expectedSeqNo,
                                         String expectedFullTitle) {

        eReports.createNode("Search -> Product Codes -> " + option + " by Production Code and Subject Category.",
                "Verify Search " + option + " Publication by Production Code and Subject Category.");

        //=== Journal Sequence No.
        ProductCodesSearchPage productCodesSearchPage = new ProductCodesSearchPage();
        eReports.compareNotNULL(productCodesSearchPage,
                "Open 'Search -> Product Codes' search page.");

        eReports.compareTrue(productCodesSearchPage.selectSearchOption(option),
                "Set '" + option + "' search option.");

        eReports.compareTrue(productCodesSearchPage.setValue(SearchFields.ProductCode, productionCode),
                "Select " + productionCode + " to the 'Production Code' field.");

        eReports.compareTrue(productCodesSearchPage.setValue(SearchFields.SubjectCategory, subjectCategory),
                "Select " + subjectCategory + " to the 'Subject Category' field.");

        SearchOCSPage searchOCSPage = productCodesSearchPage.clickSearchButton(option);
        if (eReports.compareNotNULL(searchOCSPage,
                "Click 'Search' button and verify that Search OCS page was opened.")) {
            if (expectedResultVerification) {
                eReports.compareTrue(searchOCSPage.isPublNoDisplayed(expectedPubNo),
                        "Verify that expected entity with Pub No:" + expectedPubNo + " is displayed.");
                eReports.compareTrue(searchOCSPage.isSeqNoDisplayed(expectedSeqNo),
                        "Verify that expected entity with Seq No:" + expectedSeqNo + " is displayed.");
                eReports.compareTrue(searchOCSPage.isFullTitileDisplayed(expectedFullTitle),
                        "Verify that expected entity with Full Title:" + expectedFullTitle + " is displayed.");
            }

            eReports.compareTrue(searchOCSPage.goButton.isDisplayed(),
                    "Verify that 'Go' button is displayed.");
        }
    }

    public void FullProductCodesTests() {
        searchByCodeTest(SearchOptions.ALL,
                SearchFields.ProductCode,
                prop.getProperty("searchProductCode"),
                true,
                prop.getProperty("resultPublNoByCode"),
                prop.getProperty("resultSeqNoByCode"),
                prop.getProperty("resultFullTitleByCode"));

        searchByCodeTest(SearchOptions.JOURNALS,
                SearchFields.ProductCode,
                prop.getProperty("searchProductCode"),
                true,
                prop.getProperty("resultPublNoByCode"),
                prop.getProperty("resultSeqNoByCode"),
                prop.getProperty("resultFullTitleByCode"));

        searchByCodeTest(SearchOptions.ACTIVEJOURNALS,
                SearchFields.ProductCode,
                prop.getProperty("searchProductCode"),
                true,
                prop.getProperty("resultPublNoByCode"),
                prop.getProperty("resultSeqNoByCode"),
                prop.getProperty("resultFullTitleByCode"));

        searchByCodeTest(SearchOptions.SERIES,
                SearchFields.ProductCode,
                prop.getProperty("searchProductCode"),
                false,
                prop.getProperty("resultPublNoByCode"),
                prop.getProperty("resultSeqNoByCode"),
                prop.getProperty("resultFullTitleByCode"));

        searchByCodeTest(SearchOptions.SAMPLEJOURNALS,
                SearchFields.ProductCode,
                prop.getProperty("searchProductCode"),
                false,
                prop.getProperty("resultPublNoByCode"),
                prop.getProperty("resultSeqNoByCode"),
                prop.getProperty("resultFullTitleByCode"));

        searchByCodeTest(SearchOptions.ALLJOURNALS,
                SearchFields.ProductCode,
                prop.getProperty("searchProductCode"),
                true,
                prop.getProperty("resultPublNoByCode"),
                prop.getProperty("resultSeqNoByCode"),
                prop.getProperty("resultFullTitleByCode"));

        searchByCodeTest(SearchOptions.ALLJOURNALS,
                SearchFields.ProductCode,
                prop.getProperty("searchProductCode"),
                true,
                prop.getProperty("resultPublNoByCode"),
                prop.getProperty("resultSeqNoByCode"),
                prop.getProperty("resultFullTitleByCode"));

        searchByCodeTest(SearchOptions.SAMPLEBOOKS,
                SearchFields.ProductCode,
                prop.getProperty("searchProductCode"),
                false,
                prop.getProperty("resultPublNoByCode"),
                prop.getProperty("resultSeqNoByCode"),
                prop.getProperty("resultFullTitleByCode"));

        searchByCodeTest(SearchOptions.ALLBOOKS,
                SearchFields.ProductCode,
                prop.getProperty("searchProductCode"),
                false,
                prop.getProperty("resultPublNoByCode"),
                prop.getProperty("resultSeqNoByCode"),
                prop.getProperty("resultFullTitleByCode"));



        searchByCodeAndCategory(SearchOptions.ALL,
                prop.getProperty("searchProductCode"),
                prop.getProperty("searchSubjectCategory"),
                true,
                prop.getProperty("resultPublNoByCodeAndCategory"),
                prop.getProperty("resultSeqNoByCodeAndCategory"),
                prop.getProperty("resultFullTitleByCodeAndCategory"));

        searchByCodeAndCategory(SearchOptions.JOURNALS,
                prop.getProperty("searchProductCode"),
                prop.getProperty("searchSubjectCategory"),
                true,
                prop.getProperty("resultPublNoByCodeAndCategory"),
                prop.getProperty("resultSeqNoByCodeAndCategory"),
                prop.getProperty("resultFullTitleByCodeAndCategory"));

        searchByCodeAndCategory(SearchOptions.ACTIVEJOURNALS,
                prop.getProperty("searchProductCode"),
                prop.getProperty("searchSubjectCategory"),
                true,
                prop.getProperty("resultPublNoByCodeAndCategory"),
                prop.getProperty("resultSeqNoByCodeAndCategory"),
                prop.getProperty("resultFullTitleByCodeAndCategory"));

        searchByCodeAndCategory(SearchOptions.SERIES,
                prop.getProperty("searchProductCode"),
                prop.getProperty("searchSubjectCategory"),
                false,
                prop.getProperty("resultPublNoByCodeAndCategory"),
                prop.getProperty("resultSeqNoByCodeAndCategory"),
                prop.getProperty("resultFullTitleByCodeAndCategory"));

        searchByCodeAndCategory(SearchOptions.SAMPLEJOURNALS,
                prop.getProperty("searchProductCode"),
                prop.getProperty("searchSubjectCategory"),
                false,
                prop.getProperty("resultPublNoByCodeAndCategory"),
                prop.getProperty("resultSeqNoByCodeAndCategory"),
                prop.getProperty("resultFullTitleByCodeAndCategory"));

        searchByCodeAndCategory(SearchOptions.ALLJOURNALS,
                prop.getProperty("searchProductCode"),
                prop.getProperty("searchSubjectCategory"),
                true,
                prop.getProperty("resultPublNoByCodeAndCategory"),
                prop.getProperty("resultSeqNoByCodeAndCategory"),
                prop.getProperty("resultFullTitleByCodeAndCategory"));

        searchByCodeAndCategory(SearchOptions.ALLJOURNALS,
                prop.getProperty("searchProductCode"),
                prop.getProperty("searchSubjectCategory"),
                true,
                prop.getProperty("resultPublNoByCodeAndCategory"),
                prop.getProperty("resultSeqNoByCodeAndCategory"),
                prop.getProperty("resultFullTitleByCodeAndCategory"));

        searchByCodeAndCategory(SearchOptions.SAMPLEBOOKS,
                prop.getProperty("searchProductCode"),
                prop.getProperty("searchSubjectCategory"),
                false,
                prop.getProperty("resultPublNoByCodeAndCategory"),
                prop.getProperty("resultSeqNoByCodeAndCategory"),
                prop.getProperty("resultFullTitleByCodeAndCategory"));

        searchByCodeAndCategory(SearchOptions.ALLBOOKS,
                prop.getProperty("searchProductCode"),
                prop.getProperty("searchSubjectCategory"),
                false,
                prop.getProperty("resultPublNoByCodeAndCategory"),
                prop.getProperty("resultSeqNoByCodeAndCategory"),
                prop.getProperty("resultFullTitleByCodeAndCategory"));
    }
    public void ProductCodesTest_BVT() {
        eReports.createNode("Search -> Product Codes page.",
                "Verify Search Product Codes page.");

        ProductCodesSearchPage productCodesSearchPage = new ProductCodesSearchPage();
        eReports.compareNotNULL(productCodesSearchPage,
                "Open 'Search -> Product Codes' search page.");

    }
}
