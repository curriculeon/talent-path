package com.github.curriculeon;

import java.util.Date;

public class License {
    private Long licenseNumber;
    private String firstName;
    private String lastName;
    private Date expirationDate;
    private Date birthDate;
    private Date issueDate;
    private Address address;
    private Boolean correctiveLenses;
    private Boolean isOrganDonor;
    private Character licenseClass;

    License(Long licenseNumber, String firstName, String lastName, Date expirationDate, Date birthDate, Date issueDate, Address address, Boolean correctiveLenses, Boolean isOrganDonor, Character licenseClass) {
        this.licenseNumber = licenseNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.expirationDate = expirationDate;
        this.birthDate = birthDate;
        this.issueDate = issueDate;
        this.address = address;
        this.correctiveLenses = correctiveLenses;
        this.isOrganDonor = isOrganDonor;
        this.licenseClass = licenseClass;
    }

    public Long getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(Long licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getCorrectiveLenses() {
        return correctiveLenses;
    }

    public void setCorrectiveLenses(Boolean correctiveLenses) {
        this.correctiveLenses = correctiveLenses;
    }

    public Boolean getOrganDonor() {
        return isOrganDonor;
    }

    public void setOrganDonor(Boolean organDonor) {
        isOrganDonor = organDonor;
    }

    public Character getLicenseClass() {
        return licenseClass;
    }

    public void setLicenseClass(Character licenseClass) {
        this.licenseClass = licenseClass;
    }
}
