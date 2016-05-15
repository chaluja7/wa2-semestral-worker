package cz.cvut.wa2.worker.entity;

import java.io.Serializable;

/**
 * @author jakubchalupa
 * @since 15.05.16
 */
public class Incident implements Serializable {

    private Long id;

    private Double latitude;

    private Double longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
