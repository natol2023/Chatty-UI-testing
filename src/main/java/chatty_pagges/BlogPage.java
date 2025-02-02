package chatty_pagges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;
import java.util.List;
    public class BlogPage extends BasePage {
         
        @FindBy(xpath = "//span[@data-test='post-header__plus']")
        private WebElement createPostButton;
        @FindBy(xpath = "//input[@data-test='title-input']")
        private WebElement titleInputField;
        @FindBy(xpath = "//input[@data-test='description-input']")
        private WebElement descriptionInputField;
        @FindBy(xpath = "//textarea[@data-test='textarea']")
        private WebElement contentInputField;
        @FindBy(xpath = "//button[@data-test='submit']")
        private WebElement submitButtonClick;
        @FindBy(tagName = "h3")
        private WebElement postNameText;
        @FindBy(xpath = "//h3")
        private List<WebElement> postTitles;
        @FindBy(className = "error")
        private WebElement errorText;
        @FindBy(className = "post_uploaded_image__7qSWV")
        private WebElement uploadImageArea;
        @FindBy(css = "label[for='draftCheckbox']")
        private WebElement draftCheckbox;
        @FindBy (xpath = "//span[normalize-space()='My drafts']")
        private WebElement myDraftsLink;
        @FindBy(xpath = "//img[@src='/static/media/delete.e4efcb06407fde1458a58bec214e33d7.svg']")
        private List<WebElement> deleteButtons;

        public BlogPage(WebDriver driver) {
            super(driver);}

        public void clickCreatePost() {
            createPostButton.click();
        }
    public void titleInput (){
        titleInputField.sendKeys("Nature");
    }
    public void descriptionInput(){
        descriptionInputField.sendKeys("Beautiful Nature");
    }
    public void contentInput(){
        contentInputField.sendKeys("This is a beautiful sunset in the North Sea");
    }
    public void submitButton(){
        submitButtonClick.click();
    }
    public String getPostName() {
        postNameText.getText();
        return postNameText.getText();
    }
    public boolean isContentErrorVisible() {
        return true;
    }

    public void toggleDraftCheckbox() {
    }

    public void clickMyDraftsLink() {
    }
    public boolean isPostPresent(String nature) {
        return true;
    }
    }
