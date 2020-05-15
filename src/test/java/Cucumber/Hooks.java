package Cucumber;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

import java.io.IOException;

public class Hooks {
    private static WebDriver driver;


    //@Test(alwaysRun = true)
    @SuppressWarnings("Duplicates")
    @Before
    public static void setup() throws IOException {
        if (driver == null) {

            System.setProperty("webdriver.chrome.driver", "D:\\Projects\\PAW2\\Drivers\\chromedriver.exe");
            ChromeOptions options = (ChromeOptions) new ChromeOptions().setAcceptInsecureCerts(true);

            driver = new ChromeDriver(options);

            String urls = "https://www.google.com";

            //   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get(urls);
            driver.manage().window().maximize();

        }
    }
    public static WebDriver getDriver() {
        return driver;
    }

    @AfterClass
    public void teardown() {
        //driver.quit();

    }

    @AfterSuite
    public void close() {
        driver.close();
    }
}
