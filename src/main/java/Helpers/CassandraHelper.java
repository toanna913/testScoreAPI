package Helpers;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.Row;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import java.net.InetSocketAddress;
import java.util.List;

public class CassandraHelper {
    private final Logger logger = Logger.getLogger(CassandraHelper.class);
    private CqlSession session;

    private void CreateConnection() {
        if (session == null || session.isClosed()) {
            session = CqlSession.builder()
                    .addContactPoint(new InetSocketAddress(SQLHelpers.HOST, SQLHelpers.PORT))
                    .withAuthCredentials(SQLHelpers.USERNAME, SQLHelpers.PASSWORD)
                    .withLocalDatacenter(SQLHelpers.DATACENTER)
                    .withKeyspace(SQLHelpers.KEYSPACE).build();
            logger.info("Connect cassandra success");
        }

    }
    public JSONArray executeSelect(String query) {
        try {
            CreateConnection();
            List<Row> rows = session.execute(query).all();
            if (!rows.isEmpty()) {
                logger.info("Execute query success: Query '" + query + "'");
                logger.info(JsonHelper.dataToJson(rows));
                session.close();
            }
            return JsonHelper.dataToJson(rows);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Fail to execute query '%s'", query), e);
        }
    }

    public boolean executeInsert(String query) {
        try {

            CreateConnection();
            List<Row> rows = session.execute(query).all();
            logger.info("Execute query success: Query '" + query + "'");
            session.close();
            return rows.size() == 0;
        } catch (Exception e) {
            throw new RuntimeException(String.format("Fail to execute query '%s'", query), e);
        }
    }
    public boolean executeDelete(String query) {
        try {
            CreateConnection();
            List<Row> rows = session.execute(query).all();
            logger.info("Execute query success: Query '" + query + "'");
            session.close();
            return rows.size() == 0;
        } catch (Exception e) {
            throw new RuntimeException(String.format("Fail to execute query '%s'", query), e);
        }
    }

}
