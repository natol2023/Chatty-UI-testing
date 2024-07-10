import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath= "//input[@data-test='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@data-test='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputEmail() {
        emailInput.sendKeys("test@gmail.com");
    }
    public void inputPassword(){
        passwordInput.sendKeys("qwerty");
    }
    public void clickLogin(){
        loginButton.click();
    }
}
