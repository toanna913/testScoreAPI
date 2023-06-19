package Projects.AuToPayMent;

import Helpers.HeaderBalance;
import Objects.PayMents.GetBalanceUserObj;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBalanceUser {
    @BeforeClass
    static void init() {
        RestAssured.baseURI = "http://172.16.13.13:1234";
        RestAssured.basePath = "/rabbitClient";
    }
    @Test
    @Parameters({"User", "errorCode"})
    public void GetBalanceUser(String User, int ErrCode){

        Response response = given()
                .headers(HeaderBalance.HeaderBalanceHelper())
                .body(GetBalanceUserObj.postBody(User))
                .log().all()
                .when().post()
                .then()
                .extract().response();
        System.out.println(response.body().asString());
        int statusCode = response.getStatusCode();
        System.out.println(" Status Code  for Post request is :" + statusCode);
        JsonPath jsonPathEvaluator = response.jsonPath();
        Integer errorCode = jsonPathEvaluator.get("resultCode");
        Assert.assertTrue(errorCode.equals(ErrCode));
        var res = response.body().asString();
        var jObject = new JSONObject(res);
        var sofInfo = (JSONObject)jObject.getJSONArray("sofInfo").get(0);
        var balance = sofInfo.get("balance");
        System.out.println("balance user: "+balance);

    }

}
