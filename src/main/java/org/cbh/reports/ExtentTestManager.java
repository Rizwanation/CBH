package org.cbh.reports;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public final class ExtentTestManager {
    //ExtentManager class to handle multiple extentTestInstance threads to get rid of issues during parallel execution
    private ExtentTestManager(){}

    private static ThreadLocal<ExtentTest> extentTestManager = new ThreadLocal<>();

    public static void setExtentTest(ExtentTest extentTest)
    {
        extentTestManager.set(extentTest);
    }

    public static ExtentTest getExtentTestInstance()
    {
        return extentTestManager.get();
    }

    public static void unload()
    {
        extentTestManager.remove();
    }




}

