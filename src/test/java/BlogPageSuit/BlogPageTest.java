package BlogPageSuit;

import baseTest.BaseTest;
import chatty_pagges.BlogPage;
import chatty_pagges.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

;import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlogPageTest extends BaseTest {
        @Test
        public void successCreatePost() throws InterruptedException {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.open()
                    .inputEmail("batrakalena86@gmail.com")
                    .inputPassword("qwerty12345")
                    .clickLoginButton();
            BlogPage blogPage = new BlogPage(driver);
            String postTitle = "Nature";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
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
        BlogPage blogPage = new BlogPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
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
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
    blogPage.clickCreatePost();
    blogPage.titleInput();
    blogPage.descriptionInput();
    blogPage.contentInput();
    blogPage.toggleDraftCheckbox();
    blogPage.submitButton();
    blogPage.clickMyDraftsLink();
    assertTrue(blogPage.isPostPresent("Nature"));
}
}