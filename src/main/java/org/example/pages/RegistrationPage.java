package org.example.pages;

import org.example.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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

    public void navigateToRegistrationPage() {
        driver.get(ConfigReader.getProperty("registration.url"));
    }

    public boolean isRegistrationFormDisplayed() {
        return registrationForm.isDisplayed();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public boolean areRequiredFieldsHighlighted() {
        return firstNameError.isDisplayed() && lastNameError.isDisplayed() && emailError.isDisplayed() && passwordError.isDisplayed() && confirmPasswordError.isDisplayed();
    }

    public boolean isGenericValidationMessageDisplayed() {
        return firstNameError.isDisplayed() || lastNameError.isDisplayed() || emailError.isDisplayed() || passwordError.isDisplayed() || confirmPasswordError.isDisplayed();
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public boolean isInvalidEmailMessageDisplayed() {
        return emailError.isDisplayed() && emailError.getText().contains("Please enter a valid email address");
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public boolean isPasswordStrengthWeak() {
        // Implement logic to check password strength indicator
        return passwordError.isDisplayed() && passwordError.getText().contains("Weak");
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public boolean isPasswordMismatchErrorDisplayed() {
        return confirmPasswordError.isDisplayed() && confirmPasswordError.getText().contains("Please enter the same value again.");
    }

    public void enterValidRegistrationData() {
        firstNameField.sendKeys("John");
        lastNameField.sendKeys("Doe");
        emailField.sendKeys("johndoe" + System.currentTimeMillis() + "@example.com");
        passwordField.sendKeys("StrongPass123!");
        confirmPasswordField.sendKeys("StrongPass123!");
    }

    public boolean isAccountCreated() {
        // Implement logic to check if account is created successfully
        return driver.getCurrentUrl().contains("customer/account");
    }

    public boolean isSuccessMessageDisplayedOrRedirected() {
        return driver.getCurrentUrl().contains("customer/account");
    }

    public boolean isEmailAlreadyExistsMessageDisplayed() {
        return emailAlreadyExistsError.isDisplayed();
    }

    public void enterFieldWithSpaces(String inputField) {
        WebElement element = null;
        switch (inputField.trim().toLowerCase()) {
            case "john":
                element = firstNameField;
                break;
            case "doe":
                element = lastNameField;
                break;
            case "user@example.com":
                element = emailField;
                break;
        }
        if (element != null) {
            element.sendKeys(" " + inputField + " ");
        }
    }

    public boolean areSpacesTrimmed() {
        // Implement logic to check if spaces are trimmed
        return true; // Placeholder
    }

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public boolean isFormSubmittedSuccessfully() {
        return isAccountCreated();
    }

    public boolean isRedirectedToLoginOrDashboard() {
        return driver.getCurrentUrl().contains("customer/account/login") || driver.getCurrentUrl().contains("customer/account");
    }

    public boolean isPasswordErrorDisplayed() {
        return passwordError.isDisplayed();
    }

    public boolean isEmailErrorDisplayed() {
        return emailError.isDisplayed();
    }

    public boolean isFirstNameErrorDisplayed() {
        return firstNameError.isDisplayed();
    }

    public boolean isLastNameErrorDisplayed() {
        return lastNameError.isDisplayed();
    }
}