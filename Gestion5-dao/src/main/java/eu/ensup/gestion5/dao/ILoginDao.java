package eu.ensup.gestion5.dao;

/**
 * The type Dao login.
 */
public interface ILoginDao
{
    /**
     * Gets password.
     *
     * @param mail     the mail
     * @param password the password
     * @return the password
     */
    public int checkPassword(String mail, String password);
}
