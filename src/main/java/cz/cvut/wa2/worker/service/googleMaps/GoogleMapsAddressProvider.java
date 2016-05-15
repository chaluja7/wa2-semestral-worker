package cz.cvut.wa2.worker.service.googleMaps;

import cz.cvut.wa2.worker.service.googleMaps.resource.GoogleAddressResource;
import cz.cvut.wa2.worker.service.googleMaps.resource.GoogleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jakubchalupa
 * @since 14.05.16
 */
@Service
public class GoogleMapsAddressProvider {

    @Autowired
    protected GoogleMapsAddressManager googleMapsAddressManager;

    /**
     * will download incident address from lat&lon
     * @param lat latitude
     * @param lon longitude
     */
    public List<String> getAddressesFromGPS(double lat, double lon) {
        List<String> ret = new ArrayList<>();

        //ziskame adresu
        GoogleAddressResource googleAddresses = googleMapsAddressManager.getGoogleAddresses(lat, lon);
        if(googleAddresses != null && googleAddresses.getResults() != null) {
            for(GoogleResult googleResult : googleAddresses.getResults()) {
                String address = googleResult.getFormatted_address();
                if(!StringUtils.isEmpty(address)) {
                    ret.add(address);
                }
            }
        }

        return ret;
    }

}

