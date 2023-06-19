package Objects.PayMentTelCo;

public class AddCartTelCoObj {
    public static String postBodyCartTelco (){
        String requestbody = "[\n" +
                "    {\n" +
                "        \"customerPhone\": \"0975329905\",\n" +
                "        \"description\": \"Mua mã thẻ data\",\n" +
                "        \"productId\": \"BCDC10\",\n" +
                "        \"quantity\": 1,\n" +
                "        \"serviceName\": \"Mua mã thẻ data\",\n" +
                "        \"tranData\": \"{\\\"serviceData\\\":{\\\"extras\\\":{\\\"user_type\\\":\\\"1\\\",\\\"telcoSource\\\":\\\"default\\\"}}}\",\n" +
                "        \"serviceCode\": \"buycard_data_mobifone\",\n" +
                "        \"price\": 20000,\n" +
                "        \"originalPrice\": 20000\n" +
                "    }\n" +
                "]";
        return requestbody;
    }

}
