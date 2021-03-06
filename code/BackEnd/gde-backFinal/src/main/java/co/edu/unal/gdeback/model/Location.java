package co.edu.unal.gdeback.model;

import java.util.Set;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "location")
@EntityListeners(AuditingEntityListener.class)
public class Location {
    
    public Location() {
    }

    public Location(Integer id, String location_name, String description) {
        this.location_id=id;
        this.location_name = location_name;
        this.location_description=description;
    }

    public Location(String location_name) {
        this.location_name = location_name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer location_id;

    @NotBlank
    private String location_name;
    
    @NotBlank
    private String location_description;

    @OneToMany(mappedBy = "location_r")
    private Set<Reservation> reservation;

    public Integer getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getLocation_description() {
        return location_description;
    }

    public void setLocation_description(String location_description) {
        this.location_description = location_description;
    }
    
}