package pages;

import io.cucumber.java.de.Wenn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class EmployeeDetailsPage extends PageBase {
    public EmployeeDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Contact Details")
    WebElement ContactDetails;

    @FindBy(xpath = "//label[text()='Street 1']/../../div//input")
//    @FindBy(id = "contact_street1")
    WebElement Stree1;

    @FindBy(xpath = "//label[text()='Street 2']/../../div//input")
//    @FindBy(id = "contact_street2")
    WebElement Street2;

    @FindBy(xpath = "//label[text()='City']/../../div//input")
    WebElement City;

    @FindBy(xpath = "//label[text()='State/Province']/../../div//input")
    WebElement State;

    @FindBy(xpath = "//label[text()='Zip/Postal Code']/../../div//input")
    WebElement postalCode;

    @FindBy(xpath = "//label[text()='Country']/../../div//input")
    WebElement Country;

    @FindBy(xpath = "//label[text()='Home']/../../div//input")
    WebElement Home;

    @FindBy(xpath = "//label[text()='Mobile']/../../div//input")
    WebElement Mobile;

    @FindBy(xpath = "//label[text()='Work']/../../div//input")
    WebElement Work;

    @FindBy(xpath = "//label[text()='Work Email']/../../div//input")
    WebElement WorkEmail;

    @FindBy(xpath = "//label[text()='Other Email']/../../div//input")
    WebElement OtherEmail;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--text']")
    WebElement AddAttachmentBtn;

    @FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
    WebElement SaveBtn1;

    @FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[2]")
    WebElement SaveBtn2;

    @FindBy(xpath = "//div[@class='oxd-file-button']")
    WebElement uploadFileBtn;

    @FindBy(id = "//div[@class='oxd-toast-content oxd-toast-content--success']")
    public WebElement successMsg;

    @FindBy(xpath = "//div[@id='oxd-toaster_1']//div")
    public WebElement successAlert;

    public static String generateRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 8;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
    String street1Text = generateRandomString();
    String street2Text = generateRandomString();

    public void ContactDetailsPage()
    {
        ClickButton(ContactDetails);
    }
    public void fillDetails() throws InterruptedException {
        Thread.sleep(5000);
        SetElementText(Stree1, street1Text);
        SetElementText(Street2, street2Text);
        City.sendKeys("Cairo");
        State.sendKeys("state test");
        postalCode.sendKeys("1234567");

        Home.sendKeys("01581173259");
        Mobile.sendKeys("01521278233");
        Work.sendKeys("1111515781");
        WorkEmail.sendKeys("ra77053073@gmail.com");
        OtherEmail.sendKeys("ran70350737@gmail.com");
        ClickButton(SaveBtn1);
    }

    public void AddAttach() throws InterruptedException {
        String imagePath =  System.getProperty("user.dir") + "\\ScreenShots\\imageTest.jpg";
        ClickButton(AddAttachmentBtn);
        uploadFileBtn.click();
        Thread.sleep(5000);
        SetElementText(uploadFileBtn,imagePath);
        ClickButton(SaveBtn2);
    }
}
