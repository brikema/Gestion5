package eu.ensup.gestion5.service;


import eu.ensup.gestion5.dao.ILoginDao;
import eu.ensup.gestion5.dao.LoginDao;

/**
 * The type Service connection.
 */
public class ConnectionService implements IConnectionService {
    private ILoginDao dao;
    // nom de la classe
    String className = getClass().getName();

    public ConnectionService()
    {
        this.dao = new LoginDao();
    }

    public ConnectionService(ILoginDao idao)
    {
        this.dao = idao;
    }

    @Override
    public int checkConnection(String mail, String mdp) {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        int id = 0;
        try {
            id = this.dao.checkPassword(mail, mdp); // Récupération du MDP et comparaison avec le mdp saisi
        } catch (Exception e){
            e.printStackTrace();
        } finally {

        }
        return id;
    }
}
