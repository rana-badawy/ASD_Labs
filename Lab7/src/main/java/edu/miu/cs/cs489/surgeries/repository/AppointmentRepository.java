package edu.miu.cs.cs489.surgeries.repository;

import edu.miu.cs.cs489.surgeries.model.Appointment;
import edu.miu.cs.cs489.surgeries.model.Dentist;
import edu.miu.cs.cs489.surgeries.model.Patient;
import edu.miu.cs.cs489.surgeries.model.Surgery;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByPatient(Patient patient);
}
