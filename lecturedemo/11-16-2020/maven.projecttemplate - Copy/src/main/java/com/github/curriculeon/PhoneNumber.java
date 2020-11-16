package com.github.curriculeon;

public class PhoneNumber {
    private String phoneNumberString;

    public PhoneNumber(String phoneNumberString) {
        this.phoneNumberString =  phoneNumberString;
    }

    public String getPhoneNumberString() {
        return phoneNumberString;
    }

    public void setPhoneNumberString(String phoneNumberString) {
        this.phoneNumberString = phoneNumberString;
    }
}
