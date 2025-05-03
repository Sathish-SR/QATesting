package com.costacoffee.utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URI;
import java.net.URL;

public class AppiumDriverManager {

    private static AndroidDriver<MobileElement> androidDriver;
    private static IOSDriver<MobileElement> iosDriver;

    // Android driver setup
    public static AndroidDriver<MobileElement> getAndroidDriver() {
        if (androidDriver == null) {
            try {
            	System.out.println("Initializing Android Driver...");
            	
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("automationName", "UiAutomator2");
                capabilities.setCapability("deviceName", "emulator-5554");
                capabilities.setCapability("app", "C:\\Users\\Sathish\\Downloads\\AppiumAPKPure.apk");
                androidDriver = new AndroidDriver<>(new URI("http://127.0.0.1:4723/").toURL(), capabilities);
                
                System.out.println("Android Driver Initialized Successfully.");
                
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to initialize AndroidDriver: " + e.getMessage());
            } 
            
        }else {
            // Log or print message when the driver is already initialized
            System.out.println("Android Driver already initialized.");
        }
        return androidDriver;
        
        
    }

    // iOS driver setup
    public static IOSDriver<MobileElement> getIOSDriver() {
        if (iosDriver == null) {
            try {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("deviceName", "iPhone Simulator");
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("app", "/path/to/costa_coffee.app");

                iosDriver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to initialize IOSDriver: " + e.getMessage());
            }
        }
        return iosDriver;
    }
}
