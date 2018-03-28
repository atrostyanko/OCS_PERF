package tests.loginPage;

import com.reporting.ExtentManager;
import com.webtestsbase.WebDriverFactory;
import pages.MainPage;
import pages.login.CalendarLoginPage;
import pages.login.LoginPage;

import java.util.Properties;

/**
 * Created by Alexandr Trostyanko.
 * Uses JUnit test framework
 * Build Verification Test for JCR
 */
public class CalendarLoginPage_Tests {
    private ExtentManager eReports;
    private Properties prop;

    public CalendarLoginPage_Tests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

    public MainPage login() {
        String userID = WebDriverFactory.getUsername();
        String password = WebDriverFactory.getPassword();
        MainPage returnPage = null;

        eReports.createNode("Login Page.", "Verify that user can login to the APP.");

        CalendarLoginPage loginPage = new CalendarLoginPage();
        if (eReports.compareNotNULL(loginPage, "Check that HOME Page is opened.")) {

            eReports.compareTrue(loginPage.username.setText(userID), "Set user ID: " + userID);
            eReports.compareTrue(loginPage.password.setText(password), "Set password: " + password);

            returnPage = loginPage.submit();
            eReports.compareNotNULL(returnPage, "Click 'Submit' button and check that the main page is opened.");
        }
        return returnPage;
    }
}
