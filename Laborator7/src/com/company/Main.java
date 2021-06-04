package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // write your code here

        Game game = new Game();
        game.setBoard(new Board(8));
        game.addPlayer(new Jucator("Jucator 1"));
        game.addPlayer(new Jucator("Jucator 2"));
        game.addPlayer(new Jucator("Jucator 3"));
        Daemon.start();
        long startTime = System.nanoTime();
        game.start();
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Runtime: " + totalTime + " ms");

    }

}

