package com.realworld.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractWebPage {
    protected AbstractWebPage() {
        waitForPageLoaded();
    }

    protected abstract String getClassPage();

    protected abstract WebDriver getDriver();

    protected void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(getClassPage())));
    }
}
