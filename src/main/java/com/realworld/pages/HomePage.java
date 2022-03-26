package com.realworld.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractWebPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public  HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void goTo() {
        driver.get("https://react-redux.realworld.io/");
    }

    @Override
    protected String getClassPage() {
        return "home-page";
    }

    @Override
    protected WebDriver getDriver() {
        return this.driver;
    }
}
