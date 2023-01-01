package org.cbh.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import static org.cbh.reports.ExtentTestManager.getExtentTestInstance;


public final class BrandsPage extends BasePage{


    private String optionHighToLowLocatorString = "//a[text()='%value%']";
    private By sortByDropDownLocator = By.xpath("//span[@id='a-autoid-0-announce']");
    private By allProductsLocator = By.xpath("//div[@class='a-section a-spacing-base']//h2//a");



    public BrandsPage clickSortByDropDown()
    {
        waitForAndClickOnElement(sortByDropDownLocator);
        getExtentTestInstance().pass("Clicked 'Sort By' dropdown");
        return this;
    }
    public BrandsPage selectOptionInSortByDropDown(String optionText)
    {
        waitForAndClickOnElement(getByLocatorFromGenericLocatorString(optionHighToLowLocatorString,optionText));
        getExtentTestInstance().log(Status.PASS,"Selected: " + optionText +" from dropdown");
        waitUntilUrlContains("price-desc-rank");
        getExtentTestInstance().log(Status.PASS,"Verified products list updated after sorting.");
        return this;
    }

    public ProductPage waitForAndClickOnProductByPosition(int position)
    {
        waitForVisibilityOfListOfElements(allProductsLocator).get(position - 1).click();
        getExtentTestInstance().log(Status.PASS,"Clicked on product on position: "+ position);
        switchWindow();
        getExtentTestInstance().log(Status.PASS,"Switched to new window/tab");
        return new ProductPage();
    }
}
