package com.company;

public class Board {
    Integer nodes;
    public Graph graph;

    public Board(int nrOfTokens) {
        this.nodes = nrOfTokens;
        graph = new Graph(nodes); //stabilim nr de token-uri
        graph.createGraph(); //cream graful de token uri

    }

    public synchronized Token extract() {
        Token token = graph.getFirst();
        return token;
    }

    public boolean isEmpty() {
        if (graph.empty()) {
            return true;
        }
        return false;
    }
}
