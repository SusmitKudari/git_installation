package findingpackageutil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;


public class ExtentReportManager {
	 
	public static ExtentReports report;
    
    public static ExtentReports getReportInstance() {
    	
    	if(report == null) {
    		String reportName = DateUtil.getTimeStamp()+ ".html";
    		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/" + reportName);
    	     report = new ExtentReports();
    	     report.attachReporter(htmlReporter);
    	     
    	     report.setSystemInfo("OS", "Windows 10");
    	     report.setSystemInfo("Java Version", "15.0.2");
    	     report.setSystemInfo("Environment", "UAT");
    	     report.setSystemInfo("Browser", "Chrome");
    	
    	     htmlReporter.config().setDocumentTitle("TESTCASES_VALIDATING PRACTO.COM");
    	     htmlReporter.config().setReportName("Automation Report");
    	     htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
    	     htmlReporter.config().setTimeStampFormat("MM dd,yyyy HH:mm:ss");
    	}
    	return report;
    }    
}
