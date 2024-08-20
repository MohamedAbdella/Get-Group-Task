package Paegs;

import BasePage.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class P01_RegistrationPage extends basePage {

    private By userNameField = By.id("nf-field-17");
    private By lastNameField = By.id("nf-field-18");
    private By emailField = By.id("nf-field-19");
    private By phoneField = By.id("nf-field-20");
    private By DDL_Of_Courses = By.id("nf-field-22");
    private By DDL_Of_JoinningMonth = By.id("nf-field-24");
    private By CheckBoxOf_Facebook = By.id("nf-label-class-field-23-0");
    private By RegesterBtn = By.id("nf-field-15");
    private By SuccessfullMessage = By.xpath("//div[@class='nf-response-msg']/p");
    private By ValidationMessage_For_FirstName_Field = By.id("nf-error-17");
    private By ValidationMessage_For_EmailField=By.id("nf-error-19");
    private By validationMessage_For_CheckBoxField=By.id("nf-error-23");

    public P01_RegistrationPage(WebDriver driver) {
        super(driver);
    }


    public void User_Enter_His_Data(String userName, String lastName, String email, String phone) {

        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void User_ClickOn_CheckBox(){
        driver.findElement(CheckBoxOf_Facebook).click();

    }

    public void Select_Value_From_DDL_Of_Courses() {
        Select select = new Select(driver.findElement(DDL_Of_Courses));
        select.selectByVisibleText("Selenium Automation");
    }

    public void Select_Value_From_DDL_Of_MonthJoinning() {
        Select select = new Select(driver.findElement(DDL_Of_JoinningMonth));
        select.selectByValue("march");
    }

    public void ClickOn_RegesterBtn() {
        driver.findElement(RegesterBtn).click();
    }

    public Boolean Is_SuccefullMessage_Appeared() {
        waitForVisibility(driver.findElement(SuccessfullMessage));
        return driver.findElement(SuccessfullMessage).isDisplayed();
    }

    public Boolean IS_ValidationMessage_For_FirstNameField_Appeaer() {
        waitForVisibility(driver.findElement(ValidationMessage_For_FirstName_Field));
        return driver.findElement(ValidationMessage_For_FirstName_Field).isDisplayed();
    }

    public Boolean Is_ValidationMessage_For_EmailField_Appear(){
        waitForVisibility(driver.findElement(ValidationMessage_For_EmailField));
        return driver.findElement(ValidationMessage_For_EmailField).isDisplayed();
    }

    public Boolean Is_ValidationMessage_For_CheckBox_Appear(){
        waitForVisibility(driver.findElement(validationMessage_For_CheckBoxField));
        return driver.findElement(validationMessage_For_CheckBoxField).isDisplayed();
    }
}
