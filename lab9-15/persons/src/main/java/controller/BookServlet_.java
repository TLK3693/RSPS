package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import domain.Book;
import java.sql.SQLDataException;
import java.sql.SQLException;

import dao.RoleDbDAO;
import dao.ConnectionProperty;
/**
14
 * Servlet implementation class RoleServlet
 */
@WebServlet("/book")
public class BookServlet_ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectionProperty prop;
	/**
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet_() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
		prop = new ConnectionProperty();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request,
HttpServletResponse
	 * response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		response.setContentType("text/html");
		String userPath;
		List<Book> books;
		RoleDbDAO dao = new RoleDbDAO();
		try {
			books = dao.findAll();
			request.setAttribute("books", books);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userPath = request.getServletPath();
		if ("/book".equals(userPath)) {
			request.getRequestDispatcher("/persons/views/book.jsp").forward(request,response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request,
HttpServletResponse
15
	 * response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoleDbDAO dao = new RoleDbDAO();
		String inputName = request.getParameter("inputName");
		String inputPereplet = request.getParameter("inputPereplet");
		String inputIzdatelstvo = request.getParameter("inputIzdatelstvo");
		String inputYearOfBitrth = request.getParameter("inputYearOfBitrth");
		String inputGenre = request.getParameter("inputGenre");
		Book newBook = new Book(inputName,inputPereplet,inputIzdatelstvo,inputYearOfBitrth,inputGenre);
		try {
			Long index = dao.insert(newBook);
			System.out.println("Adding result: " + index );
		} catch (SQLDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
