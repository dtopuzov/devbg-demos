package pages.uicatalog;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

/**
 * UI Catalog app home page.
 */
public class HomePage {
    private IOSDriver driver;

    public HomePage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public boolean loaded() {
        // TODO (dtopuzov): Re-write it!
        if (this.driver.findElements(By.className("XCUIElementTypeCell")).size() > 5) {
            return true;
        } else {
            return false;
        }
    }

    public void navigateToDemo(String demoName) {
        IOSElement button = (IOSElement) this.driver.findElement(By.name(demoName));
        this.driver.performTouchAction(new TouchAction(this.driver).tap(button));
    }
}
