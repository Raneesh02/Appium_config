package appiumtestproj.uniqueproj;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
 
public class AppiumTest {
	public static void main(String[] args) throws InterruptedException {
		AppiumDriver<MobileElement> driver = null;
			
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "bc72de490304"); //Give Device ID of your mobile phone
		//caps.setCapability("udid", "192.168.2.4:5555"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.0");
		caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
//		caps.setCapability("appPackage", "com.android.chrome");
//		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", "true");
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("androidPackage", "com.android.chrome");
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		//Instantiate Appium Driver
		try {
				driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		
		//Added 10 seconds wait so that the app loads completely before starting with element identification
					//Thread.sleep(10000);
				
		//		Will return NATIVE_APP, WEBVIEW_chrome
				System.out.println("Context Handles: "+driver.getContextHandles()+"Size: "+driver.getContextHandles().size());
				driver.context("CHROMIUM");
				System.out.println(driver.getContext()+"Window Handles"+driver.getWindowHandles());
				driver.get("https://www.bing.com");
				System.out.println(driver.getTitle());
				driver.findElementByXPath("//input[@id='sb_form_q']").sendKeys("Fucker Opened");
				Thread.sleep(3000);
				driver.quit();
	}
 
}