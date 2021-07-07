package findinghospitals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import findingpackageutil.CaptureScreenShot;


public class HomePage {

	public  static WebDriver driver=null;
	public WebElement element;

	public static Properties prop;
	/********************* Invoking The Browser  ****************************/
	public void invokeBrowser(String browser)
	{
		  if(browser.equalsIgnoreCase("chrome")) 
		 {
			 // To launch application in Chrome browser
		 	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//driver//chromedriver.exe");
		 	driver = new ChromeDriver();
		 }
		 else if(browser.equalsIgnoreCase("firefox")) 
	 	{
		 
		 System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "//driver//geckodriver.exe");
		 driver = new FirefoxDriver();
	 	}
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
        //proeperties
		if(prop==null)
		{
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//objectRepository//config.properties");
				prop.load(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	 		public void openURL(String websiteURLKey) {
	        driver.get(prop.getProperty(websiteURLKey));
	    }
	 		
	 		public void clickBox() {
	 	        PageFactory.initElements(driver, POMclass.class);
	 	        POMclass.searchBox.click();
	 	        POMclass.crossIcon.click();
	 	        POMclass.searchBox.sendKeys("Bangalore");
	 	        POMclass.city.click();
	 	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 	    }
	 		
	 	// hover to next search box and type hospital
	 	    public void clickHospital() {
	 	        PageFactory.initElements(driver, POMclass.class);
	 	        POMclass.hospitalSearch.click();
	 	        POMclass.hospitalSearch.sendKeys("Hospital");
	 	        POMclass.hospital.click();
	 	    }
	 	   public void filterCheck() throws InterruptedException {
	 	        PageFactory.initElements(driver, POMclass.class);
	 	       POMclass.check.click();
	 	        Thread.sleep(8000);
	 	        
	 	        PageFactory.initElements(driver, POMclass.class);
	 	       POMclass.filter.click();
	 	        Thread.sleep(3000);
	 	    
	 	        PageFactory.initElements(driver, POMclass.class);
	 	       POMclass.filter1.click();
	 	        Thread.sleep(3000);
	 	   }
	 	  //After applying all Filters get the list of hospital name
	 	    public void hospitalLinks() throws InterruptedException {
	 	        List<WebElement> clist = driver.findElements(By.xpath("//h2[@class='u-title-font u-c-pointer u-bold']"));
	 	        System.out.println("The Hospital Names:");
	 	        for (int list = 0; list < clist.size(); list++) {
	 	            System.out.println(" " + clist.get(list).getText());
	 	            WritingExcelFile.writeExcel(clist);
	 	        }
	 	        Thread.sleep(2000);
	 	    }
	 	    
	 	    //Navigate to Diagnostic Page
	 	    public void diagnosticsPage()  {
	 	        PageFactory.initElements(driver, POMclass.class);
	 	       POMclass.diagnostics.click();

	 	    }
	 	    public void TopCities() throws Exception {
	 	 
	 	        List<WebElement> plist = driver.findElements(By.xpath("//div[@class='u-margint--standard o-f-color--primary']"));
	 	        Thread.sleep(2000);
	 	        System.out.println("The Top cities:");
	 	        for (int listt = 0; listt < plist.size(); listt++) {
	 	            System.out.println(" " + plist.get(listt).getText());
	 	            Thread.sleep(2000);
	 	        }
	 	    }
	 	    
	 	   //Corporate Wellness page form filling
	 	    public void corporateWellness() throws IOException, InterruptedException {
	 	        driver.navigate().back();
	 	        driver.findElement(By.xpath("//span[@class='u-d-item up-triangle' and contains(text(),'For Providers')]"))
	 	                .click();
	 	        driver.findElement(By.linkText("Corporate wellness")).click();
	 	        String mainWindow = driver.getWindowHandle();
	 	        Set<String> set = driver.getWindowHandles();
	 	        Iterator<String> itr = set.iterator();
	 	        while (itr.hasNext()) {
	 	            String childWindow = itr.next();
	 	            if (!mainWindow.equals(childWindow)) {
         
	 	                driver.switchTo().window(childWindow);
	 	                
	 	                 File src=new File(System.getProperty("user.dir") + "//TestInput//Book1.xlsx");
	 	                    FileInputStream stream =new FileInputStream(src);
	 	                    @SuppressWarnings("resource")
	 						XSSFWorkbook book=new XSSFWorkbook(stream);
	 	                    XSSFSheet sheet=book.getSheet("Sheet1");
	 	                   
	 	                    
	 	                    //for 2 row
	 	                    String Your_name=sheet.getRow(0).getCell(0).getStringCellValue();
	 	                    String org_name=sheet.getRow(0).getCell(1).getStringCellValue();
	 	                    String Your_mail=sheet.getRow(0).getCell(2).getStringCellValue();
	 	                   long Your_phone=(int) sheet.getRow(0).getCell(3).getNumericCellValue();
	 	                    Thread.sleep(5000);
	 	                   String phone=String.valueOf(Your_phone);
	 	                   
	 	                
	 	                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 	                
	 	                driver.findElement(By.xpath("//input[@id='name']")).sendKeys(Your_name);
	 	                driver.findElement(By.id("organization_name")).sendKeys(org_name);
	 	                driver.findElement(By.id("official_email_id")).sendKeys(Your_mail);
	 	                driver.findElement(By.id("official_phone_no")).sendKeys(phone);
	 	                CaptureScreenShot cap=new CaptureScreenShot();
	 	                cap.captureScreenShot();                
	 	                Thread.sleep(2000);
	 	                driver.findElement(By.id("button-style")).click();


 	              
	 	               WebDriverWait wait = new WebDriverWait(driver,60);
	 	               if(wait.until(ExpectedConditions.alertIsPresent())==null);
	 	               System.out.println("Alert is Present");
	 	                
	 	                String alertMessage = driver.switchTo().alert().getText();
	 	                driver.switchTo().alert().accept();
	 	                Thread.sleep(3000);
	 	                System.out.println(alertMessage);
	 	                Thread.sleep(10000);
	 	                
	 	            }
	 	        
	 	        }
	 	        }
	 	    //Close the browser
	 	    public void quitBrowser(){
	 	        // quit browser
	 	        driver.quit();
	 	    }
}
