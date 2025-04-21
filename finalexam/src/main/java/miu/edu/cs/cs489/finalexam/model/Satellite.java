package miu.edu.cs.cs489.finalexam.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "satellites")
public class Satellite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Satellite name can not be blank")
    @Column(nullable = false, unique = true)
    private String name;

    @Past(message = "Launch date must be in the past")
    private LocalDate launchDate;

    @Pattern(regexp = "LEO|MEO|GEO", message = "Orbit type must be either LEO, MEO, or GEO")
    private String orbitType;

    private boolean decommissioned;

    @ManyToMany(mappedBy = "satellites", fetch = FetchType.LAZY)
    private List<Astronaut> astronauts;

    public Satellite() {}

    public Satellite(String name, LocalDate launchDate, String orbitType, Boolean decommissioned) {
        this.name = name;
        this.launchDate = launchDate;
        this.orbitType = orbitType;
        this.decommissioned = decommissioned;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    public String getOrbitType() {
        return orbitType;
    }

    public void setOrbitType(String orbitType) {
        this.orbitType = orbitType;
    }

    public List<Astronaut> getAstronauts() {
        return astronauts;
    }

    public void setAstronauts(List<Astronaut> astronauts) {
        this.astronauts = astronauts;
    }

    public boolean isDecommissioned() {
        return decommissioned;
    }

    public void setDecommissioned(boolean decommissioned) {
        this.decommissioned = decommissioned;
    }
}
