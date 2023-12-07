package dao;
import java.sql.SQLDataException;
import java.util.List;
//import exception.DAOException;
public interface RepositoryDAO<T> {
// Добавление сущности в таблицу базы данных
// возвращает ID добавленного должности
public Long insert(T о) throws SQLDataException;
// Редактирование cущности
public void update(T o) throws SQLDataException;
// Удаление сущности
public void delete(Long Id) throws SQLDataException;
// Поиск сущности по Id
public T findById(Long Id) throws SQLDataException;
// Получение списка сущностей
public List<T> findAll() throws SQLDataException;
}