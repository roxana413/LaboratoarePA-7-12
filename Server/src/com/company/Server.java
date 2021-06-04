package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static final int          PORT         = 3000;
    public static       boolean      running      = true;
    public              ServerSocket serverSocket = null;
    public              Game         game         = new Game();
            //o instanta de tipul game//initializare matrice si sesion=true
    public              int          nrClients    = 0;

    private List<ClientThread> clients = new ArrayList<>(); //retin numarul de jucatori

    public Server() throws IOException, InterruptedException {

        try {
            game.setSesion(true);
            game.init();
            serverSocket = new ServerSocket(PORT);
            while (running && game.getSesion() == true) {

                System.out.println("Waiting for 2 players..");
                Socket socket = serverSocket.accept();
                socket.setSoTimeout(100 * 1000);

                ClientThread client = new ClientThread(socket, this, game);
                client.start();
                clients.add(client);
                if (clients.size() == 2) {
                    nrClients = 2;
                    System.out.println("Starting game...");
                }
            }
        } catch (Exception e) {
            System.out.println("Serverul nu mai accepta clienti...");
        } finally {
            serverSocket.close();
            System.out.println("Serversul se opreste....");
            for (ClientThread c : clients) {
                c.join();
            }
        }
    }

    public int getNrClients() {
        return nrClients;
    }

    public void setNrClients(int nrClients) {
        this.nrClients = nrClients;
    }
}
