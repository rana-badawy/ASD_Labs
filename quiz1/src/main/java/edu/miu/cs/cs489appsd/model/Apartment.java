package edu.miu.cs.cs489appsd.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Apartment implements Comparable<Apartment>{
    private String apartmentNo;
    private String propertyName;
    private Integer floorNo;
    private Integer size;
    private Integer numberOfRooms;
    private List<Lease> leases = new ArrayList<>();

    public Apartment() {}

    public Apartment(String apartmentNo, String propertyName, Integer floorNo, Integer size, Integer numberOfRooms) {
        this.apartmentNo = apartmentNo;
        this.propertyName = propertyName;
        this.floorNo = floorNo;
        this.size = size;
        this.numberOfRooms = numberOfRooms;
    }

    public String getApartmentNo() {
        return apartmentNo;
    }

    public void setApartmentNo(String apartmentNo) {
        this.apartmentNo = apartmentNo;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Integer floorNo) {
        this.floorNo = floorNo;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public List<Lease> getLeases() {
        return leases;
    }

    public void setLeases(List<Lease> leases) {
        this.leases = leases;
    }

    public void addLease(Lease lease) {
        this.leases.add(lease);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Apartment apartment)) return false;
        return Objects.equals(apartmentNo, apartment.apartmentNo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(apartmentNo);
    }

    @Override
    public int compareTo(Apartment other) {
        int sizeCompare = other.getSize().compareTo(this.size);

        if (sizeCompare != 0)
            return sizeCompare;

        return this.apartmentNo.compareTo(other.getApartmentNo());
    }
}
