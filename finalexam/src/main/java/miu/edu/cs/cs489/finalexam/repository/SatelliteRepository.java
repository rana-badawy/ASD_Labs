package miu.edu.cs.cs489.finalexam.repository;

import miu.edu.cs.cs489.finalexam.model.Satellite;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SatelliteRepository extends JpaRepository<Satellite, Long> {
}
