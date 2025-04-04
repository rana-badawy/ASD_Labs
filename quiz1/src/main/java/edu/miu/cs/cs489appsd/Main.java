package edu.miu.cs.cs489appsd;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import edu.miu.cs.cs489appsd.model.Apartment;
import edu.miu.cs.cs489appsd.model.Lease;

public class Main {
    public static void printApartments(List<Apartment> apartments) {
        Collections.sort(apartments);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            String jsonOutput = objectMapper.writeValueAsString(apartments);
            System.out.println(jsonOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double calculateTotalRevenue(List<Lease> leases) {
        double totalRevenue = 0;

        for (Lease l: leases) {
            totalRevenue += l.calculateLeaseRevenue();
        }

        return totalRevenue;
    }

    public static void main(String[] args) {
        List<Apartment> apartments = new ArrayList<>();
        List<Lease> leases = new ArrayList<>();

        Apartment apt1 = new Apartment("B1102", "The Cameron House", 11, 790, 3);
        Apartment apt2 = new Apartment("A705", "The Cameron House", 7, 855, 4);
        Apartment apt3 = new Apartment("C1210", "Pointe Palace", 12, 1000, 4);
        Apartment apt4 = new Apartment("A1371", "Pointe Palace", 13, 1000, 4);

        Lease l1 = new Lease(3128874121L, LocalDate.of(2025, 2, 1),
                LocalDate.of(2026, 2, 1),
                1750.5, "Michael Philips", "A705");

        Lease l2 = new Lease(2927458265L, LocalDate.of(2025, 4, 2),
                LocalDate.of(2025, 10, 2),
                1500.0, "Anna Smith", "B1102");

        Lease l3 = new Lease(9189927460L, LocalDate.of(2025, 3, 1),
                LocalDate.of(2026, 3, 1),
                2560.75, "Alex Campos", "A1371");

        Lease l4 = new Lease(3128874119L, LocalDate.of(2023, 2, 1),
                LocalDate.of(2024, 2, 1),
                1650.5, "Michael Philips", "A705");

        apartments.add(apt1);
        apartments.add(apt2);
        apartments.add(apt3);
        apartments.add(apt4);

        apt1.addLease(l2);
        apt2.addLease(l1);
        apt2.addLease(l4);
        apt4.addLease(l3);

        leases.add(l1);
        leases.add(l2);
        leases.add(l3);
        leases.add(l4);

        printApartments(apartments);

        System.out.println("\n\n");
        System.out.println("Total Revenue is $" + calculateTotalRevenue(leases));
    }
}