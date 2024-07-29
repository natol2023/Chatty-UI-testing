package editProfileTestSuit;

import baseTest.BaseTest;
import chatty_pagges.*;
import net.datafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SweetSugar extends BaseTest {

    LoginPage loginPage = new LoginPage(driver);
    CreateAccountPage createAccountPage = new CreateAccountPage(driver);
    Faker faker = new Faker();
    protected final String password_r = faker.internet().password(8, 100);
    protected final String email_r = faker.internet().emailAddress();
    protected final String name_r = faker.name().firstName();
    protected final String surname_r = faker.date().toString();
    protected final String phone_r = faker.phoneNumber().toString();

    public void registerNewUser() {
        loginPage.clickSignUpLink();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/registration"));
        createAccountPage.inputEmail(email_r)
                .inputPassword(password_r)
                .confirmPassword(password_r)
                .clickRegistrationButton();
    }

    public void openProfilePage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(email_r)
                .inputPassword(password_r)
                .clickLoginButton();

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.openHeaderPage()
                .hoverDropDown()
                .clickHeaderDropDown()
                .clickProfileLink();

    }
}