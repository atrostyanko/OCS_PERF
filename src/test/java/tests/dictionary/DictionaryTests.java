package tests.dictionary;

import com.reporting.ExtentManager;
import tests.search.PublicationsTests;

import java.util.Properties;

public class DictionaryTests {
    private ExtentManager eReports;
    private Properties prop;

    public DictionaryTests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

    public void bookCurrencyTest_BVT() {}
    public void bookFormLimitsTest_BVT() {}
    public void countryTest_BVT() {}
    public void preferedCountryTest_BVT() {}
    public void languageTest_BVT() {}
    public void productCodeTest_BVT() {}
    public void stateTest_BVT() {}
    public void subjectCategoryTest_BVT() {}
    public void prodSubjCategAllowedTest_BVT() {}
}
