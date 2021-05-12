package eu.ensup.gestion5.service;

import java.util.ArrayList;
import eu.ensup.gestion5.dao.IPersonDao;
import eu.ensup.gestion5.dao.MarkDao;
import eu.ensup.gestion5.dao.PersonDao;
import eu.ensup.gestion5.domain.*;
import eu.ensup.gestion5.dto.*;
import eu.ensup.gestion5.mapper.DirectorMapper;
import eu.ensup.gestion5.mapper.ManagerMapper;
import eu.ensup.gestion5.mapper.StudentMapper;
import eu.ensup.gestion5.mapper.TeacherMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Service person.
 */
public class PersonService implements IEntityService<PersonDTO> {

    private IPersonDao dao = null;

    // nom de la classe
    String className = getClass().getName();

    /**
     * Instantiates a new Service person.
     */
    public PersonService() {
        this.dao = new PersonDao();
    }

    public PersonService(IPersonDao idao) {
        this.dao = idao;
    }


    // TODO ravailler avec des DTO et ne pas les créer dans le service!!!
    // Create Person
    @Override
    public int create(String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught) {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        // Checker le role et faire une instace et l'envoyer dans le DAO
        int check = 0;
        switch(role){
            case 1: // Director
                PersonDTO directorDTO = new DirectorDTO(surname, mail, address, phone, 0, firstname, password);
                Person director = DirectorMapper.dtoToBusiness((DirectorDTO)directorDTO);
                try {
                    check = this.dao.create(director);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case 2: // Manager
                PersonDTO managerDTO = new ManagerDTO(surname, mail, address, phone, 0, firstname, password);
                Person manager = ManagerMapper.dtoToBusiness((ManagerDTO)managerDTO);
                try{
                    check = this.dao.create(manager);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case 3: // Teacher
                // On instancie Personne pour que dans le DAO il puisse récupérer le matière enseignée
                PersonDTO teacherDTO = new TeacherDTO(surname, mail, address, phone, 0, firstname, password, subjectTaught);
                Person teacher = TeacherMapper.dtoToBusiness((TeacherDTO)teacherDTO);
                try {
                    check = this.dao.create(teacher);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case 4: // Student
                // On instancie Personne pour que dans le DAO il puisse récupérer la date de naissance
                PersonDTO studentDTO = new StudentDTO(surname, mail, address, phone, 0, firstname,password, dateofbirth);
                Person student = StudentMapper.dtoToBusiness((StudentDTO)studentDTO);
                try{
                    check = this.dao.create(student);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }
        return check;
    }

    // Update Person
    @Override
    public int update(String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught, double average) {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        int res = 0;
        switch(role){
            case 1: // Director
                PersonDTO directorDTO = new DirectorDTO(surname, mail, address, phone, 0, firstname, password);
                Person director = DirectorMapper.dtoToBusiness((DirectorDTO)directorDTO);
                try{
                    res = this.dao.update(director);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case 2: // Manager
                PersonDTO managerDTO = new ManagerDTO(surname, mail, address, phone, 0, firstname, password);
                Person manager = ManagerMapper.dtoToBusiness((ManagerDTO)managerDTO);
                try{
                    res = this.dao.update(manager);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case 3: // Teacher
                PersonDTO teacherDTO = new TeacherDTO(surname, mail, address, phone, 0, firstname, password, subjectTaught);
                Person teacher = TeacherMapper.dtoToBusiness((TeacherDTO)teacherDTO);
                try{
                    res = this.dao.update(teacher);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case 4: // Student
                PersonDTO studentDTO = new StudentDTO(surname, mail, address, phone, 0, firstname,password,dateofbirth,average);
                Person student = StudentMapper.dtoToBusiness((StudentDTO)studentDTO);
                try{
                    res = this.dao.update(student);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }
        return res;
    }

    @Override
    public int delete(int index) {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        int res = -1;
        try{
            res = this.dao.delete(index);
            return res;
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int linkToCourse(int idEtudiant, int idCourse) {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        int res = -1;
        try {
            res = this.dao.linkToCourse(idEtudiant, idCourse);
            return res;
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public PersonDTO get(int index) {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        try{
            Person person = this.dao.get(index);
            PersonDTO personDTO = new PersonDTO();
            if(person instanceof Student)
            {
                personDTO = StudentMapper.businessToDto((Student)person);
                ((StudentDTO)personDTO).setAverage(this.getAverage(index));
            }else if(person instanceof Manager)
            {
                personDTO = ManagerMapper.businessToDto((Manager)person);
            }else if(person instanceof Teacher)
            {
                personDTO = TeacherMapper.businessToDto((Teacher)person);
            }else if(person instanceof Director)
            {
                personDTO = DirectorMapper.businessToDto((Director)person);
            }

            return personDTO;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<PersonDTO> getAll() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        List<PersonDTO> personDTOList = new ArrayList<PersonDTO>();
        try {
            List<Person> listAllPerson = this.dao.getAll();
            for(Person person : listAllPerson)
            {
                if (person instanceof Student) {
                    StudentDTO studentDTO = new StudentDTO();
                    studentDTO = StudentMapper.businessToDto((Student) person);
                    studentDTO.setAverage(getAverage(studentDTO.getId()));
                    personDTOList.add(studentDTO);
                } else if (person instanceof Manager) {
                    ManagerDTO managerDTO = new ManagerDTO();
                    managerDTO = ManagerMapper.businessToDto((Manager) person);
                    personDTOList.add(managerDTO);
                } else if (person instanceof Teacher) {
                    TeacherDTO teacherDTO = new TeacherDTO();
                    teacherDTO = TeacherMapper.businessToDto((Teacher) person);
                    personDTOList.add(teacherDTO);
                } else if (person instanceof Director) {
                    DirectorDTO directorDTO = new DirectorDTO();
                    directorDTO = DirectorMapper.businessToDto((Director) person);
                    personDTOList.add(directorDTO);
                }
            }
            return personDTOList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public float getAverage(int id)
    {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        Float average = 0f;
        List<Mark> listMark;
        try {
            listMark = (new MarkDao()).getAllMarkByStudentId(id);
            for( Mark mark : listMark )
            {
                average += mark.getMark();
            }
            average = average / listMark.size();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return average;
    }
}
