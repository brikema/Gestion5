package eu.ensup.gestion5.dao;

import eu.ensup.gestion5.domain.Mark;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MarkDao implements IMarkDao{


    public List<Mark> getAllMarkByStudentId(int index )
    {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        Connection cn = Connect.openConnection();
        List<Mark> allMark = new ArrayList<Mark>();

        Statement st = null;
        ResultSet res = null;
        try
        {
            st = cn.createStatement();
            res = st.executeQuery("SELECT * FROM Mark WHERE idStudent="+index);

            while( res.next() )
                allMark.add(new Mark(res.getInt("id"), res.getInt("idStudent"), res.getInt("idCourse"), res.getFloat("mark"), res.getString("assessment")));

            st.close();
            cn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return allMark;
    }

    @Override
    public List<Mark> getAll() {
        return null;
    }

    @Override
    public Mark get(int id) {
        return null;
    }

    @Override
    public int create( Mark mark )
    {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        int res = 1;
        Connection cn = Connect.openConnection();
        PreparedStatement pstmt = null;
        try
        {
            if( mark.getId() != -1 )
            {
                pstmt = cn.prepareStatement("INSERT INTO Mark (idStudent, idCourse, mark, assessment) VALUES ( ?, ?, ?, ? )");
                int index = 1;
                pstmt.setInt(index++, mark.getIdStudent());
                pstmt.setInt(index++, mark.getIdCourse());
                pstmt.setFloat(index++, mark.getMark());
                pstmt.setString(index++, mark.getAssessment());

                pstmt.execute();
                pstmt.close();
            }else{
            }
            cn.close();
        }
        catch (SQLException e) {
        }
        return res;
    }

    @Override
    public int update(Mark entity) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public boolean idExist(int id) {
        return false;
    }
}
