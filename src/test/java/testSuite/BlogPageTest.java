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

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void successCreatePost() throws InterruptedException {
    ChromeDriver driver = new ChromeRegistry().registerDriver();
    driver.get("http://chatty.telran-edu.de:8089/login");
    LoginPage loginPage = new LoginPage(driver, wait);
    loginPage.inputEmail();
    loginPage.inputPassword();
    loginPage.clickLogin();

    BlogPage blogPage = new BlogPage(driver, wait);
    String postTitle = "Nature";
    sleep(5000);
    blogPage.clickCreatePost();
    blogPage.titleInput();
    blogPage.descriptionInput();
    blogPage.contentInput();
    sleep(5000);
    blogPage.submitButton();
    sleep(5000);
    assertTrue(blogPage.isPostPresent(postTitle));
    }
    @Test
    public void createPostWithAllEmptyFields() throws InterruptedException {
        ChromeDriver driver = new ChromeRegistry().registerDriver();
        driver.get("http://chatty.telran-edu.de:8089/login");
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.inputEmail();
        loginPage.inputPassword();
        loginPage.clickLogin();

        BlogPage blogPage = new BlogPage(driver, wait);
        sleep(500);
        blogPage.clickCreatePost();
        blogPage.submitButton();
        assertTrue(blogPage.isContentErrorVisible(), "Please fill the field");
    }
    @Test
    public void successSavePostAsDraft() throws InterruptedException {
        ChromeDriver driver = new ChromeRegistry().registerDriver();
        driver.get("http://chatty.telran-edu.de:8089/login");
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.inputEmail();
        loginPage.inputPassword();
        loginPage.clickLogin();

        BlogPage blogPage = new BlogPage(driver, wait);
        sleep(5000);
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

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
