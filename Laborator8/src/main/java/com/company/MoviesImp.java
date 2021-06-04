package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoviesImp implements MoviesDAO{
    @Override
    public List<Movies> findAll() {
        return null;
    }

    @Override
    public List<Movies> findById(int id ) throws ClassNotFoundException, SQLException {


        try {
            Connection connection = DataBase.getConnection();

            String sql = "select title from moviess where id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setObject(1, id); //setam valoarea ? din  interogarea sql

            ResultSet result = pstmt.executeQuery(); //executam interogarea

            result.next(); //prima tupla care corespunde interogarii

            List <Movies> m = new ArrayList<>();
            Movies movie = new Movies((Integer) result.getObject("id"),(String) result.getObject("title"),null, null, null );
            m.add(movie);
            return m;



        } catch (Exception e) {
            e.getMessage();
        }
        return null;

    }
    @Override
    public List<Movies> findByName(String name) throws ClassNotFoundException, SQLException {


        return null;
    }

        @Override
    public boolean insertMovie(Movies movie) throws ClassNotFoundException, SQLException {
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
                pStmt.setObject(2, movie.getTitle());
                pStmt.setObject(3, movie.getRelase_date());
                pStmt.setObject(4, movie.getDuration());
                pStmt.setObject(5, movie.getScore());

                pStmt.executeUpdate(); //executam interogarea sql
                return true;



            } catch (Exception e) { //tratam exceptiile
                e.getMessage();
            }

            return false;

        }

    @Override
    public boolean updateMovie(Movies movie) {
        return false;
    }

    @Override
    public boolean deleteMovie(Movies movie) throws ClassNotFoundException, SQLException {

        try {
            Connection connection = DataBase.getConnection();

            String sql = "delete  from moviess where title = ?"; //stabilim interogarea

            PreparedStatement pstmt = connection.prepareStatement(sql); //adauga interogare la stmt

            pstmt.setObject(1, movie.getTitle());

            ResultSet result = pstmt.executeQuery();//executa interogarea

            result.next(); //prima tupla care corespunde interogarii

            return true;


        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }


    }
