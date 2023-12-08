package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeePage extends PageBase{
    public EmployeePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='orangehrm-header-container']//button")
    WebElement AddBtn;

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstname;

    @FindBy(xpath = "//input[@name='middleName']")
    WebElement middleName;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastName;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement SaveBtn;
    public void addEmployee(String firtname, String lastname, String middlename)
    {
        ClickButton(AddBtn);
        SetElementText(firstname, firtname);
        SetElementText(middleName, middlename);
        SetElementText(lastName, lastname);
        ClickButton(SaveBtn);
    }
}
