package Objects.PayMents;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Random;

public class CreateBillObj {
    public static HashMap<Integer, String> billIdLocation = new HashMap<Integer, String>();
    public static String postBodyBill (String amount) {
        JSONObject requestbody = new JSONObject();
        requestbody.put("queue", "ha_qu_billpay_mock_db_controller");


        JSONObject dataobj = new JSONObject();
        dataobj.put("msgType", 0);
        dataobj.put("userId", "0975329908");
        dataobj.put("requestId", "1720299222");

        JSONObject debtobj = new JSONObject();
        Random random = new Random();
        String BillId = "NinhHoa" + random.nextInt(9000);
        debtobj.put("billId", BillId);
        debtobj.put("serviceCode", "ninhhoa_water");
        debtobj.put("cycle", "07/2023");
        debtobj.put("customerName", "Toan");
        debtobj.put("customerAddress", "SCore QC");
        debtobj.put("amount", amount);

        dataobj.put("debt", debtobj);
        requestbody.put("data", dataobj);

        billIdLocation.put(1, BillId);

        return requestbody.toString();
    }
}
