package Objects.MultiBill;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Random;

public class CreateMultiBillObj {
    public static HashMap<Integer, String> billIdLocation = new HashMap<Integer, String>();
    public static String postBodyBillElectric (String amount) {
        JSONObject requestbody = new JSONObject();
        requestbody.put("queue", "ha_qu_billpay_mock_db_controller");


        JSONObject dataobj = new JSONObject();
        dataobj.put("msgType", 0);
        dataobj.put("userId", "0975329905");
        dataobj.put("requestId", "1720299222");

        JSONObject debtobj = new JSONObject();
        Random random = new Random();
        String BillId = "PC0609890" + random.nextInt(9000);
        debtobj.put("billId", BillId);
        debtobj.put("serviceCode", "evn_quangngai");
        debtobj.put("cycle", "07/2023");
        debtobj.put("customerName", "Toan");
        debtobj.put("customerAddress", "SCore QC");
        debtobj.put("amount", amount);

        dataobj.put("debt", debtobj);
        requestbody.put("data", dataobj);

        billIdLocation.put(1, BillId);

        return requestbody.toString();
    }
    public static String postBodyBillInsurance () {
        String billId = billIdLocation.get(1);
        String requestbody = "{\n" +
                "    \"serviceCode\": \"ins_billpay_home\",\n" +
                "    \"requestId\": \"1689222995\",\n" +
                "    \"type\": 50,\n" +
                "    \"source\": 2,\n" +
                "    \"isPaidBill\": false, \n" +
                "    \"data\": {\n" +
                "        \n" +
                "        \"customerAddress\": \"customerAddress\",\n" +
                "        \"customerBillId\": \""+ billId+"\",\n" +
                "    }\n" +
                "}";
        return requestbody;
    }

}
