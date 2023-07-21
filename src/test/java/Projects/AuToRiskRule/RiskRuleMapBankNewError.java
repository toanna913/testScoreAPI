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

public class RiskRuleMapBankConditional {
    @BeforeClass
    static void init() {
        RestAssured.baseURI = "http://172.16.13.13:1234";
        RestAssured.basePath = "/rabbitClient";

    }
    @Test
    @Parameters({"user", "amount", "sourceToken", "equal", "purpose", "option"})
    public void CheckUserRisk(String user, int amount, String sourceToken, int equal, String purpose, String option){
        Response response = given()
                .headers(HeaderRiskRule.HeaderRiskHelper())
                .body(RiskRuleObj.postBodyMapBank(user, amount, sourceToken))
                .log().all()
                .when().post()
                .then()
                .extract().response();
        JsonPath jsonPathEvaluator = response.jsonPath();
        Integer errorCode = jsonPathEvaluator.get("errorCode");
        var res = response.body().asString();
        var jObject = new JSONObject(res);
        var fraudData = new JSONObject( jObject.getJSONObject("extra").getString("fraudData"));
        purpose =  fraudData.getJSONObject("refParams").getJSONArray("buttons").getJSONObject(0).getString("purpose");
        option =  fraudData.getJSONObject("refParams").getJSONArray("buttons").getJSONObject(0).getString("option");
        System.out.println("conditional: "+ purpose);
        System.out.println("errorCode: "+ errorCode);
        Assert.assertTrue(errorCode.equals(equal));
        Assert.assertTrue(purpose.equals(purpose));
        Assert.assertTrue(option.equals(option));
    }
}
