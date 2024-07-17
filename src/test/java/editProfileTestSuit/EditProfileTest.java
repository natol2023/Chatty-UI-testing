package editProfileTestSuit;

import chatty_pagges.*;
import net.datafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class EditProfileTest extends SweetSugar {

//    String name_r = faker.name().firstName();
//    String surname_r = faker.date().toString();
//    String phone_r = faker.phoneNumber().toString();
    String password_r = faker.internet().password(8,100);
    String email_r = faker.internet().emailAddress();

    String newName_r = faker.name().firstName();
    String newSurname_r = faker.name().lastName();
    String newBirthday_r = faker.date().toString();
    String newPhone_r = faker.phoneNumber().toString();
    //String oldPass = password_r;
    String newPass_r = faker.internet().password(8,100);

    @BeforeEach
    public void goToProfilePage() {
        //registerNewUser();
        loginPage.clickSignUpLink();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/registration"));
        String email_r = faker.internet().emailAddress();
        String password_r = faker.internet().password(8, 100);
        createAccountPage.inputEmail(email_r);
        createAccountPage.inputPassword(password_r);
        createAccountPage.confirmPassword(password_r);
        createAccountPage.clickRegistrationButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(email_r)
                .inputPassword(password_r)
                .clickLoginButton();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.hoverDropDown()
                .clickProfileLink();
    }


    @Test
    public void fieldsAreDisplayedInProfile() {

    }

    @Test
    public void editAllProfileFieldsTest(){
        ProfilePage profilePage = new ProfilePage(driver);
        List<String> newUserData = new ArrayList<>();
        newUserData.add(newName_r);
        newUserData.add(newSurname_r);
        newUserData.add(newBirthday_r);
        newUserData.add(newPhone_r);
        newUserData.add("MALE");
        profilePage.clickOnEditButton();
        profilePage.editEnterName(newName_r);
        profilePage.editEnterSurname(newSurname_r);
        profilePage.editEnterBirthday(newBirthday_r);
        profilePage.enterPhoneNumber(newPhone_r);
        profilePage.clickGenderDropDown();
        profilePage.selectMaleGender("MALE");
        profilePage.clickOnSaveButton();
       // defineTestResultTrue(profilePage.containtainUserData(newUserData));
    }

}