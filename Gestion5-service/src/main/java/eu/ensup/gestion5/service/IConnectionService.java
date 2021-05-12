package eu.ensup.gestion5.service;

/**
 * The interface Service connection.
 */
public interface IConnectionService
{
    /**
     * Check connection int.
     *
     * @param mail the mail
     * @param mdp  the mdp
     * @return the int
     */
// Checker ID MDP, Mot de passe oublié
    int checkConnection(String mail, String mdp);
}
