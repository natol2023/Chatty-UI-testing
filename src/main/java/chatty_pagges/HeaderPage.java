package chatty_pagges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage {
    @FindBy(className = "header__user")
    private WebElement headerUserText;//поменять название
    @FindBy(css = "[href='/login']")
    private WebElement logoutLink;
    @FindBy(className = "dropdown-menu")
    private WebElement headerDropdownMenu;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public HeaderPage open(){
        driver.get("http://chatty.telran-edu.de:8089/homeblog");
        return this;
    }

    public WebElement getHeaderUserText() {
        return headerUserText;
    }

    public void clickOnLogoutButton() {
        headerUserText.click();
        logoutLink.click();
    }

    public WebElement getHeaderDropdownMenu() {
        return headerDropdownMenu;
    }

    public void selectYourProfileOption() {
        WebElement profileOption = headerDropdownMenu.findElement(By.xpath(".//a[contains(text(), 'Your Profile')]"));
        profileOption.click();//написать элемент
    }

    public void clickOnHeaderUserMenu() {
        headerUserText.click();
    }
}
//    public void hoverDropdownMenu() {
//        new Actions(driver).moveToElement(headerUser).perform();
//    }
//}