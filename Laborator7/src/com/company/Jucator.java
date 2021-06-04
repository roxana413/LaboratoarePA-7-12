package com.company;

public class Jucator implements Runnable {

    private final int    Time = 500;
    private       String name;
    private       Game   game;
    private       Graph  graph;
    private       int    scor;

    public Jucator(String name) {
        this.name = name;
    }

    public void setScor(int scor) {
        this.scor = scor;
    }

    public String getGraph() {
        return this.graph.toString();
    }

    public String getCloseSequence() {
        return this.graph.generateCloseSequence();
    }


    public int getScor() {
        return scor;
    }

    private boolean play() throws InterruptedException {
        Board board = game.getBoard(); //jucatorul preia tabla cu "graful complet"
        if (graph == null)
            graph = new Graph(); //cream un noua structura de tip graph board.graph.nodes
        if (board.isEmpty() || game.isEnded()) {
            scor = graph.ClosedSequenceValue();
            setScor(scor);
            game.setGscore(this.toString(), scor);
            game.computeWinner();
            return false;
        }

        graph.addPToken(board.extract()); //adauga primul token din "graful complet de token-uri" care a fost "shuffle"
        Thread.sleep(Time);

        return true;

    }


    public void run() {
        try {
            while (this.play()) {
                System.out.println(this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void setGame(Game g) {
        game = g;
    }

    public String toString() {
        return this.name;
    }

}
