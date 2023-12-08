package Tests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
public class AddNewEmployee {

    @Test
    public void addEmployeeTest() {
        RestAssured.baseURI = "https://opensource-demo.orangehrmlive.com";

        // Request payload for adding an employee
        String requestBody = "{\"firstName\":\"tamer8\",\"middleName\":\"mohamed8\",\"lastName\":\"hassan8\",\"empPicture\":null,\"employeeId\":\"0378\"}";

        Response response = RestAssured.given()
                .header("Accept", "application/json")
                .header("Bearer Token","42088.JJ7ubt9xIt_AlBu5INDAmaLha83QHd-SFU9hmhtRjig.V_fdF5YVd4zy0X3ME76JzdOvXJSaLL3gRz8uxU1j2WFV9qEPnSZFsan1Vg")
                .header("Accept-Language", "en-US,en;q=0.9")
                .header("Connection", "keep-alive")
                .header("Content-Type", "application/json")
                .header("Cookie", "orangehrm=486544069e25866c7652fd7cd2a77ed5")
                .header("Origin", "https://opensource-demo.orangehrmlive.com")
                .header("Referer", "https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee")
                .header("Sec-Fetch-Dest", "empty")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Site", "same-origin")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36")
                .header("sec-ch-ua-mobile", "?0")
                .header("sec-ch-ua-platform", "Windows")
                .body(requestBody)
                .post("/web/index.php/api/pim/addEmployee");

        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
    }
}
