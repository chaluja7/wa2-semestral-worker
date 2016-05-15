package cz.cvut.wa2.worker.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jakubchalupa
 * @since 14.05.16
 */
public class IncidentServiceTest extends AbstractServiceTest {

    @Autowired
    protected IncidentService incidentService;

    @Test
    public void testFind() {
        incidentService.find(1L);
    }

    @Test
    public void testUpdateAddress() {
        incidentService.updateIncidentAddress(1L, "aaa bbb ccc");
    }

}
