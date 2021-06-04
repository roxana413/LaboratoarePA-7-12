package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenresImp implements GenreDAO{
    @Override
    public List<Genres> findAll() {
        return null;
    }

    @Override
    public List<Genres> findById(Integer id )  throws ClassNotFoundException, SQLException {


        try {
            Connection connection = DataBase.getConnection();

            String sql = "select title from genress where id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setObject(1, id); //setam valoarea ? din  interogarea sql

            ResultSet result = pstmt.executeQuery(); //executam interogarea

            result.next(); //prima tupla care corespunde interogarii

            List <Genres> g = new ArrayList<>();
            Genres genre = new Genres((Integer) result.getObject("id"),(String) result.getObject("name"));
            g.add(genre);
            return g;



        } catch (Exception e) {
            e.getMessage();
        }
        return null;

    }

    @Override
    public List<Genres> findByName() {
        return null;
    }

    @Override
    public boolean insertGenre(Genres genre) throws ClassNotFoundException, SQLException {
        try {
            Connection connection = DataBase.getConnection(); //preia conexiunea

            String count = "select count ( * ) from genress "; //definim o interogare

            Statement statement = connection.createStatement(); // cream un stmt de interogari

            ResultSet resultCount = statement.executeQuery(count); //primeste nr de tuple din tabel

            String sql = "insert into genress values ( ?,?)";

            PreparedStatement pStmt = connection.prepareStatement(sql);

            resultCount.next(); // preia pe rand linile din tabela movies

            //pregatim parametrii interogarii
            pStmt.setObject(1, resultCount.getInt(1) + 1); //indexam id-ul in functie de rezultatul interogarii
            pStmt.setObject(2, genre.getTitle());


            pStmt.executeUpdate(); //executam interogarea sql
            return true;



        } catch (Exception e) { //tratam exceptiile
            e.getMessage();
        }

        return false;

    }

    @Override
    public boolean updateGenre(Genres genre) {
        return false;
    }

    @Override
    public boolean deleteGenre(Genres genre) throws ClassNotFoundException, SQLException {

        try {
            Connection connection = DataBase.getConnection();

            String sql = "delete from genress where name = ?"; //stabilim interogarea

            PreparedStatement pstmt = connection.prepareStatement(sql); //adauga interogare la stmt

            pstmt.setObject(1, genre.getTitle());

            ResultSet result = pstmt.executeQuery();//executa interogarea

            result.next(); //prima tupla care corespunde interogarii

            return true;


        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

}
