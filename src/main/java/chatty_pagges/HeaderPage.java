package chatty_pagges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage {
    @FindBy(className = "header__user")
    private WebElement headerUserText;
    @FindBy(css = "[href='/login']")
    private WebElement logoutButton;
    @FindBy(className = "dropdown-menu")
    private WebElement headerDropdownMenu;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public HeaderPage open() {
        driver.get("http://chatty.telran-edu.de:8089/homeblog");
        return this;
    }

    public WebElement getHeaderUserText() {
        return headerUserText;
    }

    public void clickOnLogoutButton() {
        headerUserText.click();
        logoutButton.click();
    }

    public WebElement getHeaderDropdownMenu() {
        return headerDropdownMenu;
    }

    public void selectYourProfileOption() {
        WebElement profileOption = headerDropdownMenu.findElement(By.xpath(".//a[contains(text(), 'Your Profile')]"));
        profileOption.click();
    }

    public void clickOnHeaderUserMenu() {
        headerUserText.click();
    }
}
