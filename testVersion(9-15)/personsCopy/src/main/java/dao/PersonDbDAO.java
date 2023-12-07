package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLDataException;
import java.util.LinkedList;
import java.util.List;
import domain.Author;

/**
 * Класс реализации функций взаимодействия с базой данных для таблицы
persons
 * (Сотрудники)
 */
public class PersonDbDAO implements RepositoryDAO<Author> {
	// SQL-запросы к таблице persons базы данных
	private static final String select_all_person = "SELECT id, bookid, firstname, middlename, lastname, phone, raiting, email FROM authors ORDER BY lastname ASC";
	private static final String select_person_ById = "SELECT id, bookid, firstname, middlename, lastname, phone, raiting, email FROM persons WHERE id = ?";
	private static final String insert_person = "INSERT INTO authors(bookid, firstname, middlename, lastname, phone, raiting, email) VALUES(?,?,?,?,?,?,?)";
	private static final String edit_person = "UPDATE authors SET bookid = ?, firstname = ?, middlename = ?, lastname = ?, phone = ?, raiting = ?, email = ? WHERE id = ?";
	private static final String delete_person = "DELETE FROM authors WHERE id = ?";
	// Создание соединения с базой данных
	private ConnectionBuilder builder = new DbConnectionBuilder();
	private Connection getConnection() throws SQLException {
		return builder.getConnection();
	}
//	private ConnectionBuilder builder = new DbConnectionBuilder();
//	private Connection getConnection() throws SQLException {
//		String url = "jdbc:postgresql://localhost:5433/persons";
//		String login = "postgres";
//		String password = "0000";
//		
//		return builder.getConnection(url, login, password);
//	}
	
	RoleDbDAO dao = new RoleDbDAO();
	public PersonDbDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Long insert(Author author) throws SQLDataException {
		try (Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement(insert_person, new String[] { "id" })) {
				Long Id = -1L;
				pst.setLong(1, author.getIdBook());
				pst.setString(2, author.getFirstName());
				pst.setString(3, author.getMiddleName());
				pst.setString(4, author.getLastName());
				pst.setString(5, author.getPhone());
				pst.setInt(6, author.getRaiting());
				pst.setString(7, author.getEmail());
				pst.executeUpdate();
				ResultSet gk = pst.getGeneratedKeys();
				if (gk.next()) {
					Id = gk.getLong("id");
				}
					gk.close();
					return Id;
				} catch (Exception e) {
					throw new SQLDataException(e); // SQLException
				}
			}
	
			@Override
			public void update(Author author) throws SQLDataException {
				try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(edit_person)) {
					pst.setLong(1, author.getIdBook());
					pst.setString(2, author.getFirstName());
					pst.setString(3, author.getMiddleName());
					pst.setString(4, author.getLastName());
					pst.setString(5, author.getPhone());
					pst.setInt(6, author.getRaiting());
					pst.setString(7, author.getEmail());
					pst.setLong(8, author.getId());
					pst.executeUpdate();
				} catch (Exception e) {
					throw new SQLDataException(e);
				}
			}
			
			@Override
			public void delete(Long Id) throws SQLDataException {
				try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(delete_person)) {
					pst.setLong(1, Id);
					pst.executeUpdate();
				} catch (Exception e) {
					throw new SQLDataException(e);
				}
			}
			
			@Override
			public Author findById(Long Id) throws SQLDataException {
				Author person = null;
				try (Connection con = getConnection()) {
					PreparedStatement pst = con.prepareStatement(select_person_ById);
					pst.setLong(1, Id);
					ResultSet rs = pst.executeQuery();
					if (rs.next()) {
						person = fillPerson(rs);
					}
					rs.close();
					pst.close();
				} catch (Exception e) {
					throw new SQLDataException(e);
				}
				return person;
			}
			
			@Override
			public List<Author> findAll() throws SQLDataException {
				List<Author> list = new LinkedList<>();
				try (Connection con = getConnection();
						PreparedStatement pst = con.prepareStatement(select_all_person);
						ResultSet rs = pst.executeQuery()) {
					while (rs.next()) {
						list.add(fillPerson(rs));
					}
					rs.close();
				} catch (Exception e) {
					throw new SQLDataException(e);
				}
				return list;
			}
			
			private Author fillPerson(ResultSet rs) throws SQLException, SQLDataException {
				Long idBook = rs.getLong("bookid");
				Author person = new Author();
				person.setId(rs.getLong("id"));
				person.setFirstName(rs.getString("firstname"));
				person.setMiddleName(rs.getString("middlename"));
				person.setLastName(rs.getString("lastname"));
				person.setPhone(rs.getString("phone"));
				person.setRaiting(rs.getInt("raiting"));
				person.setEmail(rs.getString("email"));
				person.setIdBook(idBook);
				return person;
			}
}
