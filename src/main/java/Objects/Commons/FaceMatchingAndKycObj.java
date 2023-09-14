package Objects.Commons;

import java.util.Random;

public class InsertKYCInfoObj {
    public static String postBody (String user){
        Random random = new Random();
        String kyc_personal_id = "215234" + random.nextInt(9000);
        String requestbody = "{\n" +
                "  \"queue\": \"ha_qu_core_v7_qctest_req\",\n" +
                "  \"data\": {\n" +
                "    \"initiator\": \"protoconfirm\",\n" +
                "    \"pin\": \"PP12!@pp\",\n" +
                "    \"pin_encoding\": \"plain\",\n" +
                "    \"ugaml_content_type\": \"modify_agent\",\n" +
                "    \"class_name\": \"com.mservice.goldengate.model.ModifyRequest\",\n" +
                "    \"extraTransData\": {},\n" +
                "        \"agent\": \""+ user+"\",\n" +
                "    \"agentData\": {\n" +
                "        \"kyc_personal_id\": \""+ kyc_personal_id+"\",\n" +
                "      \"address\": \"Đây là địa chỉ tạm trú\",\n" +
                "      \"gender\": \"2\",\n" +
                "      \"kyc_issue_date\": \"04/02/2020\",\n" +
                "      \"kyc_issue_place\": \"đây là nơi cấp CMND\",\n" +
                "      \"kyc_address\": \"Đây là địa chỉ thường trú\",\n" +
                "      \"kyc_confirm\": \"1\",\n" +
                "      \"kyc_dob\": \"09/11/1993\",\n" +
                "      \"kyc_expired_date\": \"04/02/2035\",\n" +
                "      \"kyc_gender\": \"MALE\",\n" +
                "      \"kyc_name\": \"Nguyen Anh Toan\",\n" +
                "      \"kyc_nationality\": \"VIỆT NAM\",\n" +
                "      \"kyc_native_address\": \"Đây là nguyên quán\",\n" +
                "      \"nationality\": \"VN\",\n" +
                "      \"wallet_status\": \"1000000000\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        return requestbody;
    }
}
