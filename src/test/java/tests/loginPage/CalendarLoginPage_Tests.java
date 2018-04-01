package tests.loginPage;

import com.reporting.ExtentManager;
import com.webtestsbase.WebDriverFactory;
import pages.calendar.CalendarMainPage;
import pages.login.CalendarLoginPage;

import java.util.Properties;

/**
 * Created by Alexandr Trostyanko.
 * Uses JUnit test framework
 */
public class CalendarLoginPage_Tests {
    private ExtentManager eReports;
    private Properties prop;

    public CalendarLoginPage_Tests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

    public CalendarMainPage login() {
        String userID = WebDriverFactory.getUsername();
        String password = WebDriverFactory.getPassword();
        CalendarMainPage returnPage = null;

        eReports.createNode("Login Page.", "Verify that user can login to the APP.");

        CalendarLoginPage loginPage = new CalendarLoginPage();
        if (eReports.compareNotNULL(loginPage, "Check that HOME Page is opened.")) {

            eReports.compareTrue(loginPage.username.setText(userID), "Set user ID: " + userID);
            eReports.compareTrue(loginPage.password.setText(password), "Set password: " + password);

            if (eReports.compareTrue(loginPage.loginBtn.click(), "Click 'LOG IN' button.")) {
                returnPage = new CalendarMainPage();
            }
        }
        return returnPage;
    }
}
