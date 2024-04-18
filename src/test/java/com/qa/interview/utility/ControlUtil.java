package com.qa.interview.utility;

import com.qa.interview.TestBase.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class ControlUtil {


    public void click(MobileElement element){
        Wait<AndroidDriver<MobileElement>> wait = new FluentWait<>(DriverManager.getInstance().getDriver())
                .withTimeout(Duration.ofSeconds(30)) // Maximum time to wait for the element
                .pollingEvery(Duration.ofMillis(500)) // Polling interval to check for the element
                .ignoring(Exception.class);

        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
