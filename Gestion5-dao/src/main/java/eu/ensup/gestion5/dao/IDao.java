package eu.ensup.gestion5.dao;


import java.util.List;

/**
 * The interface Dao.
 *
 * @param <T> the type parameter
 */
public interface IDao<T>
{

//    final LoggerDao DaoLogger = new LoggerDao();
// TODO enlever les commentaires inutiles (chercher "//")

    /**
     * list all T of the database.
     *
     * @return list of all T
     */
    List<T> getAll();

    /**
     * Get an T in the database.
     *
     * @param id index of the T to be get
     * @return the class of type T
     */
    T get(int id);

    /**
     * Create an T in the database.
     *
     * @param entity T to be created
     * @return type of the result
     */
    int create(T entity);

    /**
     * Update an T of the database.
     *
     * @param entity T to be updated
     * @return type of the result
     */
    int update(T entity);

//    /**
//     * delete an T in the database.
//     *
//     * @param entity T to be deleted
//     * @return type of the result
//     */
//    default int delete(T entity) {
//        //TODO : to delete
//        return 0;
//    }

    /**
     * Delete int.
     *
     * @param id the index
     * @return the int
     */
    int delete(int id);
}
