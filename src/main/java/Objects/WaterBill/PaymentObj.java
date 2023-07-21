package Objects.PayMents;


import org.json.JSONArray;
import org.json.JSONObject;

public class PaymentObj {
    public static String postBodyPayment (String requestId, String cartId, JSONArray cartInfo, JSONObject sourceInit, String purchaseId, JSONObject purchaseInfo,
                                          String purchaseToken, JSONObject extra){

        JSONObject Rbody= new JSONObject();
        JSONObject momoMsg = new JSONObject();
        momoMsg.put("requestId", requestId);
        momoMsg.put("cartId", cartId);
        momoMsg.put("paymentType", "P_PLATFORM");
        momoMsg.put("miniAppId", "vn.momo.paymentoffline");
        momoMsg.put("bundleCode", "M001");
        momoMsg.put("cartInfo", cartInfo);
        momoMsg.put("sourceInit",sourceInit);
        momoMsg.put("purchaseId", purchaseId);
        momoMsg.put("purchaseInfo",purchaseInfo);
        momoMsg.put("purchaseToken",purchaseToken);
        momoMsg.put("tranType", 7);
        momoMsg.put("orderState", "OPEN");
        momoMsg.put("cartState", "PAYMENT");
        momoMsg.put("paymentResCountDown", -1);
        momoMsg.put("_class", "mservice.backend.entity.msg.OrderCartMsg");

        Rbody.put("momoMsg",momoMsg);
        Rbody.put("user","0975329908");
        Rbody.put("pass","000000");
        Rbody.put("cmdId","1675416552344000000");
        Rbody.put("msgType","PAYMENT");
        Rbody.put("result",true);
        Rbody.put("appCode","4.0.18");
        Rbody.put("buildNumber",2777);
        Rbody.put("appVer",40181);
        Rbody.put("channel","APP");
        Rbody.put("deviceOS","ios");
        Rbody.put("resultType","SUCCESS");
        Rbody.put("errorCode",0);
        Rbody.put("extra",extra);
        Rbody.put("path","/v1/order/checkout");


        return  Rbody.toString();
    }
}
