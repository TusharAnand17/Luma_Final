package org.example.pages;

import org.example.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstname")
    private WebElement firstNameField;

    @FindBy(id = "lastname")
    private WebElement lastNameField;

    @FindBy(id = "email_address")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "password-confirmation")
    private WebElement confirmPasswordField;

    @FindBy(css = ".action.submit.primary")
    private WebElement submitButton;

    @FindBy(id = "firstname-error")
    private WebElement firstNameError;

    @FindBy(id = "lastname-error")
    private WebElement lastNameError;

    @FindBy(id = "email_address-error")
    private WebElement emailError;

    @FindBy(xpath = "//div[@data-bind = \"html: $parent.prepareMessageForHtml(message.text)\"]")
    private WebElement emailAlreadyExistsError;

    @FindBy(id = "password-error")
    private WebElement passwordError;

    @FindBy(id = "password-confirmation-error")
    private WebElement confirmPasswordError;

    @FindBy(xpath = "//div[@class=\"column main\"]")
    private WebElement registrationForm;
}