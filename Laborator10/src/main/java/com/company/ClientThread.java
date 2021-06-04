package main.java.com.company;

import main.java.com.company.Person;
import main.java.com.company.ServerManager;
import main.java.com.company.SimpleServer;
import main.java.com.company.SocialNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ClientThread extends Thread { //trateaza comunizarea cu clientul
    private Socket         socket      = null;
    public  SimpleServer   server;
    private boolean        logged      = false;
    private Person         currentUser = null;
    private BufferedReader in;
    private PrintWriter    out;
    public  ServerManager  serverManager;
    public  String response;

    public ClientThread(Socket socket, SimpleServer simpleServer, ServerManager serverManager) {

        this.socket = socket;
        this.server = simpleServer;
        this.serverManager = serverManager; //primeste server manager-ul

    }

    public void run() {
        try {

           // String response;

            //get the request : client ->server
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();

            // send the response: server -> client
            out = new PrintWriter(socket.getOutputStream());

            while (!socket.isClosed()) {
                if (request == null) {
                    System.out.println("Clientul s-a deconectat...");
                    socket.close();
                   // break;
                }

                if (request.compareTo("stop") == 0) {
                    response = "Server stopped!";
                    server.serverSocket.close(); //!!!!
                    server.running = false; // !!!  -->se duce in finnally

                } else
                    if (request.compareTo("stop") != 0) {
                   // response = "Server recived the request: " + request;
                    response = command(request);
                }
                if (request.compareTo("exit") == 0) {
                    // response = "Server recived the request: " + request;
                    response = "We miss you!";


                }

                out.println(response);
                out.flush();
               // out.println(currentUser.getName());
                out.flush();


            }
        } catch (SocketTimeoutException e) {
            out.println("Timpul a expirat");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }

    }

    public String command(String command) {
        String status = null;
        String[] commandBreak = command.split(" ");
        int size = commandBreak.length; //sunt doar 2 argumente

        if (commandBreak[0].compareTo("register") == 0 && size == 2) {
            this.currentUser=new Person(commandBreak[1]);
            serverManager.registerClient(commandBreak[1]); //facem inregistrarea
            status = "Inregistrarea a avut loc cu succes";
            return status;

        } else if (commandBreak[0].compareTo("login") == 0 && size == 2) {
            int x = serverManager.loginClient(commandBreak[1]);
            if (x == 1)
                status = "Nu sunteti inregistrat in retea!";
            else
                status = "Logarea a avut loc cu succes";
            //logged = true;
            return status;
        } else if (commandBreak[0].compareTo("friend") == 0 && size >= 2) {
            int x = serverManager.addFriendship(currentUser.getName(), commandBreak[1], commandBreak[2]);
            if (x == 1)
                status =
                        "Something bad happened! Asigurati-va ca v-ati inregistrat si logat, atat dv cat si prietenii!";
            else
                status = "Prietenie adaugata cu succes";
        } else if (commandBreak[0].compareTo("send") == 0 && size == 2) {
            int x = serverManager.sendMessage(currentUser.getName(), commandBreak[1]);
            if (x == 1)
                status = "Something bad happened! Asigurati-va ca v-ati inregistrat si logat!";
            else
                status = "Mesaj trimis cu suces!";
        } else if (commandBreak[0].compareTo("read") == 0 && size == 1) {
            String stringArray[] = serverManager.readMessage(currentUser);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < stringArray.length; i++) {
                sb.append(stringArray[i]);
            }
            status = sb.toString();

            if (status.compareTo("") == 0) {
                status = "nu ai primit nici un mesaj";
            }
        }

        return status;
    }


}
