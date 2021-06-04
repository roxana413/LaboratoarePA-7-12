package com.company;
import java.sql.*;

public class MovieController {

    //id,title, release_date, duration, score
    public void create(String title, Date relase_date, Float duration, Float score)
            throws ClassNotFoundException, SQLException {
        try {
            Connection connection = DataBase.getConnection(); //preia conexiunea

            String count = "select count ( * ) from moviess "; //definim o interogare

            Statement statement = connection.createStatement(); // cream un stmt de interogari

            ResultSet resultCount = statement.executeQuery(count); //primeste nr de tuple din tabel

            String sql = "insert into moviess values ( ?,?,?,?,?)";

            PreparedStatement pStmt = connection.prepareStatement(sql);

            resultCount.next(); // preia pe rand linile din tabela movies

            //pregatim parametrii interogarii
            pStmt.setObject(1, resultCount.getInt(1) + 1); //indexam id-ul in functie de rezultatul interogarii
            pStmt.setObject(2, title);
            pStmt.setObject(3, relase_date);
            pStmt.setObject(4, duration);
            pStmt.setObject(5, score);

            pStmt.executeUpdate(); //executam interogarea sql



        } catch (Exception e) { //tratam exceptiile
            e.getMessage();
        }


    }


    public String findById(Integer id) throws ClassNotFoundException, SQLException {


        try {
            Connection connection = DataBase.getConnection();

            String sql = "select title from moviess where id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setObject(1, id); //setam valoarea ? din  interogarea sql

            ResultSet result = pstmt.executeQuery(); //executam interogarea

            result.next(); //prima tupla care corespunde interogarii

            return (String) result.getObject("title"); //returnam doar titlul interogarii cautate


        } catch (Exception e) {
            e.getMessage();
        }
        return null;

    }

    public String findByTitle(String title) throws ClassNotFoundException, SQLException {

        try {
            Connection connection = DataBase.getConnection();

            String sql = "select * from moviess where title = ?"; //stabilim interogarea

            PreparedStatement pstmt = connection.prepareStatement(sql); //adauga interogare la stmt

            pstmt.setObject(1, title);

            ResultSet result = pstmt.executeQuery();//executa interogarea

            result.next(); //prima tupla care corespunde interogarii

            return (String) result.getObject("id"); //afisam id-ul filmului cu titlul cautat


        } catch (Exception e) {
            e.getMessage();
        }
        return null;


    }


}





