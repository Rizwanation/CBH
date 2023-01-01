package org.cbh.tests;

import org.cbh.pages.HomePage;
import org.cbh.pages.ProductPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public final class ProductFeaturesTest extends BaseTest{
    //final because this class will not be extended

    @Test
    private void verifyProductFeaturesListIsPresent()
    {
        //private because only this class will use it

        List<WebElement> ProductFeaturesList = new HomePage()
                .openHomePage("https://www.amazon.in")
                .clickHamburgerMenu()
                .clickCategoryFromHamburgerMenu("TV, Appliances, Electronics")
                .clickSubCategoryFromHamburgerMenu("Televisions")
                .selectBrandNameFromHamburgerMenu("Samsung")
                .clickSortByDropDown()
                .selectOptionInSortByDropDown("Price: High to Low")
                .waitForAndClickOnProductByPosition(2)
                .getAboutThisProductList();

        Assert.assertTrue(ProductFeaturesList.get(1).isDisplayed());
        new ProductPage().printProductAboutListToConsoleAndReport();
    }

    @Test()
    private void verifyProductFeaturesListIsPresent2()
    {
        List<WebElement> ProductFeaturesList = new HomePage()
                .openHomePage("https://www.amazon.in")
                .clickHamburgerMenu()
                .clickCategoryFromHamburgerMenu("TV, Appliances, Electronics")
                .clickSubCategoryFromHamburgerMenu("Televisions")
                .selectBrandNameFromHamburgerMenu("Samsung")
                .clickSortByDropDown()
                .selectOptionInSortByDropDown("Price: High to Low")
                .waitForAndClickOnProductByPosition(2)
                .getAboutThisProductList();

        Assert.assertTrue(ProductFeaturesList.get(1).isDisplayed());
        new ProductPage().printProductAboutListToConsoleAndReport();
    }
}
