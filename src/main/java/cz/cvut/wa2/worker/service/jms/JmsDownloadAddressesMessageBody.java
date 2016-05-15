package cz.cvut.wa2.worker.service.jms;

/**
 * @author jakubchalupa
 * @since 15.05.16
 */
public class JmsDownloadAddressesMessageBody {

    private Long incidentId;

    public Long getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(Long incidentId) {
        this.incidentId = incidentId;
    }

}
