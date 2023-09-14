package Projects.Common;

import Helpers.HeaderAuthenHelper;
import Objects.Commons.RegisterMoMoWalletObj;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RegisterMoMoWallet {
    @BeforeClass
    static void init() {
        RestAssured.baseURI = "http://172.16.13.13:1234";
        RestAssured.basePath = "/rabbitClient";

    }

    @Test
    @Parameters({"userNumber"})
    public void CheckUser(String userNumber ){
      //  String userNumber = "0975329906";
        Response response = given()
                .headers(HeaderAuthenHelper.HeaderAuthenHelper())
                .body(RegisterMoMoWalletObj.postBody(userNumber))
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
        // lay data response luu vao bien local
        var res = response.body().asString();
        var jObject = new JSONObject(res);
        var reference = jObject.getJSONObject("datas").getString("reference");
        System.out.println("SDT vi MoMo la: "+reference);
    }
}
