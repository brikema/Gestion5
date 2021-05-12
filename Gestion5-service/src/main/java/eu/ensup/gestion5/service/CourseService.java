package eu.ensup.gestion5.service;

import eu.ensup.gestion5.dao.CourseDao;
import eu.ensup.gestion5.dao.IPersonDao;
import eu.ensup.gestion5.dao.*;
import eu.ensup.gestion5.dao.PersonDao;
import eu.ensup.gestion5.domain.Course;
import eu.ensup.gestion5.dto.CourseDTO;
import eu.ensup.gestion5.mapper.CourseMapper;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class CourseService implements ICourseService {

     ICourseDao dao = null;    // nom de la classe

    String className = getClass().getName();

    public CourseService() {
        this.dao = new CourseDao();
    }

    public CourseService(ICourseDao idao) {
        this.dao = idao;
    }


    public List<CourseDTO> getAll() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        List<CourseDTO> listCourseDto = new ArrayList<CourseDTO>();

        try {
            for (Course c : this.dao.getAll())
                listCourseDto.add(CourseMapper.businessToDto(c));
        } catch (Exception e) {
        }

        return listCourseDto;
    }

    public CourseDTO get(int index) {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        CourseDTO courseDTO = null;
        try {
            courseDTO = CourseMapper.businessToDto(this.dao.get(index));
        } catch (Exception e) {
        }
        return courseDTO;
    }

    @Override
    public int delete(int index) {
        return 0;
    }
}
