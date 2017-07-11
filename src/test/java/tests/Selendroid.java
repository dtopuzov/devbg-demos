package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.selendroid.HomePage;
import pages.selendroid.ProgressDialog;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

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

    @BeforeMethod
    public void beforeMethod() {
        this.driver.resetApp();
        if (this.driver.getOrientation() != ScreenOrientation.PORTRAIT) {
            this.driver.rotate(ScreenOrientation.PORTRAIT);
        }
    }

    @Test
    public void checkBox() {
        HomePage seleniumDemo = new HomePage(this.driver);
        seleniumDemo.tapCheckBox();
        Assert.assertEquals(seleniumDemo.isChecked(), false, "Checkbox is still checked.");
        seleniumDemo.tapCheckBox();
        Assert.assertEquals(seleniumDemo.isChecked(), true, "Checkbox is unchecked.");
    }

    @Test
    public void progressDialog() {
        HomePage seleniumDemo = new HomePage(this.driver);
        ProgressDialog dialog = seleniumDemo.tapShowProgressBar();
        dialog.waitUntilDisappear();
    }

    @Test
    public void rotate() throws InterruptedException {
        HomePage seleniumDemo = new HomePage(this.driver);
        Assert.assertEquals(seleniumDemo.isChecked(), true, "Checkbox is unchecked.");
        this.driver.rotate(ScreenOrientation.LANDSCAPE);
        Thread.sleep(5000);
        Assert.assertEquals(seleniumDemo.isChecked(), true, "Checkbox is unchecked.");
    }
}
