package AppiumTest.com.appium;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class RealDevice {

	public AppiumDriver<MobileElement> driver;
	private AppiumDriverLocalService service;
	private DesiredCapabilities dc;
	String pack="com.android.calculator2";
	String act="com.android.calculator2.Calculator";
	String tpack="com.truecaller";
	String tact="com.truecaller.ui.TruecallerInit";    //"com.truecaller.ui.TruecallerInit";
	
	@BeforeTest
	public void startServer()
	{
	    service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		
		
	}
	
	@BeforeClass
	public void setUp() throws Exception
	{
		
		String DeviceName="Samsung";
		String udid= "4d0a8332c821c000";//"4b18ae7"; // 
		String version="7.1.2" ;//"9.0"; //

	    dc=new DesiredCapabilities();
		dc.setCapability("deviceName", DeviceName);
		dc.setCapability("udid", udid);
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
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
	
	@Test()
	
	public void launchtiktok() throws Exception
	{
		
		driver.findElement(By.id(tpack+":id/nextButton")).click();
		
		driver.findElement(By.id("android:id/button2")).click();
		int i=0,j=0;
		while(i<3)
		{
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		i++;
		}
		WebDriverWait wait=new WebDriverWait(driver,200);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(tpack+":id/button_skip"))).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.ImageButton"))).click();
		
		Thread.sleep(15000);
	
	int k=1;	
		
	while(j<k)
	{
		try {
		if(driver.findElement(By.xpath("//android.widget.TextView[@text='Home Docomo']")).isDisplayed())
			
		{
			j=k;
			break;
		}
		}
		catch(Exception e)
		
		{
			    Dimension size = driver.manage().window().getSize();
			    Double hs=size.getHeight()* 0.5;
			    int hsi=hs.intValue();
			    System.out.println(hsi);
			   
			    Double he=size.getHeight()* 0.1;
			    int hei=he.intValue();
			    
			    System.out.println(hei);
			 
			    new TouchAction((PerformsTouchActions) driver)
		                .press(PointOption.point(0, hsi))
		                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
		                .moveTo(PointOption.point(0, hei))
		                .release().perform();
			    k++;
			
		}
	}
		
		
	}
	
	
	
	
	@AfterTest
	public void stopServer()
	{
		
	
		service.stop();
		
	
}
	
}
