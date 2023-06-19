package Projects.AuToPayMent;

import Objects.PayMents.CreateBillObj;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateBill {
    @BeforeClass
    static void init() {
        RestAssured.baseURI = "http://172.16.13.13:1234";
        RestAssured.basePath = "/rabbitClient";

    }

    @Test

    public void CreateBill(ITestContext context) {

        Response response = given()
                .accept("application/json")
                .contentType("application/json") // request.header
                .body(CreateBillObj.postBodyBill())
                .log().all()
                .when().post()
                .then()
                .extract().response();
        System.out.println(response.body().asString());
        int statusCode = response.getStatusCode();
        System.out.println(" Status Code  for Post request is :" + statusCode);

    }
}
