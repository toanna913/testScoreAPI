package Projects.Database.Mapbank;

import Helpers.CassandraHelper;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Delete {
    @Test
    @Parameters({"user"})
    public void DeleteMapBank(String user) {
        CassandraHelper cassandraHelper = new CassandraHelper();
        String queryDelete = "DELETE FROM test_backend.wallet_mapping WHERE user_id = '%s'";
        cassandraHelper.executeInsert(String.format(queryDelete,user));
    }
}
