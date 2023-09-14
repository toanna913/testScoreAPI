package Projects.AuToAuthen;

import Helpers.HeaderAuthenHelper;
import Objects.Authen.CheckUserObj;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CheckUser {
    @BeforeClass
    static void init() {
        RestAssured.baseURI = "https://api.mservice.com.vn";
        RestAssured.basePath = "/backend/auth-app/public/CHECK_USER_BE_MSG";

    }

    @Test
    @Parameters({"user-number", "errorCode"})
    //invocationCount = 2
    public void CheckUser(String userNumber, int erCode){
            Response response = given()
                    .headers(HeaderAuthenHelper.HeaderAuthenHelper())
                    .body(CheckUserObj.postBody(userNumber))
                    .log().all()
                    .when().post()
                    .then()
                    .extract().response();
            JsonPath jsonPathEvaluator = response.jsonPath();
            Integer errorCode = jsonPathEvaluator.get("errorCode");
             Assert.assertTrue(errorCode.equals(erCode));
        }
}
