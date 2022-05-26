package thucydides.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import thucydides.cucumber.commonMethod.ValidateHelpers;
import thucydides.cucumber.pages.LoginPage;
import thucydides.cucumber.pages.SignUpPage;

public class LoginSteps extends PageObject {
    LoginPage loginPage;
    ValidateHelpers validateHelpers;
    SignUpPage signUpPage;

    @When("^I enter \"([^\"]*)\" and \"([^\"]*)\" in text boxs$")
    public void iEnterAndInTextBoxs(String email, String password)  {
        validateHelpers.setText(loginPage.tbxEmail, email);
        validateHelpers.setText(loginPage.tbxPassword,password);
    }

    @And("^I click the 'Đăng nhập' button$")
    public void iClickTheĐăngNhậpButton() {
        validateHelpers.clickElement(loginPage.btnLogin);
        validateHelpers.clickElement(loginPage.btnLogin);
    }

    @Then("^The Login popup disappears$")
    public void theLoginPopupDisappears() {
        validateHelpers.verifyDisplayedTrue(signUpPage.logo);
    }

    @When("^I enter valid \"([^\"]*)\" and invalid \"([^\"]*)\"$")
    public void iEnterValidAndInvalid(String email, String password) {
        validateHelpers.setText(loginPage.tbxEmail, email);
        validateHelpers.setText(loginPage.tbxPassword, password);
    }

    @Then("^The 'Email hoặc SĐT hoặc Mật khẩu không đúng' error message is shown$")
    public void theEmailHoặcSĐTHoặcMậtKhẩuKhôngĐúngErrorMessageIsShown() throws InterruptedException {
        Thread.sleep(2000);
        validateHelpers.verifyDisplayedTrue(loginPage.errInvalidPassword);
    }


    @When("^I enter valid \"([^\"]*)\" and leave password field blank$")
    public void iEnterValidAndLeavePasswordFieldBlank(String email) {
        validateHelpers.setText(loginPage.tbxEmail,email);
    }

    @Then("^The error messsage is shown \"([^\"]*)\" next to the 'Mật khẩu' label$")
    public void theErrorMesssageIsShownNextToTheMậtKhẩuLabel(String message) {
        validateHelpers.getErrorMsg(loginPage.errPassword, message);
    }


    @When("^I enter valid \"([^\"]*)\" and enter spaces in the Password field$")
    public void iEnterValidAndEnterSpacesInThePasswordField(String email) {
        validateHelpers.setText(loginPage.tbxEmail, email);
        validateHelpers.setText(loginPage.tbxPassword, Keys.chord(Keys.SPACE,Keys.SPACE,Keys.SPACE,Keys.SPACE));
    }


    @When("^I enter \"([^\"]*)\" less than six characters on the Login form$")
    public void iEnterLessThanSixCharactersOnTheLoginForm(String password) {
        validateHelpers.setText(loginPage.tbxPassword,password);
    }

    @And("^I enter \"([^\"]*)\" on Login form$")
    public void iEnterOnLoginForm(String email) {
        validateHelpers.setText(loginPage.tbxEmail, email);
    }
    @Then("^The error message is shown \"([^\"]*)\"on the Login form$")
    public void theErrorMessageIsShownOnTheLoginForm(String message) {
        validateHelpers.getErrorMsg(loginPage.errPassword,message);
    }

    @Then("^The error message is shown \"([^\"]*)\" next to Email label$")
    public void theErrorMessageIsShownNextToEmailLabel(String message)  {
        validateHelpers.getErrorMsg(loginPage.errEmail, message);
    }


    @When("^I enter spaces in the Email field on the Login form$")
    public void iEnterSpacesInTheEmailFieldOnTheLoginForm() {
        validateHelpers.setText(loginPage.tbxEmail, Keys.chord(Keys.SPACE,Keys.SPACE,Keys.SPACE,Keys.SPACE));
    }
}
