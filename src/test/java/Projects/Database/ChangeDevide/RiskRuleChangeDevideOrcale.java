package Projects.Database.ChangeDevide;

import Helpers.SQLHelpers;
import org.testng.annotations.Test;

import java.sql.*;

public class RiskRuleChangeDevideOrcale {
    @Test
    public void InsertDB() {
        // String delete = "INSERT INTO SOAP_ADMIN.RISK_USER_DEVICE_CHANGE (USER_ID, EVENT_TIME)" + "VALUES ('0975329906', 1681957919497);";
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        try {
            Connection connectionInput = SQLHelpers.CreateConnectionOracle();
            Statement stmt = connectionInput.createStatement();
            stmt.executeUpdate("DELETE FROM SOAP_ADMIN.RISK_USER_DEVICE_CHANGE WHERE USER_ID = '0975329909'");
            stmt.executeUpdate("INSERT INTO SOAP_ADMIN.RISK_USER_DEVICE_CHANGE (USER_ID, EVENT_TIME)" + "VALUES ('0975329909', "+timestamp.getTime()+")");
            ResultSet rs = stmt.executeQuery("SELECT * FROM SOAP_ADMIN.RISK_USER_DEVICE_CHANGE WHERE  USER_ID = '0975329909'");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                        + "  " + rs.getString(3));
            }
            connectionInput.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
