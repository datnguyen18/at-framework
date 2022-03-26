package com.realworld.pages;

import com.realworld.util.DriverSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractWebPage {
    private static final Logger log = LogManager.getLogger(HomePage.class);

    private WebDriver driver = DriverSession.getDriver();
    private WebDriverWait wait;

    @FindBy(css = "[placeholder='Username']")
    private WebElement usernameInput;

    @FindBy(css = "[placeholder='Email']")
    private WebElement emailInput;

    @FindBy(css = "[placeholder='Password']")
    private WebElement passwordInput;

    @FindBy(className = "btn-lg")
    private WebElement signInButton;

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

    public void enterUserInformationDetail(String username, String email, String password) {

    }
}
