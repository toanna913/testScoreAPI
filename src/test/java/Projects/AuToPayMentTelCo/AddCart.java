package Projects.AuToPayMentTelCo;

import Helpers.HeaderMangerHelper;
import Objects.PayMentTelCo.AddCartTelCoObj;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.vertx.core.json.JsonObject;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddCart {
    @BeforeClass
    static void init() {
        RestAssured.baseURI = "https://api.mservice.com.vn";
        RestAssured.basePath = "/api/telco/add-to-cart";

    }

    @Test
    public void AddCart(ITestContext context) {

        Response response = given()
                .headers(HeaderMangerHelper.httpHeaderManager())
                .body(AddCartTelCoObj.postBodyCartTelco())
                .log().all()
                .when().post()
                .then()
                .extract().response();
        System.out.println(response.body().asString());
        int statusCode = response.getStatusCode();
        var res = response.body().asString();
        var jObject = new JsonObject(res);
        var items = jObject.getJsonObject("data").getJsonArray("items");
        if (!items.isEmpty()) {
            var item = items.getJsonObject(0);
            var productId = item.getString("productId");
            var itemId = item.getString("itemId");
            System.out.println("productId :" + productId);
            System.out.println("itemId :" + itemId);
            context.setAttribute("productId", productId);
            context.setAttribute("itemId", itemId);
        }

    }
}
