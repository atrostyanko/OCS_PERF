package pages;

import com.reporting.ExtentManager;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.FindBy;

public class TocPage extends MenuPage {
    @FindBy(name = "submBtn")
    private Button openIndicator;

    public TocPage() {
        super(true);
    }

    public TocPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        tocBtn.click();
        if (WebDriverFactory.getDriver() instanceof PhantomJSDriver){
            /*
            JavascriptExecutor je = (JavascriptExecutor) WebDriverFactory.getDriver();
            je.executeScript("function jsPrompt(formObj)\n" +
                    "    {\n" +
                    "        accnNum = prompt(\"Please Enter the Accession Number\",\"\");\n" +
                    "\tif (accnNum != \"\") {\n" +
                    "\t  formObj.AcnVal.value = ET8DK;\n" +
                    "\t  formObj.submit();\n" +
                    "\t}\n" +
                    "    }");


            je.executeScript("window.alert = function(){};");
            ExtentManager.compareTrue(false, "2");
            je.executeScript("window.confirm = function(){return true;};");
            ExtentManager.compareTrue(false, "3");
            System.out.println("Alert has been handled");
            */
        } else {
            WebDriverFactory.getDriver().switchTo().alert().sendKeys("ET8DK");
            WebDriverFactory.getDriver().switchTo().alert().accept();
        }
    }

    @Override
    public boolean isPageOpened() {
        return WebDriverFactory.getDriver().getTitle().trim().equalsIgnoreCase("The Toc Page")
                && openIndicator.isDisplayed();
    }

    //===== Click methods ==============================================================================================
}
