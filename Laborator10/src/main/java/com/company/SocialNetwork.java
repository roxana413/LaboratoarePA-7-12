package main.java.com.company;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {

    private List<Person> persons = new ArrayList<Person>(); //persoanele din retea

    public SocialNetwork() {
        this.persons = null;
    }

    void addPerson(Person p) {
        persons.add(p);
    }

    Person getPerson(int index) {
        return persons.get(index);
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "SocialNetwork{" +
                "persons=" + persons +
                '}';
    }
}
