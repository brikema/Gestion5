package eu.ensup.gestion5.dto;

import eu.ensup.gestion5.domain.ERole;
/**
 * The type Director.
 */
public class DirectorDTO extends ManagerDTO {
    /**
     * Instantiates a new Director.
     *
     * @param lastname    the lastname
     * @param mailAddress the mail address
     * @param address     the address
     * @param phoneNumber the phone number
     * @param id          the id
     * @param firstname   the firstname
     * @param password    the password
     */
    public DirectorDTO(String lastname, String mailAddress, String address, String phoneNumber, int id, String firstname, String password) {
        super(lastname, mailAddress, address, phoneNumber, id, firstname, ERole.DIRECTOR, password);
    }

    /**
     * Instantiates a new Director.
     *
     * @param lastname    the lastname
     * @param mailAddress the mail address
     * @param address     the address
     * @param phoneNumber the phone number
     * @param firstname   the firstname
     * @param password    the password
     */
    public DirectorDTO(String lastname, String mailAddress, String address, String phoneNumber, String firstname, String password) {
        super(lastname, mailAddress, address, phoneNumber, firstname, ERole.DIRECTOR, password);
    }

    /**
     * Instantiates a new Director.
     */
    public DirectorDTO() {

    }

    @Override
    public String toString() {
        String res = super.toString();
        res = res.replace("Manager", "Director");

        return res;
    }
}
