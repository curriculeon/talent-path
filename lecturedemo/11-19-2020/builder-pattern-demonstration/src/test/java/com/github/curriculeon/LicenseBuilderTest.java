package com.github.curriculeon;

import org.junit.Test;

import java.util.Date;

public class LicenseBuilderTest {
    @Test
    public void test() {
        License license = new LicenseBuilder()
                .setLicenseClass('C')
                .setFirstName("Leon")
                .setBirthDate(new Date())
                .setLastName("Hunter")
                .setAddress(null)
                .build();
    }
}
