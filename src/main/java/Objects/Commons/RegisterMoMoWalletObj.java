package Objects.Commons;

public class GetBalanceUserObj {
    public static String postBody (String user){
        String requestbody = "{\n" +
                "    \"queue\": \"ha_qu_sof_sync\",\n" +
                "    \"data\": {\n" +
                "        \"phone\": \""+ user+"\",\n" +
                "        \"channel\": \"APP\",\n" +
                "        \"msgType\": \"SYNC_ONCE\",\n" +
                "        \"sla\": 4000,\n" +
                "        \"orderItem\": {}\n" +
                "    }\n" +
                "}";
        return requestbody;
    }
}
