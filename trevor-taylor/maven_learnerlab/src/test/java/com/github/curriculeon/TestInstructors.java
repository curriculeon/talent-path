package com.github.curriculeon;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestInstructors {
    @Test
    public void test() {
        // given
        String[] nameArray = "Leon Hunter,Fred Zirdung,David S,LEON".split(",");
        List<String> nameList = Arrays.asList(nameArray);

        // when
        Instructors instructorsSingleton = Instructors.getInstance();
        for(Instructor person : instructorsSingleton) {
            String personName = person.getName();
            // then
            boolean outcome = nameList.contains(personName);
            Assert.assertTrue(outcome);
        }
    }

}
