package Projects.Database.Whitelist24;

import Helpers.SQLHelpers;
import org.testng.annotations.Test;

import java.sql.*;

public class Insert {
    @Test
    public void InsertDB() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        try {
            Connection connectionInput = SQLHelpers.CreateConnectionOracle();
            Statement stmt = connectionInput.createStatement();
            stmt.executeUpdate(" UPDATE UMARKETADM.AGENT_DATA SET" + "VALUE = "+timestamp.getTime()+" WHERE AGENT_ID = '42702127' AND AD_KEY = 'face_timestamp'");
            connectionInput.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
