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
import domain.Book;
import dao.RoleDbDAO;
import dao.ConnectionProperty;
@WebServlet("/editrole")
public class EditRoleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ConnectionProperty prop;

	public EditRoleServlet()
			throws FileNotFoundException, IOException {
		super();
		prop = new ConnectionProperty();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String userPath;
		List<Book> roles;
		Book editrole = null;
		RoleDbDAO dao = new RoleDbDAO();
		try {
			roles = dao.findAll();
			request.setAttribute("roles", roles);
		} catch (SQLDataException e) {
			e.printStackTrace();
		}
		String strId = request.getParameter("id");
		Long id = null; // id редактируемой должности
		if(strId != null) {
			id = Long.parseLong(strId);
		}
		try {
			editrole = dao.findById(id);
		} catch (SQLDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("roleEdit", editrole);
		userPath = request.getServletPath();
		if ("/editrole".equals(userPath)) {
			request.getRequestDispatcher("/views/editrole.jsp")
			.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {

		RoleDbDAO dao = new RoleDbDAO();
		String strId = request.getParameter("id");
		Long id = null;
		if(strId != null) {
			id = Long.parseLong(strId);
		}
		String namerole = request.getParameter("inputRole");
		Book editrole = new Book(id, namerole);
		try {
			dao.update(editrole);
		} catch (SQLDataException e) {
			e.printStackTrace();
		}
		response.sendRedirect("/persons/role");
	}
}