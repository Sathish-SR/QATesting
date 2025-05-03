package com.costacoffee.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {

    private static final int DEFAULT_TIMEOUT = 20;

    // Wait for an element by locator (By)
    public static MobileElement waitForElement(AppiumDriver<MobileElement> driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait for an element by locator (By) with custom timeout
    public static MobileElement waitForElement(AppiumDriver<MobileElement> driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    
}
