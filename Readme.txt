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

C:\>adb shell "dumpsys window windows | grep -E 'mCurrentFocus'"

1|root@generic:/ # dumpsys window windows | grep -E 'mCurrentFocus'

  mCurrentFocus=Window{a619a9e8 u0 com.example.android.apis/com.example.android.apis.ApiDemos}
root@generic:/ #

=====================================

Error obtaining UI hierarchy

Reason:
Error while obtaining UI hierarchy XML file: com.android.ddmlib.SyncException:
Remote object doesn't exist!'

Method -1

Solution:
Go to command prompt, kill the server and start the server..
$ adb kill-server
$ adb start-server

Other way Method -2

This is what I’ve been doing:

Save the following commands as a batch or shell script.
adb shell uiautomator dump
adb pull /sdcard/window_dump.xml ui.uix
adb shell screencap -p /sdcard/ui.png
adb pull /sdcard/ui.png .

Run the script. It will generate ‘ui.uix’ and ‘ui.png’ files in current directory.
Load the ‘ui.uix’ and ‘ui.png’ files into ui automator viewer by clicking ‘Open’ button.
===========================================
Gennymotion emulator :
1)	Open Genymotion shell and type below:
Genymotion Shell > devices list
Available devices:

 Id | Select |    Status     |   Type   |   IP Address    |      Name
----+--------+---------------+----------+-----------------+---------------
  0 |    *   |            On |  virtual | 192.168.111.102 | Samsung Galaxy S9 - 8.0 - API 26 - 1440x2960
2)	Open cmd prompt:
3)	adb connect 192.168.111.102:5555
4)	adb devices
==================================================
To list packages of installed apps in the connected device:
adb shell "pm list packages |grep io.selendroid.testapp"

To see the activty of the package:
adb shell "pm list packages |grep io.selendroid.testapp"

==============================================
To pull apk from real device and install in emualator in cmd:

1)List packages of the apps in real device
adb shell pm list packages

2)select one package of target app and write below command:
adb shell pm path com.truecaller

3)Now the beow command copies the apk file from real device location to local path of system
adb pull /data/app/com.truecaller-j_ZGUUrr21ZQ8RW3Y4vHEg==/base.apk  C:\eclipse-WS\com.appium\apk

4)Disconnect the real device and enter below command
adb install C:\eclipse-WS\com.appium\apk\base.apk


====================================================

Code for starting Appium server with free port
/*AppiumDriverLocalService service =AppiumDriverLocalService.buildService( new
			      AppiumServiceBuilder().usingDriverExecutable(new File(
			      "C:\\Program Files\\nodejs\\node.exe")) .withAppiumJS(new File(
			      "C:\\Users\\Sajindra Prasad\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"
			      )) .withIPAddress("127.0.0.1").usingAnyFreePort());
		*/
		
======================================
