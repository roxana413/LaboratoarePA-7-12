package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SimpleClient {


    public static void main(String[] args) throws IOException {

        String serverAddress = "127.0.0.1"; //adresa ip a serverului

        PlayerAttributes player = new PlayerAttributes();
        MainFrame mainFrame = new MainFrame();
        Game game = new Game(true);
        boolean started = false;
        boolean named = false;
        String request;
        int PORT = 3000;
        Socket socket = new Socket(serverAddress, PORT);

        while (!socket.isClosed())
            try {


                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );

                if (!named) {
                    request = "name"; //se vor memora date despre nume
                    named = true;
                } else if (!started) {
                    request = "start";
                    started = true;
                } else
                    request = mainFrame.getRequest();

                out.println(request);
                out.flush();
                System.out.println("Client request: " + request);//string


                String response = in.readLine(); //citeste de la server

                System.out.println("Server response: " + response);
                switch (response) {
                    case "start":
                        mainFrame.first(player); //se initializeaza tabla
                    case "x":
                        player.setName("x");
                        break;
                    case "0":
                        player.setName("0");
                        break;
                    case "w0":
                        System.out.println("Wait for a partener");
                        player.setName("0");
                        break;
                    case "s1":
                        System.out.println("Game is starting...!");
                        player.setName("1");

                        break;
                    case "00x":
                        mainFrame.addMove(0, 0, "x");

                        break;
                    case "01x":
                        mainFrame.addMove(0, 1, "x");
                        break;
                    case "02x":
                        mainFrame.addMove(0, 2, "x");
                        break;

                    case "10x":
                        mainFrame.addMove(1, 0, "x");
                        break;
                    case "11x":
                        mainFrame.addMove(1, 1, "x");
                        break;
                    case "12x":
                        mainFrame.addMove(1, 2, "x");
                        break;
                    case "20x":
                        mainFrame.addMove(2, 0, "x");
                        break;
                    case "21x":
                        mainFrame.addMove(2, 1, "x");
                        break;
                    case "22x":
                        mainFrame.addMove(2, 2, "x");
                        break;
                    case "010":
                        mainFrame.addMove(0, 1, "0");
                    case "020":
                        mainFrame.addMove(0, 1, "0");
                        break;

                    case "100":
                        mainFrame.addMove(1, 0, "0");
                        break;
                    case "110":
                        mainFrame.addMove(1, 1, "0");
                        break;
                    case "120":
                        mainFrame.addMove(1, 2, "0");
                        break;
                    case "200":
                        mainFrame.addMove(2, 0, "0");
                        break;
                    case "210":
                        mainFrame.addMove(2, 1, "0");
                        break;
                    case "220":
                        mainFrame.addMove(2, 2, "0");
                        break;
                    case "00xW":
                        mainFrame.addMove(0, 0, "x");
                        if (player.getName().compareTo("x") == 0)
                            System.out.println("Congratulation!You won!");

                        else
                            System.out.println("Your partener won!Maybe next time..:)!");
                        game.setStatus(false);

                        break;
                    case "01xW":
                        mainFrame.addMove(0, 1, "x");
                        if (player.getName().compareTo("x") == 0)
                            System.out.println("Congratulation!You won!");
                        else
                            System.out.println("Your partener won!Maybe next time..:)!");
                        game.setStatus(false);

                        break;

                    case "02xW":
                        mainFrame.addMove(0, 2, "x");
                        if (player.getName().compareTo("x") == 0)
                            System.out.println("Congratulation!You won!");
                        else
                            System.out.println("Your partener won!Maybe next time..:)!");
                        break;

                    case "10xW":
                        mainFrame.addMove(1, 0, "x");
                        if (player.getName().compareTo("x") == 0)
                            System.out.println("Congratulation!You won!");
                        else
                            System.out.println("Your partener won!Maybe next time..:)!");
                        break;
                    case "11xW":
                        mainFrame.addMove(1, 1, "x");
                        if (player.getName().compareTo("x") == 0)
                            System.out.println("Congratulation!You won!");
                        else
                            System.out.println("Your partener won!Maybe next time..:)!");
                        break;
                    case "12xW":
                        mainFrame.addMove(1, 2, "x");
                        if (player.getName().compareTo("x") == 0)
                            System.out.println("Congratulation!You won!");
                        else
                            System.out.println("Your partener won!Maybe next time..:)!");
                        break;
                    case "20xW":
                        mainFrame.addMove(2, 0, "x");
                        if (player.getName().compareTo("x") == 0)
                            System.out.println("Congratulation!You won!");
                        else
                            System.out.println("Your partener won!Maybe next time..:)!");
                        break;
                    case "21xW":
                        mainFrame.addMove(2, 1, "x");
                        if (player.getName().compareTo("x") == 0)
                            System.out.println("Congratulation!You won!");
                        else
                            System.out.println("Your partener won!Maybe next time..:)!");
                        break;
                    case "22xW":
                        mainFrame.addMove(2, 2, "x");

                        if (player.getName().compareTo("x") == 0)
                            System.out.println("Congratulation!You won!");
                        else
                            System.out.println("Your partener won!Maybe next time..:)!");

                    case "010W":
                        mainFrame.addMove(0, 1, "0");
                        if (player.getName().compareTo("0") == 0)
                            System.out.println("Congratulation!You won!");
                        else
                            System.out.println("Your partener won!Maybe next time..:)!");
                        break;
                    case "020W":
                        mainFrame.addMove(0, 1, "0");
                        if (player.getName().compareTo("0") == 0)
                            System.out.println("Congratulation!You won!");
                        else
                            System.out.println("Your partener won!Maybe next time..:)!");
                        break;

                    case "100W":
                        mainFrame.addMove(1, 0, "0");
                        if (player.getName().compareTo("0") == 0)
                            System.out.println("Congratulation!You won!");
                        else
                            System.out.println("Your partener won!Maybe next time..:)!");
                        break;
                    case "110W":
                        mainFrame.addMove(1, 1, "0");
                        if (player.getName().compareTo("0") == 0)
                            System.out.println("Congratulation!You won!");
                        else
                            System.out.println("Your partener won!Maybe next time..:)!");
                        break;
                    case "120W":
                        mainFrame.addMove(1, 2, "0");
                        if (player.getName().compareTo("0") == 0)
                            System.out.println("Congratulation!You won!");
                        else
                            System.out.println("Your partener won!Maybe next time..:)!");
                        break;
                    case "200W":
                        mainFrame.addMove(2, 0, "0");
                        if (player.getName().compareTo("0") == 0)
                            System.out.println("Congratulation!You won!");
                        else
                            System.out.println("Your partener won!Maybe next time..:)!");
                        break;
                    case "210W":
                        mainFrame.addMove(2, 1, "0");
                        if (player.getName().compareTo("0") == 0)
                            System.out.println("Congratulation!You won!");
                        else
                            System.out.println("Your partener won!Maybe next time..:)!");
                        break;
                    case "220W":
                        mainFrame.addMove(2, 2, "0");
                        if (player.getName().compareTo("0") == 0)
                            System.out.println("Congratulation!You won!");
                        else
                            System.out.println("Your partener won!Maybe next time..:)!");
                        break;


                }
                //validam raspunsul de la server
                System.out.println("Server response: " + response);


            } catch (UnknownHostException e) {
                System.err.println("No server listening..." + e);

            }


    }
}

