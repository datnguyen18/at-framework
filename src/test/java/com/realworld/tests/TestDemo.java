package com.realworld.tests;

import com.realworld.pages.HomePage;
import com.realworld.pages.RegistrationPage;
import com.realworld.util.GeneralUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDemo extends BaseTest {
    private static final String RAND_CODE = GeneralUtil.getCode(3);
    private static final String USERNAME = "username_" + RAND_CODE;
    private static final String EMAIL = "email_" + RAND_CODE + "@email.com";
    private static final String PASSWORD = "password123";
    @Test
    public void test() {
        navigateToPage("https://react-redux.realworld.io/");
        HomePage homePage = new HomePage();
        RegistrationPage registrationPage = homePage.goToRegistrationPage();
        registrationPage.enterUserInformationDetail(USERNAME, EMAIL, PASSWORD);
        homePage = registrationPage.clickSignIn();
    }
}
