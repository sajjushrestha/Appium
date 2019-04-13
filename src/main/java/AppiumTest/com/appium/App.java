package AppiumTest.com.appium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	
    	 ProcessBuilder processBuilder = new ProcessBuilder();
         // Windows
         processBuilder.command("cmd.exe", "/C", "ping -n 3 google.com"); //"netstat -ano | find \" :4723\" ");

         try {

             Process process = processBuilder.start();

             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(process.getInputStream()));

             String line;
             while ((line = reader.readLine()) != null) {
                 System.out.println(line);
             }

             int exitCode = process.waitFor();
             System.out.println("\nExited with error code : " + exitCode);

         } catch (IOException e) {
             e.printStackTrace();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
    	
    	
    	
    	
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
