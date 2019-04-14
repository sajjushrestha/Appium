package AppiumTest.com.appium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.R;
import android.os.Build;
import android.util.Log;
import android.widget.TextView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
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
    	
    		
    	
    	
    	/* ProcessBuilder processBuilder = new ProcessBuilder();
         // Windows
         processBuilder.command("cmd.exe", "/C", "cmd.exe\", \"/C\", \"adb shell \\\" cat /system/build.prop |grep ro.build.version.release\\\"");
        // processBuilder.command("cmd.exe", "/C","dumpsys window windows | grep -E 'mCurrentFocus'"); //"netstat -ano | find \" :4723\" ");

         try {

             Process process = processBuilder.start();

             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(process.getInputStream()));

             String line;
             while ((line = reader.readLine()) != null) {
            	 
                 System.out.println(line);
                 
                 if(!line.startsWith("List"))
                 {
                	 String s=line.replace("device", "");
                    
                     System.out.println(s);
                     
                	
                 }
                 
                
             }

             int exitCode = process.waitFor();
            
         } catch (IOException e) {
             e.printStackTrace();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
    	*/
    	
    	
    	
    	 /*try {  
    	      String line;  
    	      Process p = Runtime.getRuntime().exec("netstat -ano | find \" :4723\" ");  
    	      BufferedReader input =  
    	        new BufferedReader  
    	          (new InputStreamReader(p.getInputStream()));  
    	      while ((line = input.readLine()) != null) {  
    	        System.out.println(line);  
    	      }  
    	      input.close();  
    	    }  
    	    catch (Exception err) {  
    	      err.printStackTrace();  
    	    }  */
    }
}
