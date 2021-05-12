package eu.ensup.gestion5.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * The type Connect.
 */
public class Connect
{

    private static  String URL = "";
    private static  String USERNAME = "";
    private static  String PASSWORD = "";

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
            ResourceBundle bundle = ResourceBundle.getBundle("db");
            URL = bundle.getString("db.url");
            USERNAME = bundle.getString("db.username");
            PASSWORD =bundle.getString("db.password");
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
