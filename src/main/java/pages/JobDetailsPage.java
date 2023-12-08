package pages;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.util.List;

public class JobDetailsPage extends PageBase {
    public JobDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Job")
    WebElement JobDetails;

    @FindBy(xpath = "//input[@placeholder='yyyy-mm-dd']")
    WebElement JoinedDate;

    @FindBy(xpath = "//label[text()='Job Title']/../..//div[@class='oxd-select-text-input']")
    WebElement JobTitle;

    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[2]")
    WebElement JobCategory;

    @FindBy(xpath = "//label[text()='Sub Unit']/../..//div[@class='oxd-select-text-input']")
    WebElement SubUnit;

    @FindBy(xpath = "//label[text()='Location']/../..//div[@class='oxd-select-text-input']")
    WebElement Location;

    @FindBy(xpath = "//label[text()='Employment Status']/../..//div[@class='oxd-select-text-input']")
    WebElement EmploymentStatus;

    @FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
    WebElement IncludeContractDetails;

    @FindBy(xpath = "//div//label[text()='Contract Start Date']/../..//div//input[@placeholder='yyyy-mm-dd']")
    WebElement ContractStartDate;

    @FindBy(xpath = "//div//label[text()='Contract End Date']/../..//div//input[@placeholder='yyyy-mm-dd']")
    WebElement ContractEndDate;

    @FindBy(className = "oxd-toast oxd-toast--success oxd-toast-container--toast oxd-toast")
    public WebElement SuccessMessage;

    @FindBy(xpath = "//div[@id='oxd-toaster_1']//div")
    public WebElement successAlert;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement SaveButton;

    boolean textFound1 = false;
    boolean textFound2 = false;
    boolean textFound3 = false;
    boolean textFound4 = false;
    public void OpenJobDetails() {
        ClickButton(JobDetails);
    }

    public void AddJobDetails() {
        sleep(3);
        SetElementText(JoinedDate, "2015-06-15");

        ClickButton(JobTitle);
        while (!textFound1) {
            JobTitle.sendKeys(Keys.ARROW_DOWN);
            // Get the current value/text of the input element
            String currentValue = JobTitle.getText();
            // Check if the desired text is found
            if (currentValue.equals("Software Engineer")) {
                textFound1 = true;
                break;
            }
        }
        JobTitle.sendKeys(Keys.ENTER);
        sleep(2);
        ClickButton(SubUnit);
        while (!textFound3) {
            SubUnit.sendKeys(Keys.ARROW_DOWN);
            // Get the current value/text of the input element
            String currentValue = SubUnit.getText();
            // Check if the desired text is found
            if (currentValue.equals("Quality Assurance")) {
                textFound3 = true;
                break;
            }
        }
        SubUnit.sendKeys(Keys.ENTER);
        ClickButton(Location);
        while (!textFound4) {
            Location.sendKeys(Keys.ARROW_DOWN);
            // Get the current value/text of the input element
            String currentValue = Location.getText();
            // Check if the desired text is found
            if (currentValue.equals("Canadian Regional HQ")) {
                textFound4 = true;
                break;
            }
        }
        Location.sendKeys(Keys.ENTER);

        ClickButton(EmploymentStatus);
        while (!textFound2) {
            EmploymentStatus.sendKeys(Keys.ARROW_DOWN);
            // Get the current value/text of the input element
            String currentValue = EmploymentStatus.getText();
            // Check if the desired text is found
            if (currentValue.equals("Part-Time Internship")) {
                textFound2 = true;
                break;
            }
        }
        sleep(2);
        EmploymentStatus.sendKeys(Keys.ENTER);


        ClickButton(IncludeContractDetails);
        LocalDate today = getTodayDate();
        SetElementText(ContractStartDate, String.valueOf(today));
        LocalDate endDate = addOneYear(today);
        SetElementText(ContractEndDate, String.valueOf(endDate));

        ClickButton(SaveButton);
    }

    public static LocalDate getTodayDate() {
        return LocalDate.now();
    }

    public static LocalDate addOneYear(LocalDate startDate) {
        return startDate.plusYears(1);
    }
}
