package com.company;

public class Game {
    private Player[] players;
    private int[][]  table = new int[3][3];
    private String   winner;
    private boolean  sesion;


    public void Game() {
        this.sesion = true;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                table[i][j] = -1;


    }

    public void init() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                table[i][j] = -1;

    }

    public boolean addMove(int x, int y, String name) { //ex: 01
        if (name.equals("x") && this.table[x][y] == -1) {
            this.table[x][y] = 1;
            return true; //piesa inserata cu succes
        } else if (name.equals("0") && this.table[x][y] == -1) {
            this.table[x][y] = 0;
            return true;
        } else
            return false;


    }


    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public int[][] getTable() {
        return table;
    }

    public void setTable(int[][] table) {
        this.table = table;
    }

    public boolean checkWin() {
        int i = 0;
        int j = 0;

        if (
                (this.table[i][j] == 0 && this.table[i + 1][j] == 0 && this.table[i + 2][j] == 0) //check first line and first column
                        || (this.table[i][j] == 0 && this.table[i][j + 1] == 0 && this.table[i][j + 2] == 0) //chech second column
                        || (this.table[i][j + 1] == 0 && this.table[i + 1][j + 1] == 0 && this.table[i][j + 2] == 0)
                        || (this.table[i + 1][j] == 0 && this.table[i + 1][j + 1] == 0 && this.table[i][j + 2] == 0) //check second line
                        || (this.table[i][j + 2] == 0 && this.table[i + 1][j + 2] == 0 && this.table[i + 2][j + 2] == 0)
                        || (this.table[i + 2][j] == 0 && this.table[i + 2][j + 1] == 0 && this.table[i + 2][j + 2] == 0)) {
            this.winner = "0";
            this.sesion = false;
            return true;

        }


        if ((this.table[i][j] == 1 && this.table[i + 1][j] == 1 && this.table[i + 2][j] == 1)
                || (this.table[i][j] == 1 && this.table[i][j + 1] == 1 && this.table[i][j + 2] == 1)
                || (this.table[i][j + 1] == 1 && this.table[i + 1][j + 1] == 1 && this.table[i][j + 2] == 1)
                || (this.table[i + 1][j] == 1 && this.table[i + 1][j + 1] == 1 && this.table[i][j + 2] == 1)
                || (this.table[i][j + 2] == 1 && this.table[i + 1][j + 2] == 1 && this.table[i + 2][j + 2] == 1)
                || (this.table[i + 2][j] == 1 && this.table[i + 2][j + 1] == 1 && this.table[i + 2][j + 2] == 1)) {
            this.winner = "1";
            this.sesion = false;
            return true;
        }


        return false;

    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public boolean getSesion() {
        return sesion;
    }

    public void setSesion(boolean sesion) {
        this.sesion = sesion;
    }

}
