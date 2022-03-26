package com.realworld.pages;

import com.realworld.util.DriverSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractWebPage {
    private static final Logger log = LogManager.getLogger(HomePage.class);

    private WebDriverWait wait;

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
        driver.findElement(By.cssSelector("[href='#register']")).click();
        return new RegistrationPage();
    }
}
