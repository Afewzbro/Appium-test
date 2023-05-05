import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class AndroidSampleTest {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        System.setProperty("appium.debug.log.level", "debug");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554")
                .setPlatformVersion("12.0")
                .setAppPackage("com.saucelabs.mydemoapp.rn")
                .setAppActivity(".MainActivity");
//                .setApp()
//                .setNoReset(true)
        AppiumDriver driver = new AndroidDriver(new URL ( "http://127.0.0.1:4723/wd/hub"), options);

        driver.findElement(AppiumBy.accessibilityId("open menu")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("menu item log in")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("bob@example.com");

        driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");
        driver.findElement(AppiumBy.accessibilityId("Login button")).click();

        Thread.sleep(3000);
        driver.quit();



    }
}
