package org.cbh.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import static org.cbh.reports.ExtentReport.getTestInstance;

public final class ProductPage extends BasePage{

    private By aboutThisProdList = (By.xpath("//div[@id='feature-bullets']/ul/li"));

    public void printFeaturesToConsole()
    {
        findElementsFromLocator(aboutThisProdList)
                .forEach(element -> getTestInstance().log(Status.PASS,element.getText()));
        getTestInstance().log(Status.PASS,"Features list of product printed to console and report");

    }

}
