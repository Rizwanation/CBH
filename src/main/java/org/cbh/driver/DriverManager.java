package org.cbh.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    //DriverManager class to handle multiple driverInstance threads to get rid of issues during parallel execution
    private DriverManager(){}

    private static ThreadLocal<WebDriver> driverManager = new ThreadLocal<>();

    public static void setDriver(WebDriver driver)
    {
        driverManager.set(driver);
    }

    public static WebDriver getDriverInstance()
    {
        return driverManager.get();
    }

    public static void unload()
    {
        driverManager.remove();
    }




}

