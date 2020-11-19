package com.github.curriculeon;

public class AddressBuilder {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private Integer postalCode;

    public AddressBuilder setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public AddressBuilder setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    public AddressBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder setState(String state) {
        this.state = state;
        return this;
    }

    public AddressBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public AddressBuilder setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public Address build() {
        return new Address(addressLine1, addressLine2, city, state, country, postalCode);
    }
}