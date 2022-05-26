package thucydides.cucumber.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageObject {
    @FindBy(css="input[placeholder='Bạn cần tìm sản phẩm nào?']")
    public WebElementFacade tbxSearch;

    @FindBy(xpath = "//input[@id='search']")
    public WebElementFacade tbxSearch2;

    @FindBy(css = "#search_show .search_main:nth-child(5) label a")
    public WebElementFacade testProduct;

    @FindBy(css=".text-primary.font-150")
    public WebElementFacade nameProduct;

    @FindBy(css="div[id='search_show'] h5")
    public WebElementFacade msgNoResult;

    @FindBy(xpath="//a[contains(text(),'samsung A24')]")
    public WebElementFacade samsung;


}
