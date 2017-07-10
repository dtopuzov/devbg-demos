package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Tests for Selendroid application.
 */
public class Selendroid {

    private AndroidDriver driver;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "testapps");
        File app = new File(appDir, "selendroid-test-app-0.11.0.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        this.driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void smokeTest(){

    }
    @Test
    public void rotate() {

    }

    @Test
    public void runInBackground() {

    }
}
