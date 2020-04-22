import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.net.MalformedURLException;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class gestures extends base {

    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.findElementByXPath("//android.widget.TextView[@text='views']").click();
        //Touch Class
        TouchActions t=new TouchActions(driver);

        WebElement expandList= driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists')");
        t.singleTap((WebElement) tapOptions().withElement(element(expandList))).perform();
        driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter')").click();
        WebElement pn= driver.findElementByXPath("//android.widget.TextView[@text='People Name')");
        t.longPress((WebElement) longPressOptions().withElement(element(pn)).withDuration(ofSeconds(2))).release().perform();




    }
}
