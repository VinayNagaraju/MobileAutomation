import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class base {

    public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
        AndroidDriver<AndroidElement> driver;
        File f=new File("src");
        File fs=new File(f,"original.apk");

        //Creating the Desired Capabilities to start the mobile automation
        DesiredCapabilities cap=new DesiredCapabilities();
        //Adding desired mobile device to capabilities
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "ONEPLUS A6000");
        //Access Android Element
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        //Adding desired App to capabilities, Used File Method to provide path of app
        cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        //Creating the Android Driver to connect to APPIUM server
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
