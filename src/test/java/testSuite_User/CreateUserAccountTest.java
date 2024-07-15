package testSuite_User;

import baseTest.BaseTest;
import chatty_pagges.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateUserAccountTest extends BaseTest {

    @Test
    public void registerUserTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .clickSignUpLink()
                .inputEmail("example4@email.com")
                .inputPassword("example1234")
                .confirmPassword("example1234")
                .selectUser()
                .clickRegistrationButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
        defineTestResultEquals("http://chatty.telran-edu.de:8089/homeblog", driver.getCurrentUrl());

    }
    @Test
    public void registerAlreadyExistingUserTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .clickSignUpLink()
                .inputEmail("example4@email.com")
                .inputPassword("example1234")
                .confirmPassword("example1234")
                .selectUser()
                .clickRegistrationButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessageEmailAlreadyExists;
        errorMessageEmailAlreadyExists = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-error")));
        assertTrue(loginPage.getTextFromErrorMessage().contains("Email already exists"));

}
}
