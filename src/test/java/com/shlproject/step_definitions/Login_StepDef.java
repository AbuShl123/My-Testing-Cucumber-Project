package com.shlproject.step_definitions;

import com.shlproject.data_base.ExcelTable;
import com.shlproject.pages.MainPage;
import com.shlproject.utilities.ConfigurationReader;
import com.shlproject.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

public class Login_StepDef {
    private static final MainPage mainPage = new MainPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

    @Given("user navigates to etsy main page")
    public void user_navigates_to_etsy_main_page() {
        Driver.getDriver().navigate().to("https://www.etsy.com");
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        mainPage.signInButton.click();
    }

    @And("user enters valid email")
    public void userEntersValidEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.emailInput));
        mainPage.emailInput.sendKeys(ConfigurationReader.getProperty("my.email"));
    }

    @And("user enters valid password")
    public void userEntersValidPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.passInput));
        mainPage.passInput.sendKeys(ExcelTable.getPassword());
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.submitButton));
        mainPage.submitButton.click();
    }

    @Then("welcome user message is displayed")
    public void welcome_user_message_is_displayed() {
        assertTrue(mainPage.welcomeMessage.isDisplayed());
    }

    @And("user enters invalid email")
    public void userEntersInvalidEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.emailInput));
        mainPage.emailInput.sendKeys("wrongUnExcitingMaybeEmail@gmail.com");
    }

    @And("user enters invalid password")
    public void userEntersInvalidPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.passInput));
        mainPage.passInput.sendKeys("wrong password of un-existing user");

        wait.until(ExpectedConditions.elementToBeClickable(mainPage.submitButton));
        mainPage.submitButton.click();
    }

    @Then("error message is displayed")
    public void errorMessageIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(mainPage.errorMessage));
        assertTrue(mainPage.errorMessage.isDisplayed());
    }
}
