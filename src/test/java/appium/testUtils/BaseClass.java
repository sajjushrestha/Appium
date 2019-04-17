package appium.testUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {

	
	public static AppiumDriver<MobileElement> driver;
	private AppiumDriverLocalService service;
	protected DesiredCapabilities dc;
	protected String pack="com.android.calculator2";
	protected String act="com.android.calculator2.Calculator";
	protected String tpack=ExcelUtils.getData("Mobile_Details", "pack");
	protected String tact=ExcelUtils.getData("Mobile_Details", "act");   
	
	
	@BeforeSuite
	public void appiumServerKiller()
	{
	ProcessBuilder processBuilder = new ProcessBuilder();
	processBuilder.command("cmd.exe", "/C", "netstat -ano | find \":4723 \"");
	String line,s = "";  
    
    try {

        Process process = processBuilder.start();

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(process.getInputStream()));

        while ((line = reader.readLine()) != null) {
       	 
          
           	s=line.replaceAll("[A-Za-z]", "");
           	System.out.println(s);
               String[] a=s.split("\\s+");
                System.out.println(a[a.length-1]);
                String res=a[a.length-1];
	if(!(res=="0"))
	{
		processBuilder.command("cmd.exe", "/C", "taskkill /pid "+res+" /f");
		 process = processBuilder.start();
		System.out.println("taskkill /pid "+res+" /f");
	}
            
 }


} catch (IOException e) {
    e.printStackTrace();
}
	
	} 	
	
	
	@BeforeTest
	public void startServer()
	{
	    service = AppiumDriverLocalService.buildDefaultService();
		service.start();

	
	}
	
	
	@BeforeClass
	public void setUp() throws Exception
	{
		
		String DeviceName=ReusableMethods.listDevice("name");//ExcelUtils.getData("Mobile_Details", "DeviceName");
		String udid= ReusableMethods.listDevice("devices");   //ExcelUtils.getData("Mobile_Details", "udid");
		String version=ReusableMethods.listDevice("version");  //ExcelUtils.getData("Mobile_Details", "version");
		if(DeviceName.isEmpty() || version.isEmpty())
		{
			DeviceName=ExcelUtils.getData("Mobile_Details", "DeviceName");
			version=ExcelUtils.getData("Mobile_Details", "version");
		}
		
		dc=new DesiredCapabilities();
		
		if(!DeviceName.contains("emulator"))
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
		dc.setCapability(MobileCapabilityType.NO_RESET, false);
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
		dc.setCapability("appPackage", tpack);  //com.google.android.calculator
		dc.setCapability("appActivity", tact);
		
		driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		
		Thread.sleep(3000);
	}
	
	
	
	
	
	@AfterTest
	public void stopServer()
	{
		
	
		service.stop();
		
	
}
}
