package chatty_pagges;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {
    @FindBy(xpath= "//input[@data-test='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@data-test='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@data-test='confirmPassword']")
    private WebElement confirmPasswordInput;
    @FindBy(className = "registration-btn")
    private WebElement registrationButton;
    private WebElement signUpLink;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public CreateAccountPage open(){
        driver.get("http://chatty.telran-edu.de:8089/registration");
        return this;
    }
    public void clickRegistryLink(){ signUpLink.click();}
    public void inputEmail(){emailInput.sendKeys("test@gmail.com");}
    public void inputPassword(){
        passwordInput.sendKeys("qwerty");
    }
    public void confirmPassword(){
        confirmPasswordInput.sendKeys("qwerty");
    }
    public void clickLogin(){
        registrationButton.click();
    }
}
