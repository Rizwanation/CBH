package org.cbh.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Objects;

public final class Driver {
    //final so it can't be extended
    private static WebDriver driverInstance;

    private Driver()
    {}

    public static WebDriver getDriverInstance()
    {
        if(Objects.isNull(driverInstance)) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver");
            driverInstance = new ChromeDriver();
            driverInstance.manage().window().maximize();
            return driverInstance;
        }
        return driverInstance;
    }

    public static void quitDriver()
    {
        if(Objects.nonNull(driverInstance))
        {
            driverInstance.quit();
            driverInstance = null;
        }
    }
}
