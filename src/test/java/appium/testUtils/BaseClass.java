package appium.testUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {

	
	public static AppiumDriver<MobileElement> driver;
	private AppiumDriverLocalService service;
	
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
	
	
	@AfterTest
	public void stopServer()
	{
		
	
		service.stop();
		
	
}
}
