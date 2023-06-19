package Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelpers {
    public static Connection CreateConnectionOracle() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String dbUrl = "jdbc:oracle:thin:@//172.16.13.10:1521/umarketuat";
        //Database Username
        String username = "soap_admin";
        //Database Password
        String password = "1234567";
        Connection mConnection  = DriverManager.getConnection(dbUrl,username,password);
        return mConnection;
        //Load mysql jdbc driver
    }
    public static String HOST = "172.16.9.51";
    public static int PORT = 9042;
    public static String PASSWORD = "cassandra";
    public static String USERNAME = "cassandra";
    public static String KEYSPACE = "test_backend";

    public static String DATACENTER = "datacenter1";

    public static void setCassandraConnectionInfo(String host, int port, String keyspace, String username, String password){
        SQLHelpers.HOST = host;
        SQLHelpers.PORT = port;
        SQLHelpers.KEYSPACE = keyspace;
        SQLHelpers.PASSWORD = password;
        SQLHelpers.USERNAME = username;
    }

}
