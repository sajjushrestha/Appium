package AppiumTest.com.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class RealDevice_emulator {

	public AppiumDriver<MobileElement> driver;
	 AppiumDriverLocalService service;
	String pack="com.android.calculator2";
	String act="com.android.calculator2.Calculator";
	String startServer="n";
	
	
@BeforeClass

public void startServer()
{
	if(startServer.equals("y"))
	{
	 service = AppiumDriverLocalService.buildDefaultService();	
	 service.start();
	}
}
	@BeforeTest
	
	public void setUp() throws Exception
	{
		
		
		DesiredCapabilities dc=new DesiredCapabilities();
		
		dc.setCapability("deviceName", "Google Nexus 9");
		dc.setCapability("udid", "192.168.111.103:5555");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.0");
		dc.setCapability(MobileCapabilityType.NO_RESET, true);
		dc.setCapability("appPackage", pack);
	    dc.setCapability("appActivity", act);

		driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);

	}
	
	@Test
	
	public void Add() throws Exception
		
	{	
		
		Thread.sleep(3000);
		driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
		
		String res=driver.findElement(By.id("com.google.android.calculator:id/result")).getText();
		
		System.out.println(res);
		
		
		
	}
	
	@AfterClass

	public void stopServer()
	{
		if(startServer.equals("y"))
		{service.stop();}
				
	}
	
}
