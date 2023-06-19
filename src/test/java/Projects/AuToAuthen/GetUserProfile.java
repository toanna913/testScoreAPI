package Projects.AuToAuthen;

import Helpers.HeaderAuthenHelper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUserProfile {
    @BeforeClass
    static void init() {
        RestAssured.baseURI = "http://api-dev.mservice.io";
        RestAssured.basePath = "/user-profile-app-api-core-service/profile/v1/get-fields";

    }
    @Test
    public void GetUserProfile(ITestContext context){

        Response response = given()
                .headers(HeaderAuthenHelper.HeaderAuthenHelper())
                .queryParam("fieldNames", "deviceName,validateEmail,lastImeiKey,address")
                .queryParam("requestTime", "1619493829882")
                .queryParam("user", "0975329909")
                .queryParam("cmdId", "cbc0e5af-9d5f-4e4f-93dc-d86006c7ab2d")
                .queryParam("callerId", "sample-caller-id")
                .log().all()
                .when().get()
                .then()
                .extract().response();
        System.out.println(response.body().asString());
        int statusCode = response.getStatusCode();
        System.out.println(" Status Code  for Post request is :" + statusCode);
        JsonPath jsonPathEvaluator = response.jsonPath();
        Integer errorCode = jsonPathEvaluator.get("errorCode");
        Assert.assertTrue(errorCode.equals(0));
        var res = response.body().asString();
        var jObject = new JSONObject(res);
        var lastImeiKey = jObject.getJSONObject("userProfile").getString("lastImeiKey");
        context.setAttribute("lastImeiKey", lastImeiKey);
    }
}
