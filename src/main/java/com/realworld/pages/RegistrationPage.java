package com.realworld.pages;

import com.realworld.util.DriverSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends AbstractWebPage{

    private static final Logger log = LogManager.getLogger(HomePage.class);

    private WebDriverWait wait;

    @FindBy(css = "[placeholder='Username']")
    private WebElement usernameInput;

    @FindBy(css = "[placeholder='Email']")
    protected WebElement emailInput;

    @FindBy(css = "[placeholder='Password']")
    protected WebElement passwordInput;

    @FindBy(className = "btn-lg")
    protected WebElement signInButton;

    @Override
    protected Logger getLogger() {
        return log;
    }

    public  RegistrationPage() {
        this.wait = new WebDriverWait(driver, 30);
    }

    @Override
    protected String getClassPage() {
        return "auth-page";
    }

    public void enterUserInformationDetail(String username, String email, String password) {
        log.debug(String.format("Set username: [%s]", username));
        usernameInput.sendKeys(username);
        log.info(String.format("Set email: [%s]", email));
        emailInput.sendKeys(email);
        log.info(String.format("Set password: [%s]", password));
        passwordInput.sendKeys(password);
    }

    public HomePage clickSignIn() {
        log.info("Click [Sign in] button");
        signInButton.click();
        return new HomePage();
    }

}
