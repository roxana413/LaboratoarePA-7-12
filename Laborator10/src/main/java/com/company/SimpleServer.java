package main.java.com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SimpleServer {

    public static final int                            PORT    = 8100;
    private             ServerManager                  serverManager;
    private             List<ClientThread> clients = new ArrayList<>();
    public static boolean running = true;
    public  ServerSocket serverSocket = null;

    public SimpleServer() throws IOException, InterruptedException {



        try {

            serverSocket = new ServerSocket(PORT);
            serverManager = new ServerManager();   //initializam noul serverManager
            while (running) {
                System.out.println("Waiting for a client ..");
                Socket socket = serverSocket.accept();//acceptam conexiunea cu clientul


                socket.setSoTimeout(100 * 1000);

                ClientThread client = new ClientThread(socket, this,serverManager);
                client.run();
                clients.add(client);

                //new com.company.ClientThread(socket).run(); //rulam thred-ul pentru a executa comenzile

            }
        } catch (IOException e) {
            System.err.println("Ooops ..." + e);
        } finally {


            serverSocket.close();
            System.out.println("Serverul se opreste....");
            for (ClientThread c : clients) {
                c.join();
            }


        }


    }


}
