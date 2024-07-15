package BlogPageSuit;

import baseTest.BaseTest;
import chatty_pagges.BlogPage;
import chatty_pagges.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

;import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlogPageTest extends BaseTest {

    @Test
    public void createPostWithAllEmptyFields() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("")
                .inputPassword("")
                .clickLoginButton();
        BlogPage blogPage = new BlogPage(driver);
        sleep(500);
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
}