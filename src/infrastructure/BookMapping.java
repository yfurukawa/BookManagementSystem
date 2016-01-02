/**
 * 
 */
package infrastructure;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Book;

/**
 * @author vagrant
 *
 */
public class BookMapping implements ResultSetBeanMapping<Book> {
    /**
     * @param resultSet
     * @return book
     * @throws SQLException
     */
    public Book createFromResultSet(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setIsbn(resultSet.getString("isbn"));
        book.setName(resultSet.getString("name"));
        book.setAuthor(resultSet.getString("author"));
        book.setPrice(resultSet.getInt("price"));
        
        return book;
    }

}
