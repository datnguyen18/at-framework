package com.realworld.tests;

import com.realworld.pages.HomePage;
import com.realworld.pages.LoginPage;
import com.realworld.pages.RegistrationPage;
import com.realworld.util.GeneralUtil;
import org.testng.annotations.Test;

public class TestDemo extends BaseTest {
    private static final String RAND_CODE = GeneralUtil.getCode(3);
    private static final String USERNAME = "username_" + RAND_CODE;
    private static final String EMAIL = "email_" + RAND_CODE + "@email.com";
    private static final String PASSWORD = "password123";
    private static final String INVALID_EMAIL = "email_" + RAND_CODE + "@e";
    private static final String MESSAGE = "email or password is invalid";

    @Test
    public void test1() {
        navigateToPage("https://react-redux.realworld.io/");
        HomePage homePage = new HomePage();
        RegistrationPage registrationPage = homePage.goToRegistrationPage();
        registrationPage.enterUserInformationDetail(USERNAME, EMAIL, PASSWORD);
        registrationPage.clickSignIn();
        homePage = new HomePage();
        homePage.verifyHomepageIsLoaded();
    }

    @Test
    public void test2() {
        navigateToPage("https://react-redux.realworld.io/");
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.enterEmailAndPassword(INVALID_EMAIL, PASSWORD);
        loginPage.clickSignIn();
        loginPage.verifyErrorMessageDisplay(MESSAGE);
    }

    @Test
    public void testWillBeFailed() {
        navigateToPage("https://react-redux.realworld.io/");
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.enterEmailAndPassword(INVALID_EMAIL, PASSWORD);
        loginPage.clickSignIn();
        loginPage.verifyErrorMessageDisplay(MESSAGE + "ssss");
    }
}
