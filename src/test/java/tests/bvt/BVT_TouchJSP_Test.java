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
import pages.calendar.CalendarMainPage;
import pages.login.TouchJSPLoginPage;
import pages.touchJSP.TouchJSPMainPage;
import tests.loginPage.CalendarLoginPage_Tests;
import tests.loginPage.TouchJSPLoginPage_Tests;

import java.util.Properties;

/**
 * Created by Alexandr Trostyanko.
 */

@PropertyFile("testData/bvt/touchJSP.properties")
public class BVT_TouchJSP_Test {
    public static ExtentManager eReports;

    @AllProperties
    public static Properties prop;

    @BeforeClass
    public static void beforeClass() {
        eReports = new ExtentManager();
        ExtentManager.setFolderPath(TestsConfig.getConfig().getReportsPath());
        ExtentManager.GetExtent("CORRECTIONS BVT Test.");
        WebDriverFactory.startBrowser(true);
        PropertiesLoader.populate(new BVT_TouchJSP_Test());
    }

    @AfterClass
    public static void afterClass() {
        WebDriverFactory.finishBrowser();
        eReports.flush();
    }

    @Test
    public void mainTests() {
        String issueNo = prop.getProperty("issueNo");

        eReports.createTest("TouchJSP Build Verification Test.", "Verify all items from TouchJSP menu.");

        TouchJSPMainPage touchJSPMainPage = new TouchJSPLoginPage_Tests(eReports, prop).login();

        if (eReports.compareNotNULL(touchJSPMainPage, "Verify that Main page is opened.")) {

            eReports.compareTrue(touchJSPMainPage.issueNo.setText(issueNo), "Set Issue No: " + issueNo);

            eReports.compareTrue(touchJSPMainPage.clickSearchButton(), "Click 'search' button.");

            eReports.createNode("Logoff from the APP", "Logoff from the APP");

            TouchJSPLoginPage touchJSPLoginPage = touchJSPMainPage.logout();
            eReports.compareNotNULL(touchJSPLoginPage, "Logoff from the APP.");
        }
    }
}
