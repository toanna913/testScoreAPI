package Projects.MultiBill;

import Helpers.HeaderMangerHelper;
import Objects.MultiBill.AddCartMultiBillObj;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.vertx.core.json.JsonObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddCartInsuranceHaveParent {
    @BeforeClass
    static void init() {
        RestAssured.baseURI = "http://172.16.13.13:1234";
        RestAssured.basePath = "/rabbitClient";

    }
    @Test

    public void AddCartInsurance(ITestContext context ){
        String billInsu = context.getAttribute("billInsu").toString();
        String typeInsu = context.getAttribute("typeInsu").toString();
        String itemId = context.getAttribute("itemId").toString();
        Response response = given()
                .headers(HeaderMangerHelper.httpHeaderManager())
                .body(AddCartMultiBillObj.postBodyCartInsurance(billInsu, typeInsu, itemId))
                .log().all()
                .when().post()
                .then()
                .extract().response();
        var res = response.body().asString();
        var jObject = new JsonObject(res);
        var cartInfoInsu = jObject.getJsonArray("cartInfo").getJsonObject(0);

        //Add value for context
        context.setAttribute("cartInfoInsu", cartInfoInsu);
//        context.setAttribute("tranData", tranData);
        System.out.println(response.body().asString());
        int statusCode = response.getStatusCode();
        System.out.println(" Status Code  for Post request 2 is :" + statusCode);
        System.out.println(" cartInfoInsu :" + cartInfoInsu);
        JsonPath jsonPathEvaluator = response.jsonPath();
        Integer errorCode = jsonPathEvaluator.get("resultCode");
        Assert.assertTrue(errorCode.equals(0));
    }
}
