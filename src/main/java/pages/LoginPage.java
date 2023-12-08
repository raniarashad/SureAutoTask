package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameInput;

    @FindBy(xpath = "//input[@name='password']")
    WebElement PassInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement SubmitLoginBtn;

    public void login(String Email, String Password)
    {
        SetElementText(usernameInput,Email);
        SetElementText(PassInput,Password);
        ClickButton(SubmitLoginBtn);
    }
}
