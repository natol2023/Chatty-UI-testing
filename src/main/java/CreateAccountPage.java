import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {
    @FindBy(xpath = "//p[@class='link']//a")
    private WebElement signUpLink;
    @FindBy(xpath= "//input[@data-test='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@data-test='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@data-test='confirmPassword']")
    private WebElement confirmPasswordInput;

    @FindBy(className = "registration-btn")
    private WebElement registrationButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
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
