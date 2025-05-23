package edu.miu.cs.cs489.surgeries.repository;

import edu.miu.cs.cs489.surgeries.model.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Query("select p from Patient p left join fetch p.address order by p.lastName")
    List<Patient> getAllPatientsSortedByLastName();

    @Query("select p from Patient p where lower(p.firstName) like lower(concat('%', :name, '%')) or lower(p.lastName) like lower(concat('%', :name, '%'))")
    List<Patient> getAllPatientsWithName(@Param("name") String name);

    @Query("select p from Patient p where p.firstName = :firstName and p.lastName = :lastName")
    Optional<Patient> findPatientByName(String firstName, String lastName);
}
