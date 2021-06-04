package main.java.com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {

    String       name;
    List<Friend> friends  = new ArrayList<>();
    String[]     messages = new String[100]; //mesajele
    int          count    = 0;

    public Person() {
        friends = null;

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Person(String name) {
        this.name = name;
        friends = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public void addFriend(Friend f) {
        friends.add(f);
    }

    public List getFriends() {
        return this.friends;
    }

    public void addMessage(String name, String message) {
        messages[getCount()] = "[ " + name + " ]" + "message";
        setCount(getCount() + 1);
    }




    public String[] readMessage() {
        return this.messages;

    }



}
