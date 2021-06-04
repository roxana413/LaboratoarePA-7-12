package com.company;

import java.sql.*;

public class GenresController {

    public void create(String name)
            throws ClassNotFoundException, SQLException {
        try {
            Connection connection = DataBase.getConnection(); //preluam conexiunea

            String count = "select count ( * ) from genress"; //declaram o interogare

            Statement statement = connection.createStatement();

            ResultSet resultCount = statement.executeQuery(count); //primeste nr de tuple deja inserate in genres

            String sql = "insert into genress values ( ?,?)";

            PreparedStatement pStmt = connection.prepareStatement(sql);

            resultCount.next(); // preia ultima tupla introdusa

            pStmt.setObject(1, resultCount.getInt(1) + 1);
            pStmt.setObject(2, name);


            pStmt.executeUpdate(); //inseram


        } catch (Exception e) {
            e.getMessage();
        }


    }


    public String findById(Integer id)  throws ClassNotFoundException, SQLException {


        try {
            Connection connection = DataBase.getConnection();
            String sql = "select name from genress where id = ?";

            //cream un stmt precompilat
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setObject(1, id);

            ResultSet result = pstmt.executeQuery();

            result.next(); //prima tupla care corespunde interogarii

            return (String) result.getObject("name");


        } catch (Exception e) {
            e.getMessage();
        }
        return null;

    }

    public Integer findByTitle(String name)  throws ClassNotFoundException, SQLException{

        try {
            Connection connection = DataBase.getConnection();

            String sql = "select * from genress where name = ?"; //selecteaza tot randul

            PreparedStatement pstmt = connection.prepareStatement(sql); //adauga interogare la stmt

            pstmt.setObject(1, name); //pentru a compara title primit cu title din tabel

            ResultSet result = pstmt.executeQuery();//executa interogarea

            result.next(); //prima tupla care corespunde interogarii

            return (Integer) result.getObject("id");


        } catch (Exception e) {
            e.getMessage();
        }
        return null;


    }
}
