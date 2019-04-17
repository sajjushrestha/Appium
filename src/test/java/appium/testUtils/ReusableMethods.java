package appium.testUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class ReusableMethods extends BaseClass{

	
	
	public static void verticalScroll(String locator)
	{
		int k=1,j=0;	
		
		while(j<k)
		{
			try {
			if(driver.findElement(By.xpath(locator)).isDisplayed())
				
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
	
	
	public static void verticalScroll()
	{
		 Dimension size = driver.manage().window().getSize();
		    Double hs=size.getHeight()* 0.5;
		    int hsi=hs.intValue();
		    System.out.println(hsi);
		   
		    Double he=size.getHeight()* 0.;
		    int hei=he.intValue();
		    
		    System.out.println(hei);
		 
		    new TouchAction((PerformsTouchActions) driver)
	             .press(PointOption.point(0, hsi))
	             .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
	             .moveTo(PointOption.point(0, hei))
	             .release().perform();
		
		}
	public static void longPress(WebElement ele)
	{
		TouchAction action = new TouchAction((PerformsTouchActions) driver);
	
		
		action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(ele))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).release().perform();
	}

	
	public static void horizontalScroll()
	{
		 Dimension size = driver.manage().window().getSize();
		    Double hs=size.getHeight()* 0.5;
		    int hsi=hs.intValue();
		    System.out.println(hsi);
		   
		    Double he=size.getHeight()* 0.1;
		    int hei=he.intValue();
		    
		    System.out.println(hei);
		 
		    new TouchAction((PerformsTouchActions) driver)
	             .press(PointOption.point(hsi, 0))
	             .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
	             .moveTo(PointOption.point(hei, 0))
	             .release().perform();
		
		}
	
	
	public static String listDevice(String cmd)
	{
		 ProcessBuilder processBuilder = new ProcessBuilder();
		 String line,s = "";
		 if(cmd.equalsIgnoreCase("devices"))
		 {
         processBuilder.command("cmd.exe", "/C", "adb devices");
       
        
         try {

             Process process = processBuilder.start();

             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(process.getInputStream()));
  
             while ((line = reader.readLine()) != null) {
            	 
                 System.out.println(line);
                 
                 if(!line.startsWith("List"))
                 {
                	 s=line.replace("device", "");
                    
                     System.out.println(s);
    	
                 }
       
             }

          
         } catch (Exception e) {
             e.printStackTrace();
         }
         return s;
		 }
		 
		 if(cmd.equalsIgnoreCase("version"))
		 { 
			 processBuilder.command("cmd.exe", "/C", "adb shell \" cat /system/build.prop |grep ro.build.version.release\"");
		       
		        
	         try {

	             Process process = processBuilder.start();

	             BufferedReader reader =
	                     new BufferedReader(new InputStreamReader(process.getInputStream()));
	  
	             while ((line = reader.readLine()) != null) {
	            	 
	                 System.out.println(line); 
	                 if(!line.startsWith("List"))
	                 {
	                	s=line.replace("ro.build.version.release=", "");
	                    
	                     System.out.println(s);
	    	
	                 }
		 }
         
      
         } catch (Exception e) {
             e.printStackTrace();
         }
	         return s;
		 }
		 
		 if(cmd.equalsIgnoreCase("name"))
		 { 
			 processBuilder.command("cmd.exe", "/C", "adb shell \" cat /system/build.prop |grep ro.product.brand\"");
		       
		        
	         try {

	             Process process = processBuilder.start();

	             BufferedReader reader =
	                     new BufferedReader(new InputStreamReader(process.getInputStream()));
	  
	             while ((line = reader.readLine()) != null) {
	            	 
	                 System.out.println(line); 
	                 if(!line.startsWith("List"))
	                 {
	                	s=line.replace("ro.product.brand=", "");
	                    
	                     System.out.println(s);
	    	
	                 }
		 }
         
      
         } catch (Exception e) {
             e.printStackTrace();
         }
	         
	         return s;
		 }
		return s;
	   
		
    	
	}
	
	public static String listDevices(String cmd)
	{
		 ProcessBuilder processBuilder = new ProcessBuilder();
		 String line,s = "";
	    
         processBuilder.command("cmd.exe", "/C", cmd);

         try {

             Process process = processBuilder.start();

             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(process.getInputStream()));
  
             while ((line = reader.readLine()) != null) {
            	 
                 System.out.println(line);
                 
                 if(!line.startsWith("List"))
                 {
                	 if(cmd.contains("adb devices"))
                	 {
                	 s=line.replace("device", "");
                	 }
                	 if(cmd.contains("grep ro.build.version.release"))
                	 {
                	 s=line.replace("ro.build.version.release=", "");
                	 }
                     System.out.println(s);
    	
                 }
       
             }

          
         } catch (Exception e) {
             e.printStackTrace();
         }
		 
		 
		 
		 
	   
		return s;
    	
	}
	
	

	}
	
	

