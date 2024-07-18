package editProfileTestSuit;

import chatty_pagges.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChangePasswordTest extends SweetSugar {

    final String oldPassword = password_r;
    final String newPass_r = faker.internet().password(8, 100);

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
        headerPage.hoverDropDown()
                .clickProfileLink();
    }

    @Test
    public void editUserPasswordTest() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickOnPasswordChangeButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        PasswordChangePage passwordChangePage = new PasswordChangePage(driver);
        passwordChangePage.enterOldPassword(oldPassword)
                .enterNewPassword(newPass_r)
                .enterConfirmNewPassword(newPass_r)
                .clickOnSavePasswordButton();
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.openHeaderPage()
                .hoverDropDown()
                .clickOnLogoutDropdown();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(email_r)
                .inputPassword(newPass_r)
                .clickLoginButton();

        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
        defineTestResultEquals("http://chatty.telran-edu.de:8089/homeblog", driver.getCurrentUrl());

    }
}