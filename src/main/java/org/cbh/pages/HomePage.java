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
        waitAndclickOnElement(hamburgerMenu);
        getTestInstance().log(Status.PASS,"Clicked Hamburger Menu Button");

        return this;
    }

    public HomePage clickCategoryFromHamburgerMenu(String categoryName)
    {
        String categoryLocatorPath = genericCategoryPath.replace("%value%",categoryName);
        By categoryLocator = By.xpath(categoryLocatorPath);
        waitAndclickOnElement(categoryLocator);
        getTestInstance().log(Status.PASS,"Selected Category: " + categoryName);
        return this;
    }

    public CategoriesPage clickSubCategoryFromHamburgerMenu(String subCategoryName)
    {
        String subCategoryLocatorPath = genericSubCategoryPath.replace("%value%",subCategoryName);
        By subCategoryLocator = By.xpath(subCategoryLocatorPath);
        waitAndclickOnElement(subCategoryLocator);
        getTestInstance().log(Status.PASS,"Selected SubCategory: " + subCategoryName);
        return new CategoriesPage();
    }

}
