package tests.loginPage;

import com.reporting.ExtentManager;
import com.webtestsbase.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.MainPage;

import java.util.Properties;

/**
 * Created by Alexandr Trostyanko.
 * Uses JUnit test framework
 */
public class LoginPage_Tests {
    private ExtentManager eReports;
    private Properties prop;
    WebDriverFactory webDriverFactory;

    public LoginPage_Tests(WebDriverFactory webDriverFactory, ExtentManager eReports, Properties prop) {
        this.webDriverFactory = webDriverFactory;
        this.eReports = eReports;
        this.prop = prop;
    }

    public MainPage login() {
        String userID = webDriverFactory.getUsername();
        String password = webDriverFactory.getPassword();
        MainPage returnPage = null;

        eReports.createNode("Login Page.", "Verify that user can login to the APP.");

        LoginPage loginPage = new LoginPage(webDriverFactory, eReports);
        if (eReports.compareNotNULL(loginPage, "Check that Login Page is opened.")) {

            eReports.compareTrue(loginPage.setUserID(userID), "Set user ID: " + userID);
            eReports.compareTrue(loginPage.setPassword(password), "Set password: " + password);

            returnPage = loginPage.submit();
            eReports.compareNotNULL(returnPage, "Click 'Submit' button and check that the main page is opened.");
        }
        return returnPage;
    }
}
