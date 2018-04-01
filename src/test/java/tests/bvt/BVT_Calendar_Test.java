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
import tests.loginPage.CalendarLoginPage_Tests;

import java.util.Properties;

/**
 * Created by Alexandr Trostyanko.
 */

@PropertyFile("testData/bvt/calendar.properties")
public class BVT_Calendar_Test {
    public static ExtentManager eReports;

    @AllProperties
    public static Properties prop;

    @BeforeClass
    public static void beforeClass() {
        eReports = new ExtentManager();
        ExtentManager.setFolderPath(TestsConfig.getConfig().getReportsPath());
        ExtentManager.GetExtent("CORRECTIONS BVT Test.");
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

        CalendarMainPage calendarMainPage = new CalendarLoginPage_Tests(eReports, prop).login();

        if (eReports.compareNotNULL(calendarMainPage, "Verify that Main page is opened.")) {

            eReports.createNode("Logoff from the APP", "Logoff from the APP");

            eReports.compareTrue(calendarMainPage.clickEditCalendarLink(), "Click ''");

            eReports.compareTrue(calendarMainPage.logout(), "Logoff from the APP.");
        }
    }
}
