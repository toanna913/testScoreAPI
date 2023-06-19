package Projects.AuToAuthen;

import Helpers.HeaderAuthenHelper;
import Objects.Authen.VerifyOTPObj;
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

public class VerifyOTP {
    @BeforeClass
    static void init() {
        RestAssured.baseURI = "https://api.mservice.com.vn";
        RestAssured.basePath = "/backend/otp-app/public/REG_DEVICE_MSG";

    }
    @Test
    @Parameters({"User-number", "errorCode"})
    public void VerifyOTP(ITestContext context, String user, int errCode){
        Response response = given()
                .headers(HeaderAuthenHelper.HeaderAuthenHelper())
                .body(VerifyOTPObj.postBody(user))
                .log().all()
                .when().post()
                .then()
                .extract().response();
        System.out.println(response.body().asString());
        int statusCode = response.getStatusCode();
        System.out.println(" Status Code  for Post request is :" + statusCode);
        JsonPath jsonPathEvaluator = response.jsonPath();
        Integer errorCode = jsonPathEvaluator.get("errorCode");
        var res = response.body().asString();
        var jObject = new JSONObject(res);
      //  var setupKey = jObject.getJSONObject("extra").getString("setupKey");
      //  context.setAttribute("setupKey", setupKey);
     //   var ohash = jObject.getJSONObject("extra").getString("ohash");
       // context.setAttribute("ohash", ohash);
        System.out.println(" Error Code  for Post request is :" + errorCode);
        Assert.assertTrue(errorCode.equals(errCode));

    }
}
