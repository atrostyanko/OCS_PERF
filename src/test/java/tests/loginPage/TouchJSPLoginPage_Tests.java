package tests.loginPage;

import com.reporting.ExtentManager;
import com.webtestsbase.WebDriverFactory;
import pages.calendar.CalendarMainPage;
import pages.login.CalendarLoginPage;
import pages.login.TouchJSPLoginPage;
import pages.touchJSP.TouchJSPMainPage;

import java.util.Properties;

/**
 * Created by Alexandr Trostyanko.
 * Uses JUnit test framework
 */
public class TouchJSPLoginPage_Tests {
    private ExtentManager eReports;
    private Properties prop;

    public TouchJSPLoginPage_Tests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

    public TouchJSPMainPage login() {
        String userID = WebDriverFactory.getUsername();
        String password = WebDriverFactory.getPassword();
        TouchJSPMainPage returnPage = null;

        eReports.createNode("Login Page.", "Verify that user can login to the APP.");

        TouchJSPLoginPage loginPage = new TouchJSPLoginPage();
        if (eReports.compareNotNULL(loginPage, "Check that HOME Page is opened.")) {

            eReports.compareTrue(loginPage.username.setText(userID), "Set user ID: ******");
            eReports.compareTrue(loginPage.password.setText(password), "Set password: ******");

            if (eReports.compareTrue(loginPage.loginBtn.click(), "Click 'LOG IN' button.")) {
                returnPage = new TouchJSPMainPage();
            }
        }
        return returnPage;
    }
}
