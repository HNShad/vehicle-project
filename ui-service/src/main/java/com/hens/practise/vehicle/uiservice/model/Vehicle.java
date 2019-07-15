package com.hens.practise.vehicle.uiservice.model;

public class Vehicle {

    private long id;

    private String vin;

    private String regnr;

    private String customer;

    private String address;

    private String status;

    protected Vehicle() {
    }

    public Vehicle(long id, String vin, String regnr, String customer, String address, String status) {
        this.id = id;
        this.vin = vin;
        this.regnr = regnr;
        this.customer = customer;
        this.address = address;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getRegnr() {
        return regnr;
    }

    public void setRegnr(String regnr) {
        this.regnr = regnr;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
