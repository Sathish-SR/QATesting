package com.costacoffee.tests;

import com.costacoffee.utilities.AppiumDriverManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.costacoffee.utilities.TestUtil;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest {

    private static ExtentReports extent;
    private ExtentTest test;
    
    @BeforeClass
    public void setUp() {
        extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
        test = extent.startTest("Costa Coffee Test");
    }

    @Test
    public void unlockButton() {
        try {
            // Get Android driver instance
            MobileElement phoneNumberField;
            MobileElement countryDropdown;
            
            
            // Initialize Android driver using AppiumDriverManager
            AndroidDriver<MobileElement> driver = AppiumDriverManager.getAndroidDriver();
            
            if (driver == null) {
                test.log(LogStatus.FAIL, "Driver is null, test cannot proceed.");
                return;  // Exit the test if the driver is null
            }

            // Navigate and select Kuwait
            //countryDropdown = driver.findElement(By.id("com.costacoffee:id/country_dropdown"));
           // countryDropdown.click();
            
           
            MobileElement unlockChapter1 = TestUtil.waitForElement(driver, By.xpath("(//android.widget.Button[@resource-id=\"everything.appium:id/buttonunlock\"])[1]"));
            Assert.assertTrue(unlockChapter1.isDisplayed(), "Unlock should be displayed");
            test.log(LogStatus.PASS, "Unlock button is displayed as expected");
            unlockChapter1.click();
            MobileElement appiumTutorialHeading = TestUtil.waitForElement(driver, By.xpath("//android.widget.TextView[@text=\"Appium Tutorial\"]"));
            Assert.assertTrue(appiumTutorialHeading.isDisplayed(), "Title should be displayed");
            test.log(LogStatus.PASS, "Appium Tutorial is displayed as expected");
                     
            
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Test failed due to: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        // End the test and close the app
        extent.endTest(test);
        extent.flush();
    }
}
