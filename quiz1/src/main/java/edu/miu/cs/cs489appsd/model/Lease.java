package edu.miu.cs.cs489appsd.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Lease {
    private Long leaseNo;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double monthlyRentalRate;
    private String tenant;
    private String apartmentNo;

    public Lease(Long leaseNo, LocalDate startDate, LocalDate endDate, Double monthlyRentalRate, String tenant, String apartmentNo) {
        this.leaseNo = leaseNo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.monthlyRentalRate = monthlyRentalRate;
        this.tenant = tenant;
        this.apartmentNo = apartmentNo;
    }

    public Long getLeaseNo() {
        return leaseNo;
    }

    public void setLeaseNo(Long leaseNo) {
        this.leaseNo = leaseNo;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getMonthlyRentalRate() {
        return monthlyRentalRate;
    }

    public void setMonthlyRentalRate(Double monthlyRentalRate) {
        this.monthlyRentalRate = monthlyRentalRate;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getApartmentNo() {
        return apartmentNo;
    }

    public void setApartmentNo(String apartmentNo) {
        this.apartmentNo = apartmentNo;
    }

    public long getLeaseDurationInMonths() {
        System.out.println(ChronoUnit.MONTHS.between(startDate, endDate));
        return ChronoUnit.MONTHS.between(startDate, endDate);
    }

    public double calculateLeaseRevenue() {
        return getLeaseDurationInMonths() * monthlyRentalRate;
    }
}
