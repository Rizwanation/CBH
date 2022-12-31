package org.cbh.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import static org.cbh.reports.ExtentReport.getTestInstance;

public final class CategoriesPage extends BasePage{
    private String brandNamePath = "//span[text()='%value%' and @dir='auto']";

    public BrandsPage selectBrandNameFromHamburgerMenu(String brandName)
    {
        By brandNameLocator = getByLocatorFromGenericLocatorString(brandNamePath,brandName);
        waitForAndScrollToElement(brandNameLocator,brandName);
        waitForAndClickOnElement(brandNameLocator);
        getTestInstance().log(Status.PASS,"Selected brand: " + brandName);
        waitUntilUrlContains(brandName);

        return new BrandsPage();
    }

}
