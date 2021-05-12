package eu.ensup.gestion5.dao;

import eu.ensup.gestion5.domain.Course;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseDao implements ICourseDao {

    String className = getClass().getName();

    @Override
    public List<Course> getAll()
    {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        Connection cn = Connect.openConnection();
        List<Course> allCourse = new ArrayList<Course>();

        Statement st = null;
        ResultSet res = null;
        try
        {
            st = cn.createStatement();
            res = st.executeQuery("SELECT * FROM Course");
            if(!res.next()){
            }
            while( res.next() )
            {
                Course cours = new Course(res.getString("coursesubject"),res.getFloat("nbhours"),res.getInt("id"));

                allCourse.add(cours);
            }

            // TODO: Gestion erreur et succès
            if(allCourse.isEmpty())
            {
            }
            st.close();
            cn.close();
        }
        catch (SQLException e) {
        }
        finally{
            try {
                st.close();
                cn.close();
            }
            catch(SQLException sqle) {
            }
        }

        return allCourse;
    }

    @Override
    public Course get( int index )
    {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        Connection cn = Connect.openConnection();
        Course cours = null;

        Statement st = null;
        ResultSet res = null;
        try
        {
            st = cn.createStatement();
            res = st.executeQuery("SELECT * FROM Course WHERE id="+index);
            if(!res.next()){
            }
            else
            {
                cours = new Course(res.getString("coursesubject"), res.getFloat("nbhours"), res.getInt("id"));
            }
        }
        catch (SQLException e) {
        }
        finally{
            try {
                st.close();
                cn.close();
            }
            catch(SQLException sqle) {
            }
        }

        return cours;
    }

    @Override
    public int getIndex(String subject, float nbhours) {
        return 0;
    }

    @Override
    public boolean indexExist(int index) {
        return false;
    }

    @Override
    public int create(Course entity) {
        return 0;
    }

    @Override
    public int update(Course entity) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
