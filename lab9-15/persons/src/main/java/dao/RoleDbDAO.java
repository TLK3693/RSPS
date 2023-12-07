package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import domain.Book;
import java.sql.SQLDataException;

/**
 * Класс реализации функций взаимодействия с базой данных для таблицы
roles
 * (Должности)
 */
public class RoleDbDAO implements RepositoryDAO<Book> {
	public RoleDbDAO(){
		// TODO Auto-generated constructor stub
	}
	// SQL-запросы к таблице roles базы данных
	private static final String select_all_role = "SELECT id, bookname, pereplet, izdatelstvo, yearOfBirth, genre FROM public.books ORDER BY bookname ASC";
	private static final String select_role_ById = "SELECT id, bookname, pereplet, izdatelstvo, yearOfBirth, genre FROM public.books WHERE id = ?";
	private static final String insert_role = "INSERT INTO public.books(bookname, pereplet, izdatelstvo, yearOfBirth, genre) VALUES(?,?,?,?,?)";
	private static final String edit_role = "UPDATE public.books SET bookname = ?, pereplet = ?, izdatelstvo = ?, yearOfBirth = ?, genre = ? WHERE id = ?";
	private static final String delete_role = "DELETE FROM public.books WHERE id = ?";
	// Создание соединения с базой данных
	private ConnectionBuilder builder = new DbConnectionBuilder();
	private Connection getConnection() throws SQLException {	
		return builder.getConnection();
	}

//	private Connection getConnection() throws SQLException {
//		String url = "jdbc:postgresql://localhost:5433/persons";
//		String login = "postgres";
//		String password = "0000";
//		
//		return builder.getConnection(url, login, password);
//	}
		//Class.forName("org.postgresql.Driver");
//		Connection con = DriverManager.getConnection(url, login, password);
	
	// Добавление новой должности
	@Override
	public Long insert (Book book) throws SQLDataException {
		try (Connection con = getConnection();PreparedStatement pst = con.prepareStatement(insert_role, new String[] { "id" })) {
			Long Id = -1L;
			pst.setString(1, book.getNameBook());
			pst.setString(2, book.getPereplet());
			pst.setString(3, book.getIzdatelstvo());
			pst.setString(4, book.getYearOfBirth());
			pst.setString(5, book.getGenre());
			pst.executeUpdate();
			ResultSet gk = pst.getGeneratedKeys();
			if (gk.next()) {
				Id = gk.getLong("id");
			}
			gk.close();
			return Id;
		} catch (Exception e) {
			throw new SQLDataException(e);
		}
	}
	
	// Редактирование должности
	@Override
	public void update(Book book) throws SQLDataException {
		try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(edit_role)) {
			pst.setString(1, book.getNameBook());
			pst.setString(2, book.getPereplet());
			pst.setString(3, book.getIzdatelstvo());
			pst.setString(4, book.getYearOfBirth());
			pst.setString(5, book.getGenre());
			pst.setLong(6, book.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			throw new SQLDataException(e);
		}
	}
	
	// Удаление должности
	@Override
	public void delete(Long Id) throws SQLDataException {
		try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(delete_role)) {
			pst.setLong(1, Id);
			pst.executeUpdate();
		} catch (Exception e) {
			throw new SQLDataException(e);
		}
	}
	
	// Поиск должности по Id
	@Override
	public Book findById(Long Id) throws SQLDataException {
		Book book = null;
		try (Connection con = getConnection()) {
			PreparedStatement pst = con.prepareStatement(select_role_ById);
			pst.setLong(1, Id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				book = fillBook(rs);
			}
			rs.close();
			pst.close();
		} catch (Exception e) {
			
			throw new SQLDataException(e);
		}
		return book;
	}
	
	// Формирование списка всех должностей
	@Override
	public List<Book> findAll() throws SQLDataException {
		List<Book> list = new LinkedList<>();
		try (Connection con = getConnection();
				PreparedStatement pst = con.prepareStatement(select_all_role);
				ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				list.add(fillBook(rs));
			}
			rs.close();
		} catch (Exception e) {
			throw new SQLDataException(e);
		}
		return list;
	}
	
	// Формирование класса Должности по результатам запроса к БД
	private Book fillBook(ResultSet rs) throws SQLException {
		Book book = new Book();
		book.setId(rs.getLong("id"));
		book.setNameBook(rs.getString("bookname"));
		book.setPereplet(rs.getString("pereplet"));
		book.setIzdatelstvo(rs.getString("izdatelstvo"));
		book.setYearOfBirth(rs.getString("yearOfBirth"));
		book.setGenre(rs.getString("genre"));
		return book;
	}
	
	// Поиск должности по id из списка должностей
	public Book FindById(Long id, List<Book> books) {
		if (books != null) {
			for (Book r : books) {
				if ((r.getId()).equals(id)) {
					return r;
				}
			}
		} else {
			return null;
		}
		return null;
	}
}