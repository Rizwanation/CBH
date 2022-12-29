package org.cbh.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class Driver {
    public static WebDriver driver;

    public static WebDriver getDriver()
    {
        if(Objects.isNull(driver)) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            return driver;
        }
        return driver;
    }

    public static void quitDriver()
    {
        if(Objects.nonNull(driver))
        {
            driver.quit();
        }
    }


}
