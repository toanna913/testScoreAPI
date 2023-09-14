package Projects.Gift;

import Helpers.HeaderBalance;
import Objects.P2P.SendMoneyP2PObj;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SendMoneyP2P {
    @BeforeClass
    static void init() {
        RestAssured.baseURI = "https://ai-dev.mservice.io";
        RestAssured.basePath = "/giftv2-sync/filter";

    }

    @Test
    public void SendP2P() {
        String user = "0975329909";
        Response response = given()
                .headers(HeaderBalance.HeaderBalanceHelper())
                .body(SendMoneyP2PObj.postBody(user))
                .log().all()
                .when().post()
                .then()
                .extract().response();
        System.out.println(response.body().asString());
        int statusCode = response.getStatusCode();
        System.out.println(" Status Code  for Post request is :" + statusCode);
        JsonPath jsonPathEvaluator = response.jsonPath();
        Integer errorCode = jsonPathEvaluator.get("result");
        Assert.assertTrue(errorCode.equals(0));
    }


}
