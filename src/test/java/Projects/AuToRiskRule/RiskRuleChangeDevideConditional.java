package Projects.AuToRiskRule;

import Helpers.HeaderRiskRule;
import Objects.RiskRules.RiskRuleObj;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RiskRuleChangeDevide {
    @BeforeClass
    static void init() {
        RestAssured.baseURI = "http://172.16.13.13:1234";
        RestAssured.basePath = "/rabbitClient";

    }

    @Test
    @Parameters({"user", "amount", "equal"})
    public void CheckUserRisk(String user, int amount, int equal){
        Response response = given()
                .headers(HeaderRiskRule.HeaderRiskHelper())
                .body(RiskRuleObj.postBodyRissRule(user, amount))
                .log().all()
                .when().post()
                .then()
                .extract().response();
        JsonPath jsonPathEvaluator = response.jsonPath();
        Integer errorCode = jsonPathEvaluator.get("errorCode");
        System.out.println("errorCode: "+ errorCode);
        Assert.assertTrue(errorCode.equals(equal));

    }
    @Test
    @Parameters({"user", "amount", "equal", "conditional"})
    public void CheckUserRiskConditional(String user, int amount, int equal, String conditional){
        Response response = given()
                .headers(HeaderRiskRule.HeaderRiskHelper())
                .body(RiskRuleObj.postBodyRissRule(user, amount))
                .log().all()
                .when().post()
                .then()
                .extract().response();
        JsonPath jsonPathEvaluator = response.jsonPath();
        Integer errorCode = jsonPathEvaluator.get("errorCode");
        // get data from json array
        var res = response.body().asString();
        var jObject = new JSONObject(res);
        var fraudData = new JSONObject( jObject.getJSONObject("extra").getString("fraudData"));
        conditional = fraudData.getJSONArray("refParams").getJSONObject(0).getString("purpose");
        System.out.println("conditional: "+ conditional);
        System.out.println("errorCode: "+ errorCode);
        Assert.assertTrue(errorCode.equals(equal));
        Assert.assertTrue(conditional.equals(conditional));
    }
}
