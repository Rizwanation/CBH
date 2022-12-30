package org.cbh.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.cbh.driver.Driver.getDriverInstance;
import static org.cbh.driver.Driver.quitDriver;

class BaseTest {
    //package private class - to be exnteded by all tests in this package

    protected BaseTest(){
        //marked as protected to avoid creation of its instances outside child classes
    }
    @BeforeMethod
    protected void initDriver() {

        getDriverInstance().get("https://www.amazon.in");
    }

    @AfterMethod
    protected void tearDown()
    {
        quitDriver();
    }
}
