package com.reporting;

import com.configuration.TestsConfig;
import com.webtestsbase.WebDriverFactory;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ExtentManager {
    private ExtentReports extent;
    private ExtentTest test;
    private ExtentTest currentTest;
    private ExtentHtmlReporter htmlReporter;
    private static String folderPath;
    private static String filePath;
    private static String screenShotPath;
    private File logsDir = null;
    private boolean bResult = true;
    WebDriverFactory webDriverFactory;

    public ExtentManager(WebDriverFactory webDriverFactory) {
        this.webDriverFactory = webDriverFactory;
    }
    private void prepareFolder() {
        File f = new File(folderPath);
        if (!f.exists() || !f.isDirectory()) {
            if (!f.mkdirs()) {
                System.out.println("Reports folder could not be created. \n" + "Please check 'reportPath' setting.");
                throw new IllegalStateException("Reports folder could not be created. " + "Please check 'reportPath' setting.");
            }
        }
        f = new File(screenShotPath);
        if (!f.exists() || !f.isDirectory()) {
            if (!f.mkdir()) {
                System.out.println("ScreenShot folder could not be created. \n" + "Please check 'reportPath' setting.");
                throw new IllegalStateException("ScreenShot folder could not be created. " + "Please check 'reportPath' setting.");
            }
        }
    }

    public void setFolderPath(String folderPath) {
        ExtentManager.folderPath = folderPath;
        setFilePath(folderPath);
        setScreenShotPath(folderPath);
        logsDir = new File(folderPath);
    }
    private void setFilePath(String folderPath) {
        String reportFileName = "testReport.html";
        ExtentManager.filePath = folderPath + reportFileName;
    }
    private void setScreenShotPath(String folderPath) {
        String screenShotFolder = "ScreenShots/";
        ExtentManager.screenShotPath = folderPath + screenShotFolder;
    }

    public ExtentTest getCurrentTest() {
        return currentTest;
    }
    private ExtentHtmlReporter getHtmlReporter() {
        prepareFolder();
        htmlReporter = new ExtentHtmlReporter(filePath);

        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("GCS Automation Test Report");
        htmlReporter.config().setProtocol(Protocol.HTTP);

        return htmlReporter;
    }
    private ExtentHtmlReporter getHtmlReporter(String sReportName) {
        htmlReporter = getHtmlReporter();
        htmlReporter.config().setReportName(sReportName);

        return htmlReporter;
    }
    public void GetExtent(String sReportName){
        if (extent != null)
            return;
        extent = new ExtentReports();
        extent.attachReporter(getHtmlReporter(sReportName));
        extent.setSystemInfo("Browser: ", String.valueOf(TestsConfig.getConfig().getBrowser()));
        extent.setSystemInfo("Env:", System.getProperty("os.name"));
        extent.setSystemInfo("Server:", TestsConfig.getConfig().getBrowserURL());
        extent.setAnalysisStrategy(AnalysisStrategy.SUITE);
    }

    public void createTest(String name, String description){
        checkTestStatus();
        test = extent.createTest(name, description);
        currentTest = test;
    }
    public void createNode(String name, String description) {
        currentTest = test.createNode(name, description);
    }

    public void flush() {
        checkTestStatus();
        extent.flush();
        /*
        if (test.getStatus() != Status.PASS) {
            Assert.fail();
        }
        */
        if (!bResult) {
            Assert.fail();
        }
    }
    public void switchToParentTest() {
        currentTest = test;
    }

    public boolean compare(boolean expectedResult, boolean actualResult, String description) {
        if (expectedResult == actualResult) {
            currentTest.pass(description);
            return true;
        } else {
            putFailResult(String.valueOf(expectedResult), String.valueOf(actualResult), description);
            return false;
        }
    }
    public boolean compare(ArrayList<String> expectedResult, ArrayList<String> actualResult, String description) {
        if (expectedResult.equals(actualResult)) {
            currentTest.pass(description);
            return true;
        } else {
            putFailResult(String.valueOf(expectedResult), String.valueOf(actualResult), description);
            return false;
        }
    }
    public boolean compare(boolean expectedResult, boolean actualResult, String description, String priority) {
        if (expectedResult == actualResult) {
            currentTest.pass(description);
            return true;
        } else {
            try {
                if (priority.toLowerCase().equals("info")) {
                    currentTest.info(description + " <div><b>Expected Result:</b> " + expectedResult + "<div><b>Actual Result:</b> "
                            + actualResult + "<br>", MediaEntityBuilder.createScreenCaptureFromPath(capture()).build());
                } else if (priority.toLowerCase().equals("fatal")) {
                    currentTest.fatal(description + " <div><b>Expected Result:</b> " + expectedResult + "<div><b>Actual Result:</b> "
                            + actualResult + "<br>", MediaEntityBuilder.createScreenCaptureFromPath(capture()).build());
                } else if (priority.toLowerCase().equals("error")) {
                    currentTest.error(description + " <div><b>Expected Result:</b> " + expectedResult + "<div><b>Actual Result:</b> "
                            + actualResult + "<br>", MediaEntityBuilder.createScreenCaptureFromPath(capture()).build());
                } else if (priority.toLowerCase().equals("warning")) {
                    currentTest.warning(description + " <div><b>Expected Result:</b> " + expectedResult + "<div><b>Actual Result:</b> "
                            + actualResult + "<br>", MediaEntityBuilder.createScreenCaptureFromPath(capture()).build());
                } else if (priority.toLowerCase().equals("fail")) {
                    currentTest.fail(description + " <div><b>Expected Result:</b> " + expectedResult + "<div><b>Actual Result:</b> "
                            + actualResult + "<br>", MediaEntityBuilder.createScreenCaptureFromPath(capture()).build());
                }
                return false;
            } catch (IOException e) {
                currentTest.fatal("Internal exception compare (bool, bool)");
                return false;
            }
        }
    }
    public boolean compare(String expectedResult, String actualResult, String description) {
        if (actualResult != null && expectedResult != null) {
            if (expectedResult.trim().equals(actualResult.trim())) {
                currentTest.pass(description);
                return true;
            } else {
                putFailResult(expectedResult, actualResult, description);
                return false;
            }
        } else {
            currentTest.debug("One of parameters is NULL.");
            return false;
        }
    }
    public boolean compare(int expectedResult, int actualResult, String description) {
        if (expectedResult == actualResult) {
            currentTest.pass(description);
            return true;
        } else {
            putFailResult(String.valueOf(expectedResult), String.valueOf(actualResult), description);
            return false;
        }
    }
    public boolean compareTrue(boolean actualResult, String description){
        return compare(true, actualResult, description);
    }
    public boolean compareFalse(boolean actualResult, String description){
        return compare(false, actualResult, description);
    }
    public boolean compareNotNULL(Object actualResult, String description) {
        if (actualResult != null) {
            currentTest.pass(description);
            return true;
        } else {
            try {
                currentTest.fail(description + "<div><b>Actual Result:</b> is NULL<br>",
                        MediaEntityBuilder.createScreenCaptureFromPath(capture()).build());
                return false;
            } catch (IOException e) {
                currentTest.fatal("compareIsNULL: Exception during screenShot creation." + e.toString());
                return false;
            }
        }
    }
    public boolean compareIsNULL(Object actualResult, String description) {
        if (actualResult == null) {
            currentTest.pass(description);
            return true;
        } else {
            try {
                currentTest.fail(description + "<div><b>Actual Result:</b> is not NULL<br>",
                        MediaEntityBuilder.createScreenCaptureFromPath(capture()).build());
                return false;
            } catch (IOException e) {
                currentTest.fatal("compareIsNULL: Exception during screenShot creation." + e.toString());
                return false;
            }
        }
    }

    public String capture() {
        File src = ((TakesScreenshot) webDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        String filename = "SCREEN_CAPTURE_" + System.currentTimeMillis() + ".png";
        filename = filename.replaceAll("[^0-9a-zA-Z.]", "_");
        String IMAGES_DIR = "ScreenShots";
        File file = new File(logsDir.getAbsolutePath() + File.separator + IMAGES_DIR + File.separator + filename);
        try {
            FileUtils.copyFile(src, file);
        } catch (IOException e) {
        }
        return IMAGES_DIR + File.separator + file.getName();
    }

    //=== Private methods
    private void putFailResult(String expectedResult, String actualResult, String description) {
        try {
            if (currentTest != null) {
                currentTest.fail(description + " <div><b>Expected Result:</b> " + expectedResult + "<div><b>Actual Result:</b> "
                        + actualResult + "<br>", MediaEntityBuilder.createScreenCaptureFromPath(capture()).build());
            }
        } catch (IOException e) {
            currentTest.fatal("putFailResult: Exception during screenShot creation." + e.toString());
        }
    }
    private void checkTestStatus() {
        if (test != null) {
            bResult &= test.getStatus() == Status.PASS;
        }
    }
}