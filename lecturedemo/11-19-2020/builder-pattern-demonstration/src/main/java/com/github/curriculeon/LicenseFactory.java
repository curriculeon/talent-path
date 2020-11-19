package com.github.curriculeon;

public class LicenseFactory {
    public License createDelawareLicense() {
        return new LicenseBuilder()
                .setAddress(new AddressBuilder()
                        .setState("Delaware")
                        .setCity("Wilmington")
                        .setPostalCode(18752)
                        .build())
                .setFirstName("Leon")
                .setLastName("Hunter")
                .build();
    }
}
