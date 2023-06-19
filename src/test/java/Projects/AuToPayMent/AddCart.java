package Projects.AuToPayMent;

import Helpers.HeaderMangerHelper;
import Objects.PayMents.AddCartObj;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.vertx.core.json.JsonObject;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.ITestContext;
import static io.restassured.RestAssured.given;

public class AddCart {
    @BeforeClass
    static void init() {
        RestAssured.baseURI = "https://api.mservice.com.vn";
        RestAssured.basePath = "/api/bill/core/checkinfo";

    }
    @Test
    public void AddCart(ITestContext context ){

        Response response = given()
                .headers(HeaderMangerHelper.httpHeaderManager())
                .body(AddCartObj.postBodyCart())
                .log().all()
                .when().post()
                .then()
                .extract().response();
        var res = response.body().asString();
        var jObject = new JsonObject(res);
        var billId = jObject.getJsonObject("momoMsg").getString("billId");
        var extra = jObject.getJsonObject("extra");
        var dataResponse = extra.getString("dataResponse");
        var jDataResponse = new JSONObject(dataResponse);
        var jA =  (JSONObject)jDataResponse.getJSONObject("extras").getJSONObject("order_msg").getJSONArray("items").get(0);
        var itemId  = jA.getString("itemId");
        var tranData = jA.getString("tranData");
    //    ITestContext context = null;
        context.setAttribute("itemId", itemId);
        context.setAttribute("billId", billId);
        context.setAttribute("tranData", tranData);
        System.out.println(response.body().asString());
        int statusCode = response.getStatusCode();
        System.out.println(" Status Code  for Post request 2 is :" + statusCode);
        System.out.println(" billID :" + billId);
        System.out.println(" itemId :" + itemId);
      //  System.out.println(" itemId :" + itemId);


    }
}
