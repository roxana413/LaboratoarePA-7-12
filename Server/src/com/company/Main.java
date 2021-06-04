package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            new Server();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
