package org.cbh.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;


public final class BasicTest extends BaseTest{

    @Test
    private void endToEndTest()
    {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement hamburgerMenu = driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']"));

        wait.until(ExpectedConditions.visibilityOf(hamburgerMenu)).click();
        WebElement category = driver.findElement(By.xpath("//div[text()='TV, Appliances, Electronics']/parent::a"));
        wait.until(ExpectedConditions.visibilityOf(category)).click();

        WebElement subCategory = driver.findElement(By.xpath("//a[text()='Televisions' and @class='hmenu-item']"));
        wait.until(ExpectedConditions.visibilityOf(subCategory)).click();

        WebElement brand = driver.findElement(By.xpath("//span[text()='Samsung' and @dir='auto']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",brand);
        wait.until(ExpectedConditions.visibilityOf(brand)).click();

        WebElement drpDown = driver.findElement(By.xpath("//select[@name='s']"));
        wait.until(ExpectedConditions.visibilityOf(drpDown));

        Select dropDown = new Select(drpDown);
        dropDown.selectByVisibleText("Price: High to Low");

        List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class='a-section a-spacing-base']//h2//a"));

        wait.until(ExpectedConditions.visibilityOfAllElements(allProducts));
        allProducts.get(1).click();


        Iterator<String> windowHandles = driver.getWindowHandles().iterator();
        while (windowHandles.hasNext())
        {
            driver.switchTo().window(windowHandles.next());
        }

        List<WebElement> aboutThisProdList = driver.findElements(By.xpath("//div[@id='feature-bullets']/ul/li"));

        aboutThisProdList.forEach(x-> System.out.println(x.getText()));

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));

    }
}
