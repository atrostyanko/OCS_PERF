package tests;

import com.configuration.TestsConfig;
import com.configuration.properties.AllProperties;
import com.configuration.properties.PropertiesLoader;
import com.configuration.properties.PropertyFile;
import com.reporting.ExtentManager;
import com.webtestsbase.WebDriverFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.MainPage;
import tests.loginPage.LoginPage_Tests;
import tests.request.RequestTests;

import java.util.Properties;

/**
 * Created by Alexandr Trostyanko.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@PropertyFile("testData/bvt.properties")
public class BVT_Test {
    public static ExtentManager eReports;

    @AllProperties
    public static Properties prop;

    @BeforeClass
    public static void beforeClass() {
        eReports = new ExtentManager();
        ExtentManager.setFolderPath(TestsConfig.getConfig().getReportsPath());
        ExtentManager.GetExtent("GCS Performance Test.");
        WebDriverFactory.startBrowser(true);
        PropertiesLoader.populate(new BVT_Test());
    }

    @AfterClass
    public static void afterClass() {
        WebDriverFactory.finishBrowser();
        eReports.flush();
    }

    @Test
    public void requestTests() {
        eReports.createTest("REQUEST Tests.", "Verify all items from REQUEST menu.");

        MainPage mainPage = new LoginPage_Tests(eReports, prop).login();
        RequestTests requestTests = new RequestTests(eReports, prop);

        requestTests.RequestDetails_BVT();
        requestTests.EditRequest_BVT();
        requestTests.AddRequest_BVT();
        requestTests.ViewAllRequests_BVT();
        requestTests.RequestsReadyForRelease_BVT();

        eReports.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }
}
