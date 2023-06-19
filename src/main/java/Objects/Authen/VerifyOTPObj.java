package Objects.Authen;


import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;


public class VerifyOTPObj {
    public static String postBody (String user){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //String user = "0975329906";
        String rKey = SendOTPObj.KeyR;
        String Pohash = user+rKey+"1111";
        String ohash  = Hashing.sha256()
                 .hashString(Pohash, StandardCharsets.UTF_8)
                  .toString();
        String cmdID = "cmd"+ (timestamp.getTime());
       // ohash =  Cryption.getSHA256
        String requestbody = "{\n" +
                "        \"user\": \""+ user+"\",\n" +
                "  \"msgType\": \"REG_DEVICE_MSG\",\n" +
                "        \"cmdId\": \""+ cmdID+"\",\n" +
                "  \"lang\": \"vi\",\n" +
                "  \"time\": 1653381876489,\n" +
                "  \"channel\": \"APP\",\n" +
                "  \"appVer\": 40123,\n" +
                "  \"appCode\": \"3.1.13\",\n" +
                "  \"deviceOS\": \"IOS\",\n" +
                "  \"buildNumber\": 0,\n" +
                "  \"appId\": \"vn.momo.platform\",\n" +
                "  \"result\": true,\n" +
                "  \"errorCode\": 0,\n" +
                "  \"errorDesc\": \"\",\n" +
                "  \"momoMsg\": {\n" +
                "    \"_class\": \"mservice.backend.entity.msg.RegDeviceMsg\",\n" +
                "    \"number\": \"0973333333\",\n" +
                "    \"imei\": \"3BF6E078-D689-4958-980A-115994A59CDB\",\n" +
                "    \"cname\": \"Vietnam\",\n" +
                "    \"ccode\": \"084\",\n" +
                "    \"device\": \"iPhone 7 Plus\",\n" +
                "    \"firmware\": \"15.4.1\",\n" +
                "    \"hardware\": \"iPhone\",\n" +
                "    \"manufacture\": \"Apple\",\n" +
                "    \"csp\": \"Mobifone\",\n" +
                "    \"icc\": \"\",\n" +
                "    \"mcc\": \"452\",\n" +
                "    \"mnc\": \"01\",\n" +
                "    \"device_os\": \"IOS\"\n" +
                "  },\n" +
                "  \"extra\": {\n" +
                "   \"ohash\": \""+ ohash+"\",\n" +
                "    \"AAID\": \"\",\n" +
                "    \"IDFA\": \"\",\n" +
                "    \"TOKEN\": \"cn4jJNraeERKqkYoV_Fuwc:APA91bH1s5_U-KbBwX_JpUkPNYWjnIGahAY6AlRHwKnWtTWcjmPAC7wEehM0qL1y_cVqysEGccngm1E4JXs6Udf8OYgKHzxite_WiHC5wcQN5D0IHPrrawukgv1bp-WnRFAmwMe4l9j7\",\n" +
                "    \"ONESIGNAL_TOKEN\": \"cn4jJNraeERKqkYoV_Fuwc:APA91bH1s5_U-KbBwX_JpUkPNYWjnIGahAY6AlRHwKnWtTWcjmPAC7wEehM0qL1y_cVqysEGccngm1E4JXs6Udf8OYgKHzxite_WiHC5wcQN5D0IHPrrawukgv1bp-WnRFAmwMe4l9j7\",\n" +
                "    \"SIMULATOR\": \"false\",\n" +
                "    \"MODELID\": \"1181AA9F-EE92-4A56-B9FD-DDF3FB8B5F32\",\n" +
                "    \"DEVICE_TOKEN\": \"18A43C4DC4A739296B3AB5A34CE7A5527E3EAE4812F3887E06C127842CF500F0\",\n" +
                "    \"checkSum\": \"\"\n" +
                "  }\n" +
                "}";
        return requestbody;
    }
}
