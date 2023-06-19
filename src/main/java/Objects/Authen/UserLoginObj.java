package Objects.Authen;

import java.sql.Timestamp;

public class UserLoginObj {
    public static String postBody (String pHash, String appVer, String deviceOS){
        String user = "0975329906";
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        String requestbody = "{\n" +
                "    \"user\": \"0975329906\",\n" +
                "    \"pass\": \"48197ede0a33f9fc4a06bb6c3444d937c3668a6efdb985ef64106cb8c84510c8\",\n" +
                "    \"msgType\": \"USER_LOGIN_MSG\",\n" +
                "    \"momoMsg\": {\n" +
                "        \"_class\": \"mservice.backend.entity.msg.LoginMsg\",\n" +
                "        \"isSetup\": false\n" +
                "    },\n" +
                "    \"extra\": {\n" +
                "        \"pHash\": \""+ pHash+"\",\n" +
                "        \"IDFA\": \"\",\n" +
                "        \"SIMULATOR\": false,\n" +
                "        \"TOKEN\": \"eEDVafYZZkbvmfpg7_S7Ot:APA91bHjrM1ave_1PLCf2-MR2SZv2SDj_1A1tq-BuZR7QcD7ccNeckqijvWPecZlz5rcHN9reiGQcrU49nw1uiRvWmKnKDZQMITCKY0udTOLgXVyTxRtus9X6nC52SRanWGOZs9WbiU6\",\n" +
                "        \"ONESIGNAL_TOKEN\": \"eEDVafYZZkbvmfpg7_S7Ot:APA91bHjrM1ave_1PLCf2-MR2SZv2SDj_1A1tq-BuZR7QcD7ccNeckqijvWPecZlz5rcHN9reiGQcrU49nw1uiRvWmKnKDZQMITCKY0udTOLgXVyTxRtus9X6nC52SRanWGOZs9WbiU6\",\n" +
                "        \"SECUREID\": \"\",\n" +
                "        \"MODELID\": \"c817394ff8d886d6f22f3011e55408449f3473d059f0c5265ce8e8261c1772cb\",\n" +
                "        \"DEVICE_TOKEN\": \"B5C7DB5BFCA4833CD855B81AC35A8166118B8EB521373CE25CF08FB1A834DE55\",\n" +
                "        \"checkSum\": \"ykrcmbLuq7CaMTqj5Zvvl6mFmPK7+skpq0qggaO5qGE+8r3MPXZrwl0c9EPkPRiS5f6yAr0GPOlTctdDfUBPiA==\"\n" +
                "    },\n" +
                "        \"appVer\": \""+ appVer+"\",\n" +
                "    \"appCode\": \"4.0.15\",\n" +
                "    \"lang\": \"vi\",\n" +
                "        \"deviceOS\": \""+ deviceOS+"\",\n" +
                "    \"channel\": \"APP\",\n" +
                "    \"buildNumber\": 0,\n" +
                "    \"appId\": \"vn.momo.platform\",\n" +
                "    \"cmdId\": \"1677812631448000000\",\n" +
                "    \"time\": 1653381876489\n" +
                "}";
        return requestbody;
    }
}
