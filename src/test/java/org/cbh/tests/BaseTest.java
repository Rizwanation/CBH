package org.cbh.tests;

import org.cbh.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.cbh.driver.Driver.quitWebDriver;


class BaseTest {
    //package private class - to be exnteded by all tests in this package
    protected BaseTest(){
        //marked as protected to avoid creation of its instances outside child classes
    }
    @BeforeMethod
    protected void initDriver() {

        Driver.startWebDriver();
    }

    @AfterMethod
    protected void tearDown()
    {
        quitWebDriver();
    }
}
