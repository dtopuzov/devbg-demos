package pages.selendroid;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Progress dialog component of Selendoid test app.
 */
public class ProgressDialog {
    private AppiumDriver driver;

    @FindBy(className = "android.widget.ProgressBar")
    private MobileElement progressBar;

    public ProgressDialog(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
        Assert.assertTrue(this.progressBar.isDisplayed());
    }

    public void waitUntilDisappear() {
        new WebDriverWait(this.driver, 30)
                .until(ExpectedConditions
                        .invisibilityOfElementLocated(By.className("android.widget.ProgressBar")));
    }
}
