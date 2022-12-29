package org.cbh.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.cbh.driver.Driver.getDriver;
import static org.cbh.driver.Driver.quitDriver;

public class BaseTest {
    //this class will be extended by all tests so not marking it as final

    protected BaseTest(){
        //marked as protected to avoid creation of its instances outside child classes
    }
    @BeforeMethod
    public void initDriver() {

        getDriver().get("https://www.amazon.in");
    }

    public void tearDown()
    {
        quitDriver();
    }
}
