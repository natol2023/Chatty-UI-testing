package testSuite;

import baseTest.BaseTest;
import chatty_pagges.BlogPage;
import chatty_pagges.LoginPage;
import chromeRegistry.ChromeRegistry;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

public class BlogPageTest extends BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Test
    public void successCreatePost() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("batrakalena86@gmail.com")
                .inputPassword("qwerty12345")
                .clickLoginButton();
        BlogPage blogPage = new BlogPage(driver);
        String postTitle = "Nature";
        sleep(5000);
        blogPage.clickCreatePost();
        blogPage.titleInput();
        blogPage.descriptionInput();
        blogPage.contentInput();
        blogPage.submitButton();
        assertTrue(blogPage.isPostPresent(postTitle));
    }
    @Test
    public void createPostWithAllEmptyFields() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("batrakalena86@gmail.com")
                .inputPassword("qwerty12345")
                .clickLoginButton();
        sleep(500);
        BlogPage blogPage = new BlogPage(driver);
        blogPage.clickCreatePost();
        blogPage.submitButton();
        assertTrue(blogPage.isContentErrorVisible(), "Please fill the field");
    }
    @Test
    public void successSavePostAsDraft() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("example4@email.com")
                .inputPassword("example1234")
                .clickLoginButton();
        BlogPage blogPage = new BlogPage(driver);
        blogPage.clickCreatePost();
        blogPage.titleInput();
        blogPage.descriptionInput();
        blogPage.contentInput();
        blogPage.toggleDraftCheckbox();
        blogPage.submitButton();
        sleep(2000);
        blogPage.clickMyDraftsLink();
        sleep(2000);
        assertTrue(blogPage.isPostPresent("Nature"));
    }

    }

