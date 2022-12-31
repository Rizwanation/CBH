package org.cbh.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import static org.cbh.reports.ExtentReport.getTestInstance;


public final class BrandsPage extends BasePage{


    private String optionHighToLowLocatorString = "//a[text()='%value%']";
    private By sortByDropDownLocator = By.xpath("//span[@id='a-autoid-0-announce']");
    private By allProductsLocator = By.xpath("//div[@class='a-section a-spacing-base']//h2//a");



    public BrandsPage clickSortByDropDown()
    {
        waitForAndClickOnElement(sortByDropDownLocator);
        getTestInstance().pass("Clicked 'Sort By' dropdown");
        return this;
    }
    public BrandsPage selectOptionInSortByDropDown(String optionText)
    {
        waitForAndClickOnElement(getByLocatorFromGenericLocatorString(optionHighToLowLocatorString,optionText));
        getTestInstance().log(Status.PASS,"Selected: " + optionText +" from dropdown");
        waitUntilUrlContains("price-desc-rank");
        getTestInstance().log(Status.PASS,"Verified products list updated after sorting.");
        return this;
    }

    public ProductPage waitForAndClickOnProductByPosition(int position)
    {
        waitForVisibilityOfListOfElements(allProductsLocator).get(position - 1).click();
        getTestInstance().log(Status.PASS,"Clicked on product on position: "+ position);
        switchWindow();
        getTestInstance().log(Status.PASS,"Switched to new window/tab");
        return new ProductPage();
    }
}
