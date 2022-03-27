package com.realworld.util;

import org.openqa.selenium.WebDriver;

public class DriverSession {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public DriverSession(WebDriver driver) {
        this.driver.set(driver);
    }
    public static synchronized WebDriver getDriver() {
        return driver.get();
    }
}
