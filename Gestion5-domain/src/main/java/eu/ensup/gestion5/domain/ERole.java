package eu.ensup.gestion5.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * The enum Role.
 */
public enum ERole
{
    /**
     * Director role.
     */
    DIRECTOR (1, "Director"),
    /**
     * Manager role.
     */
    MANAGER  (2, "Manager"),
    /**
     * Teacher role.
     */
    TEACHER  (3, "Teacher"),
    /**
     * Student role.
     */
    STUDENT  (4, "Student");

    private int    numRole;
    private String name;

    /**
     * Gets num.
     *
     * @return the num
     */
    public int    getNum()  { return this.numRole; }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() { return this.name; }

    /**
     * Gets role by name.
     *
     * @param name the name
     * @return the role by name
     */
    public ERole getRoleByName(String name)
    {
        switch(name)
        {
            case "Director": return this.DIRECTOR;
            case "Manager": return this.MANAGER;
            case "Teacher": return this.TEACHER;
            default: return this.STUDENT;
        }
    }

    /**
     * Gets role by num.
     *
     * @param num the num
     * @return the role by num
     */
    static public ERole getRoleByNum(int num)
    {
        switch(num)
        {
            case 1: return DIRECTOR;
            case 2: return MANAGER;
            case 3: return TEACHER;
            default: return STUDENT;
        }
    }

    /**
     * Gets all roles.
     *
     * @return the all roles
     */
    public List<ERole> getAllRoles()
    {
        List<ERole> lRole = new ArrayList<ERole>();

        lRole.add(this.DIRECTOR);
        lRole.add(this.MANAGER);
        lRole.add(this.TEACHER);
        lRole.add(this.STUDENT);

        return lRole;
    }

    private ERole(int numRole, String name)
    {
        this.numRole = numRole;
        this.name = name;
    }


}