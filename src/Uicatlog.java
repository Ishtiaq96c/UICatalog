
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Duration;

public class Uicatlog {
public IOSDriver driver;

@Before
public void setup() throws MalformedURLException

	{
		File app = new File("/Users/air/Desktop/UICatalog.app");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath()); 

		driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
	}
@Test

public void scrollToDirection_iOS_XCTest() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	HashMap<String, String> swipeObject = new HashMap<String, String>();
	
	 swipeObject.put("direction", "down"); //up for swipe
     swipeObject.put("startX", "90");
     swipeObject.put("startY", "100");
     swipeObject.put("endX", "90"); //"90");
     swipeObject.put("endY", "100"); //"200");
     swipeObject.put("duration", "50");
     //js.executeScript("mobile: swipe", swipeObject); 
     js.executeScript("mobile: scroll", swipeObject);
     
     String XpathElement = "//XCUIElementTypeApplication[@name='UICatalog']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeSwitch";
     
     driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\'Switches\']")).click();
     String valueBefore= driver.findElement(By.xpath(XpathElement)).getAttribute("value");
     // System.out.println(driver.findElement(By.xpath(XpathElement)).getAttribute("value"));
   System.out.println(valueBefore);
     
     driver.findElement(By.xpath(XpathElement)).click();
     String ValueAfter=driver.findElement(By.xpath(XpathElement)).getAttribute("value");
    // System.out.println(driver.findElement(By.xpath(XpathElement)).getAttribute("value"));
     System.out.println(ValueAfter);
     if (ValueAfter == "1")
     {
    	 System.out.println("The Button is ON");
     }
     else {
    	 System.out.println("The Button is OFF");
     }
     
     

}

//@Test
public void switches()
{
	String pickerView = "//XCUIElementTypeStaticText[@name=\'Picker View\']";
	String pickWheel = "//XCUIElementTypePickerWheel[@name=\'Green color component value\']";
	driver.findElement(By.xpath(pickerView)).click();
    System.out.println(driver.findElement(By.xpath(pickWheel)).getAttribute("value"));
	driver.findElement(By.xpath(pickWheel)).sendKeys("250");
	System.out.println(driver.findElement(By.xpath(pickWheel)).getAttribute("value"));
	
	
	//XCUIElementTypePickerWheel
	
	
}





//@Test
//public void switches()
//{
//
//	//driver.scrollTo("Switches");
//	//driver.
//	driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\'Buttons\']")).click();
//	//XCUIElementTypeStaticText[@name="Switches"]
//	//driver.findElement(By.xpath("//XCUIElementTypeApplication[@name="UICatalog"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeSwitch")).click();
//	
//
//	
//}

}
