select * from dentist order by lastName;

select * from appointment
left join patient
on appointment.patientId = patient.patientId
left join address
on patient.addressId = address.addressId
where dentistId = 1;

select * from appointment
where surgeryId = 15;

select * from appointment
where patientId = 105
and appointmentDate = "2013-09-12";