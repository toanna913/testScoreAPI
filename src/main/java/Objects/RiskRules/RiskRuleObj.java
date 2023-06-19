package Objects.RiskRules;

import io.vertx.core.json.JsonObject;

public class RiskRuleObj {
    public static String postBodyRissRule (){

        String requestbody = "{\n" +
                "   \"queue\": \"ha_qu_anti_fraud\",\n" +
                "    \"data\": {\n" +
                "        \"user\": \"0975329909\",\n" +
                "        \"msgType\": \"TRAN_HIS_INIT_MSG\",\n" +
                "        \"momoMsg\": {\n" +
                "            \"channel\": \"SDK\",\n" +
                "            \"tranType\": 7,\n" +
                "            \"io\": -1,\n" +
                "            \"quantity\": 1,\n" +
                "            \"user\": \"0935123123\",\n" +
                "            \"partnerId\": \"MOMOAGAV20220420\",\n" +
                "            \"partnerCode\": \"MOMOAGAV20220420\",\n" +
                "            \"amount\": 2000001,\n" +
                "            \"moneySource\": 1,\n" +
                "            \"originalAmount\": 2000001,\n" +
                "            \"serviceId\": \"partnermomo\",\n" +
                "            \"billId\": \"MOMOAGAV20220420-bcf1kb8pzjgl4ibxt9u-d156d892a662cc43475e050f8757d0e3\",\n" +
                "            \"_class\": \"mservice.backend.entity.msg.TranHisMsg\",\n" +
                "            \"ID\": \"03472b8b-8242-4da1-9555-6d74771ef286\"\n" +
                "    }\n" +
                "}\n" +
                "}";
        return requestbody;
    }
    public static String postBodyMapBank (String user, int originalAmount, String sourceToken){

        String requestbody = "{\n" +
                "   \"queue\": \"ha_qu_anti_fraud\",\n" +
                "    \"data\": {\n" +
                "        \"user\": \""+ user+"\",\n" +
                "        \"msgType\": \"TRAN_HIS_INIT_MSG\",\n" +
                "        \"momoMsg\": {\n" +
                "            \"channel\": \"END_USER\",\n" +
                "            \"tranType\": 1,\n" +
                "            \"io\": 1,\n" +
                "            \"quantity\": 1,\n" +
                "            \"user\": \"0999999990\",\n" +
                "            \"partnerId\": \"MOMOAGAV20220420\",\n" +
                "            \"partnerCode\": \"MOMOAGAV20220420\",\n" +
                "            \"moneySource\": 2,\n" +
                "            \"originalAmount\": 0,\n" +
                "            \"serviceId\": \"partnermomo\",\n" +
                "        \"sourceToken\": \""+ sourceToken+"\",\n" +
                "            \"billId\": \"MOMOAGAV20220420-bcf1kb8pzjgl4ibxt9u-d156d892a662cc43475e050f8757d0e3\",\n" +
                "            \"_class\": \"mservice.backend.entity.msg.TranHisMsg\",\n" +
                "            \"ID\": \"03472b8b-8242-4da1-9555-6d74771ef286\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
       //return requestbody;

        var jo = new JsonObject(requestbody);
        jo.getJsonObject("data").getJsonObject("momoMsg").put("originalAmount", originalAmount);
        return  jo.toString();
    }
}
