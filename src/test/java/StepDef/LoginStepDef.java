package StepDef;

import Page.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class LoginStepDef {

    Login login = new Login();

    @Given("user enter {string} and {string}")
    public void validData(String username, String password){
        login.dataEnter(username, password);
    }

    @When("user click login button")
    public void clickLogin() throws InterruptedException {
        login.loginButton().click();
        Thread.sleep(3000);
    }

    @Then("user login successfully")
    public void loginSuccess(){
        // ** Soft Assertion ** //
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(Hooks.driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        softAssert.assertAll();
    }

    @Then("user can't login")
    public void loginFailed(){
        // ** Soft Assertion ** //
        SoftAssert softAssert = new SoftAssert();

        //First Assertion
        softAssert.assertEquals(Hooks.driver.getCurrentUrl(), "https://www.saucedemo.com/");

        //Second Assertion
        softAssert.assertTrue(login.failMessage().isDisplayed(), "Epic sadface: Error message appears");

        //Third Assertion
        String expectedColor = "rgba(226, 35, 26, 1)";
        String actualColor = login.failMessage().getCssValue("background-color");

        softAssert.assertEquals(actualColor, expectedColor, "Error background color is correct");

        //All Assert
        softAssert.assertAll();
    }
}
