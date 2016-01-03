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
        result.add("<table>");
        result.add("<thead>");
        result.add("<tr>");
        result.add("<th>ISBN番号</th>");
        result.add("<th>書籍名</th>");
        result.add("<th>著者名</th>");
        result.add("<th>価格</th>");
        result.add("<th></th>");
        result.add("</tr>");
        result.add("</thead>");
        result.add("<tbody>");
        for(int i = 0; i < book.size(); ++i) {
            result.add("<tr>");
            result.add("<td>" + book.get(i).getIsbn() + "</td>");
            result.add("<td>" + book.get(i).getName() + "</td>");
            result.add("<td>" + book.get(i).getAuthor() + "</td>");
            result.add("<td>" + book.get(i).getPrice().toString() + "</td>");
            result.add("<td><input type=\"submit\" value=\"詳細\"></td>");
            result.add("</tr>");
        }
        result.add("</tbody>");
        result.add("</table>");
        return result;
        
    }
}
