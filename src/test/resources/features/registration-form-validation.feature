@registration
Feature: Registration Form Validation and Submission

  Scenario: Verify required fields validation
    Given the registration form is displayed
    When I leave all required fields empty
    And I click on the submit button
    Then all required fields are highlighted
    And a generic required field validation message is displayed

  Scenario Outline: Verify email format validation
    Given the registration form is displayed
    When I enter an invalid email format "<invalid_email>"
    And I click on the submit button
    Then a generic invalid email format message is displayed

    Examples:
      | invalid_email       |
      | userexample.com     |
      | user@.com           |
      | @example.com        |
      | user@com            |

  Scenario Outline: Verify password strength and format - minimum length
    Given the registration form is displayed
    When I enter a password shorter than the minimum length "<short_password>"
    And I click on the submit button
    Then the password strength indicator reflects weakness
    And a generic validation error is shown

    Examples:
      | short_password |
      | Pass1!         |
      | abc123         |
      | 12345          |

  Scenario Outline: Verify password strength and format - character types
    Given the registration form is displayed
    When I enter a password without required character types "<weak_password>"
    And I click on the submit button
    Then the password strength indicator reflects weakness
    And a generic validation error is shown

    Examples:
      | weak_password |
      | password      |
      | 12345678      |
      | abcdefgh      |

  Scenario Outline: Verify confirm password match
    Given the registration form is displayed
    When I enter a password "<password>"
    And I enter a different value in the Confirm Password field "<confirm_password>"
    And I click on the submit button
    Then a mismatch error message is displayed

    Examples:
      | password | confirm_password |
      | Pass@123 | Pass@124         |
      | abc123   | abc124           |
      | 12345678 | 87654321         |

  Scenario: Verify successful submission
    Given the registration form is displayed
    When I enter valid values in all required fields
    And I click on the submit button
    Then a new account is created
    And a success message or redirection occurs

  Scenario Outline: Verify email uniqueness check
    Given the registration form is displayed
    When I enter an email that is already registered "<registered_email>"
    And I click on the submit button
    Then a generic email already exists message is displayed

    Examples:
      | registered_email    |
      | existing@example.com|
      | user@domain.com     |

  Scenario Outline: Verify leading/trailing space handling
    Given the registration form is displayed
    When I enter values with leading/trailing spaces in any input fields "<input_field>"
    And I click on the submit button
    Then leading/trailing spaces are trimmed before validation and submission

    Examples:
      | input_field       |
      | " John "          |
      | " Doe "           |
      | " user@example.com " |

  Scenario Outline: Verify first name length and character restrictions
    Given the registration form is displayed
    When I enter a first name exceeding 50 characters "<long_first_name>"
    And I click on the submit button
    Then a generic error message is displayed

    Examples:
      | long_first_name |
      | JohnJacobJingleheimerSchmidtHisNameIsMyNameToo |
      | AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA |

  Scenario Outline: Verify last name length and character restrictions
    Given the registration form is displayed
    When I enter a last name exceeding 50 characters "<long_last_name>"
    And I click on the submit button
    Then a generic error message is displayed

    Examples:
      | long_last_name |
      | JohnJacobJingleheimerSchmidtHisNameIsMyNameToo |
      | AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA |

  Scenario Outline: Verify email length restriction
    Given the registration form is displayed
    When I enter an email exceeding 100 characters "<long_email>"
    And I click on the submit button
    Then a generic error message is displayed

    Examples:
      | long_email |
      | user@example.comuser@example.comuser@example.comuser@example.comuser@example.comuser@example.com |

  Scenario Outline: Verify password length restriction
    Given the registration form is displayed
    When I enter a password shorter than 8 characters or longer than 16 characters "<invalid_password>"
    And I click on the submit button
    Then a generic error message is displayed

    Examples:
      | invalid_password |
      | Pass1!           |
      | abc123           |
      | 12345678901234567|

  Scenario Outline: Verify first name character restrictions
    Given the registration form is displayed
    When I enter a first name with non-alphabetic characters "<invalid_first_name>"
    And I click on the submit button
    Then a generic error message is displayed

    Examples:
      | invalid_first_name |
      | John123            |
      | John@!             |
      | John_123           |

  Scenario Outline: Verify last name character restrictions
    Given the registration form is displayed
    When I enter a last name with non-alphabetic characters "<invalid_last_name>"
    And I click on the submit button
    Then a generic error message is displayed

    Examples:
      | invalid_last_name |
      | Doe@!             |
      | Doe_123           |
      | Doe@!123          |

  Scenario: Verify form submission with valid data
    Given the registration form is displayed
    When I enter valid data in all fields
    And I click on the submit button
    Then the form is submitted successfully
    And the user is redirected to login/dashboard

  Scenario Outline: Verify form submission with special characters in password
    Given the registration form is displayed
    When I enter a password with special characters "<special_password>"
    And I click on the submit button
    Then the password is accepted
    And the form is submitted successfully

    Examples:
      | special_password |
      | Pass@123         |
      | Pass#456         |
      | Pass$789         |

  Scenario Outline: Verify form submission with maximum length email
    Given the registration form is displayed
    When I enter an email with exactly 100 characters "<max_length_email>"
    And I click on the submit button
    Then the email is accepted
    And the form is submitted successfully

    Examples:
      | max_length_email |
      | user@example.comuser@example.comuser@example.comuser@example.comuser@example.comuser@example.com |

  Scenario Outline: Verify form submission with maximum length first name
    Given the registration form is displayed
    When I enter a first name with exactly 50 characters "<max_length_first_name>"
    And I click on the submit button
    Then the first name is accepted
    And the form is submitted successfully

    Examples:
      | max_length_first_name |
      | JohnJacobJingleheimerSchmidtHisNameIsMyNameToo |

  Scenario Outline: Verify form submission with maximum length last name
    Given the registration form is displayed
    When I enter a last name with exactly 50 characters "<max_length_last_name>"
    And I click on the submit button
    Then the last name is accepted
    And the form is submitted successfully

    Examples:
      | max_length_last_name |
      | JohnJacobJingleheimerSchmidtHisNameIsMyNameToo |