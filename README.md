Technologies Used
Java: Programming language used to write the test scripts.
Selenium WebDriver: For interacting with the web elements on the PHP Travels signup page.
TestNG: Test framework used for organizing and running the tests.
Maven: Build tool used for managing dependencies and running the tests.
Java Faker: For generating random test data like names, email addresses, and phone numbers.
Allure: For generating detailed test reports.
Page Object Model (POM): Design pattern used to structure the code and improve maintainability.
Test Cases
Positive Test Cases
Register_With_Valid_Data: Tests successful registration with valid input data.
Negative Test Cases
Register_When_user_Leave_FirstNameField_Empty: Tests validation when the First Name field is left empty.
Register_When_User_Enter_InvalidEmail: Tests validation when an invalid email format is entered.
Register_When_User_Leave_CheckBox_Empty: Tests validation when the checkbox (e.g., terms of service) is not checked.
