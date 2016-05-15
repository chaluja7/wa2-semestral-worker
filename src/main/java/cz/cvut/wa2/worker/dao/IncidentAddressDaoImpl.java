package cz.cvut.wa2.worker.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author jakubchalupa
 * @since 15.05.16
 */
public class IncidentAddressDaoImpl extends JdbcDaoSupport implements IncidentAddressDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void insert(Long incidentId, String address) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("incidentId", incidentId);
        namedParameters.addValue("address", address);
        namedParameterJdbcTemplate.update("insert into incident_addresses (incident_id, address) values (:incidentId, :address)", namedParameters);
    }
}
