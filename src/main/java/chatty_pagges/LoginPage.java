package chatty_pagges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Instant;

public class LoginPage extends BasePage {
    @FindBy(xpath= "//input[@data-test='email']")
    private WebElement emailEditBox;
    @FindBy(xpath = "//input[@data-test='password']")
    private WebElement passwordEditBox;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    @FindBy(xpath = "//p[@class='link']//a")
    private WebElement signUpLink;
    @FindBy(className = "text-error")
    private WebElement errorMessageUserNotFound;
    @FindBy(xpath = "//div[@class='text-error']")
    private WebElement errorMessageEmailAlreadyExists;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open(){
        driver.get("http://chatty.telran-edu.de:8089/login");
        return this;
    }
    public LoginPage inputEmail(String email) {
        emailEditBox.sendKeys(email);
        return this;
    }
    public LoginPage inputPassword(String password){
        passwordEditBox.sendKeys(password);
        return this;
    }
    public BlogPage clickLoginButton(){
        loginButton.click();
        return new BlogPage(driver);
    }
    public CreateAccountPage clickSignUpLink(){
        signUpLink.click();
        return new CreateAccountPage(driver);
    }

    public String getTextFromErrorMessage(){
        return errorMessageUserNotFound.getText();
    }
    public boolean loginButtonIsDisplayed(){
        return loginButton.isDisplayed();
    }
}
