package org.cbh.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public final class ExtentReport {

    private ExtentReport() {}

    private static ExtentReports extentReport;

    public static void initReports()
    {
        extentReport = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter ("index.html");
        extentReport.attachReporter(spark);
        spark.config().setTheme (Theme.STANDARD);
        spark.config().setDocumentTitle("CBH Report");
        spark.config().setReportName ("Assessment Test");
    }


    public static void flushReports() throws IOException {
        extentReport.flush();
        Desktop.getDesktop().browse(new File("index.html").toURI());

    }

    public static void createTest(String testName)
    {
        ExtentTestManager.setExtentTest(extentReport.createTest(testName));
    }


}
