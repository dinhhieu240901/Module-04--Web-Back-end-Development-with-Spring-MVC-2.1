package com.example.healdeclaraionform.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class HealDeclaration {
    private String name;
    private int birthYear;
    private String genders;
    private String national;
    private String idCard;
    private String vehicle;
    private String licensePlate;
    private Integer numberOfSeat;
    private Date dateStart;
    private Date dateEnd;
    private String cityArrived;
    private String city;
    private String province;
    private String address;
    private String phoneNumber;
    private String email;
    private Map<String,Boolean> symptoms = new LinkedHashMap<>();
    private Map<String,Boolean> exposureHistory=new LinkedHashMap<>();

    public HealDeclaration() {
    }

    public HealDeclaration(String name, int birthYear, String genders, String national, String idCard, String vehicle, String licensePlate, Integer numberOfSeat, Date dateStart, Date dateEnd, String cityArrived, String city, String province, String address, String phoneNumber, String email, Map<String, Boolean> symptoms, Map<String, Boolean> exposureHistory) {
        this.name = name;
        this.birthYear = birthYear;
        this.genders = genders;
        this.national = national;
        this.idCard = idCard;
        this.vehicle = vehicle;
        this.licensePlate = licensePlate;
        this.numberOfSeat = numberOfSeat;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.cityArrived = cityArrived;
        this.city = city;
        this.province = province;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.symptoms = symptoms;
        this.exposureHistory = exposureHistory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getGenders() {
        return genders;
    }

    public void setGenders(String genders) {
        this.genders = genders;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(Integer numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getCityArrived() {
        return cityArrived;
    }

    public void setCityArrived(String cityArrived) {
        this.cityArrived = cityArrived;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, Boolean> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Map<String, Boolean> symptoms) {
        this.symptoms = symptoms;
    }

    public Map<String, Boolean> getExposureHistory() {
        return exposureHistory;
    }

    public void setExposureHistory(Map<String, Boolean> exposureHistory) {
        this.exposureHistory = exposureHistory;
    }
}
