package Objects.Authen;

import java.sql.Timestamp;

public class SendOTPObj {
 public static String KeyR;

    public static String postBody (String user,String appVer){

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
       // String user = "0975329906";
        //String appVer = "40123";
        String rKey = "rkey"+ (timestamp.getTime());
        String cmdId = "cmd"+ (timestamp.getTime());
        KeyR = rKey;
        String requestbody = "{\n" +
                "        \"user\": \""+ user+"\",\n" +
                "    \"msgType\": \"SEND_OTP_MSG\",\n" +
                "        \"cmdId\": \""+ cmdId+"\",\n" +
                "    \"lang\": \"vi\",\n" +
                "    \"time\": 1648440365208,\n" +
                "    \"channel\": \"APP\",\n" +
                "        \"appVer\": \""+ appVer+"\",\n" +
                "    \"appCode\": \"3.1.10\",\n" +
                "    \"deviceOS\": \"IOS\",\n" +
                "    \"buildNumber\": 0,\n" +
                "    \"appId\": \"vn.momo.platform\",\n" +
                "    \"result\": true,\n" +
                "    \"errorCode\": 0,\n" +
                "    \"errorDesc\": \"\",\n" +
                "    \"momoMsg\": {\n" +
                "        \"_class\": \"mservice.backend.entity.msg.RegDeviceMsg\",\n" +
                "        \"number\": \"0973333333\",\n" +
                "        \"imei\": \"F7FA02E6-134E-484F-BA57-55E5C28EB2CE\",\n" +
                "        \"cname\": \"Vietnam\",\n" +
                "        \"ccode\": \"084\",\n" +
                "        \"device\": \"iPhone\",\n" +
                "        \"firmware\": \"13.7\",\n" +
                "        \"hardware\": \"iPhone\",\n" +
                "        \"manufacture\": \"Apple\",\n" +
                "        \"csp\": \"Carrier\",\n" +
                "        \"icc\": \"\",\n" +
                "        \"mcc\": \"0\",\n" +
                "        \"mnc\": \"0\",\n" +
                "        \"device_os\": \"IOS\"\n" +
                "    },\n" +
                "    \"extra\": {\n" +
                "        \"action\": \"SEND\",\n" +
                "        \"rkey\": \""+ rKey+"\",\n" +
                "        \"AAID\": \"\",\n" +
                "        \"IDFA\": \"00000000-0000-0000-0000-000000000000\",\n" +
                "        \"TOKEN\": \"f6OBmzKsuEckjnR8I9XJvN:APA91bE1-MET28YXNFmaDu_NsPo9fkXhpb0J3LdsheLN180D1oobDxt4jZDhuMHkowEgkoBy-ML47bpEya8oF4Vh-_b1TzU-2o-KWwF3K5yfIqmdc-kqYxb0Yo-AfP444mv5wTTztw0E\",\n" +
                "        \"ONESIGNAL_TOKEN\": \"f6OBmzKsuEckjnR8I9XJvN:APA91bE1-MET28YXNFmaDu_NsPo9fkXhpb0J3LdsheLN180D1oobDxt4jZDhuMHkowEgkoBy-ML47bpEya8oF4Vh-_b1TzU-2o-KWwF3K5yfIqmdc-kqYxb0Yo-AfP444mv5wTTztw0E\",\n" +
                "        \"SIMULATOR\": false,\n" +
                "        \"MODELID\": \"5E8166F5-B5C6-4281-9796-2FC1521977AD\",\n" +
                "        \"DEVICE_TOKEN\": \"\",\n" +
                "        \"isVoice\": \"true\",\n" +
                "        \"REQUIRE_HASH_STRING_OTP\": true,\n" +
                "        \"checkSum\": \"\"\n" +
                "    }\n" +
                "}";
        return requestbody;
    }
}
