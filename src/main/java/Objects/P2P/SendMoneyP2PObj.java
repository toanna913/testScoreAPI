package Objects.P2P;

public class SendMoneyP2PObj {
    public static String postBody (String user){
        //String user = "0935123234";
        String requestbody = "{\n" +
                "    \"queue\": \"ha_qu_core_v7_qctest_req\",\n" +
                "    \"data\": {\n" +
                "        \"initiator\": \""+ user+"\",\n" +
                "        \"pin\": \"000000\",\n" +
                "        \"pin_encoding\": \"plain\",\n" +
                "        \"ugaml_content_type\": \"billpay\",\n" +
                "        \"class_name\": \"com.mservice.goldengate.model.BillPayRequest\",\n" +
                "        \"extraTransData\": {\n" +
                "            \"serviceId\" : \"transfer_p2p\",\n" +
                "            \"money_source\": 2\n" +
                "        },\n" +
                "        \"requires_webtool_confirm\": \"0\", \n" +
                "        \"td_params\": \"vc_amount,pn_amount,evc_source,evc_amount,target\",\n" +
                "        \"target\": \"0975329901\",\n" +
                "        \"type\": 1,\n" +
                "        \"amount\": 10000\n" +
                "    }\n" +
                "}";
        return requestbody;
    }
}
