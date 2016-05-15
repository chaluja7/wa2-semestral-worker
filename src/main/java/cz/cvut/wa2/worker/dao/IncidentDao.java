package cz.cvut.wa2.worker.dao;

import cz.cvut.wa2.worker.entity.Incident;

/**
 * @author jakubchalupa
 * @since 15.05.16
 */
public interface IncidentDao {

    Incident find(Long incidentId);

    void updateIncidentAddress(Long incidentId, String address);

}
