package cz.cvut.wa2.worker.dao;

import cz.cvut.wa2.worker.entity.Incident;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author jakubchalupa
 * @since 15.05.16
 */
public class IncidentDaoImpl extends JdbcDaoSupport implements IncidentDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Incident find(Long incidentId) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("incidentId", incidentId);
        try {
            return (Incident) namedParameterJdbcTemplate.queryForObject("select id, latitude, longitude from incident where id = :incidentId", namedParameters, new BeanPropertyRowMapper(Incident.class));
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void updateIncidentAddress(Long incidentId, String address) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("incidentId", incidentId);
        namedParameters.addValue("address", address);
        namedParameterJdbcTemplate.update("update incident set address = :address where id = :incidentId", namedParameters);
    }

}
