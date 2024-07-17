package chatty_pagges;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


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

    public ProfilePage open() {
        driver.get("http://chatty.telran-edu.de:8089/userprofile");
        return this;
    }

    public ProfilePage clickOnEditButton() {
        editButton.click();
        return this;
    }

    public ProfilePage clickOnSaveProfileButton() {
        saveButtonForEditProfile.click();
        return this;
    }

    public ProfilePage clickOnPasswordChangeButton() {
        //wait.until(ExpectedConditions.elementToBeClickable(passwordChangeButton));
        passwordChangeButton.click();
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

    public ProfilePage editEnterBirthday(String newBirthday_r) {
        wait.until(ExpectedConditions.visibilityOf(birthDateInputField));
        birthDateInputField.click();
        birthDateInputField.sendKeys(newBirthday_r);
        return this;
    }

    public ProfilePage clickGenderDropDown(){
        wait.until(ExpectedConditions.visibilityOf(genderOption));
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

    public String getNameFromProfilePage(){
        return nameInputField.getText();
    }

    public String getSurnameFromProfilePage(){
        return surnameInputField.getText();
    }

    public String getBirthdayFromProfilePage(){
        return birthDateInputField.getText();
    }

    public String getPhoneFromProfilePage(){
        return phoneInputField.getText();
    }

    public String getGenderFromProfilePage(){
        return genderOption.getText();
    }

//    public List<String> containUserData(List<String> currentUserData) {
//        List<String> currentUserData = new ArrayList<>();
//        currentUserData.add(getNameFromProfilePage());
//        currentUserData.add(getSurnameFromProfilePage());
//        currentUserData.add(getBirthdayFromProfilePage());
//        currentUserData.add(getPhoneFromProfilePage());
//        currentUserData.add(getGenderFromProfilePage());
//        return currentUserData;
//    }

//    public void uploadImage(String imagePath) {
//        avatarUpload.sendKeys(new File(imagePath).getAbsolutePath());
//    }
//
//    public WebElement getErrorMessage() {
//        return errorMessage;
//    }
//
//    public WebElement getProfileFormTitle() {
//        assertTrue(profileFormTitle.isDisplayed());
//        return profileFormTitle;
//    }
//
}
