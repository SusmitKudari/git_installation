package findinghospitaltest;

import java.io.IOException;
import java.util.Scanner;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import findinghospitals.HomePage;
import findingpackageutil.ExtentReportManager;


public class MainSuite extends HomePage {
ExtentReports report= ExtentReportManager.getReportInstance();
	
	
    @Test(groups={"Regression Suite","Smoke Suite"}) 
   
    public void browserRun() {
    	ExtentTest logger=report.createTest("Browser_run");
    	logger.log(Status.INFO, "Getting the Browser");
        invokeBrowser("chrome");
        openURL("websiteURLKey");
        logger.log(Status.PASS, "Test Executed Successfully");
    }
    @Test(groups={"Regression Suite","Smoke Suite"},dependsOnMethods="browserRun")
    public void homepage() throws Exception{
    	ExtentTest logger=report.createTest("Home Page");
    	logger.log(Status.INFO, "Getting the homepage");
         clickBox();
         clickHospital();
         logger.log(Status.PASS, "Test Executed Successfully");
    }
    @Test(groups="Regression Suite", priority=1)
    public void hospital () throws InterruptedException{
    	filterCheck();
    }
    @Test(groups="Regression Suite", priority=2)
    public void hospitalnames() throws InterruptedException {
    	ExtentTest logger=report.createTest("Hospital Names");
    	logger.log(Status.INFO, "Listing the Hospital Names");
         hospitalLinks();
         logger.log(Status.PASS, "Test Executed Successfully");
    }
    @Test(groups="Regression Suite", priority=3)
    public void diagnostics() throws Exception {
    	ExtentTest logger=report.createTest("Diagnostics");
    	logger.log(Status.INFO, "Opening diagnostics page");
         diagnosticsPage();
         logger.log(Status.INFO, "Displaying the Top Cities");
         TopCities();
         logger.log(Status.PASS, "Test Executed Successfully");
    }
    @Test(groups="Smoke Suite", priority=4)
    public  void Corp_Wellness() throws InterruptedException, IOException {
    	ExtentTest logger=report.createTest("Corporate Wellness");
    	logger.log(Status.INFO, "Getting the page for Corporates");
    	corporateWellness();
    	logger.log(Status.PASS, "Test Executed Successfully");
    }
    @Test(groups={"Regression Suite","Smoke Suite"}, priority=5)
    public void quit() {
    	ExtentTest logger=report.createTest("Close Browser");
    	logger.log(Status.INFO, "Quitting the Browser");
    	report.flush();
         quitBrowser();
         logger.log(Status.PASS, "Test Executed Successfully");
    }
}
