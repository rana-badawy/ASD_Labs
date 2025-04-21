package miu.edu.cs.cs489.finalexam.repository;

import miu.edu.cs.cs489.finalexam.model.Astronaut;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AstronautRepository extends JpaRepository<Astronaut, Long> {
}
