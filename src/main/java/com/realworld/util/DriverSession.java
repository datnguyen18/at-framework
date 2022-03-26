package com.realworld.util;

import org.openqa.selenium.WebDriver;

public class DriverSession {
    private static WebDriver driver;
    private static DriverSession instance;
    private DriverSession(WebDriver driver) {
        this.driver = driver;
    }
    public static WebDriver getDriver() {
        return driver;
    }

    public static DriverSession getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new DriverSession(driver);
        }
        return instance;
    }
}
