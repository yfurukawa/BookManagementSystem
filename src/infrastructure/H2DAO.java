/**
 * 
 */
package infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vagrant
 *
 */
public class H2DAO {

    /**
     * @return データベースへのコネクション
     */
    public static Connection getConnection() {
        try {
//            Class.forName("org.hsqldb.jdbcDriver");
            org.h2.Driver.load();
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
//            Connection connection = DriverManager.getConnection("jdbc:h2:/localhost:9092", "sa", "");
            return connection;
        }
        catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
    
    /**
     * @param sql
     * @param mapping
     * @return 検索結果のlist
     * @throws SQLException
     */
    public static <T> List<T> getAll(String sql, ResultSetBeanMapping<T> mapping) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        
        try {
            connection = getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            List<T> list = new ArrayList<T>();
            
            while(resultSet.next()) {
                T bean = mapping.createFromResultSet(resultSet);
                list.add(bean);
              }
            return list;
        }
        finally {
            if (statement != null) {
                try {statement.close();} catch (SQLException ignore) {}
            }
            if (connection != null) {
                try {connection.close();} catch (SQLException ignore) {}
            }
        }
    }
}
