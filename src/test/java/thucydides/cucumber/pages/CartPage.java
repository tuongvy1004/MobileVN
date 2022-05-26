package thucydides.cucumber.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageObject {
    @FindBy(xpath = "//label[contains(text(),'5,355,350đ')]")
    public WebElementFacade priceProduct;

    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    public WebElementFacade nameProduct;

    @FindBy(xpath = "//select[@id='2']")
    public WebElementFacade ddlAmount;

    @FindBy(xpath = "//label[contains(text(),'43,378,335đ')]")
    public WebElementFacade totalProduct;

    @FindBy(css = ".price-new")
    public WebElementFacade testPrice;

    @FindBy(css = "span[title='2']")
    public WebElementFacade deleteIcon;

    @FindBy(css="tbody tr:nth-child(1)")
    public WebElementFacade product;

    @FindBy(xpath = "//h1[contains(text(),'Vui lòng chọn sản phẩm')]")
    public WebElementFacade txtEmpty;

    @FindBy(css="button[class='btn btn-success btn-block btn-lg']")
    public WebElementFacade btnPurchase;

    @FindBy(xpath="//label[contains(text(),'4,819,815đ')]")
    public WebElementFacade price1;

    @FindBy(xpath="//label[contains(text(),'45,504đ')]")
    public WebElementFacade price2;

    @FindBy(css="label[class='font-150 pull-right toal_money'] span[class='text-danger']")
    public WebElementFacade totalPrice;

    @FindBy(xpath="//button[@id='order_product']")
    public WebElementFacade btnOrder;

    @FindBy(css="label[class='font-150 pull-right toal_money'] span[class='text-danger']")
    public WebElementFacade totalInCart;

}
