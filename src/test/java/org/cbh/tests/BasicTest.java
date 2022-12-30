package org.cbh.tests;

import org.cbh.pages.HomePage;
import org.testng.annotations.Test;



public final class BasicTest extends BaseTest{
    //final because this class will not be extended

    @Test
    private void endToEndTest()
            //private because only this class will use it
    {


        HomePage homePage = new HomePage();
        homePage.clickHamburgerMenu()
                .clickCategoryFromHamburgerMenu("TV, Appliances, Electronics")
                .clickSubCategoryFromHamburgerMenu("Televisions")
                .selectBrandNameFromHamburgerMenu("Samsung")
                .selectValueInPriceDropDown()
                .waitForAndClickOnProductByPosition(2)
                .printProductAboutListToConsoleAndReport();
        //Add Product Features List Assertion
        //Change Test Name
        //Change Class/File Name
    }
}
