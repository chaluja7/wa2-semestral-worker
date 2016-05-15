package cz.cvut.wa2.worker.service;

import cz.cvut.wa2.worker.entity.Incident;

/**
 * @author jakubchalupa
 * @since 15.05.16
 */
public interface IncidentService {

    Incident find(Long incidentId);

    void updateIncidentAddress(Long incidentId, String address);

}
