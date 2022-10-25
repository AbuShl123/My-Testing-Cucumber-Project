package com.shlproject.pages;

import com.shlproject.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (css = "button[class$='signin']")
    public WebElement signInButton;

    @FindBy (css = "input[name='email']")
    public WebElement emailInput;

    @FindBy (css = "input[name='password']")
    public WebElement passInput;

    @FindBy (css = "button[name='submit_attempt']")
    public WebElement submitButton;

    @FindBy (xpath = "//div[@data-async-homepage-modules]/div[1]")
    public WebElement welcomeMessage;

    @FindBy (css = "#aria-join_neu_email_field-error")
    public WebElement errorMessage;
}
