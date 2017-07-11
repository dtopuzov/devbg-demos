package tests;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.uicatalog.ButtonsPage;
import pages.uicatalog.HomePage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Tests for UICatalog iOS application.
 */
public class UICatalog {
    private IOSDriver driver;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "testapps");
        File app = new File(appDir, "UICatalog.app.zip");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        this.driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod() {
        this.driver.resetApp();
    }

    @Test
    public void buttonsPage() {
        HomePage homePage = new HomePage(this.driver);
        homePage.navigateToDemo("Buttons");
        ButtonsPage buttonsPage = new ButtonsPage(this.driver);
        buttonsPage.navigateBack();
        Assert.assertTrue(homePage.loaded(), "Home page not loaded!");
    }

    @Test
    public void runInBackground() {
        HomePage homePage = new HomePage(this.driver);
        Assert.assertTrue(homePage.loaded());
        this.driver.runAppInBackground(10);
        Assert.assertTrue(homePage.loaded());
    }
}
