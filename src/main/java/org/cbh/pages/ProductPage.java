package org.cbh.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

import static org.cbh.reports.ExtentTestManager.getExtentTestInstance;


public final class ProductPage extends BasePage{

    private By aboutThisProdList = (By.xpath("//div[@id='feature-bullets']/ul/li"));

    public void printProductAboutListToConsoleAndReport()
    {
        String featuresList = "";
        for (WebElement element : findElementsFromLocator(aboutThisProdList)) {
            featuresList += element.getText() +"\n";
        }

        getExtentTestInstance().log(Status.PASS,"Printing 'About This Item' Section below: ");
        featuresList = featuresList.substring(0,featuresList.length()-1); //to get rid of new line character after line
        getExtentTestInstance().log(Status.PASS,featuresList);
        System.out.println(featuresList);
        getExtentTestInstance().log(Status.PASS,"'About This Item' printed to console and report");

    }

    public List<WebElement> getAboutThisProductList() {
        return waitForVisibilityOfListOfElements(aboutThisProdList);
    }


}
