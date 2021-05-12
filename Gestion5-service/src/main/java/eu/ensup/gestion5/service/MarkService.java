package eu.ensup.gestion5.service;

import eu.ensup.gestion5.dao.IMarkDao;
import eu.ensup.gestion5.dao.IPersonDao;
import eu.ensup.gestion5.dao.MarkDao;
import eu.ensup.gestion5.dao.PersonDao;
import eu.ensup.gestion5.dto.MarkDTO;
import eu.ensup.gestion5.mapper.MarkMapper;

import java.util.List;

public class MarkService implements IMarkService {

    private IMarkDao dao = null;

    // nom de la classe
    String className = getClass().getName();

    /**
     * Instantiates a new Service person.
     */
    public MarkService() {
        this.dao = new MarkDao();
    }

    public MarkService(IMarkDao idao) {
        this.dao = idao;
    }

    @Override
    public List<MarkDTO> getAll() {
        return null;
    }

    @Override
    public MarkDTO get(int index) {
        return null;
    }

    @Override
    public int delete(int index) {
        return 0;
    }

    public int create(MarkDTO markDto) {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        int res = 0;
        try {
            res = this.dao.create(MarkMapper.dtoToBusiness(markDto));
        } catch (Exception e) {
        }
        return res;
    }
}
