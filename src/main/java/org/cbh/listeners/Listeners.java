package org.cbh.listeners;

import org.cbh.reports.ExtentReport;
import org.testng.*;

import java.io.IOException;

public class Listeners implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            ExtentReport.flushReports();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReport.getTestInstance().pass(result.getMethod().getMethodName() + " passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReport.getTestInstance().fail(result.getMethod().getMethodName() + " failed.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReport.getTestInstance().skip(result.getMethod().getMethodName() + " got skipped.");
    }



    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ExtentReport.getTestInstance().fail(result.getMethod().getMethodName() + " failed due to timeout.");
    }

}
