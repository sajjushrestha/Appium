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

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;



public class RealDevice extends BaseClass{


	
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
		
		String name="Nepal Num";
	
		ReusableMethods.verticalScroll("//android.widget.TextView[@text='"+name+"']");
		
		WebElement ele=driver.findElement(By.xpath("//android.widget.TextView[@text='"+name+"']"));
		
		ReusableMethods.longPress(ele);
		
		ReusableMethods.longPress(ele);
		
		ele.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.CheckedTextView[@text='View profile']"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button1"))).click();
		
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
   	
   
 @Test(enabled=true)
	
	public void launchTestApp() throws Exception
	{
		
    	WebDriverWait wait=new WebDriverWait(driver,200);
    	
  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("io.selendroid.testapp:id/touchTest"))).click();
  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("io.selendroid.testapp:id/LinearLayout1"))).click();
  
  
  String type=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("io.selendroid.testapp:id/gesture_type_text_view"))).getText();
 System.out.println(type);
 
  if(type.equals("SINGLE TAP CONFIRMED"))
  {
	  System.out.println("PASS");
  }
  
	}

    
	
}
