package com.realworld.listener;

import com.realworld.util.DriverSession;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String methodName = iTestResult.getName();
        if (!iTestResult.isSuccess()) {
            File scrFile = ((TakesScreenshot) DriverSession.getDriver()).getScreenshotAs(OutputType.FILE);
            String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/report/";
            String failureScreenshotPath = reportDirectory + "failure_screenshots/";
            new File(failureScreenshotPath).mkdirs();
            File destFile = new File((String) failureScreenshotPath + methodName + "_" + formater.format(calendar.getTime()) + ".png");
            try {
                Files.copy(scrFile.toPath(), destFile.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
