package com.costacoffee.utilities;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
        }
        return extent;
    }
}
