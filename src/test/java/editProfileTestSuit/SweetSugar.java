package editProfileTestSuit;

import baseTest.BaseTest;
import chatty_pagges.*;
import net.datafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class SweetSugar extends BaseTest {

    @FindBy(xpath = "//h1")
    private WebElement formTitle;

    LoginPage loginPage = new LoginPage(driver);
//    HeaderPage headerPage = new HeaderPage(driver);
//    BlogPage blogPage = new BlogPage(driver);
    CreateAccountPage createAccountPage = new CreateAccountPage(driver);
//    ProfilePage userprofilePage = new ProfilePage(driver);
//    PasswordChangePage passwordChangePage = new PasswordChangePage(driver);
    Faker faker = new Faker();

    final String password_r = faker.internet().password(8,100);
    final String email_r = faker.internet().emailAddress();
    final String name_r = faker.name().firstName();
    final String surname_r = faker.date().toString();
    final String phone_r = faker.phoneNumber().toString();


    public void registerNewUser() {
        loginPage.clickSignUpLink();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/registration"));
        createAccountPage.inputEmail(email_r);
        createAccountPage.inputPassword(password_r);
        createAccountPage.confirmPassword(password_r);
        createAccountPage.clickRegistrationButton();
    }


}
