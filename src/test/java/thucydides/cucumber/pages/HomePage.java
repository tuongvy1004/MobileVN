package thucydides.cucumber.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://14.176.232.213/mobilevn/index.php")
public class HomePage extends PageObject {

    @FindBy(css = "button[title='2'] span[class='cart']")
    public WebElementFacade btnAddToCart;

    @FindBy(xpath = "//tbody/tr[1]/td[1]/img[1]")
    public WebElementFacade imgProduct;

    @FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/p[1]")
    public WebElementFacade priceProduct;

    @FindBy(css = ".best-seller .col-xs-6:nth-child(1) .products-content-label a p")
    public WebElementFacade nameProduct;

    @FindBy(css = "button[title='3']")
    public WebElementFacade btnAdd3;

    @FindBy(xpath = "//button[@aria-expanded='true']")
    public WebElementFacade ddlExit;

    @FindBy(css = "div[class='btn-group open'] a[class='logout']")
    public WebElementFacade btnLogout;

    @FindBy(css = "div[class='col-sm-4 col-md-3 col-lg-3 login-top'] div[class='btn-group'] div[class='btn-group'] a[class='btn btn-default']")
    public WebElementFacade btnLogin;



    public void openHomePage(){
        open();
    }
}
