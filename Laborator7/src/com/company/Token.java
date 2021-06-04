package com.company;

public class Token {

    int i1, i2;

    public Token(int i, int j) {
        i1 = i;
        i2 = j;
    }

    public int getFirst() {
        return this.i1;
    }

    public int getSecond() {
        return this.i2;
    }

    public void setFirst(int i1) {
        this.i1 = i1;
    }

    public void setSecond(int i2) {
        this.i2 = i2;
    }

    @Override
    public String toString() {
        return "Token{" +
                "i1=" + i1 +
                ", i2=" + i2 +
                '}';
    }
}
