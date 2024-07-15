package chatty_pagges;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends BasePage {
    @FindBy(xpath= "//input[@data-test='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@data-test='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@data-test='confirmPassword']")
    private WebElement confirmPasswordInput;
    @FindBy(className = "registration-btn")
    private WebElement registrationButton;
    @FindBy(tagName = "select")
    private WebElement selectDropDownMenu;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public CreateAccountPage inputEmail(String email){
        emailInput.sendKeys(email);
    return this;
    }
    public CreateAccountPage inputPassword(String password){

        passwordInput.sendKeys(password);
        return this;
    }
    public CreateAccountPage confirmPassword(String password){

        confirmPasswordInput.sendKeys(password);
        return this;
    }
    public BlogPage clickRegistrationButton(){
        registrationButton.click();
        return new BlogPage(driver);
    }
    public CreateAccountPage selectUser(){
        Select select = new Select(selectDropDownMenu);
        select.selectByValue("user");
        return this;
    }
    public CreateAccountPage selectAdmin(){
        Select select = new Select(selectDropDownMenu);
        select.selectByValue("admin");
        return this;
    }}
