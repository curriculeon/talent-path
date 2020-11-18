package com.github.curriculeon.phone;

import com.github.curriculeon.exceptions.InvalidPhoneNumberFormatException;
import com.github.curriculeon.tools.RandomNumberFactory;
import com.github.curriculeon.tools.SimpleLogger;
import com.github.curriculeon.tools.SimpleLoggerInterface;

import java.util.logging.Logger;

/**
 * Created by leon on 5/1/17.
 */
public interface PhoneNumberFactoryInterface {
    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    default PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        PhoneNumber[] result = new PhoneNumber[phoneNumberCount];
        for (int i = 0; i < result.length; i++) {
            result[i] = createRandomPhoneNumber();
        }
        return result;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */
    default PhoneNumber createRandomPhoneNumber() {
        return createPhoneNumberSafely(
                RandomNumberFactory.createInteger(100, 999),
                RandomNumberFactory.createInteger(100, 999),
                RandomNumberFactory.createInteger(1000, 9999));
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    default PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        String phoneNumberFormat = "(" + areaCode + ")-" + centralOfficeCode + "-" + phoneLineCode;
        try {
            return createPhoneNumber(phoneNumberFormat);
        } catch (InvalidPhoneNumberFormatException e) {
            return null;
        }
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */
    default PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        getLogger().info(String.format("Creating phone number with value [ %s ]", phoneNumberString));
        PhoneNumber result = new PhoneNumber(phoneNumberString);
        return result;
    }

    default SimpleLoggerInterface getLogger() {
        synchronized (this) {
            return new SimpleLogger(toString());
        }
    }
}
