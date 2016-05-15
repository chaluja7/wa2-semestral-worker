package cz.cvut.wa2.worker.service;

import cz.cvut.wa2.worker.dao.IncidentDao;
import cz.cvut.wa2.worker.entity.Incident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jakubchalupa
 * @since 15.05.16
 */
@Service
public class IncidentServiceImpl implements IncidentService {

    @Autowired
    protected IncidentDao incidentDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Incident find(Long incidentId) {
        if(incidentId == null) return null;
        return incidentDao.find(incidentId);
    }

    @Override
    @Transactional
    public void updateIncidentAddress(Long incidentId, String address) {
        incidentDao.updateIncidentAddress(incidentId, address);
    }

}
