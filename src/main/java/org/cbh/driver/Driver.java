package org.cbh.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Objects;

public final class Driver {
    //final so it can't be extended
    private Driver()
    {}

    public static void startWebDriver()
    {
        if(Objects.isNull(DriverManager.getDriverInstance())) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver");
            DriverManager.setDriver(new ChromeDriver());
            DriverManager.getDriverInstance().manage().window().maximize();

        }

    }

    public static void quitWebDriver()
    {
        if(Objects.nonNull(DriverManager.getDriverInstance()))
        {
            DriverManager.getDriverInstance().quit();
            DriverManager.unload();
        }
    }
}
