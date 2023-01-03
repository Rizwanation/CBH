package org.cbh.listeners;

import org.cbh.reports.ExtentReport;
import org.testng.*;

import java.io.IOException;

import static org.cbh.reports.ExtentTestManager.getExtentTestInstance;
@org.testng.annotations.Listeners
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
        getExtentTestInstance().pass(result.getMethod().getMethodName() + " passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        getExtentTestInstance().fail(result.getMethod().getMethodName() + " failed.");
        getExtentTestInstance().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        getExtentTestInstance().skip(result.getMethod().getMethodName() + " got skipped.");
        getExtentTestInstance().skip(result.getThrowable());
    }



    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        getExtentTestInstance().fail(result.getMethod().getMethodName() + " failed due to timeout.");
    }

}
