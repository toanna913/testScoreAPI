package Projects.Database.Mapbank;

import Helpers.CassandraHelper;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Insert {
    @Test
    @Parameters({"user", "sourceToken"})
    public void InsertMapBank(String user, String sourceToken) {
        CassandraHelper cassandraHelper = new CassandraHelper();
        String queryInsert = "INSERT INTO test_backend.wallet_mapping (user_id, event_time, appcode, appver, bank_token, bankcode) VALUES ('%1$s', toTimestamp(now()), '4.0.2', 40020, '%2$s', '12345')";
        cassandraHelper.executeInsert(String.format(queryInsert,user,sourceToken));
    }
}
