insert into address values
(1, "a1", "Fairfield", "IA", "74526"),
(2, "a2", "Des Moines", "IA", "78526"),
(3, "a3", "Dallas", "TX", "74826"),
(4, "a4", "Austin", "TX", "12358");

insert into surgery values
(10, "S10", "5486942573", 1),
(13, "S13", "8426539471", 2),
(15, "S15", "2563784195", 3);

insert into dentist (dentistId, firstName, lastName, phone) values
(1, "Tony", "Smith", "4853691257"),
(2, "Helen", "Pearson", "2568195726"),
(3, "Robin", "Plevin", "2369851475");

insert into patient (patientId, firstName, lastName, phone, addressId) values
(100, "Gillian", "White", "5814695328", 1),
(105, "Jill", "Bell", "1258746395", 2),
(108, "Ian", "MacKay", "8536912475", 3),
(110, "John", "Walker", "5748123695", 4);

insert into appointment values
(1, 1, 100, 15, "2013-09-12", "10:00"),
(2, 1, 105, 15, "2013-09-12", "12:00"),
(3, 2, 108, 10, "2013-09-12", "10:00"),
(4, 2, 108, 10, "2013-09-14", "14:00"),
(5, 3, 105, 15, "2013-09-14", "16:00"),
(6, 3, 110, 13, "2013-09-15", "18:00");