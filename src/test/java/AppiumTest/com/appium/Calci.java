package AppiumTest.com.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Calci {

	public AppiumDriver<MobileElement> driver;

	@Test
	
	public void launchCalci() throws Exception
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		
		dc.setCapability("deviceName", "Moto G5 Plus");
		dc.setCapability("udid", "ZY223Z9PHM");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "7.0");
		
		dc.setCapability("appPackage", "com.google.android.calculator");
		dc.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		
		
		
		
		
		
	}
	
	
	
}
