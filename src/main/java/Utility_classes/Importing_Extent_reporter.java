package Utility_classes;

import org.apache.logging.log4j.EventLogger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Importing_Extent_reporter {

	public static ExtentHtmlReporter ExtentReporter()
	{
		ExtentHtmlReporter report= new ExtentHtmlReporter("./test-output/Extent_Report.html");
	    ExtentReports extent= new ExtentReports();
	    extent.attachReporter(report);
	    ExtentTest logger= extent.createTest("VerifyLogin");
		return report;
	
	}
	
	
}
