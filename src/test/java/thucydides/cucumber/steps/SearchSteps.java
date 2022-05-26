package thucydides.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import thucydides.cucumber.commonMethod.ValidateHelpers;
import thucydides.cucumber.pages.SearchPage;

public class SearchSteps extends PageObject {
    SearchPage searchPage;
    ValidateHelpers validateHelpers;

    @And("^I click the Search text box$")
    public void iClickTheSearchTextBox() {
        validateHelpers.clickElement(searchPage.tbxSearch);
        validateHelpers.clickElement(searchPage.tbxSearch2);
    }

    @And("^I enter valid \"([^\"]*)\"$")
    public void iEnterValid(String data) {
       validateHelpers.setText(searchPage.tbxSearch2, data);
       validateHelpers.clickElement(searchPage.testProduct);
    }

    @Then("^The product is shown$")
    public void theProductIsShown() {
        validateHelpers.verifyDisplayedTrue(searchPage.nameProduct);
    }

    @And("^I enter invalid \"([^\"]*)\"$")
    public void iEnterInvalid(String data) {
        validateHelpers.setText(searchPage.tbxSearch2, data);
    }


    @Then("^The \"([^\"]*)\" message is show below the Search textbox$")
    public void theMessageIsShowBelowTheSearchTextbox(String message) {
        validateHelpers.getErrorMsg(searchPage.msgNoResult, message);
    }

    @And("^I enter \"([^\"]*)\" in the Search textbox$")
    public void iEnterInTheSearchTextbox(String number) throws Throwable {
        validateHelpers.setText(searchPage.tbxSearch2, number);
    }


    @Then("^The products contain \"([^\"]*)\" characters are shown$")
    public void theProductsContainCharactersAreShown(String number){
        Assert.assertTrue(searchPage.samsung.getText().contains(number));
    }
}
