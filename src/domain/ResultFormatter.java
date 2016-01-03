/**
 * 
 */
package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vagrant
 *
 */
public class ResultFormatter {
    /**
     * @param book
     * @return Webページ用に整形された文字列
     */
    public List<String> buildFormat(List<Book> book) {
        List<String> result = new ArrayList<String>();
        result.add("<TD>");
        for(int i = 0; i < book.size(); ++i) {
            result.add("<TR>" + book.get(i).getIsbn() + "</TR>");
            result.add("<TR>" + book.get(i).getName() + "</TR>");
            result.add("<TR>" + book.get(i).getAuthor() + "</TR>");
            result.add("<TR>" + book.get(i).getPrice().toString() + "</TR>");
        }
        result.add("</TD>");
        return result;
        
    }
}
