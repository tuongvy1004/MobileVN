package thucydides.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import thucydides.cucumber.commonMethod.ValidateHelpers;
import thucydides.cucumber.pages.CartPage;
import thucydides.cucumber.pages.HomePage;
import org.junit.Assert;
import thucydides.cucumber.pages.LoginPage;
import thucydides.cucumber.pages.SearchPage;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class AddToCartSteps extends PageObject {
    HomePage homePage;
    ValidateHelpers validateHelpers;
    CartPage cartPage;
    LoginPage loginPage;
    int numberOfProduct = 9;
    SearchPage searchPage;

    @Given("^I am on the Home page$")
    public void iAmOnTheHomePage() throws InterruptedException {
        homePage.openHomePage();

    }

    @When("^I click the 'Thêm vào giỏ' button$")
    public void iClickTheThêmVàoGiỏButton() {
        validateHelpers.clickElement(homePage.btnAddToCart);
    }

    @Then("^The product is added successfully$")
    public void theProductIsAddedSuccessfully() {
        validateHelpers.verifyDisplayedTrue(homePage.imgProduct);
    }

    @Then("^The product price is displayed correctly in the cart$")
    public void theProductPriceIsDisplayedCorrectlyInTheCart() {
        // get price
        String strPrice = homePage.priceProduct.getTextValue();
        String[] arr = strPrice.split(" ");
        String price = arr[1];

        assertEquals(price, cartPage.priceProduct.getTextValue());
    }

    @Then("^The product name is displayed correctly in the cart$")
    public void theProductNameIsDisplayedCorrectlyInTheCart() throws InterruptedException {
        assertEquals(homePage.nameProduct.getTextValue(),cartPage.nameProduct.getTextValue());
    }

    @And("^I select the amount of product$")
    public void iSelectTheAmountOfProduct() throws InterruptedException {
        Thread.sleep(2000);
        Select select = new Select(cartPage.ddlAmount);
        select.selectByValue(String.valueOf(numberOfProduct));
    }


    @Then("^The amount and price of product is displayed correctly$")
    public void theAmountAndPriceOfProductIsDisplayedCorrectly() throws ParseException {
        String strPrice = cartPage.priceProduct.getTextValue();

        String[] arr = strPrice.split("đ");
        String price2 = arr[0];
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        Number parsedNumber = numberFormat.parse(price2);

        Number total1 = numberOfProduct* parsedNumber.intValue()*(1-0.1);
        Number parsedTotal1 = numberFormat.parse(String.valueOf(total1));

        String strTotal = cartPage.totalProduct.getTextValue();
        String[] arr2 = strTotal.split("đ");
        String total2 = arr2[0];
        Number parsedTotal2 = numberFormat.parse(total2);

        Assert.assertEquals(parsedTotal1, parsedTotal2);
    }

    @When("^I check product price$")
    public void iCheckProductPrice() throws InterruptedException {
        searchPage.tbxSearch.click();
        validateHelpers.setText(searchPage.tbxSearch2,"le");
        Thread.sleep(2000);
        searchPage.testProduct.click();
    }

    @Then("^The price must be a positive number$")
    public void thePriceMustBeAPositiveNumber() throws ParseException {
        String strPrice = cartPage.testPrice.getTextValue();
        String[] arr = strPrice.split(" ");
        String testPrice = arr[1];
        String[] arr2 = testPrice.split("đ");
        String testPrice2 = arr2[0];

        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        Number parsedNumber = numberFormat.parse(testPrice);
        System.out.println(parsedNumber);
        Assert.assertTrue(parsedNumber.intValue()>0);
    }


    @And("^I click the Delete icon$")
    public void iClickTheDeleteIcon() {
        cartPage.deleteIcon.click();
    }

    @Then("^The product is not displayed in cart$")
    public void theProductIsNotDisplayedInCart() {
        validateHelpers.getTitle(cartPage.txtEmpty, "Vui lòng chọn sản phẩm");
    }

    @And("^I choose another product$")
    public void iChooseAnotherProduct() throws InterruptedException {
        Thread.sleep(2000);
        validateHelpers.clickElement(cartPage.btnPurchase);
    }

    @Then("^I check total amount of the order is displayed correctly$")
    public void iCheckTotalAmountOfTheOrderIsDisplayedCorrectly() throws InterruptedException, ParseException {
        validateHelpers.clickElement(homePage.btnAdd3);
        Thread.sleep(2000);

        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        String strPrice1 = cartPage.price1.getTextValue();
        String[] arr1 = strPrice1.split("đ");
        String price1 = arr1[0];
        Number parsedPrice1 = numberFormat.parse(price1);

        String strPrice2 = cartPage.price2.getTextValue();
        String[] arr2 = strPrice2.split("đ");
        String price2 = arr2[0];
        Number parsedPrice2 = numberFormat.parse(price2);

        Number total12 = parsedPrice1.intValue() + parsedPrice2.intValue();
        Number parsedTotal12 = numberFormat.parse(String.valueOf(total12));

        String strTotal = cartPage.totalPrice.getTextValue();
        String[] arr3 = strTotal.split("đ");
        String total = arr3[0];
        Number parsedTotal = numberFormat.parse(total);

        Assert.assertEquals(parsedTotal12, parsedTotal);

    }




}
