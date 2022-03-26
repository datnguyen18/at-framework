package com.realworld.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends AbstractWebPage {
    private static final Logger log = LogManager.getLogger(HomePage.class);

    private WebDriverWait wait;

    @FindBy(css = "[href='#register']")
    private WebElement registrationMenu;

    @FindBy(css = "[href='#login']")
    private WebElement loginMenu;

    public HomePage() {
        this.wait = new WebDriverWait(driver, 30);
    }

    @Override
    protected Logger getLogger() {
        return log;
    }

    @Override
    protected String getClassPage() {
        return "home-page";
    }

    public RegistrationPage goToRegistrationPage() {
        log.info("Go to registration page");
        registrationMenu.click();
        return new RegistrationPage();
    }

    public LoginPage goToLoginPage() {
        log.info("Go to login page");
        loginMenu.click();
        return new LoginPage();
    }

    public void verifyHomepageIsLoaded() {
        log.info("Verify Home Page is loaded successfully");
        Assert.assertTrue(driver.findElement(By.className(getClassPage())).isDisplayed());
    }
}
