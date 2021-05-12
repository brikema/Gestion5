package eu.ensup.gestion5.dao;


import eu.ensup.gestion5.domain.Mark;

/**
 * The interface Course dao.
 */
public interface IMarkDao extends IDao<Mark>
{
    /**
     * Know if the index exist or not in the table Course
     *
     * @param id index of the course
     * @return if the index exist
     */
    public boolean idExist(int id);
}

