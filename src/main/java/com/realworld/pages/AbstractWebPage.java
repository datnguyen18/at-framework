package com.realworld.pages;

import com.realworld.util.DriverSession;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;

public abstract class AbstractWebPage {
    protected WebDriver driver;
    protected abstract Logger getLogger();

    protected AbstractWebPage() {
        this.driver = DriverSession.getDriver();
        waitForPageLoaded();
        PageFactory.initElements(driver, this);
        BasicConfigurator.configure();
    }

    protected abstract String getClassPage();

    protected void waitForPageLoaded() {
        getLogger().info("Wait for page " + getLogger().getName() + " loaded");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(getClassPage())));
    }
}
