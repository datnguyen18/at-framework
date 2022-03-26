package com.realworld.tests;

import com.realworld.pages.HomePage;
import com.realworld.util.DriverSession;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test12 extends BaseTest{

    @Test
    public void test() {
        navigateToPage("https://react-redux.realworld.io/");
        HomePage homePage = new HomePage();
    }
}
