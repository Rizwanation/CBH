package org.cbh.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import static org.cbh.reports.ExtentReport.getTestInstance;


public final class HomePage extends BasePage {


    private By hamburgerMenu = By.xpath("//a[@id='nav-hamburger-menu']");
    private String genericCategoryPath = "//div[text()='%value%']/parent::a";
    private String genericSubCategoryPath = "//a[text()='%value%' and @class='hmenu-item']";



    public HomePage clickHamburgerMenu()
    {
        waitForAndClickOnElement(hamburgerMenu);
        getTestInstance().log(Status.PASS,"Clicked Hamburger Menu Button");
        return this;
    }

    public HomePage clickCategoryFromHamburgerMenu(String categoryName)
    {
        By categoryLocator = getByLocatorFromGenericLocatorString(genericCategoryPath,categoryName);
        waitForAndScrollToElement(categoryLocator, categoryName);
        waitForAndClickOnElement(categoryLocator);
        getTestInstance().log(Status.PASS,"Selected Category: " + categoryName);
        return this;
    }

    public CategoriesPage clickSubCategoryFromHamburgerMenu(String subCategoryName)
    {
        By subCategoryLocator = getByLocatorFromGenericLocatorString(genericSubCategoryPath,subCategoryName);
        waitForAndScrollToElement(subCategoryLocator,subCategoryName);
        waitForAndClickOnElement(subCategoryLocator);
        getTestInstance().log(Status.PASS,"Selected SubCategory: " + subCategoryName);
        return new CategoriesPage();
    }

}
