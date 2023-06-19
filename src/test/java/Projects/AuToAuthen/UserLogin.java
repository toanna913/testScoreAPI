package Projects.AuToAuthen;

import Helpers.HeaderLoginHelper;
import Objects.Authen.UserLoginObj;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserLogin {
    @BeforeClass
    static void init() {
        RestAssured.baseURI = "https://owa.mservice.com.vn";
        RestAssured.basePath = "/public/login";

    }
    @Test
    @Parameters({"pHash", "AppVer", "deviceOS", "errCode"})
    public void UserLogin(String pHash, String appVer,String deviceOS, int errCode) throws Exception {
        // String pHash = "SmsaWPBMGlCsnfdFZjHblfZUNWPLnxCBRRiLs5HixFRziWY2qrGs7gP9z2T4KhaXEQcVs170DI3jKMORouLjoQ7B2uKsAqQKdGV973Jn4N8=";
        Response response = given()
                .headers(HeaderLoginHelper.HeaderLoginHelper())
                .body(UserLoginObj.postBody(pHash, appVer, deviceOS))
                .log().all()
                .when().post()
                .then()
                .extract().response();
        System.out.println(response.body().asString());
        int statusCode = response.getStatusCode();
        System.out.println(" Status Code  for Post request is :" + statusCode);
        JsonPath jsonPathEvaluator = response.jsonPath();
        Integer errorCode = jsonPathEvaluator.get("errorCode");
    Assert.assertTrue(errorCode.equals(errCode));
    }
}
