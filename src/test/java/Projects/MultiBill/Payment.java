package Projects.AuToPayMent;

import Helpers.HeaderMangerHelper;
import Objects.WaterBill.PaymentObj;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Payment {
    @BeforeClass
    static void init() {
        RestAssured.baseURI = "https://owa.mservice.com.vn";
        RestAssured.basePath = "/api/v1/order/payment";

    }
    @Test
    @Parameters({"equal"})
    public void Payment(ITestContext context, int equal) {

        String requestId = context.getAttribute("requestId").toString();
        String cartId = context.getAttribute("cartId").toString();
        JSONArray cartInfo = (JSONArray)context.getAttribute("cartInfo");
        JSONObject sourceInit = (JSONObject)context.getAttribute("sourceInit");
        String purchaseId = context.getAttribute("purchaseId").toString();
        JSONObject purchaseInfo = (JSONObject)context.getAttribute("purchaseInfo");
        String purchaseToken = context.getAttribute("purchaseToken").toString();
        JSONObject extra = (JSONObject)context.getAttribute("extra");

        Response response = given()
                .headers(HeaderMangerHelper.httpHeaderManager())
                .body(PaymentObj.postBodyPayment(requestId, cartId, cartInfo, sourceInit, purchaseId, purchaseInfo, purchaseToken, extra))
                .log().all()
                .when().post()
                .then()
                .extract().response();
        System.out.println(response.body().asString());
        int statusCode = response.getStatusCode();
        System.out.println(" Status Code  for Post request is :" + statusCode);
        JsonPath jsonPathEvaluator = response.jsonPath();
        Integer errorCode = jsonPathEvaluator.get("errorCode");
        System.out.println(" Status Code  for Post errorCode is :" + errorCode);
        Assert.assertTrue(errorCode.equals(equal));
    }
}
