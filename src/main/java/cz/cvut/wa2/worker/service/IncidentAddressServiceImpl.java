package cz.cvut.wa2.worker.service;

import cz.cvut.wa2.worker.dao.IncidentAddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jakubchalupa
 * @since 15.05.16
 */
@Service
public class IncidentAddressServiceImpl implements IncidentAddressService {

    @Autowired
    protected IncidentAddressDao incidentAddressDao;

    @Override
    @Transactional
    public void insert(Long incidentId, String address) {
        incidentAddressDao.insert(incidentId, address);
    }

}
