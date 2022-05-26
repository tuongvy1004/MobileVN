package thucydides.cucumber.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends PageObject {
    @FindBy(css = "#order_success")
    public WebElementFacade btnPayment;

    @FindBy(css="#password_od")
    public WebElementFacade tbxPassword;


    @FindBy(xpath="//h1[contains(text(),'Đặt hàng thành công')]")
    public WebElementFacade txtOrderSuccess;

    @FindBy(xpath="//h4[contains(text(),'Đặt Hàng')]")
    public WebElementFacade txtOrder;

    @FindBy(xpath="//a[contains(text(),'Click vào đây để đăng nhập')]")
    public WebElementFacade linkLogin;

    @FindBy(xpath="//input[@id='address_od']")
    public WebElementFacade tbxAddress;

    @FindBy(css="i[class='text-danger']")
    public WebElementFacade errPassword;

    @FindBy(css="span[class=' text-danger ']")
    public WebElementFacade totalInOrder;

    @FindBy(xpath="//input[@id='name_od']")
    public WebElementFacade tbxName;

    @FindBy(xpath = "//i[contains(text(),'Họ và tên không được để trống')]")
    public WebElementFacade errName;

    @FindBy(css ="#address_e_od .text-danger")
    public WebElementFacade errAddress;
}
