package Projects.AuToAuthen;

import Helpers.HeaderAuthenHelper;
import Objects.Authen.SendOTPObj;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SendOTP {
    @BeforeClass
    static void init() {
        RestAssured.baseURI = "https://api.mservice.com.vn";
        RestAssured.basePath = "/backend/otp-app/public/SEND_OTP_MSG";

    }
    @Test
    @Parameters({"User-number", "AppVer", "errorCode"})
    public void SendOTP(ITestContext context,String User, String AppVer, int ErrCode){

        Response response = given()
                .headers(HeaderAuthenHelper.HeaderAuthenHelper())
                .body(SendOTPObj.postBody(User, AppVer))
                .log().all()
                .when().post()
                .then()
                .extract().response();
        System.out.println(response.body().asString());
        int statusCode = response.getStatusCode();
        System.out.println(" Status Code  for Post request is :" + statusCode);
        JsonPath jsonPathEvaluator = response.jsonPath();
        Integer errorCode = jsonPathEvaluator.get("errorCode");
        Assert.assertTrue(errorCode.equals(ErrCode));
        var res = response.body().asString();
        var jObject = new JSONObject(res);
        var cmdId = jObject.getString("cmdId");
        context.setAttribute("cmdId", cmdId);
    }
}
