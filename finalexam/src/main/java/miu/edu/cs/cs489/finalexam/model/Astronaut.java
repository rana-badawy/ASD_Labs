package miu.edu.cs.cs489.finalexam.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.util.List;

@Data
@Entity
@Table(name = "astronauts")
public class Astronaut {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Astronaut first name can not be blank")
    @Size(min = 2, max = 20, message = "Astronaut first must be between 2 and 20 characters")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "Astronaut last name can not be blank")
    @Size(min = 2, max = 20, message = "Astronaut first must be between 2 and 20 characters")
    @Column(nullable = false)
    private String lastName;

    @Range(min = 0, max = 50, message = "Years of experience must be between 0 and 50")
    private Integer experienceYears;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "astronauts_satellites",
            joinColumns = @JoinColumn(name = "astronaut_id"),
            inverseJoinColumns = @JoinColumn(name = "satellite_id")
    )
    private List<Satellite> satellites;

    public Astronaut() {}

    public Astronaut(String firstName, String lastName, Integer experienceYears) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experienceYears = experienceYears;
    }

    public Astronaut(String firstName, String lastName, Integer experienceYears, List<Satellite> satellites) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experienceYears = experienceYears;
        this.satellites = satellites;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public List<Satellite> getSatellites() {
        return satellites;
    }

    public void setSatellites(List<Satellite> satellites) {
        this.satellites = satellites;
    }
}
