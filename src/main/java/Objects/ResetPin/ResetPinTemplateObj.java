package Objects.Authen;

public class CheckUserObj {
    public static String postBody (String user){
       //String user = "0935123234";
        String requestbody = "{\n" +
                "        \"user\": \""+ user+"\",\n" +
                "    \"msgType\": \"CHECK_USER_BE_MSG\",\n" +
                "    \"momoMsg\": {\n" +
                "        \"_class\": \"mservice.backend.entity.msg.RegDeviceMsg\",\n" +
                "        \"number\": \"0973333941\",\n" +
                "        \"imei\": \"08d193a6b7e7059e2b5bd0c47704f5335756cd8b8355df03399f3af81a524bd5\",\n" +
                "        \"cname\": \"Vietnam\",\n" +
                "        \"ccode\": \"084\",\n" +
                "        \"device\": \"iPhone 12\",\n" +
                "        \"firmware\": \"16.1\",\n" +
                "        \"hardware\": \"iPhone\",\n" +
                "        \"manufacture\": \"Apple\",\n" +
                "        \"csp\": \"Carrier\",\n" +
                "        \"icc\": \"\",\n" +
                "        \"mcc\": \"452\",\n" +
                "        \"mnc\": \"05\",\n" +
                "        \"device_os\": \"ios\",\n" +
                "        \"secure_id\": \"\"\n" +
                "    },\n" +
                "    \"appVer\": 40000,\n" +
                "    \"appCode\": \"4.0.12\",\n" +
                "    \"lang\": \"vi\",\n" +
                "    \"deviceOS\": \"ios\",\n" +
                "    \"channel\": \"APP\",\n" +
                "    \"buildNumber\": 0,\n" +
                "    \"appId\": \"vn.momo.platform\",\n" +
                "    \"cmdId\": \"1671097975067000000\",\n" +
                "    \"time\": 1671097975067\n" +
                "}";
        return requestbody;
    }
}
