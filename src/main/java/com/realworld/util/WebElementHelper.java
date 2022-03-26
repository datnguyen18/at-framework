package com.realworld.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class WebElementHelper {
    private static WebDriver driver = DriverSession.getDriver();

    public static WebElement waitAndGetElement(final By locator) {
        waitForElementExist(locator, 10);
        return driver.findElement(locator);
    }

    private static void waitForElementExist(By locator, long timeout) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout));
        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return !driver.findElements(locator).isEmpty();
            }
        });

    }
}
