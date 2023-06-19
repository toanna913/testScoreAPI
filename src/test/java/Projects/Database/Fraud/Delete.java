package Projects.Database.Fraud;

import Helpers.CassandraHelper;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Delete {
    @Test
    @Parameters({"user"})
    public void DeleteFraudDetection(String user) {
        CassandraHelper cassandraHelper = new CassandraHelper();
        String queryDelete = "DELETE from test_backend.fraud_dection WHERE user_id = '%s' and io = 1";
             cassandraHelper.executeInsert(String.format(queryDelete,user));
    }
}
