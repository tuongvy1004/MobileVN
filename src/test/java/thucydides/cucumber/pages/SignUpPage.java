package thucydides.cucumber.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import thucydides.cucumber.commonMethod.ValidateHelpers;

public class SignUpPage extends PageObject {

    @FindBy(xpath = "//a[contains(text(),'Đăng ký tài khoản mới')]")
    public WebElement linkSignUp;

    @FindBy (css = "div[id='register'] h4[class='modal-title']")
    public WebElement titleSignUp;

    @FindBy (css = "div[id='register'] div[class='modal-content']")
    public WebElement popupSignUp;

    @FindBy (xpath = "//header/div[1]/div[1]/div[1]/div[1]/a[1]")
    public WebElement logo;

    @FindBy(id = "name_rg")
    public WebElement tbxFullName;

    @FindBy(id = "email_rg")
    public WebElement tbxEmail;

    @FindBy(id = "phone_rg")
    public WebElement tbxPhoneNumber;

    @FindBy(id = "pass_rg")
    public WebElement tbxPassword;

    @FindBy(id = "c_pass_rg")
    public WebElement tbxConfirmPass;


    @FindBy(xpath = "//input[@id='submit_rg'][@type='button']")
    public WebElement btnSubmit;

    @FindBy(xpath = "//input[@id='submit_rg']")
    public WebElement btnClick;


    //error msg
    @FindBy (css ="span[id='name_e_rg'] i[class='text-danger']")
    public WebElement errFullName;

    @FindBy (css = "span[id='email_e_rg'] i[class='text-danger']")
    public WebElement errEmail;

    @FindBy (css = "span[id='phone_e_rg'] i[class='text-danger']")
    public WebElement errSDT;

    @FindBy (css = "span[id='pass_e_rg'] i[class='text-danger']")
    public WebElement errPassword;

    @FindBy (css = "span[id='c_pass_e_rg'] i[class='text-danger']")
    public WebElement errConfirmPassword;


    public void signup(String fullName, String email, String phoneNumber, String password, String confirmPassword){
        tbxFullName.sendKeys(fullName);
        tbxEmail.sendKeys(email);
        tbxPhoneNumber.sendKeys(phoneNumber);
        tbxPassword.sendKeys(password);
        tbxConfirmPass.sendKeys(confirmPassword);
    }
}
