package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLDataException;
import java.util.List;
import dao.ConnectionProperty;
import dao.PersonDbDAO;
import dao.RoleDbDAO;
import domain.Author;
import domain.Book;
/**
 * Servlet implementation class PersonServlet
 */
@WebServlet("/person")
public class PersonServlet_ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectionProperty prop;

	public PersonServlet_() throws FileNotFoundException, IOException {
		super();
		prop = new ConnectionProperty();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		response.setContentType("text/html");
		String userPath;
		List<Author> persons;
		List<Book> roles;
		RoleDbDAO daoRole = new RoleDbDAO();
		PersonDbDAO dao = new PersonDbDAO();
		try {
			persons = dao.findAll();
			roles = daoRole.findAll();
			for (Author person: persons) {
				person.setBook(daoRole.FindById(person.getIdBook(), roles));
			}
			request.setAttribute("persons", persons);
		} catch (SQLDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userPath = request.getServletPath();
		if("/person".equals(userPath)){
			request.getRequestDispatcher("persons/views/person.jsp").forward(request
					, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request,
HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}