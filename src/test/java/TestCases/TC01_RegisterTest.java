package TestCases;

import BaseTest.baseTest;
import Paegs.P01_RegistrationPage;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.TestListeners;

@Listeners(TestListeners.class)

public class TC01_RegisterTest extends baseTest {

    Faker fakeData = new Faker();  //Use faker class to generate random data
    String FirstName = fakeData.name().firstName().toUpperCase();
    String lastName = fakeData.name().lastName().toUpperCase();
    String mobileNumber = fakeData.numerify("012########");
    String email = fakeData.internet().emailAddress();

    @Test(priority = 0)
    public void Register_With_Valid_Data() {
        P01_RegistrationPage registrationPage = new P01_RegistrationPage(driver);
        registrationPage.User_Enter_His_Data(FirstName, lastName, email, mobileNumber);
        registrationPage.User_ClickOn_CheckBox();
        registrationPage.Select_Value_From_DDL_Of_Courses();
        registrationPage.Select_Value_From_DDL_Of_MonthJoinning();
        //Ensure that the first character is capital
        Assert.assertTrue(Character.isUpperCase(FirstName.charAt(0)), "First name must start with a capital letter.");
        Assert.assertNotEquals(lastName, FirstName, "Last name should not be equal to first name.");
        //Ensure that user entered valid number(only numbers and doesn't contain letters)
        Assert.assertTrue(mobileNumber.matches("\\d{11}"), "Mobile number must be valid.");
        // Assert that the phone number is exactly 11 digits long
        Assert.assertEquals(mobileNumber.length(), 11, "Phone number must contain exactly 11 digits.");
        registrationPage.ClickOn_RegesterBtn();
        Assert.assertTrue(registrationPage.Is_SuccefullMessage_Appeared());
    }

    @Test(priority = 1)
    public void Register_When_user_Leave_FirstNameField_Empty() {
        P01_RegistrationPage registrationPage = new P01_RegistrationPage(driver);
        registrationPage.User_Enter_His_Data("", lastName, email, mobileNumber);
        Assert.assertTrue(registrationPage.IS_ValidationMessage_For_FirstNameField_Appeaer());
    }

    @Test(priority = 2)
    public void Register_When_User_Enter_InvalidEmail(){
        P01_RegistrationPage registrationPage = new P01_RegistrationPage(driver);
        registrationPage.User_Enter_His_Data(FirstName, lastName, "mmm54654", mobileNumber);
        Assert.assertTrue(registrationPage.Is_ValidationMessage_For_EmailField_Appear());
    }

    @Test(priority = 3)
    public void Register_When_User_Leave_CheckBox_Empty(){
        P01_RegistrationPage registrationPage = new P01_RegistrationPage(driver);
        registrationPage.User_Enter_His_Data(FirstName, lastName, email, mobileNumber);
        registrationPage.Select_Value_From_DDL_Of_Courses();
        registrationPage.Select_Value_From_DDL_Of_MonthJoinning();
        registrationPage.ClickOn_RegesterBtn();
        Assert.assertTrue(registrationPage.Is_ValidationMessage_For_CheckBox_Appear());
    }




}
