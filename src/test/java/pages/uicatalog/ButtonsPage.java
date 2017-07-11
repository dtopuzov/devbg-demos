package pages.uicatalog;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

/**
 * Buttons page of UICatalog applications
 */
public class ButtonsPage {
    private AppiumDriver driver;

    public ButtonsPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void navigateBack() {
        this.driver.navigate().back();
    }
}
