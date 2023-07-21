package Projects.AuToPayMent;

import Helpers.HeaderMangerHelper;
import Objects.WaterBill.CheckOutObj;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CheckOut {
    @BeforeClass
    static void init() {
        RestAssured.baseURI = "https://owa.mservice.com.vn";
        RestAssured.basePath = "/api/v1/order/checkout";

    }

    @Test


    public void CheckOut(ITestContext context) {
        Response response = given()
                .headers(HeaderMangerHelper.httpHeaderManager())
                .body(CheckOutObj.postBodyCheckout((context.getAttribute("itemId").toString()), (context.getAttribute("billId").toString())))
                .log().all()
                .when().post()
                .then()
                .extract().response();
        System.out.println(response.body().asString());
        int statusCode = response.getStatusCode();
        System.out.println(" Status Code  for Post request is :" + statusCode);
        // lay data response luu vao bien local
        var res = response.body().asString();
        var jObject = new JSONObject(res);
        var requestId = jObject.getJSONObject("momoMsg").getString("requestId");
        var cartId = jObject.getJSONObject("momoMsg").getString("cartId");
        var cartInfo = jObject.getJSONObject("momoMsg").getJSONArray("cartInfo");
        var sourceInit = jObject.getJSONObject("momoMsg").getJSONObject("sourceInit");
        var purchaseId = jObject.getJSONObject("momoMsg").getString("purchaseId");
        var purchaseInfo = jObject.getJSONObject("momoMsg").getJSONObject("purchaseInfo");
        var purchaseToken = jObject.getJSONObject("momoMsg").getString("purchaseToken");
        var extra = jObject.getJSONObject("extra");
        //Add value for context
        context.setAttribute("requestId", requestId);
        context.setAttribute("cartId", cartId);
        context.setAttribute("cartInfo", cartInfo);
        context.setAttribute("sourceInit", sourceInit);
        context.setAttribute("purchaseId", purchaseId);
        context.setAttribute("purchaseInfo", purchaseInfo);
        context.setAttribute("purchaseToken", purchaseToken);
        context.setAttribute("extra", extra);
        JsonPath jsonPathEvaluator = response.jsonPath();
        Integer errorCode = jsonPathEvaluator.get("errorCode");
        Assert.assertTrue(errorCode.equals(0));
    }
}
