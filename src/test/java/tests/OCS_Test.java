package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.configuration.TestsConfig;
import com.configuration.properties.AllProperties;
import com.configuration.properties.PropertiesLoader;
import com.configuration.properties.PropertyFile;
import com.reporting.ExtentManager;
import com.webtestsbase.WebDriverFactory;
import java.util.Properties;

/**
 * Created by Alexandr Trostyanko.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@PropertyFile("ocs.properties")
public class OCS_Test {
    public static ExtentManager eReports;

    @AllProperties
    public static Properties prop;

    @BeforeClass
    public static void beforeClass() {
        eReports = new ExtentManager();
        ExtentManager.setFolderPath(TestsConfig.getConfig().getReportsPath());
        ExtentManager.GetExtent("OCS Performance Test.");
        WebDriverFactory.startBrowser(true);
        PropertiesLoader.populate(new OCS_Test());
    }

    @AfterClass
    public static void afterClass() {
        WebDriverFactory.finishBrowser();
        ExtentManager.flush();
    }

    @Test
    public void navigationTest() {
        ExtentManager.createTest("Navigation Test", "Verify Navigation Tabs, Menu's, Sub-menu's and Logo.");

    }
}
