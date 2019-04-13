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

import appium.testUtils.BaseClass;
import appium.testUtils.ExcelUtils;
import appium.testUtils.ReusableMethods;
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
		String udid= ExcelUtils.getData("Mobile_Details", "udid");
		String version=ExcelUtils.getData("Mobile_Details", "version");

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
	
	public void launchtrueCaller() throws Exception
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
	
		ReusableMethods.verticalScroll("//android.widget.TextView[@text='Home Docomo']");
		
		
	}
	
	
	
	
	
	
}
