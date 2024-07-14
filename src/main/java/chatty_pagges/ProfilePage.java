package chatty_pagges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.File;


public class ProfilePage extends BasePage {

    @FindBy(className = "post-header__feed")
    private WebElement profileFormTitle;
    @FindBy(css = "[data-test='post-header__plus']")
    private WebElement editButton;
    @FindBy(css = "[data-test='profileName']")
    private WebElement nameInputField;
    @FindBy(css = "[data-test='profileSurname']")
    private WebElement surnameInputField;
    @FindBy(id = "birthDate")
    private WebElement birthDateInputField;
    @FindBy(id = "gender")
    private WebElement genderOption;
    @FindBy(css = "input[name='phone']")
    private WebElement phoneInputField;
    @FindBy(className = "save__btn")
    private WebElement saveButton;
    @FindBy(className = "pass__btn")
    private WebElement passwordChangeButton;
    @FindBy(className = "error")
    private WebElement errorMessage;
    @FindBy(css = "input[type='file'][accept='image/png,.png,image/jpg,.jpg,image/jpeg,.jpeg']")
    private WebElement avatarUpload;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage open() {
        driver.get("http://chatty.telran-edu.de:8089/userprofile");
        return this;
    }

    public WebElement getPhone() {
        return phoneInputField;
    }

    public void uploadImage(String imagePath) {
        avatarUpload.sendKeys(new File(imagePath).getAbsolutePath());
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public WebElement getProfileFormTitle() {
        return profileFormTitle;
    }

    public WebElement getSurname() {
        return surnameInputField;
    }

    public WebElement getGenderOption() {
        return genderOption;
    }

    public void clickOnEditButton() {
        editButton.click();
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }

    public void clickOnPasswordChangeButton() {
        passwordChangeButton.click();
    }

    public void enterName(String name) {
        nameInputField.clear();
        nameInputField.sendKeys(name);
    }

    public void enterSurname(String surname) {
        surnameInputField.clear();
        surnameInputField.sendKeys(surname);
    }

    public void enterBirthDate(String birthDate) {
        birthDateInputField.click();
        birthDateInputField.sendKeys(birthDate);
    }

    public void selectGender(String gender) {
        Select genderSelect = new Select(genderOption);
        genderSelect.selectByVisibleText(gender);
    }

    public void enterPhoneNumber(String phoneNumber) {
        phoneInputField.clear();
        phoneInputField.sendKeys(phoneNumber);
    }
}
