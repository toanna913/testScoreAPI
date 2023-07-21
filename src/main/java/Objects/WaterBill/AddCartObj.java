package Objects.PayMents;

public class AddCartObj {
    public static String postBodyCart (){
        String billId = CreateBillObj.billIdLocation.get(1);
        String requestbody = "{\n" +
                "    \"momoMsg\": {\n" +
                "        \"billId\": \""+ billId+"\",\n" +
                "        \"serviceId\":\"ninhhoa_water\",\n" +
                "        \"tranType\": 7,\n" +
                "        \"_class\": \"mservice.backend.entity.msg.TranHisMsg\",\n" +
                "        \"pageNumber\": 1,\n" +
                "        \"quantity\":1,\n" +
                "        \"source\": 2,\n" +
                "        \"extras\": \"{\\\"IS_ADD_CART\\\": true}\"\n" +
                "    },\n" +
                "    \"options\": {\n" +
                "        \"loading\": true\n" +
                "    },\n" +
                "    \"path\": \"bill/core/checkinfo\",\n" +
                "    \"subDomain\": \"api\"\n" +
                "}";
        return requestbody;
    }

}
