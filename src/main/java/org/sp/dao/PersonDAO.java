package org.sp.dao;

import org.sp.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int people_count;
    private static List<Person> people;

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

    public static void addPerson(Person person) {
        person.setId(people_count++);
        people.add(person);
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
