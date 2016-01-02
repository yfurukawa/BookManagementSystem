/**
 * 
 */
package infrastructure;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author vagrant
 * @param <T> 
 *
 */
public interface ResultSetBeanMapping<T> {
    /**
     * @param resultSet
     * @return a
     * @throws SQLException
     */
    public T createFromResultSet(ResultSet resultSet) throws SQLException;
}
