package org.cbh.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.cbh.configs.ReadConfig;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Objects;

public final class Driver {
    //final so it can't be extended
    private Driver()
    {}

    static DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    public static void startWebDriver() throws Exception {
        if(Objects.isNull(DriverManager.getDriverInstance())) {

            if(ReadConfig.getKey("mode").equals("local")) {
                if(ReadConfig.getKey("localbrowser").equals("chrome"))
                {
                WebDriverManager.chromedriver().setup();
                DriverManager.setDriver(new ChromeDriver());
                DriverManager.getDriverInstance().manage().window().maximize();
                }
                if(ReadConfig.getKey("localbrowser").equals("firefox"))
                {
                    WebDriverManager.firefoxdriver().setup();
                    DriverManager.setDriver(new ChromeDriver());
                    DriverManager.getDriverInstance().manage().window().maximize();
                }
            }
            else if(ReadConfig.getKey("mode").equals("grid_standalone"))
            {
                // Start Selenium Grid in standalone mode
                desiredCapabilities.setBrowserName("chrome");
                DriverManager.setDriver(new RemoteWebDriver(new URL("http://localhost:4444"),desiredCapabilities));
                DriverManager.getDriverInstance().manage().window().maximize();
            }
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
