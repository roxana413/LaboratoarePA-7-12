package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Graph {

    int nodes;
    private List<Token> tokens = new ArrayList<Token>();

    public Graph(int nrOfTokens) {
        this.nodes = nrOfTokens;
    }

    public Graph() {

    }

    public void createGraph() {
        //creaza toate token-urile posibile
        for (int i = 1; i < nodes; i++) {
            for (int j = i + 1; j <= nodes; j++) {
                tokens.add(new Token(i, j)); //un array cu n*n perechi
            }
        }
        Collections.shuffle(tokens); //genereaza o permutare random a token-urilor

    }

    public boolean empty() {
        if (tokens.isEmpty())
            return true;
        return false;
    }


    public Token getFirst() {
        Token t = tokens.get(0);
        tokens.remove(t);
        return t;

    }

    public void addToken(Token t) {
        tokens.add(t);
    }

    public void addPToken(Token t) {
        tokens.add(t);
        nodes++;
    }

    public int ClosedSequenceValue() {

        int max = 0;
        int value = 0;
        boolean val = false;
        for (int i = 0; i < tokens.size(); ++i) {
            value = 0;
            Token first = new Token(tokens.get(i).i1, tokens.get(i).i2);
            Token last = new Token(0, 0);
            for (int j = 0; j < tokens.size(); ++j)
                if (tokens.get(i).getSecond() == tokens.get(j).getFirst()) {

                    {
                        value++;
                        last.setFirst(tokens.get(j).getFirst());
                        last.setSecond(tokens.get(j).getSecond());
                    }
                }
            if (value >= max) {
                max = value;

            }
            if (first.getFirst() == last.getSecond())
                val = true;

        }

        if (val)
            return value;
        else

            return 0;

    }

    public String generateCloseSequence() {
        List<Token> t = new ArrayList<>();
        int max = 0;
        int value = 0;
        boolean val = false;
        ArrayList<Integer> index = new ArrayList();
        for (int i = 0; i < tokens.size(); ++i) {
            value = 0;

            Token first = new Token(tokens.get(i).i1, tokens.get(i).i2);
            Token last = new Token(0, 0);
            index.add(i);
            for (int j = 0; j < tokens.size(); ++j)
                if (tokens.get(i).getSecond() == tokens.get(j).getFirst()) {

                    {
                        index.add(j);
                        value++;
                        last.setFirst(tokens.get(j).getFirst());
                        last.setSecond(tokens.get(j).getSecond());
                    }
                }
            if (value >= max) {
                max = value;

            }
            if (first.getFirst() == last.getSecond())
                val = true;

        }

        if (val) {

            for (int i = 0; i < index.size(); i++) {
                t.add(tokens.get(index.get(i)));
            }


        }

        return "Graph{" +
                "nr_of_tokens=" + nodes +
                ", tokens=" + t +
                '}';


    }

    @Override
    public String toString() {
        return "Graph{" +
                "nr_of_tokens=" + nodes +
                ", tokens=" + tokens +
                '}';
    }
}
