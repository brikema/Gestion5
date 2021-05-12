package eu.ensup.gestion5.domain;

/**
 * The type Entity
 *
 * @author amelie
 */
public class Entity
{
    private String lastname;
    private String mailAddress;
    private String address;
    private String phoneNumber;

    /**
     * Gets lastname.
     *
     * @return The lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets lastname.
     *
     * @param lastname the lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets mail address.
     *
     * @return the mail address
     */
    public String getMailAddress() {
        return mailAddress;
    }

    /**
     * Sets mail address.
     *
     * @param mailAddress the mail address
     */
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    /**
     * Gets address.
     *
     * @return the entity address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets phone number.
     *
     * @return the entity phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Instantiates a new Entity.
     *
     * @param lastname    the lastname
     * @param mailAddress the mail address
     * @param address     the address
     * @param phoneNumber the phone number
     */
    public Entity(String lastname, String mailAddress, String address, String phoneNumber) {
        super();
        this.lastname = lastname;
        this.mailAddress = mailAddress;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Instantiates a new Entity.
     *
     * @param lastname    the lastname
     * @param mailAddress the mail address
     */
    public Entity(String lastname, String mailAddress)
    {
        this(lastname, mailAddress, null, null);
    }

    /**
     * Instantiates a new Entity.
     */
    public Entity() {
    }

    @Override
    public String toString() {
        return "Entity [lastname=" + lastname + ", mailAddress=" + mailAddress + ", address=" + address + ", phoneNumber="
                + phoneNumber + "]";
    }

    /**
     * Is equal to boolean.
     *
     * @param entity the entity
     * @return the boolean
     */
    public boolean isEqualTo(Entity entity)
    {
        boolean res = false;
        if( this.getMailAddress() == entity.getMailAddress()) {
            res = true;
        }
        return res;
    }
}
