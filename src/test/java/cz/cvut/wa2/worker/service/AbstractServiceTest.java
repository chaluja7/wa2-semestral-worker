package cz.cvut.wa2.worker.service;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Abstract service test.
 *
 * @author jakubchalupa
 * @since 19.03.16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
@Rollback
@Transactional(transactionManager = "transactionManager")
@Ignore
public abstract class AbstractServiceTest {

}

