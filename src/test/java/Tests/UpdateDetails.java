package Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateDetails {

    public void updateEmployeeDetails()
    {
        String baseURL = "https://opensource-demo.orangehrmlive.com/api/";
        String empNumber = "178";

        // Request body
        String requestBody = "{\"lastName\":\"hassan8\",\"firstName\":\"tamer8\",\"middleName\":\"mohamed8\",\"employeeId\":\"{{employeeId}}\",\"otherId\":\"5\",\"drivingLicenseNo\":\"5845\",\"drivingLicenseExpiredDate\":\"2025-08-31\",\"gender\":\"1\",\"maritalStatus\":\"Single\",\"birthday\":\"1999-11-30\",\"nationalityId\":55,\"sinNumber\":\"01452144\"}";

        // Send PUT request using Rest-Assured
        Response response = RestAssured.given()
                .baseUri(baseURL)
                .basePath("pim/employees/" + empNumber + "/personal-details")
                .contentType(ContentType.JSON)
                .header("Accept", "application/json, text/plain, */*")
                .header("Accept-Language", "en-US,en;q=0.9")
                .header("Connection", "keep-alive")
                .header("Cookie", "orangehrm=486544069e25866c7652fd7cd2a77ed5")
                .header("Origin", "https://opensource-demo.orangehrmlive.com")
                .header("Referer", "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/178")
                .header("Sec-Fetch-Dest", "empty")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Site", "same-origin")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"119\", \"Chromium\";v=\"119\", \"Not?A_Brand\";v=\"24\"")
                .header("sec-ch-ua-mobile", "?0")
                .header("sec-ch-ua-platform", "\"Windows\"")
                .body(requestBody)
                .put();

        // Print response details
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
    }

}
