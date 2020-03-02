package com.hbsp.extentreports;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportListener implements IReporter {

	private ExtentReports extent;

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		this.extent = new ExtentReports(outputDirectory + File.separator + "FbExtent.html", true);

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				this.buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				this.buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				this.buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}

		this.extent.flush();
		this.extent.close();
	}

	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = this.extent.startTest(result.getMethod().getMethodName());

				test.setStartedTime(this.getTime(result.getStartMillis()));
				test.setEndedTime(this.getTime(result.getEndMillis()));

				for (String group : result.getMethod().getGroups()) {
					test.assignCategory(group);
				}

				if (result.getThrowable() != null) {
					test.log(status, result.getThrowable());
				} else {
					test.log(status, "Test " + status.toString().toLowerCase() + "ed");
				}

				this.extent.endTest(test);
			}
		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}
