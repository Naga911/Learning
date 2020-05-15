package Cucumber.StepDef;

import Cucumber.Hooks;
import Cucumber.Reports.ExtentTestManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyStepdefs extends ExtentTestManager {


    private Hooks hooks;

    public MyStepdefs(Hooks hooks)
    {
        this.hooks=hooks;
    }
    private WebDriver driver=Hooks.getDriver();

    @Given("^Entering username and password$")
    public void entering_username_and_password() throws Throwable {


        System.out.println("Entering username and password");
        ExtentTest logInfo = null;
        try {

            test = extent.createTest(Feature.class, "Verification of PAW");
            test = test.createNode(Scenario.class, "Logging into application").assignCategory("Sanity").assignAuthor("Nagaraj");
            logInfo = test.createNode(new GherkinKeyword("Given"), "Entering username and password");

            Hooks.setup();
            logInfo.pass("Entered username and password");
           // logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo, e);
        }
    }

    @When("^Clicked on submit button$")
    public void clicked_On_Submit_Button() throws Throwable {
        ExtentTest logInfo = null;
        try {
            logInfo = test.createNode(new GherkinKeyword("When"), "Clicked on submit button");
            logInfo.pass("clicked on submit button");
         //   logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo, e);
        }
    }

    @And("^On Successful login user should be navigated to Home Screen$")
    public void onSuccessfulLoginUserShouldBeNavigatedToHomeScreen() throws Throwable {
        ExtentTest logInfo = null;
        try {
            logInfo = test.createNode(new GherkinKeyword("And"), "User should be navigated to Home Screen");
            logInfo.pass("user is navigated to home page");
     //       logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo, e);
        }
    }

    @Given("^Entering mandatory fields$")
    public void entering_Mandatory_Fields() throws Throwable {
        ExtentTest logInfo = null;
        try {
            test = extent.createTest(Scenario.class, "Registration of user details");
            logInfo = test.createNode(new GherkinKeyword("Given"), "Entering mandatory fields");
            logInfo.pass("Entering mandatory fields");
      //      logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo, e);
        }
    }

    @Then("^Clicking on submit button$")
    public void clicking_On_Submit_Button() throws Throwable {
        ExtentTest logInfo = null;
        try {
            logInfo = test.createNode(new GherkinKeyword("Then"), "Clicking on submit button");
            logInfo.pass("clicked submit button");
       //     logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo, e);
        }
    }


    @And("^User navigated to Landing Home page$")
    public void userNavigatedToLandingHomePage() throws Throwable {
        ExtentTest logInfo = null;
        try {
            logInfo = test.createNode(new GherkinKeyword("And"), "User navigated to Landing Home page");
            String url = "Googl";
            String actualurl = driver.getTitle();
            Assert.assertEquals(url, actualurl);
            logInfo.pass("Successfully navigated to Home page");
  //          logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
        } catch (AssertionError | Exception e) {
            //logInfo.info(e);

            testStepHandle("FAIL", driver, logInfo, e);
        }
    }


}
