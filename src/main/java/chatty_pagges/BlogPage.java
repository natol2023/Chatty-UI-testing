package chatty_pagges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.Thread.sleep;

public class BlogPage extends BasePage {
    private final WebDriverWait wait;
    @FindBy(xpath = "//span[@data-test='post-header__plus']")
    private WebElement createPostButton;
    @FindBy(xpath = "//input[@data-test=\"title-input\"]")
    private WebElement titleInputField;
    @FindBy(xpath = "//input[@data-test=\"description-input\"]")
    private WebElement descriptionInputField;
    @FindBy(xpath = "//textarea[@data-test=\"textarea\"]")
    private WebElement contentInputField;
    @FindBy(xpath = "//button[@data-test=\"submit\"]")
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
  //  @FindBy(xpath = "//img[@alt=\"delete button\"]")
  @FindBy(xpath = "//img[@src='/static/media/delete.e4efcb06407fde1458a58bec214e33d7.svg']")
    private List<WebElement> deleteButtons;

    public BlogPage(WebDriver driver, WebDriverWait wait) {
        super(driver);
        this.wait = wait;
        PageFactory.initElements(driver, this); // Initialize PageFactory elements
    }

    public void clickCreatePost() {
        createPostButton.click();
    }
    public void titleInput() {
        titleInputField.sendKeys("Nature");
    }
    public void descriptionInput() {
        descriptionInputField.sendKeys("Beautiful Nature");
    }
    public void contentInput() {
        contentInputField.sendKeys("This is a beautiful sunset in the North Sea");
    }
    public void submitButton() {
        submitButtonClick.click();
    }
    public boolean isPostPresent(String postTitle) {
        wait.until(ExpectedConditions.visibilityOfAllElements(postTitles));
        for (WebElement post : postTitles) {
            if (post.getText().equals(postTitle)) {
                return true;
            }
        }
        return false;
    }
    public boolean isContentErrorVisible() {
        wait.until(ExpectedConditions.visibilityOf(errorText));
        return errorText.isDisplayed();
    }
    public void toggleDraftCheckbox() {
        draftCheckbox.click();
    }
    public void clickMyDraftsLink() {
        myDraftsLink.click();
    }
//    public void deleteFirstPost() {
//        if (!deleteButtons.isEmpty()) {
//            deleteButtons.get(0).click();
//            wait.until(ExpectedConditions.stalenessOf(deleteButtons.get(0)));
public void openPost(String postTitle) {
    wait.until(ExpectedConditions.visibilityOfAllElements(postTitles));
    for (WebElement post : postTitles) {
        if (post.getText().equals(postTitle)) {
            post.click(); // Предполагаем, что клик по посту открывает его
            break;
        }
    }
}

    public void deletePost(String postTitle) {
        openPost(postTitle); // Открываем пост

        // Убедимся, что кнопка удаления видима и кликабельна
        WebElement deleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='delete button']")));
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteButton.click();


        // Ожидание исчезновения поста
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h3[text()='" + postTitle + "']")));
    }
}








