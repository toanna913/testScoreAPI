package Helpers;

import com.datastax.oss.driver.api.core.cql.Row;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;


public class JsonHelper {
    public static JSONArray dataToJson(ResultSet rs) {
        JSONArray json = new JSONArray();
        ResultSetMetaData resultSetMetaData;
        try {
            resultSetMetaData = rs.getMetaData();
            while (rs.next()) {
                int numColumns = resultSetMetaData.getColumnCount();
                JSONObject obj = new JSONObject();
                for (int i = 1; i <= numColumns; i++) {
                    String column_name = resultSetMetaData.getColumnName(i);
                    if (rs.getObject(column_name) == null) {
                        obj.put(column_name, JSONObject.NULL);
                    } else {
                        obj.put(column_name, rs.getObject(column_name));
                    }
                }
                json.put(obj);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    public static JSONArray dataToJson(List<Row> rows) {
        JSONArray json = new JSONArray();
        try {
            for (Row row : rows) {
                int size = row.size();
                JSONObject jsonObject = new JSONObject();
                for (int i = 0; i < size; i++) {
                    String columnName = row.getColumnDefinitions().get(i).getName().toString();
                    Object value = row.getObject(i);
                    if(value != null){
                        if(value instanceof LocalDateTime){
                            jsonObject.put(columnName, ((LocalDateTime)value).atZone(
                                    ZoneId.systemDefault()).toInstant());
                        } else {
                            jsonObject.put(columnName, row.getObject(i));
                        }
                    }
                }
                json.put(jsonObject);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    public static JSONArray DataToJson(ResultSet rs)
    {
        JSONArray json = new JSONArray();
        ResultSetMetaData rsmd = null;
        try {
            rsmd = rs.getMetaData();
            while(rs.next()) {
                int numColumns = rsmd.getColumnCount();
                JSONObject obj = new JSONObject();
                for (int i=1; i<=numColumns; i++) {
                    String column_name = rsmd.getColumnName(i);
                    obj.put(column_name, rs.getObject(column_name));
                }
                json.put(obj);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return json;
    }
}
