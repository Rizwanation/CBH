package org.cbh.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import static org.cbh.driver.Driver.driver;
import static org.cbh.driver.Driver.getDriver;

public class BasePage {
    //this class holds utility functions that can be used by all page classes
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

    protected void waitAndclickOnElement(By locator)
    {
        waitForElementToBeClickable(locator).click();
    }

    protected WebElement waitForVisibility(By locator)
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected List<WebElement> waitForVisibilityOfList(By locator)
    {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void sendKeys(WebElement element,String value)
    {
        element.sendKeys(value);
    }

    protected void scrollElementIntoView(By locator)
    {
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) getDriver();
        WebElement element = getDriver().findElement(locator);
        javaScriptExecutor.executeScript("arguments[0].scrollIntoView;",element);
    }

    private WebElement waitForElementToBeClickable(By locator)
    {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }



    protected By GetByLocatorFromGenericLocatorString(String genericLocator,String value)
    {
        By locator = By.xpath(genericLocator.replace("%value%",value));
        return locator;
    }

    protected WebElement findElementFromLocator(By locator)
    {
        return getDriver().findElement(locator);
    }

    protected List<WebElement> findElementsFromLocator(By locator)
    {
        return waitForVisibilityOfList(locator);
    }

    protected void switchWindow()
    {
        Iterator<String> windowHandles = getDriver().getWindowHandles().iterator();
        while (windowHandles.hasNext())
        {
            getDriver().switchTo().window(windowHandles.next());
        }
        System.out.println(driver.getCurrentUrl());

    }

    protected void waitForPageUrlUpdate()
    {
        wait.until(ExpectedConditions.urlContains("price-desc-rank"));
    }


}
