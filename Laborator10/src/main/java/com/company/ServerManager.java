package main.java.com.company;

import java.util.List;

public class ServerManager {

    private SocialNetwork    socialNetworkList; //serverul are o retea a lui de persoane inregistrate
    private ConnectedPersons conectedPersons;


    public ServerManager() {
        this.socialNetworkList = new SocialNetwork();
        this.conectedPersons = new ConnectedPersons();
    }

    public void registerClient(String name) {
        socialNetworkList.addPerson(new Person(name));

    }

    public int loginClient(String name) {
        //verificam daca este inregistrat
        List<Person> registerPersons;


        //preluam persoanele conectate
        registerPersons = socialNetworkList.getPersons();
        for (int i = 0; i < registerPersons.size(); i++) {

            //daca gasim persoana ca este inregistrata
            if (registerPersons.get(i).getName().equals(name)) {
                this.conectedPersons.addConnectedPerson(new Person(name));
                return 0;
            } else
                return 1;
            // System.out.println("Person not registered! Please create an account !");
        }
        return 1;
    }


    public int addFriendship(String p1, String p2, String p3) {

        if (seeIfRegistered(p1) && seeIfLoggedIn(p1) && seeIfRegistered(p2) && seeIfRegistered(p3)) {
            Friend f1 = new Friend(p2);
            Friend f2 = new Friend(p3);
            Person p = getByName(p1);
            p.addFriend(f1);
            p.addFriend(f2);
            return 0;

        } else if (seeIfRegistered(p1) == false || seeIfLoggedIn(p1) == false)
            return 1;
            // System.out.println("Person " + p1 + " is not registered or logged in.");

        else if (seeIfRegistered(p2) == false || seeIfRegistered(p3) == false)
            //System.out.println("Friend " + p2 + " or " + p3 + " is not registered .");
            return 1;
        return 1;
    }


    public boolean seeIfLoggedIn(String name) {
        List<Person> connectedPersons = conectedPersons.getConnectedPersons();

        for (int i = 0; i < connectedPersons.size(); i++) {

            //daca gasim persoana ca este inregistrata
            if (connectedPersons.get(i).getName().equals(name)) {

                return true;

            } else
                return false;
        }
        return false;
    }


    public boolean seeIfRegistered(String name) {
        List<Person> registeredPersons = socialNetworkList.getPersons();

        for (int i = 0; i < registeredPersons.size(); i++) {

            //daca gasim persoana ca este inregistrata
            if (registeredPersons.get(i).getName().equals(name)) {

                return true;

            } else
                return false;
        }
        return false;
    }

    public Person getByName(String name) {
        List<Person> cp = conectedPersons.getConnectedPersons();
        for (int i = 0; i < cp.size(); i++) {
            if (cp.get(i).getName().equals(name))
                return cp.get(i);
        }
        return null;
    }


    public int sendMessage(String name, String message) //name se refera la numele clientului care apeleaza
    {
        if (seeIfRegistered(name) && seeIfLoggedIn(name)) {
            //daca este conectat si logat sa trimita un mesaj la toti prietenii
            Person p = getByName(name);
            List<Friend> friends = p.getFriends();

            for (int i = 0; i < friends.size(); i++) {

                Person f1 = getByName(friends.get(i).getName());
                f1.addMessage(name, message); //trimitem mesaj catre prieten


            }
            return 0;
        } else
            //System.out.println("Trebuie sa va intregistrati sau sa va logati inainte de a trimite mesajul.");
            return 1;

    }


    public String[] readMessage(Person p) {
        return p.readMessage();
    }

}

