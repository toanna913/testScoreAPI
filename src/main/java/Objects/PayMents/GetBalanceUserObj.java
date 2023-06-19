package Objects.PayMents;

public class GetBalanceUserObj {
    public static String postBody (String phone){
        String requestbody = "{\n" +
                "    \"queue\": \"ha_qu_sof_sync\",\n" +
                "    \"data\": {\n" +
                "        \"phone\": \""+ phone+"\",\n" +
                "        \"channel\": \"APP\",\n" +
                "        \"msgType\": \"SYNC_ONCE\",\n" +
                "        \"sla\": 4000,\n" +
                "        \"orderItem\": {}\n" +
                "    }\n" +
                "}";
        return requestbody;
    }
}
