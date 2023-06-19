package Projects.Database.ChangeDevide;

import Helpers.CassandraHelper;
import org.testng.annotations.Test;

public class Insert {
    @Test
    public void ChangeDevide() {
        // Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        // String delete = "INSERT INTO SOAP_ADMIN.RISK_USER_DEVICE_CHANGE (USER_ID, EVENT_TIME)" + "VALUES ('0975329906', 1681957919497);";
        CassandraHelper cassandraHelper = new CassandraHelper();
        // System.out.println(cassandraHelper.executeDelete("DELETE from test_backend.user_device_change WHERE user_id = '0975329906'and from_devicename = 'iPhone XR'"));
        //  System.out.println(cassandraHelper.executeSelect("select * from expense_category_counter WHERE owner = '0909498114'"));
        System.out.println(cassandraHelper.executeInsert("INSERT INTO test_backend.user_device_change (user_id, event_time, from_devicename, from_imei, to_devicename, to_imei, is_relogin)\n" +
                "VALUES ('0975329906', toTimestamp(now()), 'iPhone XR', '', 'iPhone', '', true)"));
//        RedisHelper redisHelper = new RedisHelper();
//        redisHelper.CreateConnection();
    }
}
