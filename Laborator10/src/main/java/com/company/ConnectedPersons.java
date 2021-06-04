package main.java.com.company;

import java.util.ArrayList;
import java.util.List;

public class ConnectedPersons {

    private List<Person> connectedPersons = new ArrayList<>();

    //initial lista persoanelor conectate este vida
    public ConnectedPersons() {
        this.connectedPersons = null;
    }

    public List<Person> getConnectedPersons() {
        return connectedPersons;
    }

    public void setConnectedPersons(List<Person> connectedPersons) {
        this.connectedPersons = connectedPersons;
    }

    public void addConnectedPerson(Person p) {
        connectedPersons.add(p);
    }


}
