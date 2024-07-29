package testSuite_User;

import baseTest.BaseTest;
import chatty_pagges.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginUserTest extends BaseTest {

    @Test
    public void loginUnregisteredUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("abcd0000@gmail.com")
                .inputPassword("abc123456789")
                .clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessageUserNotFound;
        errorMessageUserNotFound = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-error")));
        assertTrue(loginPage.getTextFromErrorMessage().contains("User not found. Please register."));
    }

    @Test
    public void loginValidUserTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("example4@email.com")
                .inputPassword("example1234")
                .clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
        defineTestResultEquals("http://chatty.telran-edu.de:8089/homeblog", driver.getCurrentUrl());
    }

    @Test
    public void logoutFromHeaderTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("example4@email.com")
                .inputPassword("example1234")
                .clickLoginButton();
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.openHeaderPage()
                .hoverDropDown()
                .clickOnLogoutDropdown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/login"));
        defineTestResultEquals("http://chatty.telran-edu.de:8089/login", driver.getCurrentUrl());
    }

}


