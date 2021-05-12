package eu.ensup.gestion5.dao;

import static eu.ensup.gestion5.dao.Connect.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import eu.ensup.gestion5.domain.*;

/**
 * The type Dao.
 */
public class PersonDao implements IPersonDao
{
    /**
     * The Cn.
     */
// initialisation des variables java permettant de dialoguer avec la bdd
    // connecter a la base de données
    Connection cn = null;
    /**
     * The St.
     */
// executer la requete
    PreparedStatement st = null;
    /**
     * The Rs.
     */
// récupérer le résultat
    ResultSet rs = null;
    /**
     * The Res.
     */
// nombre de mises à jour
    int res = 0;
    // nom de la classe
    String className = getClass().getName();

    /**
     * Instantiates a new Dao person.
     */
    public PersonDao()
    {

    }

    /**
     * Get person.
     *
     * @param id the person id in the database
     * @return Result of the request, if an exception was catched, returns -1
     */
    @Override
    public Person get(int id) {
        Person p1 = null;
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        try {
            /*
             * Créer la connexion
             */
            cn = openConnection();

            /*
             * CrÃ©er la requÃªte
             */
            String sql_request = "SELECT * FROM Person WHERE id = ?";
            st = cn.prepareStatement(sql_request);
            st.setInt(1, id);

            /*
             * ExÃ©cuter la requÃªte
             */
            rs = st.executeQuery();

            /*
             * Créer une personne
             */
            if(rs.next())
            {
                String firstName = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                int role = rs.getInt("role");
                String password = rs.getString("password");
                Object dateofbirth = rs.getObject("dateofbirth");
                Object subjecttaught = rs.getObject("subjecttaught");
                float average = rs.getFloat("average");

                if(rs.getInt("role") == ERole.DIRECTOR.getNum())
                {
                    p1 = new Director(lastname, email, address, phone, id, firstName, password);
                }
                else if(rs.getInt("role") == ERole.MANAGER.getNum())
                {
                    p1 = new Manager(lastname, email, address, phone, id, firstName, password);
                }
                else if(rs.getInt("role") == ERole.TEACHER.getNum())
                {
                    if(subjecttaught != null) {
                        p1 = new Teacher(lastname, email, address, phone, id, firstName, password, (String)subjecttaught);
                    }
                    else {
                        p1 = new Teacher(lastname, email, address, phone, id, firstName, password, null);
                    }
                }
                else if(rs.getInt("role") == ERole.STUDENT.getNum())
                {
                    if(dateofbirth != null) {
                        p1 = new Student(lastname, email, address, phone, id, firstName, password, (Date)dateofbirth, average);
                    } else {
                        p1 = new Student(lastname, email, address, phone, id, firstName, password, null, average);
                    }
                }
            } else {
            }

            /*
             * Fermer la connexion
             */
            cn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p1;
    }

    /**
     * Get all person.
     *
     * @return List of Person, if an exception was catched, returns -1
     */
    @Override
    public List<Person> getAll() {
        List<Person> listPerson = new ArrayList<Person>();
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        try {
            /*
             * CrÃ©er la connexion
             */
            cn = openConnection();

            /*
             * CrÃ©er la requÃªte
             */
            String sql_request = "SELECT * FROM Person";
            st = cn.prepareStatement(sql_request);

            /*
             * ExÃ©cuter la requÃªte
             */
            rs = st.executeQuery();

            /*
             * Créer une personne
             */

            while(rs.next())
            {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                int role = rs.getInt("role");
                String password = rs.getString("password");
                Object dateofbirth = rs.getObject("dateofbirth");
                Object subjecttaught = rs.getObject("subjecttaught");
                float average = rs.getFloat("average");

                Person p1 = null;

                if(rs.getInt("role") == ERole.DIRECTOR.getNum())
                {
                    p1 = new Director(lastname, email, address, phone, id,  firstName, password);
                }
                else if(rs.getInt("role") == ERole.MANAGER.getNum())
                {
                    p1 = new Manager(lastname, email, address, phone, id, firstName, password);
                }
                else if(rs.getInt("role") == ERole.TEACHER.getNum())
                {
                    if(subjecttaught != null) {
                        p1 = new Teacher(lastname, email, address, phone, id, firstName, password, (String)subjecttaught);
                    }
                    else {
                        p1 = new Teacher(lastname, email, address, phone, id, firstName, password, null);
                    }
                }
                else if(rs.getInt("role") == ERole.STUDENT.getNum())
                {
                    if(dateofbirth != null) {
                        p1 = new Student(lastname, email, address, phone, id, firstName, password, (Date)dateofbirth, average);
                    }
                    else {
                        p1 = new Student(lastname, email, address, phone, id, firstName, password, null, average);
                    }
                }
                listPerson.add(p1);
            }

            if(listPerson.isEmpty())
            {

            }

            /*
             * Fermer la connexion
             */

            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPerson;
    }

    /**
     * Create person. Person could be of type Teacher, Director, Student or Manager
     *
     * @param entity the person object
     * @return Result of the request, if an exception was catched, returns -1
     */
    @Override
    public int create(Person entity){
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        try {
            /*
             * CrÃ©er la connexion
             */
            cn = openConnection();

            /*
             * CrÃ©er la requete
             */
            String sql_request = "INSERT INTO Person(" +
                    "firstname," +
                    "lastname," +
                    "email," +
                    "address,"+
                    "phone,"+
                    "role,"+
                    "password,"+
                    "dateofbirth,"+
                    "subjecttaught," +
                    "average) "+
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            st = cn.prepareStatement(sql_request);
            st.setString(1, entity.getFirstname());
            st.setString(2, entity.getLastname());
            st.setString(3, entity.getMailAddress());
            st.setString(4, entity.getAddress());
            st.setString(5, entity.getPhoneNumber());
            st.setInt   (6, entity.getRole().getNum());
            st.setString(7, entity.getPassword());

            if(entity instanceof Student)
            {
//                st.setDate  (8, new java.sql.Date(((Student) entity).getDateOfBirth().getTime()));
                st.setDate  (8, null);
                st.setString (9, null);
                st.setDouble(10, ((Student) entity).getAverage());
            }else if(entity instanceof Teacher)
            {
                st.setDate  (8, null);
                st.setString (9, ((Teacher) entity).getSubjectTaught());
            }else
            {
                st.setDate  (8, null);
                st.setString (9, null);
            }

            /*
             * ExÃ©cuter la requÃªte
             */
            res = st.executeUpdate();

            /*
             * Fermer la connexion
             */
            cn.close();

            /**
             * Log to file
             */

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * Update person. Person could be of type Teacher, Director, Student or Manager
     *
     * @param entity the person object
     * @return Result of the request, if an exception was catched, returns -1
     */
    @Override
    public int update(Person entity){
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        try {
            /*
             * CrÃ©er la connexion
             */
            cn = openConnection();

            /*
             * CrÃ©er la requÃªte
             */
            String sql_request = "UPDATE Person SET " +
                    "firstname = ?, " +
                    "lastname = ?, " +
                    "address =  ?, "+
                    "phone = ?, "+
                    "role = ?, "+
                    "password = ?, "+
                    "dateofbirth = ?, "+
                    "subjecttaught = ?, "+
                    "average = ? "+
                    "WHERE email = ?";
            st = cn.prepareStatement(sql_request);
            st.setString(1, entity.getFirstname());
            st.setString(2, entity.getLastname());
            st.setString(3, entity.getAddress());
            st.setString(4, entity.getPhoneNumber());
            st.setInt   (5, entity.getRole().getNum());
            st.setString(6, entity.getPassword());
            if(entity instanceof Student)
            {
                st.setDate  (7, null);
//                st.setDate  (7, new java.sql.Date(((Student) entity).getDateOfBirth().getTime()));
                st.setString(8, null);
                st.setDouble(9, ((Student) entity).getAverage());
            }else if(entity instanceof Teacher)
            {
                st.setDate(7, null);
                st.setString (8, ((Teacher) entity).getSubjectTaught());
                st.setDouble(9, (Double)null);
            }else
            {
                st.setDate(7, null);
                st.setString (8, null);
                st.setDouble(9, (Double)null);
            }
            st.setString (10,  entity.getMailAddress());
            /*
             * ExÃ©cuter la requÃªte
             */
            res = st.executeUpdate();

            if( res == 0)
            {

            }

            /*
             * Fermer la connexion
             */
            cn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * Delete person.
     *
     * @param index index of the person in the database
     * @return List of Person, if an exception was catched, returns -1
     */
    @Override
    public int delete(int index) {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        try {
            /*
             * CrÃ©er la connexion
             */
            cn = openConnection();

            /*
             * CrÃ©er la requÃªte
             */
            String sql_request = "DELETE FROM Person WHERE id = ?";
            st = cn.prepareStatement(sql_request);
            st.setInt(1, index);

            /*
             * ExÃ©cuter la requÃªte
             */
            res = st.executeUpdate();

            if (res != 0) {
            }

            /*
             * Fermer la connexion
             */
            cn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Link to course int.
     *
     * @param entity the entity
     * @param course the course
     * @return Result of the request
     */
    public int linkToCourse(int entity, int course) {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();

        try {
            /*
             * CrÃ©er la connexion
             */
            cn = openConnection();

            /*
             * CrÃ©er la requÃªte
             */
            String sql_request = "INSERT INTO Course_Person(idPerson, idCourse) VALUES (?, ?)";
            st = cn.prepareStatement(sql_request);
            st.setInt(1, entity);
            st.setInt(2, course);

            /*
             * ExÃ©cuter la requÃªte
             */
            res = st.executeUpdate();
            if(res == 0)
            {
            }
            else {
            }
            /*
             * Fermer la connexion
             */
            cn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
