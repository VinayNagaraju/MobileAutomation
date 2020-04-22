import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class gestures extends base {

    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        //Touch Class
        TouchAction t = new TouchAction(driver);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement expandList = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
        t.tap(tapOptions().withElement(element(expandList))).perform();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
        //Create a Web Element with Xpath
        WebElement pn= driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
        //Long Press a Button
        t.longPress(longPressOptions().withElement(element(pn)).withDuration(ofSeconds(2))).release().perform();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.out.println(driver.findElementById("android:id/title").isDisplayed());

    }
}
