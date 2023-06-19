package Projects.AuToRiskRule;

import Helpers.HeaderRiskRule;
import Objects.RiskRules.RiskRuleObj;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RiskRuleChangeDevide {
    @BeforeClass
    static void init() {
        RestAssured.baseURI = "http://172.16.13.13:1234";
        RestAssured.basePath = "/rabbitClient";

    }

    @Test
    public void CheckUserRisk(){
        Response response = given()
                .headers(HeaderRiskRule.HeaderRiskHelper())
                .body(RiskRuleObj.postBodyRissRule())
                .log().all()
                .when().post()
                .then()
                .extract().response();
        JsonPath jsonPathEvaluator = response.jsonPath();
        Integer errorCode = jsonPathEvaluator.get("errorCode");
        Assert.assertTrue(errorCode.equals(-1071));
    }
}
