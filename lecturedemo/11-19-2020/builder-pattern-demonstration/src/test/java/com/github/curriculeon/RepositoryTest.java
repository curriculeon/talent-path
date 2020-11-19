package com.github.curriculeon;

public class RepositoryTest {
    public void test() {
        // given
        Person person = new Person();
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Repository<Person> personRepository = new Repository<>(person, person1, person2, person3);

        // when

        // then
    }
}
