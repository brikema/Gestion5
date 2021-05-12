package eu.ensup.gestion5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static eu.ensup.gestion5.dao.Connect.openConnection;

/**
 * The type Dao login.
 */
public class LoginDao implements ILoginDao {
    /**
     * The Connection.
     */
    Connection cn = null;

    /**
     * The Prepared Statement.
     */
    PreparedStatement st = null;

    /**
     * The Result Set.
     */
    ResultSet rs = null;


    String className = getClass().getName();
    /**
     * The update, create and remove result.
     */
    int res = 0;

    /**
     * Gets password.
     *
     * @param mail     the mail
     * @param password the password
     * @return the password
     */
    public int checkPassword(String mail, String password) {
        int id = 0;
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        try {
            /*
             * Creer la connexion
             */
            cn = openConnection();

            /*
             * CrÃ©er la requÃªte
             */
            String sql_request = "SELECT id FROM Person WHERE email = ? AND password = ? AND (role = 1 OR role = 2)";
            st = cn.prepareStatement(sql_request);
            st.setString(1, mail);
            st.setString(2, password);

            /*
             * ExÃ©cuter la requÃªte
             */
            rs = st.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
