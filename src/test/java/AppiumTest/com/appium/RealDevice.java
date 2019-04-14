package AppiumTest.com.appium;


import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import appium.testUtils.BaseClass;
import appium.testUtils.ExcelUtils;
import appium.testUtils.ReusableMethods;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class RealDevice extends BaseClass{

	
	private DesiredCapabilities dc;
	String pack="com.android.calculator2";
	String act="com.android.calculator2.Calculator";
	String tpack=ExcelUtils.getData("Mobile_Details", "pack");
	String tact=ExcelUtils.getData("Mobile_Details", "act");   
	

	
	@BeforeClass
	public void setUp() throws Exception
	{
		
		String DeviceName=ExcelUtils.getData("Mobile_Details", "DeviceName");
		String udid= ReusableMethods.listDevice();   //ExcelUtils.getData("Mobile_Details", "udid");
		String version=ExcelUtils.getData("Mobile_Details", "version");
		
		
		dc=new DesiredCapabilities();
		
		if(!DeviceName.contains("Emulator"))
		{
		dc.setCapability("deviceName", DeviceName);
		dc.setCapability("udid", udid);
		}
		else
		{
			dc.setCapability("deviceName", DeviceName);
		}
		
		
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
		dc.setCapability(MobileCapabilityType.NO_RESET, true);
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
		dc.setCapability("appPackage", tpack);  //com.google.android.calculator
		dc.setCapability("appActivity", tact);
		
		driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		
		Thread.sleep(3000);
	}
	
	
	@Test(enabled=false)
	
	public void launchCalci() throws Exception
	{
		
		
		driver.findElement(By.id(pack+":id/digit_1")).click();
		driver.findElement(By.id(pack+":id/op_add")).click();
		driver.findElement(By.id(pack+":id/digit_2")).click();
		
		String res=driver.findElement(By.id(pack+":id/result")).getText();
		
		System.out.println(res);
	
	}
	
	@Test(enabled=false)
	
	public void launchtrueCaller() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver,200);
		driver.findElement(By.id(tpack+":id/nextButton")).click();
		
		driver.findElement(By.id("android:id/button2")).click();
		int i=0,j=0;
		while(i<3)
		{
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		i++;
		}
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(tpack+":id/button_skip"))).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.ImageButton"))).click();
		
		Thread.sleep(15000);
	
		ReusableMethods.verticalScroll("//android.widget.TextView[@text='Prasad S']");
		
		WebElement ele=driver.findElement(By.xpath("//android.widget.TextView[@text='Prasad S']"));
		
		ReusableMethods.longPress(ele);
		
		ReusableMethods.longPress(ele);
		
		ele.click();
		
		String number=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.truecaller:id/buttonTextHeading"))).getText();
		System.out.println(number);

	}
	
	
    @Test(enabled=false)
	
	public void launchDialer() throws Exception
	{
		
    	WebDriverWait wait=new WebDriverWait(driver,200);
	ReusableMethods.horizontalScroll();
	
	ReusableMethods.verticalScroll("//android.widget.TextView[@text='70138 75882']");
	
	driver.findElement(By.xpath("//android.widget.TextView[@text='70138 75882']")).click();
	ReusableMethods.verticalScroll();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.dialer:id/details_action"))).click();
	
	
	String number=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.dialer:id/date"))).getText();
	System.out.println(number);
	
	
	
	}
    
    
    @Test(enabled=false)
	
   	public void launchAPIDemos() throws Exception
   	{
   		
       	WebDriverWait wait=new WebDriverWait(driver,200);
       	
       	ReusableMethods.verticalScroll("//android.widget.TextView[@text='Text']");
       	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Text']"))).click();
       	
       	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='LogTextBox']"))).click();
       	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.example.android.apis:id/add"))).click();
    	
    	
    	String number=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.example.android.apis:id/text"))).getText();
    	System.out.println(number);
    
       	 	
   	}
   	
    
    
 @Test(enabled=false)
	
   	public void launchBrowser() throws Exception
   	{
   		
       	WebDriverWait wait=new WebDriverWait(driver,200);
       	
     wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Top charts']")));
   // wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.vending:id/search_box_idle_text"))).sendKeys("facebook");
      // 	driver.hideKeyboard();
    ReusableMethods.verticalScroll("//android.widget.TextView[@text='Comedy Games']");
      // 	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Google Search']"))).click();
    	
    	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[contains(@content-desc,'https://m.facebook.com Link')]"))).click();
       //		
       	 	
   	}
   	
    @Test()
 public void launchtrueCaller2() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver,200);
		
	
		ReusableMethods.verticalScroll("//android.widget.TextView[@text='Babu Painter']");
		
		WebElement ele=driver.findElement(By.xpath("//android.widget.TextView[@text='Babu Painter']"));
		
		ReusableMethods.longPress(ele);
		
		ReusableMethods.longPress(ele);
		
		ele.click();
		
		String number=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.truecaller:id/buttonTextHeading"))).getText();
		System.out.println(number);

	}
	
    
    
	
}
