From cmd:
adb devices -- to know the devices connected to system

to get platform tools -open cmd tools\bin and type cmd in address bar - sdkmanager "platform-tools" "platforms:android-26

To install appium server through npm : 
node.js should be installed before this
npm install -g appium
==================================

netstat -ano | find ":4723 "

taskkill /pid 11488 /f
================================

To find app activity and package in cmd prompt:

C:\>adb shell

1|root@generic:/ # dumpsys window windows | grep -E 'mCurrentFocus'

  mCurrentFocus=Window{a619a9e8 u0 com.example.android.apis/com.example.android.apis.ApiDemos}
root@generic:/ #

=====================================

Error obtaining UI hierarchy

Reason:
Error while obtaining UI hierarchy XML file: com.android.ddmlib.SyncException:
Remote object doesn't exist!

Solution:
Go to command prompt, kill the server and start the server..
$ adb kill-server
$ adb start-server




==============================================
Code for starting Appium server with free port
/*AppiumDriverLocalService service =AppiumDriverLocalService.buildService( new
			      AppiumServiceBuilder().usingDriverExecutable(new File(
			      "C:\\Program Files\\nodejs\\node.exe")) .withAppiumJS(new File(
			      "C:\\Users\\Sajindra Prasad\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"
			      )) .withIPAddress("127.0.0.1").usingAnyFreePort());
		*/
		
======================================
long press on object:
 int pressX = driver.manage().window().getSize().width / 2;
		    // 4/5 of the screen as the bottom finger-press point
		    int bottomY = driver.manage().window().getSize().height * 4/5;
		    // just non zero point, as it didn't scroll to zero normally
		    int topY = driver.manage().window().getSize().height / 8;
		    
		    TouchAction touchAction = new TouchAction(driver);
		    touchAction.longPress(PointOption.point(0, 0)).moveTo(PointOption.point(0, 250)).release().perform();
		    
#Touch Options		    
 Dimension size = driver.manage().window().getSize();
	        int anchor = (int) (size.width * 0.6);
	        int startPoint = (int) (size.height * 0.3);
	        int endPoint = (int) (size.height * 0.5);
	 
	        new TouchAction(driver)
	                .press(PointOption.point(anchor, startPoint))
	                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
	                .moveTo(PointOption.point(anchor, endPoint))
	                .release().perform();
	                
	                
============================================	               
	                Swipe Vertical untill particular element:
			  int k=1;	
		
	while(j<k)
	{
		try {
		if(driver.findElement(By.xpath("//android.widget.TextView[@text='Prasad S']")).isDisplayed())
			
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
			