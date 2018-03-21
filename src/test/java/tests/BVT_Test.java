package tests;

import com.configuration.TestsConfig;
import com.configuration.properties.AllProperties;
import com.configuration.properties.PropertiesLoader;
import com.configuration.properties.PropertyFile;
import com.reporting.ExtentManager;
import com.webtestsbase.WebDriverFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.MainPage;
import pages.dictionaries.FirstSecondWordPage;
import pages.dictionaries.HomographTablePage;
import pages.dictionaries.PreliminaryCitedTitleListingPage;
import pages.dictionaries.VariantPreferredPage;
import tests.loginPage.LoginPage_Tests;

import java.util.Properties;

/**
 * Created by Alexandr Trostyanko.
 */

@PropertyFile("testData/bvt.properties")
public class BVT_Test {
    public static ExtentManager eReports;

    @AllProperties
    public static Properties prop;

    @BeforeClass
    public static void beforeClass() {
        eReports = new ExtentManager();
        ExtentManager.setFolderPath(TestsConfig.getConfig().getReportsPath());
        ExtentManager.GetExtent("OCS Performance Test.");
        WebDriverFactory.startBrowser(true);
        PropertiesLoader.populate(new BVT_Test());
    }

    @AfterClass
    public static void afterClass() {
        WebDriverFactory.finishBrowser();
        eReports.flush();
    }

    @Test
    public void publisherTests() {
        eReports.createTest("PUBLISHER Tests.", "Verify all items from PUBLISHER menu.");

        MainPage mainPage = new LoginPage_Tests(eReports, prop).login();
        eReports.compareNotNULL(mainPage,
                "Verify that Main page is opened.");

        VariantPreferredPage variantPreferredPage = mainPage.clickVariantPreferredSubMenu();
        eReports.compareNotNULL(variantPreferredPage,
                "Verify that Variant/Preferred page is opened.");

        HomographTablePage homographTablePage = mainPage.clickHomographTableSubMenu();
        eReports.compareNotNULL(homographTablePage,
                "Verify that Homograph Table page is opened.");

        PreliminaryCitedTitleListingPage preliminaryCitedTitleListingPage = mainPage.clickPreliminaryCitedTitleListingSubMenu();
        eReports.compareNotNULL(preliminaryCitedTitleListingPage,
                "Verify that Preliminary Cited Title Listing page is opened.");

        FirstSecondWordPage firstSecondWordPage = mainPage.clickFirstSecondWordSubMenuSubMenu();
        eReports.compareNotNULL(preliminaryCitedTitleListingPage,
                "Verify that First/Second Word page is opened.");

        eReports.compareTrue(mainPage.logoffMainMenu.click(), "Logoff from the APP.");
    }
}
