package edu.miu.cs.cs489.surgeries.repository;

import edu.miu.cs.cs489.surgeries.model.Surgery;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@Repository
public interface SurgeryRepository extends JpaRepository<Surgery, Integer> {
    Optional<Surgery> findByName(String name);
}
