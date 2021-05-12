package eu.ensup.gestion5.mapper;

import eu.ensup.gestion5.domain.School;
import eu.ensup.gestion5.dto.SchoolDTO;

/**
 * The type School mapper.
 */
public class SchoolMapper
{
    /**
     * Business to dto school dto.
     *
     * @param school the school
     * @return the school dto
     */
    public static SchoolDTO businessToDto(School school)
    {
        SchoolDTO schoolDto = new SchoolDTO();

        schoolDto.setId(school.getId());
        schoolDto.setLastname(school.getLastname());
        schoolDto.setMailAddress(school.getMailAddress());
        schoolDto.setAddress(school.getAddress());
        schoolDto.setPhoneNumber(school.getPhoneNumber());
        schoolDto.setDirector(school.getDirector());
        
        return schoolDto;
    };

    /**
     * Dto to business school.
     *
     * @param schoolDto the school dto
     * @return the school
     */
    public static School dtoToBusiness(SchoolDTO schoolDto)
    {
    	School school = new School();

    	school.setId(schoolDto.getId());
    	school.setLastname(schoolDto.getLastname());
    	school.setMailAddress(schoolDto.getMailAddress());
    	school.setAddress(schoolDto.getAddress());
    	school.setPhoneNumber(schoolDto.getPhoneNumber());
    	school.setDirector(schoolDto.getDirector());

        return school;
    };
}
