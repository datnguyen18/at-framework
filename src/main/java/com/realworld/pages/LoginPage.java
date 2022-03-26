package com.realworld.pages;

import com.realworld.util.WebElementHelper;
import junit.framework.Assert;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends RegistrationPage {

    private static final Logger log = LogManager.getLogger(LoginPage.class);

    @Override
    protected Logger getLogger() {
        return log;
    }

    @Override
    protected String getClassPage() {
        return "auth-page";
    }

    public void enterEmailAndPassword(String email, String password) {
        log.info(String.format("Set email: [%s]", email));
        emailInput.sendKeys(email);
        log.info(String.format("Set password: [%s]", password));
        passwordInput.sendKeys(password);
    }

    public void verifyErrorMessageDisplay(String expectedMessage) {
        log.info(String.format("Verify message [%s] is displayed", expectedMessage));
        String actualMessage = WebElementHelper.waitAndGetElement(By.className("error-messages")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
