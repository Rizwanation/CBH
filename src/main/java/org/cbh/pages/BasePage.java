package org.cbh.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import static org.cbh.driver.Driver.getDriverInstance;
import static org.cbh.reports.ExtentReport.getTestInstance;

class BasePage {
    //package-private class - contains utility methods - to be extended by all page classes
    WebDriverWait wait = new WebDriverWait(getDriverInstance(), Duration.ofSeconds(20));
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriverInstance();

    //wait and click on single element
    protected void waitForAndClickOnElement(By locator)
    {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void waitUntilUrlContains(String urlShouldContain)
    {
        wait.until(ExpectedConditions.urlContains(urlShouldContain));
    }

    //wait for visibility of single element by locator
    protected WebElement waitForElementToBeVisible(By locator)
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    //wait for visibility of list of elements by locator
    protected List<WebElement> waitForVisibilityOfListOfElements(By locator)
    {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected By getByLocatorFromGenericLocatorString(String genericLocator,String value)
    {
        By locator = By.xpath(genericLocator.replace("%value%",value));
        return locator;
    }

    protected List<WebElement> findElementsFromLocator(By locator)
    {
        return waitForVisibilityOfListOfElements(locator);
    }

    protected void switchWindow()
    {
        Iterator<String> windowHandles = getDriverInstance().getWindowHandles().iterator();
        while (windowHandles.hasNext())
        {
            getDriverInstance().switchTo().window(windowHandles.next());
        }
    }

    protected void waitForAndScrollToElement(By locator, String elementName)
    {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",waitForElementToBeVisible(locator));
        getTestInstance().log(Status.PASS,"Scrolled to " + elementName);
    }

}
