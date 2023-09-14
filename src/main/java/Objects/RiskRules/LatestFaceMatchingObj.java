package Objects.RiskRules;

import io.vertx.core.json.JsonObject;

public class RiskRuleObj {
    public static String postBodyRissRule (String user, int originalAmount){

        String requestbody = "{\n" +
                "   \"queue\": \"ha_qu_anti_fraud\",\n" +
                "    \"data\": {\n" +
                "        \"user\": \""+ user+"\",\n" +
                "        \"buildNumber\": \"TRAN_HIS_INIT_MSG\",\n" +
                "        \"appVer\": \"40180\",\n" +
                "        \"buildNumber\": \"2776\",\n" +
                "        \"momoMsg\": {\n" +
                "            \"channel\": \"SDK\",\n" +
                "            \"tranType\": 7,\n" +
                "            \"io\": -1,\n" +
                "            \"quantity\": 1,\n" +
                "            \"user\": \"0935123123\",\n" +
                "            \"partnerId\": \"MOMOAGAV20220420\",\n" +
                "            \"partnerCode\": \"MOMOAGAV20220420\",\n" +
                "            \"amount\": 2000000,\n" +
                "            \"moneySource\": 1,\n" +
                "            \"originalAmount\": 0,\n" +
                "            \"serviceId\": \"partnermomo\",\n" +
                "            \"billId\": \"MOMOAGAV20220420-bcf1kb8pzjgl4ibxt9u-d156d892a662cc43475e050f8757d0e3\",\n" +
                "            \"_class\": \"mservice.backend.entity.msg.TranHisMsg\",\n" +
                "            \"ID\": \"03472b8b-8242-4da1-9555-6d74771ef286\"\n" +
                "    }\n" +
                "}\n" +
                "}";
       // return requestbody;
        var jo = new JsonObject(requestbody);
        jo.getJsonObject("data").getJsonObject("momoMsg").put("originalAmount", originalAmount);
        return  jo.toString();
    }
    public static String postBodyMapBank (String user, int originalAmount, String sourceToken){

        String requestbody = "{\n" +
                "   \"queue\": \"ha_qu_anti_fraud\",\n" +
                "    \"data\": {\n" +
                "        \"user\": \""+ user+"\",\n" +
                "        \"msgType\": \"TRAN_HIS_INIT_MSG\",\n" +
                "        \"appVer\": \"40180\",\n" +
                "        \"buildNumber\": \"2776\",\n" +
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
    public static String postBodyFaceMatching (String user, String kyc, String face_matching){

        String requestbody = "{\n" +
                "\"queue\": \"ha_qu_core_v7_qctest_req\",\n" +
                "\"data\":\n" +
                "  {\n" +
                "    \"initiator\":\"protoconfirm\",\n" +
                "    \"pin\":\"PP12!@pp\",\n" +
                "    \"pin_encoding\":\"plain\",\n" +
                "    \"ugaml_content_type\":\"modify_agent\",\n" +
                "    \"class_name\":\"com.mservice.goldengate.model.ModifyRequest\",\n" +
                "    \"extraTransData\":\n" +
                "    {\n" +
                "    },\n" +
                "        \"agent\": \""+ user+"\",\n" +
                "        \"agentData\":\n" +
                "    {\n" +
                "        \"kyc_confirm\": \""+ kyc+"\",\n" +
                "        \"face_matching\": \""+ face_matching+"\"\n" +
                "  }\n" +
                "  }\n" +
                "}";
        return requestbody;

    }
}
