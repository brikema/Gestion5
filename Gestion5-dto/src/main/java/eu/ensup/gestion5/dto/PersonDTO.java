package eu.ensup.gestion5.dto;

import eu.ensup.gestion5.domain.ERole;

/**
 * The type Person.
 *
 * @author Allan
 */
public class PersonDTO extends EntityDTO {

    private int id;
    private String firstname;
    private String password;
    private ERole role;
    // TODO Faire un ERoleDTO afin de e pas lie la couche domain et la couche DTO

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public ERole getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(ERole role) {
        this.role = role;
    }

    /**
     * Gets firstname.
     *
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets firstname.
     *
     * @param firstname the firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Instantiates a new Person.
     */
    public PersonDTO() {
    }

    /**
     * Instantiates a new Person.
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
    public PersonDTO(String lastname, String mailAddress, String address, String phoneNumber, int id, String firstname, ERole role, String password) {
        super(lastname, mailAddress, address, phoneNumber);
        this.id = id;
        this.firstname = firstname;
        this.role = role;
        this.password = password;
    }

    /**
     * Instantiates a new Person.
     *
     * @param lastname    the lastname
     * @param mailAddress the mail address
     * @param address     the address
     * @param phoneNumber the phone number
     * @param firstname   the firstname
     * @param role        the role
     * @param password    the password
     */
    public PersonDTO(String lastname, String mailAddress, String address, String phoneNumber, String firstname, ERole role, String password) {
        super(lastname, mailAddress, address, phoneNumber);
        this.id = id;
        this.firstname = firstname;
        this.role = role;
        this.password = password;
    }

    /**
     * Instantiates a new Person.
     *
     * @param lastname    the lastname
     * @param mailAddress the mail address
     * @param id          the id
     * @param firstname   the firstname
     * @param password    the password
     */
    public PersonDTO(String lastname, String mailAddress, int id, String firstname, String password) {
        super(lastname, mailAddress);
        this.id = id;
        this.firstname = firstname;
        this.password = password;
    }

    @Override
    public String toString()
    {
        String res = super.toString();
        res = res.replace("Entity", "Person");
        res = res.substring(0, res.length()-1);
        res = res + ", id=" + id + ", firstname=" + firstname + ", password=" + password + "]";

        return res;
    }
}
