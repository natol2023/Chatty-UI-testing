package chatty_pagges;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class ProfilePage extends BasePage {

    private WebDriverWait wait;

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
    private WebElement saveButtonForEditProfile;
    @FindBy(className = "pass__btn")
    private WebElement passwordChangeButton;
    @FindBy(className = "error")
    private WebElement errorMessage;
    @FindBy(css = "input[type='file'][accept='image/png,.png,image/jpg,.jpg,image/jpeg,.jpeg']")
    private WebElement avatarUpload;

    public ProfilePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public ProfilePage clickOnEditButton() {
        editButton.click();
        return this;
    }

    public ProfilePage editEnterName(String newName_r) {
        wait.until(ExpectedConditions.visibilityOf(nameInputField));
        nameInputField.clear();
        nameInputField.sendKeys(newName_r);
        return this;
    }

    public ProfilePage editEnterSurname(String newSurname_r) {
        wait.until(ExpectedConditions.visibilityOf(surnameInputField));
        surnameInputField.clear();
        surnameInputField.sendKeys(newSurname_r);
        return this;
    }

    public ProfilePage editEnterBirthday(String date, String month, String year) {
        wait.until(ExpectedConditions.visibilityOf(birthDateInputField));
        birthDateInputField.clear();
        birthDateInputField.sendKeys(date, month, year);
        return this;
    }

    public ProfilePage clickGenderDropDown() {
        wait.until(ExpectedConditions.elementToBeClickable(genderOption));
        genderOption.click();
        return this;
    }

    public ProfilePage selectMaleGender(String gender) {
        Select genderSelect = new Select(genderOption);
        genderSelect.selectByValue("MALE");
        return this;
    }

    public ProfilePage selectFemaleGender(String gender) {
        Select genderSelect = new Select(genderOption);
        genderSelect.selectByValue("FEMALE");
        return this;
    }

    public ProfilePage editEnterPhoneNumber(String newPhone_r) {
        wait.until(ExpectedConditions.visibilityOf(phoneInputField));
        phoneInputField.clear();
        phoneInputField.sendKeys(newPhone_r);
        return this;
    }

    public PasswordChangePage clickOnPasswordChangeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(passwordChangeButton));
        passwordChangeButton.click();
        return new PasswordChangePage(driver);
    }

    public ProfilePage clickOnSaveProfileButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButtonForEditProfile));
        saveButtonForEditProfile.click();
        return new ProfilePage(driver);
    }

    public String getNameFromProfilePage() {
        wait.until(ExpectedConditions.visibilityOf(nameInputField));
        return nameInputField.getAttribute("value");
    }

    public String getSurnameFromProfilePage() {
        wait.until(ExpectedConditions.visibilityOf(surnameInputField));
        return surnameInputField.getAttribute("value");
    }

    public String getBirthdayFromProfilePage() {
        wait.until(ExpectedConditions.visibilityOf(birthDateInputField));
        return birthDateInputField.getAttribute("value");
    }

    public String getBirthdayFromProfilePage2() {
        wait.until(ExpectedConditions.visibilityOf(birthDateInputField));
        return birthDateInputField.getText();
    }

    public String getPhoneFromProfilePage() {
        wait.until(ExpectedConditions.visibilityOf(phoneInputField));
        return phoneInputField.getAttribute("value");
    }

    public String getGenderFromProfilePage() {
        wait.until(ExpectedConditions.visibilityOf(genderOption));
        return genderOption.getAttribute("value");
    }
}
