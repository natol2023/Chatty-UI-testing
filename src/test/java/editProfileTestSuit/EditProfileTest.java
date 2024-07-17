package editProfileTestSuit;

import chatty_pagges.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class EditProfileTest extends SweetSugar {

    final String newName_r = faker.name().firstName();
    final String newSurname_r = faker.name().lastName();
    final String newBirthday = "1999-12-30";
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
        headerPage.clickHeaderDropDown();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//[@href='/userprofile']")));
        headerPage.clickProfileLink();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='profileName']")));

    }


//    @Test
//    public void fieldsAreDisplayedInProfile() {
//
//    }

    @Test
    public void editAllProfileFieldsTest(){
        ProfilePage profilePage = new ProfilePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='profileName']")));

        List<String> newUserData = new ArrayList<>();
        newUserData.add(newName_r);
        newUserData.add(newSurname_r);
        newUserData.add(newBirthday);
        newUserData.add(newPhone_r);
        newUserData.add("MALE");
        profilePage.clickOnEditButton()
                .editEnterName(newName_r)
                .editEnterSurname(newSurname_r)
                .editEnterBirthday(newBirthday)
                .editEnterPhoneNumber(newPhone_r)
                .clickGenderDropDown()
                .selectMaleGender("MALE")
                .clickOnSaveProfileButton();
//        defineTestResultTrue(profilePage.containUserData(newUserData));   // надо дописать метод опеределения-вхождения
    }

}