package tests.miscellaneous;

import com.reporting.ExtentManager;
import tests.dictionary.DictionaryTests;
import tests.reports.ReportsTests;

import java.util.Properties;

public class MiscellaneousTests {
    private ExtentManager eReports;
    private Properties prop;

    public MiscellaneousTests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

    public void reportsTest() {
        ReportsTests reportsTests = new ReportsTests(eReports, prop);

        reportsTests.publisherTest_BVT();

        reportsTests.journalTest_BVT();

        reportsTests.issueTest_BVT();

        reportsTests.conferenceTest_BVT();

        reportsTests.productCodesTest_BVT();

        reportsTests.royaltyTest_BVT();
    }

    public void dictionaryTest() {
        DictionaryTests dictionaryTests = new DictionaryTests(eReports, prop);

        dictionaryTests.bookCurrencyTest_BVT();

        dictionaryTests.bookFormLimitsTest_BVT();

        dictionaryTests.countryTest_BVT();

        dictionaryTests.preferedCountryTest_BVT();

        dictionaryTests.languageTest_BVT();

        dictionaryTests.productCodeTest_BVT();

        dictionaryTests.stateTest_BVT();

        dictionaryTests.subjectCategoryTest_BVT();

        dictionaryTests.prodSubjCategAllowedTest_BVT();
    }

    public void printerSetupTest() {

    }
}
