package com.qa.interview.stepDefinitions;

import com.qa.interview.TestBase.Base;
import com.qa.interview.TestBase.DriverManager;
import com.qa.interview.utility.ControlUtil;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;


public class LoginSteps {

 //   private AppiumDriver driver;
    Base base = new Base();
    ControlUtil util = new ControlUtil();



    @When("^User opens the side menu$")
    public void user_opens_the_side_menu() {
        // Find and click on the button to open the side menu

        MobileElement  menuButton = DriverManager.getInstance().getDriver().findElement(By.xpath ("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView"));
     //   menuButton.click();
        util.click(menuButton);
    }

    @When("^User enters valid username and password$")
    public void user_enters_valid_username_and_password() throws Throwable {
        //Open side Menu
        //MobileElement openMenu = DriverManager.getInstance().getDriver().findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView"));
       // openMenu.click();

        //Click on Log In
        MobileElement logIn = DriverManager.getInstance().getDriver().findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item log in\"]"));
        logIn.click();

        MobileElement usernameField = DriverManager.getInstance().getDriver().findElement(By.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]"));
        MobileElement passwordField = DriverManager.getInstance().getDriver().findElement(By.xpath("//android.widget.EditText[@content-desc=\"Password input field\"]"));

        // Enter valid username and password
        usernameField.sendKeys("bob@example.com");
        passwordField.sendKeys("10203040");
    }
    @When("^User enters invalid username and password$")
    public void user_enters_invalid_username_and_password() throws Throwable {
        //Open side Menu
       MobileElement openMenu = DriverManager.getInstance().getDriver().findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView"));
       openMenu.click();

        //Click on Log In
        MobileElement logIn = DriverManager.getInstance().getDriver().findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item log in\"]"));
        logIn.click();

        MobileElement usernameField = DriverManager.getInstance().getDriver().findElement(By.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]"));
        MobileElement passwordField = DriverManager.getInstance().getDriver().findElement(By.xpath("//android.widget.EditText[@content-desc=\"Password input field\"]"));

        // Enter valid username and password
        usernameField.sendKeys("bob@example.com");
        passwordField.sendKeys("sfera");
    }

    @When("^User enters valid password$")
    public void user_enters_valid_password() throws Throwable {
        //Open side Menu
        MobileElement openMenu = DriverManager.getInstance().getDriver().findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView"));
        openMenu.click();

        //Click on Log In
        MobileElement logIn = DriverManager.getInstance().getDriver().findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item log in\"]"));
        logIn.click();

        MobileElement usernameField = DriverManager.getInstance().getDriver().findElement(By.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]"));
        MobileElement passwordField = DriverManager.getInstance().getDriver().findElement(By.xpath("//android.widget.EditText[@content-desc=\"Password input field\"]"));

        // Enter valid password
        passwordField.sendKeys("10203040");
    }
    @When("^User enters valid username")
    public void user_enters_valid_username() throws Throwable {
        //Open side Menu
        MobileElement openMenu = DriverManager.getInstance().getDriver().findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView"));
        openMenu.click();

        //Click on Log In
        MobileElement logIn = DriverManager.getInstance().getDriver().findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item log in\"]"));
        logIn.click();

        MobileElement usernameField = DriverManager.getInstance().getDriver().findElement(By.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]"));
        MobileElement passwordField = DriverManager.getInstance().getDriver().findElement(By.xpath("//android.widget.EditText[@content-desc=\"Password input field\"]"));

        // Enter valid username
        usernameField.sendKeys("bob@example.com");
    }

    @And("^User taps on the login button$")
    public void user_taps_on_the_login_button() throws Throwable {
        MobileElement loginButton = DriverManager.getInstance().getDriver().findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Login button\"]"));
        loginButton.click();
    }

    @Then("^User should be logged in successfully$")
    public void user_should_be_logged_in_successfully() throws Throwable {

        MobileElement homePageValidation = DriverManager.getInstance().getDriver().findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"generic-error-message\"]/android.widget.TextView"));
        Assert.assertEquals(homePageValidation, homePageValidation);
    }

    @Then("^Validate error message$")
    public void Validate_error_message() throws Throwable {

        MobileElement homePageValidation = DriverManager.getInstance().getDriver().findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"generic-error-message\"]/android.widget.TextView"));
        String excualResult = homePageValidation.getText();
        Assert.assertEquals("Provided credentials do not match any user in this service.", excualResult);
    }

    @Then("Validate error message username is required")
    public void validate_error_message_username_is_required() {
        // to validate the error message
        MobileElement errorMessage = DriverManager.getInstance().getDriver().findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Username-error-message\"]/android.widget.TextView"));
        assertEquals("Username is required", errorMessage.getText());
    }

    @Then("Validate error message Password is required")
    public void validate_error_message_Password_is_required() {
        // to validate the error message
        MobileElement errorMessage = DriverManager.getInstance().getDriver().findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Username-error-message\"]/android.widget.TextView"));
        assertEquals("Password is required", errorMessage.getText());
    }

    @After
    public void teardown() {
        // Quit driver after test execution
        if (DriverManager.getInstance().getDriver() != null) {
            DriverManager.getInstance().getDriver().quit();
        }
    }

    @Then("Validate error message {string}")
    public void validateErrorMessage(String arg0) {
    }

    @Then("Validate error message user has been locked out")
    public void validateErrorMessageUserHasBeenLockedOut() {
    }

    @Given("^User is on the login screen$")
    public void user_is_on_the_login_screen() {
        try {
            base.launchApp();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
