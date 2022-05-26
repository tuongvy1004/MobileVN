package thucydides.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Keys;
import thucydides.cucumber.commonMethod.ValidateHelpers;
import thucydides.cucumber.pages.HomePage;
import thucydides.cucumber.pages.LoginPage;
import thucydides.cucumber.pages.SignUpPage;
import thucydides.cucumber.utils.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SignUpSteps extends PageObject {

    HomePage homePage;
    ValidateHelpers validateHelpers;
    LoginPage loginPage;
    SignUpPage signUpPage;


    @Given("I am on the Home page and click the User icon")
    public void iAmOnTheHomePageAndClickTheUserIcon() throws InterruptedException {
        homePage.openHomePage();
        validateHelpers.clickElement(loginPage.iconUser);
        Thread.sleep(2000);
    }


    @When("^I click the Sign up link$")
    public void iClickTheSignUpLink() {
        validateHelpers.clickElement(signUpPage.linkSignUp);

    }

    @Then("^The Sign up popup appears with title \"([^\"]*)\"$")
    public void theSignUpPopupAppearsWithTitle(String title) throws InterruptedException {
        Thread.sleep(2000);
        validateHelpers.getTitle(signUpPage.titleSignUp, title);
        Thread.sleep(2000);
    }

    @And("^I enter valid inputs \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void iEnterValidInputs(String fullName, String email, String phoneNumber, String password, String confirmPassword) {
        signUpPage.signup(fullName, email, phoneNumber, password, confirmPassword);
    }

    @And("^I click the Sign up button$")
    public void iClickTheSignUpButton() throws InterruptedException {
        signUpPage.btnSubmit.submit();
    }

    @Then("^The Sign up popup disappears$")
    public void theSignUpPopupDisappears() throws InterruptedException {
        validateHelpers.verifyDisplayedTrue(signUpPage.logo);
    }


    @And("^I click on the Sign up button$")
    public void iClickOnTheSignUpButton() throws InterruptedException {
        Thread.sleep(1000);
        signUpPage.btnClick.click();
    }

    @Then("^The error message \"([^\"]*)\" is shown next to the full name label$")
    public void theErrorMessageIsShownNextToTheFullNameLabel(String message) throws InterruptedException {
//        Thread.sleep(1000);
        validateHelpers.getErrorMsg(signUpPage.errFullName, message);
    }

    @And("^I enter \"([^\"]*)\" less than six characters$")
    public void iEnterLessThanSixCharacters(String fullName) throws Throwable {
        validateHelpers.setText(signUpPage.tbxFullName, fullName);
    }

    @And("^I enter spaces in the full name field$")
    public void iEnterSpacesInTheFullNameField() {
        validateHelpers.setText(signUpPage.tbxFullName, Keys.chord(Keys.SPACE,Keys.SPACE,Keys.SPACE,Keys.SPACE));
    }

    @And("^I enter \"([^\"]*)\" in the wrong format$")
    public void iEnterInTheWrongFormat(String email) {
        validateHelpers.setText(signUpPage.tbxEmail, email);
    }

    @Then("^The error message \"([^\"]*)\" is shown next to the email label$")
    public void theErrorMessageIsShownNextToTheEmailLabel(String message) {
        validateHelpers.getErrorMsg(signUpPage.errEmail, message);
    }

    @And("^I enter spaces in the Email field$")
    public void iEnterSpacesInTheEmailField() {
        validateHelpers.setText(signUpPage.tbxEmail, Keys.chord(Keys.SPACE,Keys.SPACE,Keys.SPACE,Keys.SPACE));
    }

    @Then("^The error message \"([^\"]*)\" is shown next to the phone number label$")
    public void theErrorMessageIsShownNextToThePhoneNumberLabel(String message) {
        validateHelpers.getErrorMsg(signUpPage.errSDT, message);
    }

    @Then("^The error message \"([^\"]*)\" is shown next to the password label$")
    public void theErrorMessageIsShownNextToThePasswordLabel(String message) throws Throwable {
        validateHelpers.getErrorMsg(signUpPage.errPassword, message);
    }
}
