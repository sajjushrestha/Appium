package appium.testUtils;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {

	
	public static AppiumDriver<MobileElement> driver;
	private AppiumDriverLocalService service;
	
	
	@BeforeTest
	public void startServer()
	{
	    service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		
		
	}
	
	
	@AfterTest
	public void stopServer()
	{
		
	
		service.stop();
		
	
}
}
