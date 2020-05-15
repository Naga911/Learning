package Cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "C:\\Users\\Nagaraj\\IdeaProjects\\Learning\\src\\test\\java\\Cucumber\\Feature\\login.feature",
        glue = {"Cucumber.StepDef"},
       tags = {"@WeHere"},
       plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

//@RunWith(Cucumber.class)
public class Runnerclass extends AbstractTestNGCucumberTests {

}

