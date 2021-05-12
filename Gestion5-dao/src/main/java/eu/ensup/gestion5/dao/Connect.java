package eu.ensup.gestion5.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The type Connect.
 */
public class Connect
{

    private static final String URL = "jdbc:mysql://localhost:3306/gestion5?serverTimezone=Europe/Berlin";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    /**
     * Open an connention with the information in the class
     *
     * @return an connection open
     */
    public static Connection openConnection()
    {
        Connection cn = null;
        try
        {
            //Chargement du Driver
            //?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC

            //Récuperation de la connection
            if( URL != null && USERNAME != null && PASSWORD != null )
                cn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if( cn == null && URL != null )
                cn = DriverManager.getConnection(URL);

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return cn;
    }
}
