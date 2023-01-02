package org.sp.dao;

import org.sp.models.Person;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyPermission;

@Component
public class PersonDAO {
    private static int people_count;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(people_count++, "Ben", "Wood", "male", "married",
                30, 195, 120));
        people.add(new Person(people_count++, "Ted", "Philips", "male", "single",
                25, 185, 90));
        people.add(new Person(people_count++, "Marry", "Sue", "female", "married",
                28, 167, 55));
        people.add(new Person(people_count++, "Clark", "Kent", "male", "single",
                23, 190, 100));
        people.add(new Person(people_count++, "Ben", "Parker", "male", "married",
                55, 175, 85));
    }

    public void addPerson(Person person) {
        person.setId(people_count++);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
            people.set(id, updatedPerson);
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
