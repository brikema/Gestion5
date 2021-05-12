package eu.ensup.gestion5.dao;

import eu.ensup.gestion5.domain.Person;

/**
 * The interface School dao.
 */
public interface IPersonDao extends IDao<Person>
{
    public int linkToCourse( int idEtudiant, int idCourse );
}
