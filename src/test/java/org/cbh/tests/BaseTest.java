package org.cbh.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    //this class will be extended by all tests so not marking it as final

    protected BaseTest(){
        //marked as protected to avoid creation of its instances
    }

    WebDriver driver;
    @BeforeMethod
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.amazon.in");
    }

    @AfterMethod
    public void quitDriver()
    {
        driver.quit();
    }
}
