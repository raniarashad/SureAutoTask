package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeList extends PageBase {
    public EmployeeList(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='oxd-icon-button oxd-table-cell-action-space'][2]")
    WebElement EditIcon;

    @FindBy(xpath = "(//div[@class='oxd-input-group__label-wrapper'])[1]/..//div[2]//input")
    WebElement EmployeenameSearch;

    @FindBy(xpath = "(//div[@class='oxd-form-actions'])//button[2]")
    WebElement SearchBtn;

    public void ClickEditBtn(String searchFirstname)
    {
        EmployeenameSearch.sendKeys(searchFirstname);
        ClickButton(SearchBtn);
        ClickButton(EditIcon);
    }
}
