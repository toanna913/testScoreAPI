package Objects.MultiBill;

import java.sql.Timestamp;

public class CheckOutObj {
    public static String postBodyCheckout (String itemId, String billId, String cartInfoInsu){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String requestbody = "{\n" +
                "  \"appCode\": \"4.0.18\",\n" +
                "  \"appId\": \"\",\n" +
                "  \"appVer\": 40181,\n" +
                "  \"buildNumber\": 2777,\n" +
                "  \"channel\": \"APP\",\n" +
                "  \"cmdId\": \"1689563834877000000.cada00a2\",\n" +
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
                "                \"serviceType\": \"BILL_PAY\",\n" +
                "                \"serviceId\": \"evn_quangngai\",\n" +
                "                \"serviceCode\": \"billpaywater\",\n" +
                "                \"serviceName\": \"Điện lực Quảng Ngãi\",\n" +
                "        \"itemId\": \""+ itemId+"\",\n" +
                "        \"itemCode\": \""+ billId+"\",\n" +
                "                \"description\": \"Điện lực Quảng Ngãi\",\n" +
                "                \"originalPrice\": 20000,\n" +
                "                \"price\": 20000,\n" +
                "                \"quantity\": 1,\n" +
                "                \"fee\": 0,\n" +
                "                \"visibleFee\": true,\n" +
                "                \"feeFromCore\": true,\n" +
                "                \"agentFee\": \"vttiinternal_test\",\n" +
                "                \"originalAmount\": 10000,\n" +
                "                \"amount\": 10000,\n" +
                "                \"paymentStatus\": 0,\n" +
                "                \"orderState\": 0,\n" +
                "                \"status\": 0,\n" +
                "                \"tranData\": \"\",\n" +
                "                \"redeemStatus\": {\n" +
                "                    \"voucherError\": 0,\n" +
                "                    \"voucherDesc\": \"\",\n" +
                "                    \"discountError\": 0,\n" +
                "                    \"discountDesc\": \"\",\n" +
                "                    \"prepaidError\": 0,\n" +
                "                    \"prepaidDesc\": \"\",\n" +
                "                    \"discountFeeError\": 0,\n" +
                "                    \"discountFeeDesc\": \"\",\n" +
                "                    \"groupSaleError\": 0,\n" +
                "                    \"groupSaleDesc\": \"\"\n" +
                "                }\n" +
                "            }\n" +
                "    ],\n" +
                "        \""+ cartInfoInsu+"\",\n" +
                "    \"sourceInit\": {\n" +
                "      \"moneySource\": 1,\n" +
                "      \"moneySourceInfo\": {\n" +
                "        \"partnerCode\": \"momo\",\n" +
                "        \"bankName\": \"Ví MoMo\",\n" +
                "        \"sourceToken\": \"SOF-1\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"cartState\": \"CHECKOUT\",\n" +
                "    \"_class\": \"mservice.backend.entity.msg.OrderCartMsg\"\n" +
                "  },\n" +
                "  \"pass\": \"48197ede0a33f9fc4a06bb6c3444d937c3668a6efdb985ef64106cb8c84510c8\"\n" +
                "}";
      return  requestbody;
    }

}
