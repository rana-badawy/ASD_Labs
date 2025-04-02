package edu.miu.cs.cs489appsd.lab1b;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import edu.miu.cs.cs489appsd.lab1b.model.Employee;
import edu.miu.cs.cs489appsd.lab1b.model.PensionPlan;

import java.time.Month;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void printEmployees(List<Employee> employees) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // Convert LocalDate to String

            String jsonOutput = objectMapper.writeValueAsString(employees);
            System.out.println(jsonOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> getQuarterlyUpcomingEnrollees(List<Employee> employees) {
        LocalDate today = LocalDate.now();
        int currentQuarter = (today.getMonthValue() - 1) / 3 + 1;
        int nextQuarter = (currentQuarter % 4) + 1;
        int nextYear = (nextQuarter == 1) ? today.getYear() + 1 : today.getYear();
        Month endMonth = Month.of(nextQuarter * 3);
        LocalDate lastDayOfNextQuarter = LocalDate.of(nextYear, endMonth, endMonth.maxLength());

        return employees.stream()
                .filter(emp -> emp.getEmploymentDate().plusYears(3).isBefore(lastDayOfNextQuarter) ||
                        emp.getEmploymentDate().plusYears(3).isEqual(lastDayOfNextQuarter))
                .filter(emp -> emp.getPensionPlan() == null)
                .sorted((e1, e2) -> e2.getEmploymentDate().compareTo(e1.getEmploymentDate()))
                .toList();
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1L, "Daniel", "Agar",
                LocalDate.of(2018, 1, 17), 105945.5,
                new PensionPlan("EX1089", LocalDate.of(2023, 1, 17), 100.0)
                ));

        employees.add(new Employee(2L, "Benard", "Shaw",
                LocalDate.of(2018, 10, 3), 197750.0));

        employees.add(new Employee(3L, "Carly", "Agar",
                LocalDate.of(2014, 5, 16), 842000.75,
                new PensionPlan("SM2307", LocalDate.of(2019, 11, 4), 1555.5)));

        employees.add(new Employee(4L, "Wesley", "Schneider",
                LocalDate.of(2018, 11, 2), 74500.0));

        Collections.sort(employees);

        printEmployees(employees);

        printEmployees(getQuarterlyUpcomingEnrollees(employees));
    }
}