package cz.cvut.wa2.worker.service;

/**
 * @author jakubchalupa
 * @since 15.05.16
 */
public interface IncidentAddressService {

    void insert(Long incidentId, String address);

}
