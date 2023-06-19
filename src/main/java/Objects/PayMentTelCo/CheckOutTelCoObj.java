package Objects.PayMentTelCo;

import java.sql.Timestamp;

public class CheckOutTelCoObj {
    public static String postBodyCheckoutTelCo (String productId, String itemId){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String requestbody = "{\n" +
                "  \"appCode\": \"4.0.13\",\n" +
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
                "        \"productId\": \""+ productId+"\",\n" +
                "        \"itemId\": \""+ itemId+"\",\n" +
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
}
