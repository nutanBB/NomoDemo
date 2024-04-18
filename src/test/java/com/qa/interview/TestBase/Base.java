package com.qa.interview.TestBase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {


    private DesiredCapabilities setCapabilities(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", Platform.ANDROID);
        caps.setCapability("automationName","uiautomator2");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("noReset", false); // Set as boolean value
        caps.setCapability("fullReset", true);
        caps.setCapability("appWaitForLaunch", true);
        caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        caps.setCapability("appPackage", "com.saucelabs.mydemoapp.rn");
        caps.setCapability("appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");
        caps.setCapability(MobileCapabilityType.APP,"C:\\Users\\naik_nu\\Downloads\\Cucumber_BDD\\App\\Android-MyDemoAppRN.1.3.0.build-244.apk");

        return caps;
        // Initialize Appium driver

    }

    public void launchApp() throws MalformedURLException {
        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), setCapabilities());
        DriverManager.getInstance().setDriver(driver);
        DriverManager.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


}
