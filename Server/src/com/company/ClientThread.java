package com.company;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.time.Period;

//Thread de comunicare cu fiecare client in parte unde transmit mesaje
public class ClientThread extends Thread {
    private Socket         socket        = null;
    private BufferedReader in;
    private PrintWriter    out;
    public  Server         server;
    private Player         currentPlayer = null;
    private Game           game;
    public  int            nrClients;
    public  String         request;
    public  String         response;

    private boolean logged = false;


    public ClientThread(Socket socket, Server server, Game game) {
        this.game = game;
        this.socket = socket;
        this.server = server;
    }

    public void run() {

        while (!socket.isClosed()) {
            try {

                in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //citeste din capatul de citire
                out = new PrintWriter(socket.getOutputStream()); //afiseaza in capatul de scriere


                if ((request = in.readLine()) == null) {
                    System.out.println("Clientul s-a deconectat...");
                    socket.close();
                    break;
                }

                if (request.compareTo("stop") != 0) {


                    if (request.compareTo("name") == 0) {

                        if (server.nrClients == 1) {
                            response = "s1"; //al doilea ia titlul 1
                            server.setNrClients(server.getNrClients() + 1);
                            System.out.println(server.getNrClients());

                        } else {
                            response = "w0"; //primul ia titlul0
                            server.setNrClients(server.getNrClients() + 1);
                            System.out.println(server.getNrClients());
                        }


                    }


                    switch (request) {
                        case "start":
                            response = "start";
                        case "01x":
                            if (game.addMove(0, 1, "x"))
                                response = "01x";
                            else
                                response = "i";
                            if (game.checkWin())
                                response = "01xW";
                            break;
                        case "02x":
                            if (game.addMove(0, 2, "x"))

                                response = "02x";
                            else
                                response = "i";
                            if (game.checkWin())
                                response = "02xW";
                            break;

                        case "10x":
                            if (game.addMove(1, 0, "x"))
                                response = "10x";
                            else
                                response = "i";
                            if (game.checkWin())
                                response = "10xW";
                            break;
                        case "11x":
                            if (game.addMove(1, 1, "x"))
                                response = "11x";
                            else
                                response = "i";
                            if (game.checkWin())
                                response = "01xW";
                            break;
                        case "12x":
                            if (game.addMove(1, 2, "x"))
                                response = "12x";
                            else
                                response = "i";
                            if (game.checkWin())
                                response = "12xW";
                            break;
                        case "20x":
                            if (game.addMove(2, 0, "x"))
                                response = "20x";
                            else
                                response = "i";
                            if (game.checkWin())
                                response = "20xW";
                            break;
                        case "21x":
                            if (game.addMove(2, 1, "x"))
                                response = "21x";
                            else
                                response = "i";
                            if (game.checkWin())
                                response = "21xW";
                            break;
                        case "22x":
                            if (game.addMove(2, 2, "x"))
                                response = "22x";
                            else
                                response = "i";
                            if (game.checkWin())
                                response = "22xW";
                            break;
                        case "010":
                            if (game.addMove(0, 1, "0"))

                                response = "010";
                            else
                                response = "i";
                            if (game.checkWin())
                                response = "010W";
                            break;
                        case "020":
                            if (game.addMove(0, 1, "0"))
                                response = "020";
                            else
                                response = "i";
                            if (game.checkWin())
                                response = "020W";
                            break;

                        case "100":
                            if (game.addMove(1, 0, "0"))
                                response = "100";
                            else
                                response = "i";
                            if (game.checkWin())
                                response = "100W";
                            break;
                        case "110":
                            if (game.addMove(1, 1, "0"))
                                response = "110";
                            else
                                response = "i";
                            if (game.checkWin())
                                response = "110W";
                            break;
                        case "120":
                            if (game.addMove(1, 2, "0"))
                                response = "120";
                            else
                                response = "i";
                            if (game.checkWin())
                                response = "120W";
                            break;
                        case "200":
                            if (game.addMove(2, 0, "0"))
                                response = "200";
                            else
                                response = "i";
                            if (game.checkWin())
                                response = "200W";
                            break;
                        case "210":
                            if (game.addMove(2, 1, "0"))
                                response = "210";
                            else
                                response = "i";
                            if (game.checkWin())
                                response = "210W";
                            break;
                        case "220":
                            if (game.addMove(2, 2, "0"))
                                response = "220";
                            else
                                response = "i";
                            if (game.checkWin())
                                response = "220W";
                            break;


                    }

                } else {
                    response = "server stopped..";
                    server.serverSocket.close();
                    Server.running = false;
                }


                out.println(response); //afiseaza in capatul de scriere
                out.flush();


            } catch (SocketTimeoutException e) {
                out.println("Timpul a expirat");
                out.flush();
            } catch (IOException e) {
                System.out.println("Communication error..." + e);
            } finally {
                try {
                    System.out.println("Inchid Socket-ul");
                    socket.close();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }


    }
}

