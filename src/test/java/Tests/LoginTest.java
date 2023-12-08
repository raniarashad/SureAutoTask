package Tests;

import Helper.DataReaderExcelSheet;
import Helper.ScreenRecorder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class LoginTest extends TestBase{

    LoginPage object;

    @DataProvider(name = "ExcelData")
    public Object[][] LoginData() throws IOException {
        // get data from ExcelReader Class
        DataReaderExcelSheet Reader = new DataReaderExcelSheet();
        return Reader.getExcelData(0);
    }

    @Test(priority = 1,dataProvider = "ExcelData")
    public void AuthenticateNewUser(String Email, String Pass) throws Exception {
        ScreenRecorder.startRecording("Authenticate New User");
        object = new LoginPage(driver);
        object.login(Email,Pass);
        Thread.sleep(5000);
        ScreenRecorder.stopRecording();
    }
}
