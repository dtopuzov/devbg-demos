package pages.google;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Home page of www.google.com.
 */
public class HomePage {

    private AppiumDriver driver;
    private String url = "http://www.google.com";

    @FindBy(id = "lst-ib")
    public WebElement searchBox;

    @FindBy(id = "tsbb")
    public WebElement searchButton;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        this.driver.get(this.url);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public HomePage verifyLinkExist(String linkText) {
        WebElement link = this.driver.findElement(By.xpath("//a[@href='" + linkText + "']"));
        Assert.assertTrue(link.isDisplayed(), linkText + " is not visible.");
        return this;
    }

    public HomePage searchFor(String searchTerm) {
        this.searchBox.sendKeys(searchTerm);
        this.searchButton.click();
        return this;
    }
}
