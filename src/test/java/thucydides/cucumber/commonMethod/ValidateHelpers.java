package thucydides.cucumber.commonMethod;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class ValidateHelpers extends PageObject {

    private WebDriver driver;
    public WebDriverWait wait;
    private final int timeoutWaitForPageLoaded = 20;


    public void setText(WebElement element, String value ){
        //sendKey một giá trị là value cho element truyền vào
        element.sendKeys(value);

    }

    public void clickElement(WebElement element){
        //click vào một phần từ element truyền vào
        element.click();
    }

    public void getErrorMsg(WebElement element, String message){
        String strErrorMsg = element.getText();
        Assert.assertEquals(strErrorMsg, message);
    }

    public void getTitle(WebElement element, String message){
        String strTitle = element.getText();
        Assert.assertEquals(strTitle, message);
    }

    public void verifyTrue (WebElement element, String message){
        String strTitle = element.getText();
        Assert.assertTrue(strTitle.contains(message));
    }

    public void verifyRadioBtn(WebElement element){
        Assert.assertTrue(element.isSelected());
    }

    public void verifyDisplayedTrue(WebElement element){
        Assert.assertTrue(element.isDisplayed());
    }

    public void verifyDisplayedFalse(WebElement element){
        Assert.assertFalse(element.isDisplayed());
    }

    public void exceptionFalse(WebElement element, String message){
        try {
            Assert.assertFalse(element.isDisplayed());
        }
        catch (NoSuchElementException e) {
            throw new RuntimeException(message);
        }
    }
}
