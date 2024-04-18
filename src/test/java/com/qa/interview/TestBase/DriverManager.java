package com.qa.interview.TestBase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverManager {


    private static ThreadLocal<AndroidDriver<MobileElement>> td = new ThreadLocal<>();
    private static DriverManager driverManager =null;

    private DriverManager(){}


  public static DriverManager getInstance(){
        if(driverManager == null){
            return new DriverManager();
        }
        return driverManager;
  }

  public void setDriver(AndroidDriver<MobileElement> driver){
        td.set(driver);
  }

  public AndroidDriver<MobileElement> getDriver(){
        return td.get();
  }
}
