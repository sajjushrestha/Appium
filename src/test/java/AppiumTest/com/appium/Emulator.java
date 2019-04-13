package AppiumTest.com.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
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

public class Emulator {

	public AppiumDriver<MobileElement> driver;
	public AppiumDriverLocalService service;
	String deviceName= "Samsung";   //"Android Emulator";
	String pack="com.vector.guru99";
	String act="com.vector.guru99.QuizActivity";
	
	
	@BeforeTest

	public void startServer()
	{
		service = AppiumDriverLocalService.buildDefaultService();	
		 service.start();
				
	}

	@Test
	
	public void launchCalci() throws Exception
	{
		
		
		File appDir=new File("C:\\eclipse-WS\\com.appium\\apk");
		File app=new File(appDir,"bookmyshow-5-5-2.apk"); //
		//File app=new File(appDir,"google-play-services-16-1-53-000300-242560017.apk");
		DesiredCapabilities dc=new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		dc.setCapability(MobileCapabilityType.NO_RESET, true);
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
		driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		
		Thread.sleep(3000);
		
	
		
	}
	
	@AfterTest

	public void stopServer()
	{
		service.stop();
				
	}
	
}
