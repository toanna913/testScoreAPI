package Projects.MultiBill;

import Objects.WaterBill.CreateBillObj;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateBillElectric {
    @BeforeClass
    static void init() {
        RestAssured.baseURI = "http://172.16.13.13:1234";
        RestAssured.basePath = "/rabbitClient";
    }
    @Test
    @Parameters({"amount"})
    public void CreateBill(ITestContext context, String amount) {
        Response response = given()
                .accept("application/json")
                .contentType("application/json") // request.header
                .body(CreateBillObj.postBodyBill(amount))
                .log().all()
                .when().post()
                .then()
                .extract().response();
        System.out.println(response.body().asString());
        int statusCode = response.getStatusCode();
        System.out.println(" Status Code  for Post request is :" + statusCode);
    }
}
