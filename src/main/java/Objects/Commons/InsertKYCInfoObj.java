package Objects.Commons;

public class RegisterMoMoWalletObj {
    public static String postBody (String user){
        String requestbody = "{\n" +
                "\"queue\": \"ha_qu_core_v7_test_req\",\n" +
                "\"data\":\n" +
                "  {\n" +
                "    \"initiator\":\"protoconfirm\",\n" +
                "    \"pin\":\"PP12!@pp\",\n" +
                "    \"pin_encoding\":\"plain\",\n" +
                "    \"ugaml_content_type\":\"register\",\n" +
                "    \"class_name\":\"com.mservice.goldengate.model.RegisterRequest\",\n" +
                "    \"suppress_confirm\":\"1\",\n" +
                "    \"suppress_sms\":\"1\",\n" +
                "    \"requires_webtool_confirm\":\"0\",\n" +
                "    \"suppress_response\":\"0\",\n" +
                "    \"td_params\":\"new_pin_hash\",\n" +
                "    \"trans_group\":-1,\n" +
                "        \"agent\": \""+ user+"\",\n" +
                "    \"name\":\"Nguyen Anh Toan\",\n" +
                "    \"new_pin\":\"000000\",\n" +
                "    \"new_pin_hash\":\"des\",\n" +
                "    \"suppress_pin_expiry\":true\n" +
                "  }\n" +
                "}";
        return requestbody;
    }
}
