package org.cbh.pages;

import com.aventstack.extentreports.Status;
import org.cbh.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import static org.cbh.reports.ExtentTestManager.getExtentTestInstance;


class BasePage {
    //package-private class - contains utility methods - to be extended by all page classes
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriverInstance(), Duration.ofSeconds(20));
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManager.getDriverInstance();

    //wait and click on single element
    protected void navigateToUrl(String url)
    {
        DriverManager.getDriverInstance().get(url);
    }

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
        return By.xpath(genericLocator.replace("%value%",value));
    }

    protected List<WebElement> findElementsFromLocator(By locator)
    {
        return waitForVisibilityOfListOfElements(locator);
    }

    protected void switchWindow()
    {
        Iterator<String> windowHandles = DriverManager.getDriverInstance().getWindowHandles().iterator();
        while (windowHandles.hasNext())
        {
            DriverManager.getDriverInstance().switchTo().window(windowHandles.next());
        }
    }

    protected void waitForAndScrollToElement(By locator, String elementName)
    {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",waitForElementToBeVisible(locator));
        getExtentTestInstance().log(Status.PASS,"Scrolled to " + elementName);
    }
}