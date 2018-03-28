package tests.bvt;

import com.configuration.TestsConfig;
import com.configuration.properties.AllProperties;
import com.configuration.properties.PropertiesLoader;
import com.configuration.properties.PropertyFile;
import com.reporting.ExtentManager;
import com.webtestsbase.WebDriverFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.*;
import pages.extraction.ExtractionConfirmPage;
import pages.extraction.ExtractionResultPage;
import pages.extraction.ExtractionSearchPage;
import tests.loginPage.LoginPage_Tests;

import java.util.Properties;

/**
 * Created by Alexandr Trostyanko.
 */

@PropertyFile("testData/bvt/bvt.properties")
public class BVT_Calendar_Test {
    public static ExtentManager eReports;

    @AllProperties
    public static Properties prop;

    @BeforeClass
    public static void beforeClass() {
        eReports = new ExtentManager();
        ExtentManager.setFolderPath(TestsConfig.getConfig().getReportsPath());
        ExtentManager.GetExtent("CHEM Performance Test.");
        WebDriverFactory.startBrowser(true);
        PropertiesLoader.populate(new BVT_Calendar_Test());
    }

    @AfterClass
    public static void afterClass() {
        WebDriverFactory.finishBrowser();
        eReports.flush();
    }

    @Test
    public void mainTests() {
        eReports.createTest("CHEM Build Verification Test.", "Verify all items from CHEM menu.");

        MainPage mainPage = new LoginPage_Tests(eReports, prop).login();
        eReports.compareNotNULL(mainPage,
                "Verify that Main page is opened.");

        //=== Toc Menu

        TocPage tocPage = new TocPage();
        eReports.compareNotNULL(tocPage,
                "Verify that 'Toc' page is opened.");

        //=== Input menu
        ChemInputSelectionPage chemInputSelectionPage = new ChemInputSelectionPage();
        eReports.compareNotNULL(chemInputSelectionPage,
                "Verify that 'Chem Input Selection' page is opened.");
        chemInputSelectionPage.closeWindow();

        //ToDo: new window is opened - need add additional methods to handle it

        //=== Edit menu
        //ToDo: An exception on the page

        //=== Extract menu
        ExtractionSearchPage extractionSearchPage = new ExtractionSearchPage();
        eReports.compareNotNULL(extractionSearchPage,
                "Verify that 'Extraction' page is opened.");

        ExtractionConfirmPage extractionConfirmPage = extractionSearchPage.clickSubmit();
        eReports.compareNotNULL(extractionConfirmPage,
                "Click 'Submit' and verify that Extraction Confirmation page is opened.");

        ExtractionResultPage extractionResultPage = extractionConfirmPage.clickExtract();
        eReports.compareNotNULL(extractionResultPage,
                "Click 'Extract' and verify that Extraction Result page is opened.");

        //=== Report menu
        //ToDo: not working is the APP

        //=== Dictionary menu
        DictionaryUpdatePage dictionaryUpdatePage = new DictionaryUpdatePage();
        eReports.compareNotNULL(dictionaryUpdatePage,
                "Verify that 'Dictionary Update' page is opened.");

        //=== NNC menu
        NNCPage nncPage = new NNCPage();
        eReports.compareNotNULL(nncPage,
                "Verify that 'NNC Journal Input' page is opened.");

        eReports.compareTrue(mainPage.logoffMainMenu.click(), "Logoff from the APP.");
    }
}
