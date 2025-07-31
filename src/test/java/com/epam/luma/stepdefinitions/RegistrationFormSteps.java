package com.epam.luma.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.pages.RegistrationPage;
import org.example.utils.DriverManager;
import org.testng.Assert;

public class RegistrationFormSteps {

    private RegistrationPage registrationPage;

    public RegistrationFormSteps() {
        registrationPage = new RegistrationPage(DriverManager.getDriver());
    }

    @Given("the registration form is displayed")
    public void theRegistrationFormIsDisplayed() {
        registrationPage.navigateToRegistrationPage();
        Assert.assertTrue(registrationPage.isRegistrationFormDisplayed(), "Registration form is not displayed");
    }

    @When("I leave all required fields empty")
    public void iLeaveAllRequiredFieldsEmpty() {
        // No action needed, fields are empty by default
    }

    @When("I click on the submit button")
    public void iClickOnTheSubmitButton() {
        registrationPage.clickSubmitButton();
    }

    @Then("all required fields are highlighted")
    public void allRequiredFieldsAreHighlighted() {
        Assert.assertTrue(registrationPage.areRequiredFieldsHighlighted(), "Required fields are not highlighted");
    }

    @Then("a generic required field validation message is displayed")
    public void aGenericRequiredFieldValidationMessageIsDisplayed() {
        Assert.assertTrue(registrationPage.isGenericValidationMessageDisplayed(), "Generic validation message is not displayed");
    }

    @When("I enter an invalid email format {string}")
    public void iEnterAnInvalidEmailFormat(String invalidEmail) {
        registrationPage.enterEmail(invalidEmail);
    }

    @Then("a generic invalid email format message is displayed")
    public void aGenericInvalidEmailFormatMessageIsDisplayed() {
        Assert.assertTrue(registrationPage.isInvalidEmailMessageDisplayed(), "Invalid email message is not displayed");
    }

    @When("I enter a password shorter than the minimum length {string}")
    public void iEnterAPasswordShorterThanTheMinimumLength(String shortPassword) {
        registrationPage.enterPassword(shortPassword);
    }

    @Then("the password strength indicator reflects weakness")
    public void thePasswordStrengthIndicatorReflectsWeakness() {
        Assert.assertTrue(registrationPage.isPasswordStrengthWeak(), "Password strength indicator does not reflect weakness");
    }

    @Then("a generic validation error is shown")
    public void aGenericValidationErrorIsShown() {
        Assert.assertTrue(registrationPage.isGenericValidationErrorDisplayed(), "Generic validation error is not displayed");
    }

    @When("I enter a password without required character types {string}")
    public void iEnterAPasswordWithoutRequiredCharacterTypes(String weakPassword) {
        registrationPage.enterPassword(weakPassword);
    }

    @When("I enter a password {string}")
    public void iEnterAPassword(String password) {
        registrationPage.enterPassword(password);
    }

    @When("I enter a different value in the Confirm Password field {string}")
    public void iEnterADifferentValueInTheConfirmPasswordField(String confirmPassword) {
        registrationPage.enterConfirmPassword(confirmPassword);
    }

    @Then("a mismatch error message is displayed")
    public void aMismatchErrorMessageIsDisplayed() {
        Assert.assertTrue(registrationPage.isPasswordMismatchErrorDisplayed(), "Password mismatch error is not displayed");
    }

    @When("I enter valid values in all required fields")
    public void iEnterValidValuesInAllRequiredFields() {
        registrationPage.enterValidRegistrationData();
    }

    @Then("a new account is created")
    public void aNewAccountIsCreated() {
        Assert.assertTrue(registrationPage.isAccountCreated(), "Account is not created");
    }

    @Then("a success message or redirection occurs")
    public void aSuccessMessageOrRedirectionOccurs() {
        Assert.assertTrue(registrationPage.isSuccessMessageDisplayedOrRedirected(), "Success message is not displayed or redirection did not occur");
    }

    @When("I enter an email that is already registered {string}")
    public void iEnterAnEmailThatIsAlreadyRegistered(String registeredEmail) {
        registrationPage.enterEmail(registeredEmail);
    }

    @Then("a generic email already exists message is displayed")
    public void aGenericEmailAlreadyExistsMessageIsDisplayed() {
        Assert.assertTrue(registrationPage.isEmailAlreadyExistsMessageDisplayed(), "Email already exists message is not displayed");
    }

    @When("I enter values with leading\\/trailing spaces in any input fields {string}")
    public void iEnterValuesWithLeadingTrailingSpacesInAnyInputFields(String inputField) {
        registrationPage.enterFieldWithSpaces(inputField);
    }

    @Then("leading\\/trailing spaces are trimmed before validation and submission")
    public void leadingTrailingSpacesAreTrimmedBeforeValidationAndSubmission() {
        Assert.assertTrue(registrationPage.areSpacesTrimmed(), "Spaces are not trimmed from input fields");
    }

    @When("I enter a first name exceeding {int} characters {string}")
    public void iEnterAFirstNameExceedingCharacters(int maxLength, String longFirstName) {
        registrationPage.enterFirstName(longFirstName);
    }

    @When("I enter a last name exceeding {int} characters {string}")
    public void iEnterALastNameExceedingCharacters(int maxLength, String longLastName) {
        registrationPage.enterLastName(longLastName);
    }

    @When("I enter an email exceeding {int} characters {string}")
    public void iEnterAnEmailExceedingCharacters(int maxLength, String longEmail) {
        registrationPage.enterEmail(longEmail);
    }

    @When("I enter a password shorter than {int} characters or longer than {int} characters {string}")
    public void iEnterAPasswordShorterThanCharactersOrLongerThanCharacters(int minLength, int maxLength, String invalidPassword) {
        registrationPage.enterPassword(invalidPassword);
    }

    @When("I enter a first name with non-alphabetic characters {string}")
    public void iEnterAFirstNameWithNonAlphabeticCharacters(String invalidFirstName) {
        registrationPage.enterFirstName(invalidFirstName);
    }

    @When("I enter a last name with non-alphabetic characters {string}")
    public void iEnterALastNameWithNonAlphabeticCharacters(String invalidLastName) {
        registrationPage.enterLastName(invalidLastName);
    }

    @When("I enter valid data in all fields")
    public void iEnterValidDataInAllFields() {
        registrationPage.enterValidRegistrationData();
    }

    @Then("the form is submitted successfully")
    public void theFormIsSubmittedSuccessfully() {
        Assert.assertTrue(registrationPage.isFormSubmittedSuccessfully(), "Form is not submitted successfully");
    }

    @Then("the user is redirected to login\\/dashboard")
    public void theUserIsRedirectedToLoginDashboard() {
        Assert.assertTrue(registrationPage.isRedirectedToLoginOrDashboard(), "User is not redirected to login/dashboard");
    }

    @When("I enter a password with special characters {string}")
    public void iEnterAPasswordWithSpecialCharacters(String specialPassword) {
        registrationPage.enterPassword(specialPassword);
    }

    @Then("the password is accepted")
    public void thePasswordIsAccepted() {
        Assert.assertFalse(registrationPage.isPasswordErrorDisplayed(), "Password is not accepted");
    }

    @When("I enter an email with exactly {int} characters {string}")
    public void iEnterAnEmailWithExactlyCharacters(int maxLength, String maxLengthEmail) {
        registrationPage.enterEmail(maxLengthEmail);
    }

    @Then("the email is accepted")
    public void theEmailIsAccepted() {
        Assert.assertFalse(registrationPage.isEmailErrorDisplayed(), "Email is not accepted");
    }

    @When("I enter a first name with exactly {int} characters {string}")
    public void iEnterAFirstNameWithExactlyCharacters(int maxLength, String maxLengthFirstName) {
        registrationPage.enterFirstName(maxLengthFirstName);
    }

    @Then("the first name is accepted")
    public void theFirstNameIsAccepted() {
        Assert.assertFalse(registrationPage.isFirstNameErrorDisplayed(), "First name is not accepted");
    }

    @When("I enter a last name with exactly {int} characters {string}")
    public void iEnterALastNameWithExactlyCharacters(int maxLength, String maxLengthLastName) {
        registrationPage.enterLastName(maxLengthLastName);
    }

    @Then("the last name is accepted")
    public void theLastNameIsAccepted() {
        Assert.assertFalse(registrationPage.isLastNameErrorDisplayed(), "Last name is not accepted");
    }
}