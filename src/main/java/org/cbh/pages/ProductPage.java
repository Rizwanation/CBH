package org.cbh.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.cbh.reports.ExtentReport.getTestInstance;

public final class ProductPage extends BasePage{

    private By aboutThisProdList = (By.xpath("//div[@id='feature-bullets']/ul/li"));

    public void printProductAboutListToConsoleAndReport()
    {
        findElementsFromLocator(aboutThisProdList)
                .forEach(element -> {getTestInstance().log(Status.PASS,element.getText());
                    System.out.println(element.getText());});

        getTestInstance().log(Status.PASS,"Features list of product printed to console and report");

    }

    public List<WebElement> getAboutThisProdList() {
        return waitForVisibilityOfListOfElements(aboutThisProdList);
    }
}
