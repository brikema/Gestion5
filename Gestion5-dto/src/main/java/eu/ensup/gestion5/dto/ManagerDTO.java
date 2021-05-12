package eu.ensup.gestion5.dto;

import eu.ensup.gestion5.domain.ERole;

/**
 * The type Director.
 * Is responsible
 */
public class ManagerDTO extends PersonDTO {
    /**
     * Instantiates a new Manager.
     *
     * @param lastname    the lastname
     * @param mailAddress the mail address
     * @param address     the address
     * @param phoneNumber the phone number
     * @param id          the id
     * @param firstname   the firstname
     * @param role        the role
     * @param password    the password
     */
    public ManagerDTO(String lastname, String mailAddress, String address, String phoneNumber, int id, String firstname, ERole role, String password) {
        super(lastname, mailAddress, address, phoneNumber, id, firstname, role, password);
    }

    /**
     * Instantiates a new Manager.
     *
     * @param lastname    the lastname
     * @param mailAddress the mail address
     * @param address     the address
     * @param phoneNumber the phone number
     * @param id          the id
     * @param firstname   the firstname
     * @param password    the password
     */
    public ManagerDTO(String lastname, String mailAddress, String address, String phoneNumber, int id, String firstname, String password) {
        super(lastname, mailAddress, address, phoneNumber, id, firstname, ERole.MANAGER, password);
    }

    /**
     * Instantiates a new Manager.
     *
     * @param lastname    the lastname
     * @param mailAddress the mail address
     * @param address     the address
     * @param phoneNumber the phone number
     * @param firstname   the firstname
     * @param password    the password
     */
    public ManagerDTO(String lastname, String mailAddress, String address, String phoneNumber, String firstname, String password) {
        super(lastname, mailAddress, address, phoneNumber, firstname, ERole.MANAGER, password);
    }

    /**
     * Instantiates a new Manager.
     *
     * @param lastname    the lastname
     * @param mailAddress the mail address
     * @param id          the id
     * @param firstname   the firstname
     * @param password    the password
     */
    public ManagerDTO(String lastname, String mailAddress, int id, String firstname, String password) {
        super(lastname, mailAddress, id, firstname, password);
    }

    /**
     * Instantiates a new Manager.
     */
    public ManagerDTO() {

    }

    /**
     *
     * @param lastname
     * @param mailAddress
     * @param address
     * @param phoneNumber
     * @param firstname
     * @param director
     * @param password
     */
    public ManagerDTO(String lastname, String mailAddress, String address, String phoneNumber, String firstname, ERole director, String password) {
    }

    @Override
    public String toString() {
        String res = super.toString();
        res = res.replace("Person", "Manager");

        return res;
    }
}
