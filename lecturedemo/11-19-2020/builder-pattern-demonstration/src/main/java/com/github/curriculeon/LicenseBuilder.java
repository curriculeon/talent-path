package com.github.curriculeon;

import java.util.Date;

public class LicenseBuilder {
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

    public LicenseBuilder setLicenseNumber(Long licenseNumber) {
        this.licenseNumber = licenseNumber;
        return this;
    }

    public LicenseBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public LicenseBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public LicenseBuilder setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public LicenseBuilder setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public LicenseBuilder setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
        return this;
    }

    public LicenseBuilder setAddress(Address address) {
        this.address = address;
        return this;
    }

    public LicenseBuilder setCorrectiveLenses(Boolean correctiveLenses) {
        this.correctiveLenses = correctiveLenses;
        return this;
    }

    public LicenseBuilder setIsOrganDonor(Boolean isOrganDonor) {
        this.isOrganDonor = isOrganDonor;
        return this;
    }

    public LicenseBuilder setLicenseClass(Character licenseClass) {
        this.licenseClass = licenseClass;
        return this;
    }

    public License build() {
        return new License(licenseNumber, firstName, lastName, expirationDate, birthDate, issueDate, address, correctiveLenses, isOrganDonor, licenseClass);
    }
}