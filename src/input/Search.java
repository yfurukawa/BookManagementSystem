package input;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Book;
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
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    
	    try {
            List<Book> list = H2DAO.getAll("SELECT * FROM book where isbn = '9784844365105'", new BookMapping());
            request.setAttribute("list", list);
            request.getRequestDispatcher("/input/SearchFrame.jsp");
        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
	    
	    PrintWriter out = response.getWriter();
	    
	    responseFrame(request, response);
	    
	    Enumeration<String> names = request.getParameterNames();
	    
	    while(names.hasMoreElements()) {
	        String name = names.nextElement();
	        String[] values = request.getParameterValues(name);
	        for(int i = 0; i < values.length; ++i) {
	            out.println(name + "=" + values[i]);
	        }
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
