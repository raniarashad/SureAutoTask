package Tests;

import org.junit.Assert;
import org.junit.experimental.theories.Theories;
import org.testng.annotations.DataProvider;
import pages.*;

import org.testng.annotations.Test;

import static Tests.TestBase.driver;

public class EmployeeTest {

    EmployeePage object;
    HomePage object2;

    EmployeeList employlistObject;
    EmployeeDetailsPage detailsPageObject;

    JobDetailsPage jobDetailsPageObject;
    @DataProvider(name = "EmployeeData")
    public Object[][] FirstNameProvider() {
        return new Object[][]{
                {"ran000301903", "ra1n00930030", "ra133009000"},
        };
    }

    @Test(priority = 1, dataProvider = "EmployeeData")
    public void AddNewEmployee(String firstname, String middlename, String lastname) throws InterruptedException {
//        ScreenRecorder.startRecording("Authenticate New User");
        object2 = new HomePage(driver);
        object2.ClickOnPIMLink();
        object = new EmployeePage(driver);
        object.addEmployee(firstname, middlename, lastname);
        object2.ClickOnPIMLink();
//        ScreenRecorder.stopRecording();
        employlistObject = new EmployeeList(driver);
        employlistObject.ClickEditBtn(firstname);
        detailsPageObject = new EmployeeDetailsPage(driver);
        Thread.sleep(2000);
        detailsPageObject.ContactDetailsPage();
//        detailsPageObject.fillDetails();
//        Assert.assertTrue(detailsPageObject.successAlert.isDisplayed());
        detailsPageObject.AddAttach();
        Assert.assertTrue(detailsPageObject.successAlert.isDisplayed());
    }

    @Test(priority = 2)
    public void AddJobDetails() throws InterruptedException {
        jobDetailsPageObject = new JobDetailsPage(driver);
        jobDetailsPageObject.OpenJobDetails();
        jobDetailsPageObject.AddJobDetails();
        Assert.assertTrue(jobDetailsPageObject.successAlert.isDisplayed());
    }
}
