package editProfileTestSuit;

import chatty_pagges.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChangePasswordTest extends SweetSugar {

    private final String oldPassword = password_r;
    private final String newPass_r = faker.internet().password(8, 100);

    @BeforeEach
    public void goToProfilePage() {
        registerNewUser();
        openProfilePage();
    }

    @Test
    public void editUserPasswordTest() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickOnPasswordChangeButton();
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
        defineTestResultEquals("http://chatty.telran-edu.de:8089/homeblog", driver.getCurrentUrl());
    }
}