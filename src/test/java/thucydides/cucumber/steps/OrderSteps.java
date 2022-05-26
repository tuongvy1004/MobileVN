package thucydides.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import thucydides.cucumber.commonMethod.ValidateHelpers;
import thucydides.cucumber.pages.CartPage;
import thucydides.cucumber.pages.HomePage;
import thucydides.cucumber.pages.LoginPage;
import thucydides.cucumber.pages.OrderPage;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class OrderSteps extends PageObject {
    OrderPage orderPage;
    CartPage cartPage;
    ValidateHelpers validateHelpers;
    LoginPage loginPage;
    HomePage homePage;
    int numberOfProduct = 2;

    @And("^I click the 'Đặt hàng ngay' button$")
    public void iClickTheĐặtHàngNgayButton() throws InterruptedException {
        Thread.sleep(2000);

        validateHelpers.clickElement(cartPage.btnOrder);
        orderPage.linkLogin.click();
        validateHelpers.setText(loginPage.tbxEmail, "jenny33@yopmail.com");
        validateHelpers.setText(loginPage.tbxPassword, "Hananhh@10");
        loginPage.btnLogin.click();
        loginPage.btnLogin.click();
        Thread.sleep(2000);

    }
    @And("^I order product$")
    public void iOrderProduct() throws InterruptedException {

        validateHelpers.clickElement(homePage.btnAddToCart);
        Thread.sleep(2000);
        validateHelpers.clickElement(cartPage.btnOrder);
    }
    @Then("^The \"([^\"]*)\" popup appears$")
    public void thePopupAppears(String title)  {
        validateHelpers.getTitle(orderPage.txtOrder, title);
    }


    @And("^I click the 'Thanh toán' button$")
    public void iClickTheThanhToánButton() {
        validateHelpers.clickElement(orderPage.btnPayment);
        validateHelpers.clickElement(orderPage.btnPayment);

    }

    @Then("^The \"([^\"]*)\" popup is displayed$")
    public void thePopupIsDisplayed(String title) {
        validateHelpers.getTitle(orderPage.txtOrderSuccess, title);
    }

    @And("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterAnd(String address, String passWord) {
        validateHelpers.setText(orderPage.tbxAddress, address);
        validateHelpers.setText(orderPage.tbxPassword,passWord);
    }

    @Then("^The error message \"([^\"]*)\" is shown next to 'Mật khẩu' label$")
    public void theErrorMessageIsShownNextToMậtKhẩuLabel(String message){
        validateHelpers.getTitle(orderPage.errPassword,message);
    }


    @And("^I enter \"([^\"]*)\"$")
    public void iEnter(String password) {
        validateHelpers.setText(orderPage.tbxPassword, password);
    }


    @Then("^The \"([^\"]*)\" error message is shown next to 'Mật khẩu' field$")
    public void theErrorMessageIsShownNextToMậtKhẩuField(String message) throws Throwable {
       validateHelpers.getErrorMsg(orderPage.errPassword,message );
    }

    @And("^I choose number two in 'Số lượng' dropdown$")
    public void iChooseNumberTwoInSốLượngDropdown() {
        Select select = new Select(cartPage.ddlAmount);
        select.selectByValue(String.valueOf(numberOfProduct));
    }

    @Then("^The total price in cart is equal to total price in order$")
    public void theTotalPriceInCartIsEqualToTotalPriceInOrder() throws ParseException, InterruptedException {
        validateHelpers.clickElement(homePage.btnAddToCart);
        Thread.sleep(2000);
        String strTotal1 = cartPage.totalInCart.getTextValue();
        System.out.println(strTotal1);
        validateHelpers.clickElement(cartPage.btnOrder);
        String strTotal2 = orderPage.totalInOrder.getTextValue();
        System.out.println(strTotal2);

        Assert.assertEquals(strTotal1, strTotal2);

    }

    @And("^I clear data in all fields$")
    public void iClearDataInAllFields() {
        orderPage.tbxName.clear();
    }

    @Then("^The error message is shown$")
    public void theErrorMessageIsShown() {
        validateHelpers.verifyDisplayedTrue(orderPage.errName);
    }

    @And("^I clear data in Address field and enter \"([^\"]*)\"$")
    public void iClearDataInAddressFieldAndEnter(String address)  {
        orderPage.tbxAddress.clear();
        validateHelpers.setText(orderPage.tbxAddress, address);
    }


    @Then("^The error message \"([^\"]*)\" is shown next to 'Địa chỉ' label$")
    public void theErrorMessageIsShownNextToĐịaChỉLabel(String message)  {
        validateHelpers.getErrorMsg(orderPage.errAddress, message);
    }
}
