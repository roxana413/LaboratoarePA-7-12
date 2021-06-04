package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game {

    private Board board;
    Map<String, Integer> scoruri = new HashMap<String, Integer>();
    private final  List<Jucator>   jucatori   = new ArrayList<Jucator>();
    private        String          castigator = null;
    private static ExecutorService executors  = Executors.newFixedThreadPool(8);
    //thread manager , performance,  run in several threads


    public void addPlayer(Jucator jucator) {
        jucatori.add(jucator);
        jucator.setGame(this);

    }

    public void setBoard(Board b) {
        board = b;
    }

    public Board getBoard() {
        return board;
    }

    public void setGscore(String name, Integer score) {
        scoruri.put(name, score);
    }

    public synchronized void computeWinner() { //se asteapta ca primul thread care invoca metoda sa se termine si la celelalte thread-uri li se partajeaza schimbarile
        int maxScore = 0;
        String winner = null;
        for (Map.Entry<String, Integer> me : scoruri.entrySet()) {
            if (me.getValue() >= maxScore) {
                winner = me.getKey();


            }

        }
        if (castigator == null) {
            castigator = winner;
        }
    }


    public void start() throws InterruptedException {
        for (Jucator j : jucatori) { //assign tasks
            executors.execute(j); //apleaza metoda run din clasa jucator (flexible and powerful framework for asynchronous task)
        }

        executors.shutdown(); //nu mai primeste alte task-uri
        while (!executors.isTerminated()) {
            Thread.sleep(100); //pune thread-ul in asteptare atat timp cat executors nu s-a terminat
        }
        System.out.println("Castigatorul este " + castigator);

        for (Jucator j : jucatori) {
            System.out.println(j.getGraph());
            // System.out.println(j.getCloseSequence());
        }

    }

    public boolean isEnded() {
        return castigator != null;
    }


}