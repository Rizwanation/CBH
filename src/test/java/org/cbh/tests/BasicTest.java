package org.cbh.tests;

import org.cbh.pages.HomePage;
import org.testng.annotations.Test;



public final class BasicTest extends BaseTest{

    @Test
    private void endToEndTest()
    {


        HomePage homePage = new HomePage();
        homePage.clickHamburgerMenu()
                .clickCategoryFromHamburgerMenu("TV, Appliances, Electronics")
                .clickSubCategoryFromHamburgerMenu("Televisions")
                .selectBrandNameFromHamburgerMenu("Samsung")
                .selectValueInPriceDropDown()
                .waitForAndClickOnProductByPosition(2)
                .printFeaturesToConsole();


        //        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        //        js.executeScript("arguments[0].scrollIntoView();",brand);
        //        wait.until(ExpectedConditions.visibilityOf(brand)).click();

    }
}
