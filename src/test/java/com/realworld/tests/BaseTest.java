package com.realworld.tests;

import com.realworld.listener.TestListener;
import com.realworld.util.DriverSession;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class BaseTest {
    private DriverSession driverSessionHolder;
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeTest
    public void setupProperty() {
        BasicConfigurator.configure();
    }

    @BeforeMethod
    @Parameters("browser")
    public void setupDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    "C:\\selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
            System.setProperty("webdriver.chrome.logfile", "C:\\selenium\\logs\\chromedriver.log");
            this.driverSessionHolder = new DriverSession(new ChromeDriver());
        }
        this.driver.set(DriverSession.getDriver());
        getDriver().manage().window().maximize();
    }

    private synchronized WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    protected void navigateToPage(String url) {
        getDriver().get(url);
    }
}
