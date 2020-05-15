package Cucumber.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {


    private static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    public static ExtentReports extent;
    public static ExtentTest test;


    @BeforeClass
    @SuppressWarnings("Duplicates")
    public static ExtentReports report() {
        String projectName="meow";

        ExtentKlovReporter klovReporter = new ExtentKlovReporter(projectName);

        klovReporter.initMongoDbConnection("localhost", 27017);
        klovReporter.setProjectName("Diesel");
        klovReporter.setReportName("3.0");

        //klovReporter.setReportName(  "Build " + LocalDateTime.now().toString());
        klovReporter.initKlovServerConnection("http://localhost");
        extent = new ExtentReports();
        String css = ".r-img {width: 50%;}";

        extent.attachReporter(klovReporter);
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Architecture", System.getProperty("os.arch"));
        return extent;
    }

    public static void testStepHandle(String teststatus, WebDriver driver, ExtentTest test, Throwable throwable) {
        switch (teststatus) {
            case "FAIL":
                test.fail(MarkupHelper.createLabel("FAIL:", ExtentColor.RED));
                System.out.println(": i want to know: "+throwable);


                try {
                    test.info(throwable.getMessage());
                    test.addScreenCaptureFromPath(captureScreenShot(driver));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (driver != null) {
                    driver.quit();
                }
                break;

            case "PASS":
                test.pass(MarkupHelper.createLabel("Test Case is Passed : ", ExtentColor.GREEN));
                break;

            default:
                break;
        }
    }

    public static String captureScreenShot(WebDriver driver) throws IOException {
        TakesScreenshot screen = (TakesScreenshot) driver;
        File src = screen.getScreenshotAs(OutputType.FILE);
        String dest = "C:\\Users\\Nagaraj\\IdeaProjects\\Learning\\target\\Screenshots\\" + getcurrentdateandtime() + ".png";
        File target = new File(dest);
        FileUtils.copyFile(src, target);
        return dest;
    }

    private static String getcurrentdateandtime() {
        String str = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
            Date date = new Date();
            str = dateFormat.format(date);
            str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}

