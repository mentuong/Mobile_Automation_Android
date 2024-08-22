package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class BaseTest {
    public static void main(String[] args) {
        try{
//Driver instance
            AppiumDriver<MobileElement> appiumDriver;

            //set desireCapabilities to send to Appium sever
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
            desiredCapabilities.setCapability("appPackage", "com.wdiodemoapp");
            desiredCapabilities.setCapability("appActivity", "com.wdiodemoapp.MainActivity");

            //Setup Appium sever URL to connect
            URL appiumServer = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new AppiumDriver<>(appiumServer, desiredCapabilities);
            appiumDriver.findElementByXPath("//android.widget.TextView[@text=\"Swipe\"]").click();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
