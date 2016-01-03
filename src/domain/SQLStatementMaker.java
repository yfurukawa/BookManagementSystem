/**
 * 
 */
package domain;

import java.util.List;

/**
 * @author vagrant
 *
 */
public class SQLStatementMaker {
    /**
     * @param table
     * @param fields
     * @param values
     * @return SQLステートメント
     */
    public String makeStatement(String table, List<String> fields, List<String> values) {
        String statement = "SELECT * FROM ";
        statement += table;
        statement += " WHERE ";
        
        for(int i = 0; i < fields.size(); ++i) {
            statement += fields.get(i) + " LIKE " + "'";
            if(fields.get(i).equals("isbn")) {
            }
            else {
                statement += "%";
            }
            statement += values.get(i) + "%'";
            
            if(i < fields.size()-1) {
                statement += " AND ";
            }
        }

        return statement;
    }
}
