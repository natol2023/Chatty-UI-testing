package testSuite_Admin;

import baseTest.BaseTest;
import chatty_pagges.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginAdminTest extends BaseTest {
    @Test
    public void loginValidAdminTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("admin1@email.com")
                .inputPassword("admin123")
                .clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/users"));
        defineTestResultEquals("http://chatty.telran-edu.de:8089/users", driver.getCurrentUrl());
    }
}
