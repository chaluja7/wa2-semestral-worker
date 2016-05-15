package cz.cvut.wa2.worker.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jakubchalupa
 * @since 14.05.16
 */
public class IncidentAddressServiceTest extends AbstractServiceTest {

    @Autowired
    protected IncidentAddressService incidentAddressService;

    @Test
    public void testInsertIncidentAddress() {
        incidentAddressService.insert(2L, "addressssssa");
    }

}
