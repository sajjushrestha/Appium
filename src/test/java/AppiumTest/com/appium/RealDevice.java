package AppiumTest.com.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class RealDevice {

	public AppiumDriver<MobileElement> driver;
	String pack="com.vector.guru99";
	String act="com.vector.guru99.QuizActivity";
	

	@Test
	
	public void launchCalci() throws Exception
	{
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		
		/*AppiumDriverLocalService service =AppiumDriverLocalService.buildService( new
			      AppiumServiceBuilder().usingDriverExecutable(new File(
			      "C:\\Program Files\\nodejs\\node.exe")) .withAppiumJS(new File(
			      "C:\\Users\\Sajindra Prasad\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"
			      )) .withIPAddress("127.0.0.1").usingAnyFreePort());
		*/
	service.start();
		
		
		DesiredCapabilities dc=new DesiredCapabilities();
		
		dc.setCapability("deviceName", "Mi A2");
		dc.setCapability("udid", "4b18ae7");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
		
		//dc.setCapability("appPackage", pack);
	   // dc.setCapability("appActivity", act);
		//Calci
				dc.setCapability("appPackage", "com.google.android.calculator");
				dc.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		
		Thread.sleep(3000);
		//driver.findElement(By.id("com.vector.guru99:id/action_quiz")).click();
		
		
		
		
		driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		
		Thread.sleep(3000);
		driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
		
		String res=driver.findElement(By.id("com.google.android.calculator:id/result")).getText();
		
		System.out.println(res);
		
		service.stop();
		
	}
	
	
	
}
