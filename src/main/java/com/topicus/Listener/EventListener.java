package com.topicus.Listener;

import com.topicus.DriverFactory.WebDriverFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class EventListener implements  ITestListener{

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    // Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        return ((TakesScreenshot)WebDriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        saveScreenshotPNG();
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        saveScreenshotPNG();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        saveScreenshotPNG();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        saveScreenshotPNG();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }
}
