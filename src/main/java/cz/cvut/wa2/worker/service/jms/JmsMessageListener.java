package cz.cvut.wa2.worker.service.jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.cvut.wa2.worker.entity.Incident;
import cz.cvut.wa2.worker.service.IncidentAddressService;
import cz.cvut.wa2.worker.service.IncidentService;
import cz.cvut.wa2.worker.service.googleMaps.GoogleMapsAddressProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author jakubchalupa
 * @since 15.05.16
 */
@Service
public class JmsMessageListener {

    @Autowired
    protected IncidentService incidentService;

    @Autowired
    protected IncidentAddressService incidentAddressService;

    @Autowired
    protected GoogleMapsAddressProvider googleMapsAddressProvider;

    private static final String UNKNOWN_ADDRESS = "UNKNOWN";

    /**
     * @param text zprava z fronty wa2-address
     * pokud bych chtel odpovede do jine fronty staci vratit odpoved a pridat anotaci @SendTo("queue name")
     */
    @JmsListener(destination = "wa2-address")
    public void downloadAddressesToIncident(String text) {
        try {
            JmsDownloadAddressesMessageBody jmsDownloadAddressesMessageBody = new ObjectMapper().readValue(text, JmsDownloadAddressesMessageBody.class);
            if(jmsDownloadAddressesMessageBody != null) {
                Incident incident = incidentService.find(jmsDownloadAddressesMessageBody.getIncidentId());
                if(incident != null && incident.getLatitude() != null && incident.getLongitude() != null) {

                    //simulace dlouheho behu
                    try {
                        Thread.sleep(20000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //incident opravdu existuje, takze jdeme k nemu zjistit adresy
                    List<String> addresses = googleMapsAddressProvider.getAddressesFromGPS(incident.getLatitude(), incident.getLongitude());
                    if(!addresses.isEmpty()) {
                        //prvni adresu dam primo k incidentu a vsechny dam do incidentAddresses
                        incidentService.updateIncidentAddress(incident.getId(), addresses.get(0));

                        for(String address : addresses) {
                            incidentAddressService.insert(incident.getId(), address);
                        }
                    } else {
                        //zadna adresa k mani :(
                        incidentService.updateIncidentAddress(incident.getId(), UNKNOWN_ADDRESS);
                    }
                }
            }
        } catch (IOException e) {
            //nothing
            e.printStackTrace();
        }
    }

}
