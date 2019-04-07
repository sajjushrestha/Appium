package AppiumTest.com.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Calci {

	public AppiumDriver<MobileElement> driver;

	@Test
	
	public void launchCalci() throws Exception
	{
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		
		
		DesiredCapabilities dc=new DesiredCapabilities();
		
		dc.setCapability("deviceName", "MI A2");
		dc.setCapability("udid", "4b18ae7");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9.0");
		
		dc.setCapability("appPackage", "com.opera.mini.native");
		dc.setCapability("appActivity", "com.opera.mini.android.Browser");
		
		driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		
		//driver.findElement(By.xpath("//android.widget.Button[@text='1' and @index='6']")).click();
		//driver.findElement(By.xpath("//android.view.ViewGroup[@index='1']")).click();
		
		//driver.findElement(By.xpath("//android.widget.Button[@text='2']")).click();
		
		
		service.stop();
		
	}
	
	
	
}
