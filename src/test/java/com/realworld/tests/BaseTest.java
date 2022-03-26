package com.realworld.tests;

import com.realworld.util.DriverSession;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    private DriverSession driverSession;
    private WebDriver driver;
    @BeforeTest
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.logfile", "C:\\selenium\\logs\\chromedriver.log");
        this.driverSession = DriverSession.getInstance(new ChromeDriver());
        this.driver = DriverSession.getDriver();
    }

    protected void navigateToPage(String url) {
        this.driver.get(url);
    }
}
