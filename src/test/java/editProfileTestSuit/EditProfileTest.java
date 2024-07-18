package editProfileTestSuit;

import chatty_pagges.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Arrays;

public class EditProfileTest extends SweetSugar {

    final String newName_r = faker.name().firstName();
    final String newSurname_r = faker.name().lastName();
    final String year = "1999";
    final String month = "12";
    final String date = "30";
    final String newPhone_r = faker.phoneNumber().toString();

    @BeforeEach
    public void goToProfilePage() {
        registerNewUser();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(email_r)
                .inputPassword(password_r)
                .clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.openHeaderPage()
                .hoverDropDown()
                .clickHeaderDropDown();
        headerPage.clickProfileLink();
    }

    @Test
    public void editAllProfileFieldsTest(){
        ProfilePage profilePage = new ProfilePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='profileName']")));
        profilePage.clickOnEditButton()
                .editEnterName(newName_r)
                .editEnterSurname(newSurname_r)
                .editEnterBirthday(date, month, year)
                .editEnterPhoneNumber(newPhone_r)
                .clickGenderDropDown()
                .selectMaleGender("MALE")
                .clickOnSaveProfileButton();
        defineTestResultEquals(newName_r, profilePage.getNameFromProfilePage());
        defineTestResultEquals(newSurname_r, profilePage.getSurnameFromProfilePage());
      //  System.out.println(Arrays.toString(profilePage.getBirthdayFromProfilePage().split("-")));
        defineTestResultEquals(String.format("%s-%s-%s", year, month, date), profilePage.getBirthdayFromProfilePage());
        defineTestResultEquals(newPhone_r, profilePage.getPhoneFromProfilePage());
        defineTestResultEquals("MALE", profilePage.getGenderFromProfilePage());
    }
}