package chatty_pagges;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordChangePage extends BasePage{
    @FindBy(className = "PasswordModal_passParagraph__feEN9")
    private WebElement formTitle;
    @FindBy(css = "input[placeholder='Old password']")
    private WebElement oldPasswordField;
    @FindBy(css = "input[placeholder='New password']")
    private WebElement newPasswordField;
    @FindBy(css = "input[placeholder='Confirm new password']")
    private WebElement confirmPasswordField;
    @FindBy(className = "PasswordModal_pass_btn__eGL9h")
    private WebElement saveButton;
    @FindBy(className = "PasswordModal_error__9a5OG")
    private WebElement errorMessage;

    public PasswordChangePage(WebDriver driver) { super(driver);}

//    public PasswordChangePage getErrorMessage() {
//        return errorMessage;
//    }
//
//    public PasswordChangePage getFormTitle() {
//        return formTitle;
//    }

    public void enterOldPassword(String oldPasswordValue) {
        oldPasswordField.sendKeys(oldPasswordValue);
    }

    public void enterNewPassword(String newPasswordValue) {
        newPasswordField.sendKeys(newPasswordValue);
    }

    public void confirmPassword(String confirmPasswordValue) {
        confirmPasswordField.sendKeys(confirmPasswordValue);
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }
}