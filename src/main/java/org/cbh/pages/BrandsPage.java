package org.cbh.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import static org.cbh.reports.ExtentReport.getTestInstance;


public final class BrandsPage extends BasePage{

    private By priceDropDownLocator = By.cssSelector("span.a-dropdown-label");
    private By optionHighToLowLocator = By.xpath("//*[@id='s-result-sort-select_2' and text()='Price: High to Low']");
    private By allProductsLocator = By.xpath("//div[@class='a-section a-spacing-base']//h2//a");


    public BrandsPage selectValueInPriceDropDown()
    {
        waitAndClickOnElement(priceDropDownLocator);
        getTestInstance().log(Status.PASS,"Clicked on Sort By Dropdown");
        waitAndClickOnElement(optionHighToLowLocator);
        getTestInstance().log(Status.PASS,"Selected \"Price: High to Low\"" );
        waitUntilUrlContains("price-desc-rank");
        getTestInstance().log(Status.PASS,"Verified products list updated after sorting.");
        return this;
    }

    public ProductPage waitForAndClickOnProductByPosition(int position)
    {
        waitForVisibilityOfListOfElements(allProductsLocator).get(position - 1).click();
        getTestInstance().log(Status.PASS,"Clicked on product on "+ position + " position");
        switchWindow();
        getTestInstance().log(Status.PASS,"Switched to new window/tab");
        return new ProductPage();
    }
}
