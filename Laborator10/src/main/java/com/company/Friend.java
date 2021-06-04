package main.java.com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Friend {

    private String   name;
    private String[] messages = null;

    public Friend(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
