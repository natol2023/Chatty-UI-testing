package testSuite_Admin;

import baseTest.BaseTest;
import chatty_pagges.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CreateAdminAccountTest extends BaseTest {
    @Test
    public void registerUserTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .clickSignUpLink()
                .inputEmail("admin1@email.com")
                .inputPassword("admin123")
                .confirmPassword("admin123")
                .selectAdmin()
                .clickRegistrationButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
        defineTestResultEquals("http://chatty.telran-edu.de:8089/homeblog", driver.getCurrentUrl());

    }
}


