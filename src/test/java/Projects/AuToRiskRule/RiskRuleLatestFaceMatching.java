package Projects.AuToRiskRule;

import Helpers.HeaderRiskRule;
import Objects.RiskRules.RiskRuleObj;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RiskRuleFaceMatching {
    @BeforeClass
    static void init() {
        RestAssured.baseURI = "http://172.16.13.13:1234";
        RestAssured.basePath = "/rabbitClient";

    }

    @Test
    @Parameters({"user", "kyc", "face_matching"})
    public void RiskRuleFaceMatching(String user, String kyc, String face_matching){
        Response response = given()
                .headers(HeaderRiskRule.HeaderRiskHelper())
                .body(RiskRuleObj.postBodyFaceMatching(user, kyc, face_matching))
                .log().all()
                .when().post()
                .then()
                .extract().response();
        JsonPath jsonPathEvaluator = response.jsonPath();
        Integer errorCode = jsonPathEvaluator.get("result");
        Assert.assertTrue(errorCode.equals(0));
    }
}
