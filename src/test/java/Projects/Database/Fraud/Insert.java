package Projects.Database.Fraud;

import Helpers.CassandraHelper;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Insert {
    @Test (invocationCount = 2)
    @Parameters({"user"})
    public void InsertFraudDetection(String user) {
        CassandraHelper cassandraHelper = new CassandraHelper();
        String queryInsert = "INSERT INTO test_backend.fraud_dection (user_id, io, event_time, amount, trans_id, trantype) VALUES ('%s', 1, toTimestamp(now()), 2000000, 3098883483, 1)";
        cassandraHelper.executeInsert(String.format(queryInsert,user));
    }
}
