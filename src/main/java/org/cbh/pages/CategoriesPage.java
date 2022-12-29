package org.cbh.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static org.cbh.driver.Driver.getDriver;
import static org.cbh.reports.ExtentReport.getTestInstance;

public final class CategoriesPage extends BasePage{

    private String brandNamePath = "//span[text()='%value%' and @dir='auto']";



    public BrandsPage selectBrandNameFromHamburgerMenu(String brandName)
    {
        By brandNameLocator = GetByLocatorFromGenericLocatorString(brandNamePath,brandName);
        scrollToElement(brandNameLocator);
        waitAndclickOnElement(brandNameLocator);
        getTestInstance().log(Status.PASS,"Selected brand: " + brandName);

        return new BrandsPage();
    }

    public void scrollToElement(By locator)
    {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();",findElementFromLocator(locator));
        getTestInstance().log(Status.PASS,"Scrolled to element");
    }


}
