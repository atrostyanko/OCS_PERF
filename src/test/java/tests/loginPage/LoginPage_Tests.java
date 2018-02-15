package tests.loginPage;

import com.reporting.ExtentManager;
import pages.LoginPage;
import pages.MainPage;
import tests.OCS_Test;

import java.util.Properties;

/**
 * Created by Alexandr Trostyanko.
 * Uses JUnit test framework
 * Build Verification Test based on AUT-143
 */
public class LoginPage_Tests {
    public static ExtentManager eReports = OCS_Test.eReports;
    public static Properties prop = OCS_Test.prop;

    public MainPage login() {
        String userID = prop.getProperty("userID");
        String password = prop.getProperty("password");
        MainPage returnPage = null;

        ExtentManager.createTest("Login Page.", "Verify that user can login to the APP.");

        LoginPage loginPage = new LoginPage();
        if (ExtentManager.compareNotNULL(loginPage, "Check that HOME Page is opened.")) {
            ExtentManager.compareTrue(loginPage.setUserID(userID), "Set user ID: " + userID);
            ExtentManager.compareTrue(loginPage.setPassword(password), "Set password: " + password);
            returnPage = loginPage.submit();
            ExtentManager.compareNotNULL(returnPage, "Click 'Submit' button and check that the main page is opened.");
        }
        return returnPage;
    }
}
