package findinghospitals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POMclass {
		
	/****************HomePage ***********************/
	@FindBy(xpath="//input[@placeholder='Search location']")
    public static WebElement searchBox;
    @FindBy(xpath="//*[@class='icon-ic_cross_solid']")
    public static WebElement crossIcon;
    @FindBy(xpath="//*[@id='c-omni-container']/div/div[1]/div/input")
    public static WebElement city;
    @FindBy(xpath="//input[@placeholder='Search doctors, clinics, hospitals, etc.']")
    public static WebElement hospitalSearch;
    @FindBy(xpath="//div[normalize-space()='Hospital']")
    public static WebElement hospital;
    
    /*****************Hospital Page **********************/
    @FindBy(xpath="//span[contains(text(),'Open 24X7')]")
    public static WebElement check;
    
    /****************** filter**********************/
    @FindBy(css=".u-transition--transform")
    public static WebElement filter;
   
    @FindBy(xpath="//span[contains(text(),'Has Parking')]")
    public static WebElement filter1;
    
    @FindBy(xpath="//h2[@class='u-title-font u-c-pointer u-bold']]")
    public static WebElement clist ;
    
    @FindBy(xpath="/h2[@class='u-title-font u-c-pointer u-bold']")
    public static WebElement hospitalList;
    
    //Diagnostics Page
    @FindBy(xpath="//div[@class='product-tab__title' and contains(text(),'Diagnostics')]")
    public static WebElement diagnostics;
   @FindBy(xpath="//div[@class='u-margint--standard o-f-color--primary']")
    public static WebElement diagnostics2;

}
