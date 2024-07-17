//package editProfileTestSuit;
//
//import chatty_pagges.BlogPage;
//import chatty_pagges.HeaderPage;
//import chatty_pagges.LoginPage;
//import chatty_pagges.ProfilePage;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//
//public class ChangePasswordTest extends SweetSugar {
//
//    String name_r = faker.name().firstName();
//    String surname_r = faker.date().toString();
//    String phone_r = faker.phoneNumber().toString();
//    String password_r = faker.internet().password(8,100);
//    String email_r = faker.internet().emailAddress();
//
//    String oldPassword = password_r;
//    String newPass_r = faker.internet().password(8,100);
//
//    @BeforeEach
//    public void goToProfilePage() {
//        registerNewUser();
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.open()
//                .inputEmail(email_r)
//                .inputPassword(password_r)
//                .clickLoginButton();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
//
//        HeaderPage headerPage = new HeaderPage(driver);
//        headerPage.hoverDropDown()
//                .clickProfileLink();
//    }
//
//    @Test
//    public void editUserPassword() {
//        ProfilePage profilePage = new ProfilePage(driver);
//        profilePage.clickOnPasswordChangeButton();
//        profilePage.inputOldPassword(oldPassword)
//                .inputNewPassword(newPass_r)
//                .inputConfirmNewPassword(newPass_r)
//                .clickOnSaveButton()
//                .openHeader()
//                .hoverDropDown()
//                .clickOnLogout()
//                .inputEmail("asdfasdf")
//                .inputPassword(newPass_r)
//                .clickLogin;
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
//        defineTestResultEquals("http://chatty.telran-edu.de:8089/homeblog", driver.getCurrentUrl());
//
//        BlogPage blogPage = new BlogPage(driver);
//        blogPage.openHeader()
//                .hoverDropDown()
//                .clickOnYourProfile()
//                .
//
//    }
//
//}