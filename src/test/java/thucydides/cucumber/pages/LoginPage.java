package thucydides.cucumber.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    // 1. Locators:
    @FindBy(css = "div[class='col-sm-4 col-md-3 col-lg-3 login-top'] a[class='btn btn-default']")
    public WebElementFacade iconUser;

    @FindBy(css = "#e_p_lg")
    public WebElementFacade tbxEmail;

    @FindBy(css = "#pass_lg")
    public WebElementFacade tbxPassword;

    @FindBy(xpath="//input[@id='submit_lg']")
    public WebElementFacade btnLogin;

    @FindBy(css=".alert.alert-danger.alert-dismissable")
    public WebElementFacade errInvalidPassword;

    @FindBy(css="i[class='text-danger']")
    public WebElementFacade errPassword;

    @FindBy(css="#e_p_e_lg .text-danger")
    public WebElementFacade errEmail;

//    @FindBy(css="#e_p_e_lg .text-danger")
//    public WebElementFacade errEmail;
//
//    @FindBy(css="#e_p_e_lg .text-danger")
//    public WebElementFacade errEmail;


}
