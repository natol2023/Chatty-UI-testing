package chatty_pagges;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasswordChangePage extends BasePage {

    private WebDriverWait wait;

    @FindBy(className = "PasswordModal_passParagraph__feEN9")
    private WebElement formTitle;
    @FindBy(css = "input[placeholder='Old password']")
    private WebElement oldPasswordField;
    @FindBy(css = "input[placeholder='New password']")
    private WebElement newPasswordField;
    @FindBy(css = "input[placeholder='Confirm new password']")
    private WebElement editConfirmPasswordField;
    @FindBy(className = "PasswordModal_pass_btn__eGL9h")
    private WebElement saveButtonForEditPassword;
    @FindBy(className = "PasswordModal_error__9a5OG")
    private WebElement errorMessage;

    public PasswordChangePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

//    public WebElement getErrorMessage() {
//        return errorMessage;
//    }
//
//    public WebElement getFormTitle() {
//        return formTitle;
//    }

    public PasswordChangePage enterOldPassword(String oldPassword) {
        oldPasswordField.sendKeys(oldPassword);
        return this;
    }

    public PasswordChangePage enterNewPassword(String newPassword_r) {
        newPasswordField.sendKeys(newPassword_r);
        return this;
    }

    public PasswordChangePage enterConfirmNewPassword(String confirmPasswordNew) {
        editConfirmPasswordField.sendKeys(confirmPasswordNew);
        return this;
    }

    public ProfilePage clickOnSavePasswordButton() {
        saveButtonForEditPassword.click();
        return new ProfilePage(driver);
    }
}