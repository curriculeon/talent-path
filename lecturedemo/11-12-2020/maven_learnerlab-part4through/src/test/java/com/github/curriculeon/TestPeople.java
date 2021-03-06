package com.github.curriculeon;

import org.junit.Assert;
import org.junit.Test;

public class TestPeople {
    // given
    People<Person> people = new People<Person>() {
        @Override
        public Person[] toArray() {
            return this.personList.stream().toArray(Person[]::new);
        }
    };

    @Test
    public void testAdd() {
        // given
        Person personToAdd = new Person(null, null);
        Assert.assertFalse(people.contains(personToAdd));

        // when
        people.add(personToAdd);

        // then
        Assert.assertTrue(people.contains(personToAdd));
    }

    @Test
    public void testRemove() {
        // given
        Person preExistingPerson = new Person(null, null);
        people.add(preExistingPerson);
        Assert.assertTrue(people.contains(preExistingPerson));

        // when
        people.remove(preExistingPerson);

        // then
        Assert.assertFalse(people.contains(preExistingPerson));
    }

    @Test
    public void testFindById() {
        // given
        Long expectedId = Long.MAX_VALUE;
        Person expected = new Person(expectedId, null);
        people.add(expected);
        Assert.assertTrue(people.contains(expected));

        // when
        Person actual = people.findById(expectedId);

        // then
        Assert.assertEquals(expected, actual);
    }
}
