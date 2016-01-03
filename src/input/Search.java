package input;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Book;
import domain.ResultFormatter;
import domain.SQLStatementMaker;
import infrastructure.BookMapping;
import infrastructure.H2DAO;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String isbnToSearch = null;
            String bookNameToSearch = null;
            String authorToSearch = null;
            List<String> fields = new ArrayList<String>();
            List<String> conditions = new ArrayList<String>();
            
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            List<String> result = new ArrayList<String>();

            
            Enumeration<String> names = request.getParameterNames();

            while(names.hasMoreElements()) {
                String name = names.nextElement();
                String[] values = request.getParameterValues(name);
                result.add(name + "=" + values[0]);
                if(name.equals("isbn") && !values[0].isEmpty()) {
                    fields.add("isbn");
                    conditions.add(values[0]);
                }
                else if(name.equals("bookName") && !values[0].isEmpty()) {
                    fields.add("name");
                    conditions.add(values[0]);
                }
                else if(name.equals("author") && !values[0].isEmpty()) {
                    fields.add("author");
                    conditions.add(values[0]);
                }
                else {
                    result.add("other");
                }
            }
            SQLStatementMaker statementMaker = new SQLStatementMaker();

            result.add("結果");
            List<Book> list = H2DAO.getAll(statementMaker.makeStatement("book", fields, conditions), new BookMapping());
            if(list.isEmpty()) {
                result.add("<h1>該当なし</h1>");
            }
            else {
                ResultFormatter resultFormatter = new ResultFormatter();
                request.setAttribute("list", list);
                result = resultFormatter.buildFormat(list);
            }
            request.setAttribute("result", result);
            responseFrame(request, response);

        }
        catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

    }

    private void responseFrame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/input/SearchFrame.jsp");
        dispatcher.include(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
