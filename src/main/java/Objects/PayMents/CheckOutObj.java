package Objects.PayMents;

import io.vertx.core.json.JsonObject;

import java.sql.Timestamp;

public class CheckOutObj {
    public static String postBodyCheckout (String itemId, String billId){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String requestbody = "{\n" +
                "  \"appCode\": \"4.0.18\",\n" +
                "  \"appId\": \"\",\n" +
                "  \"appVer\": 40130,\n" +
                "  \"buildNumber\": 0,\n" +
                "  \"channel\": \"APP\",\n" +
                "  \"cmdId\": \"1675416552344000000\",\n" +
                "  \"time\": \""+ (timestamp.getTime())+"\",\n" +
                "  \"deviceOS\": \"ios\",\n" +
                "  \"errorCode\": 0,\n" +
                "  \"errorDesc\": \"\",\n" +
                "  \"extra\": {\n" +
                "    \"checkSum\": \"UG2PEIqRERrp1A+xSAc0nkzv0Mv2nEknBZM8OXLz3PGoaLx/F3I1TtIHr7p7sasrfNz17xAUJzZgOMsy7phlWQ==\"\n" +
                "  },\n" +
                "  \"lang\": \"vi\",\n" +
                "  \"user\": \"0975329905\",\n" +
                "  \"msgType\": \"CHECKOUT\",\n" +
                "  \"momoMsg\": {\n" +
                "    \"miniAppId\": \"vn.momo.paymentoffline\",\n" +
                "    \"bundleCode\": \"M001\",\n" +
                "    \"tranType\": 7,\n" +
                "    \"serviceCode\": \"topbar_scancode\",\n" +
                "    \"paymentType\": \"P_PLATFORM\",\n" +
                "    \"cartInfo\": [\n" +
                "      {\n" +
                "        \"itemId\": \""+ itemId+"\",\n" +
                "        \"billId\": \""+ billId+"\",\n" +
                "                \"status\": 0\n" +
                "               // \"discountCode\": \"cashback\"\n" +
                "            }\n" +
                "    ],\n" +
                "    \"sourceInit\": {\n" +
                "      \"moneySource\": 1,\n" +
                "      \"moneySourceInfo\": {\n" +
                "        \"partnerCode\": \"momo\",\n" +
                "        \"rowCardId\": \"\",\n" +
                "        \"cardNumber\": \"\",\n" +
                "        \"cardType\": \"\",\n" +
                "        \"cardSchema\": \"\",\n" +
                "        \"bankName\": \"Ví MoMo\",\n" +
                "        \"sourceToken\": \"SOF-1\",\n" +
                "        \"bankCustomerId\": \"\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"cartState\": \"CHECKOUT\",\n" +
                "    \"_class\": \"mservice.backend.entity.msg.OrderCartMsg\"\n" +
                "  },\n" +
                "  \"pass\": \"ff891237a052ad07f21b01824f1661f08b22a3e9482e4a1bd9661df14c4c056e\"\n" +
                "}";
      return  requestbody;
    }
    public static String postBodyNewCheckout (String itemId, String billId, String tranData){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        String requestbody = "{\n" +
                "    \"queue\": \"ha_qu_be_checkout_onestep_dev\",\n" +
                "    \"data\": {\n" +
                "  \"appCode\": \"4.0.18\",\n" +
                "  \"appId\": \"vn.momo.payment\",\n" +
                "  \"appVer\": 40181,\n" +
                "  \"buildNumber\": 1562,\n" +
                "  \"channel\": \"APP\",\n" +
                "  \"cmdId\": \"1682046672728000000\",\n" +
                "  \"time\": \""+ (timestamp.getTime())+"\",\n" +
                "  \"deviceOS\": \"ios\",\n" +
                "  \"errorCode\": 0,\n" +
                "  \"errorDesc\": \"\",\n" +
                "  \"lang\": \"vi\",\n" +
                "  \"user\": \"0975329905\",\n" +
                "  \"msgType\": \"CHECKOUT\",\n" +
                "  \"extra\": {\n" +
                "    \"isShop\": false\n" +
                "  },\n" +
                "  \"momoMsg\": {\n" +
                "    \"bundleCode\": \"M001\",\n" +
                "    \"tranType\": 7,\n" +
                "    \"cartInfo\": [\n" +
                "      {\n" +
                "        \"serviceType\": \"BILL_PAY\",\n" +
                "        \"serviceId\": \"ninhhoa_water\",\n" +
                "        \"serviceCode\": \"billpaywater\",\n" +
                "        \"serviceName\": \"Nước Ninh Hòa\",\n" +
                "        \"itemId\": \""+ itemId+"\",\n" +
                "        \"billId\": \""+ billId+"\",\n" +
                "        \"itemName\": null,\n" +
                "        \"description\": \"Nước Ninh Hòa\",\n" +
                "        \"originalPrice\": 20000,\n" +
                "        \"price\": 20000,\n" +
                "        \"quantity\": 1,\n" +
                "        \"unit\": null,\n" +
                "        \"fee\": 2000,\n" +
                "        \"fromCore\": false,\n" +
                "        \"visibleFee\": true,\n" +
                "        \"agentFee\": \"mservice\",\n" +
                "        \"feeFromCore\": true,\n" +
                "        \"markupFee\": false,\n" +
                "        \"discountPrice\": 0,\n" +
                "        \"discountFee\": 0,\n" +
                "        \"voucher\": null,\n" +
                "        \"usedVoucher\": 0,\n" +
                "        \"discountCode\": null,\n" +
                "        \"discountCampaignAmount\": 0,\n" +
                "        \"prepaidIds\": null,\n" +
                "        \"usedPrepaid\": 0,\n" +
                "        \"cbAmount\": 0,\n" +
                "        \"discountGroupSaleAmount\": 0,\n" +
                "        \"originalAmount\": 22000,\n" +
                "        \"amount\": 22000,\n" +
                "        \"itemToken\": null,\n" +
                "        \"data3rdCode\": null,\n" +
                "        \"data3rdToken\": null,\n" +
                "        \"parentId\": null,\n" +
                "        \"paymentTid\": 0,\n" +
                "        \"paymentStatus\": 0,\n" +
                "        \"allowToFalse\": 0,\n" +
                "        \"orderState\": 0,\n" +
                "        \"status\": 0,\n" +
                "        \"tranData\": \"0\", \n" +
                "        \"extrasDiscount\": {},\n" +
                "        \"errorCode\": 0,\n" +
                "        \"errorDesc\": null\n" +
                "      }\n" +
                "    ],\n" +
                "    \"paymentType\": \"IN_APP\",\n" +
                "    \"miniAppId\": \"vn.momo.mobilecenter\",\n" +
                "    \"sourceInit\": {\n" +
                "      \"moneySource\": 1,\n" +
                "      \"moneySourceInfo\": {\n" +
                "        \"partnerCode\": \"momo\",\n" +
                "        \"rowCardId\": \"\",\n" +
                "        \"cardNumber\": \"\",\n" +
                "        \"cardType\": \"\",\n" +
                "        \"cardSchema\": \"\",\n" +
                "        \"bankName\": \"Ví MoMo\",\n" +
                "        \"sourceToken\": \"SOF-1\",\n" +
                "        \"bankCustomerId\": \"\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"cartState\": \"CHECKOUT\",\n" +
                "    \"_class\": \"mservice.backend.entity.msg.OrderCartMsg\"\n" +
                "  }\n" +
                "}\n" +
                "}";
        var jo = new JsonObject(requestbody);
        jo.getJsonObject("data").getJsonObject("momoMsg").getJsonArray("cartInfo").getJsonObject(0).put("tranData", tranData);
        return  jo.toString();
    }
}
