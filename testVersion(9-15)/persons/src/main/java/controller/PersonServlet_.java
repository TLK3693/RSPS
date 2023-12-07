package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLDataException;
import java.sql.SQLException;
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
			roles = daoRole.findAll();
			request.setAttribute("roles", roles);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			persons = dao.findAll();
			roles = daoRole.findAll();
			for (Author person: persons) {
				person.setBook(daoRole.FindById(person.getIdBook(), roles));
			}
			request.setAttribute("persons", persons);
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		userPath = request.getServletPath();
		if("/person".equals(userPath)){
			request.getRequestDispatcher("/persons/views/author.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonDbDAO dao = new PersonDbDAO();
		String lastName = request.getParameter("lastName");
		String middleName = request.getParameter("middleName");
		String firstname = request.getParameter("firstname");
		String raiting = request.getParameter("raiting");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		String role = request.getParameter("nameBook");
		int index1 = role.indexOf('=');
		int index2 = role.indexOf(",");
		String r1 = role.substring(index1+1, index2);
		Long idRole = Long.parseLong(r1.trim());
		
		Author newPerson = new Author(lastName, middleName, firstname,Integer.parseInt(raiting),phone, email,idRole) ;
		try {
			Long index = dao.insert(newPerson);
			System.out.println("Adding result: " + index);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}
}