package Objects.MultiBill;

public class AddCartObj {
    public static String postBodyCartElectric (){
        String billId = CreateMultiBillObj.billIdLocation.get(1);
        String requestbody = "{\n" +
                "    \"momoMsg\": {\n" +
                "        \"billId\": \""+ billId+"\",\n" +
                "        \"serviceId\": \"evn_quangngai\",\n" +
                "        \"tranType\": 7,\n" +
                "        \"_class\": \"mservice.backend.entity.msg.TranHisMsg\",\n" +
                "        \"pageNumber\": 1,\n" +
                "        \"quantity\": 1,\n" +
                "        \"source\": 2,\n" +
                "        \"extras\": \"{\\\"IS_ADD_CART\\\": true}\",\n" +
                "        \"ownerName\": \"\"\n" +
                "    },\n" +
                "    \"extra\": {\n" +
                "        \n" +
                "    },\n" +
                "    \"options\": {\n" +
                "        \"loading\": true\n" +
                "    },\n" +
                "    \"path\": \"bill/core/checkinfo\",\n" +
                "    \"subDomain\": \"api\"\n" +
                "}";
        return requestbody;
    }
    public static String postBodyCartInsurance (String billInsu, String typeInsu, String itemId){
        String billId = CreateMultiBillObj.billIdLocation.get(1);
        String requestbody = "{\n" +
                "    \"queue\": \"ha_sf_financial_platform\",\n" +
                "    \"data\": {\n" +
                "        \"serviceCode\": \"ins_pvi_home\",\n" +
                "        \"requestId\": \"1689145001\",\n" +
                "        \"source\": 2,\n" +
                "        \"type\": 27,\n" +
                "        \"items\": [\n" +
                "            {\n" +
                "                \"amount\": 3000,\n" +
                "                \"quantity\": 1,\n" +
                "        \"reference1\": \""+ billInsu+"\",\n" +
                "        \"reference2\": \""+ typeInsu+"\",\n" +
                "        \"parentId\": \""+ itemId+"\",\n" +
                "                \"source\": 2,\n" +
                "                \"serviceCode\": \"ins_pvi_home\",\n" +
                "                \"serviceName\": \"Bảo hiểm nhà tư Nhân\",\n" +
                "                \"description\": \"Bảo hiểm nhà tư Nhân\"\n" +
                "                }\n" +
                "                ]\n" +
                "            },\n" +
                "        \"headers\": {\n" +
                "            \"user\": \"0975329905\",\n" +
                "            \"name\": \"toan test\"\n" +
                "            }\n" +
                "}";
        return requestbody;
    }

}
