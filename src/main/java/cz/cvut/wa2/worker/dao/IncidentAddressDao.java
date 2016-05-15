package cz.cvut.wa2.worker.dao;

/**
 * @author jakubchalupa
 * @since 15.05.16
 */
public interface IncidentAddressDao {

    void insert(Long incidentId, String address);

}
