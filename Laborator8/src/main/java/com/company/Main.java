package com.company;

import java.sql.Date;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        {
            try {
                DataBase.rollback();
                DataBase.acommit();
                MovieController movies = new MovieController();
                GenresController genres = new GenresController();
                genres.create("Drama");
                genres.create("Comedy");
                genres.create("Romantic");
                DataBase.commit();


                movies.create("Before you", new Date(2323223232L), 3600f, 7.5f);
                movies.create("Titanic ", new Date(2323223232L), 3600f, 7.5f);
                DataBase.commit();
                //test
                System.out.print(movies.findById(1));
                System.out.print('\n');
                //System.out.print(movies.findByTitle("Before you")); //afiseaza null
                System.out.print('\n');

                System.out.print(genres.findById(1));
                System.out.print('\n');

                //System.out.print(genres.findByTitle("Comedy")); //afiseaza tot null

                Movies m1 = new Movies(4,"BabyBoss", new Date(2323223232L), 3600f, 7.5f);
                MoviesImp moviesImp = new MoviesImp();
                moviesImp.insertMovie(m1);
                moviesImp.deleteMovie(m1);
                System.out.printf(movies.findById(1));
                System.out.print('\n');
                System.out.printf(movies.findById(2));

                GenresImp genreController = new GenresImp();
                Genres g1 = new Genres(4,"Action");
                genreController.insertGenre(g1);
                genreController.deleteGenre(g1);
                //System.out.printf(genreController.findById(4).get(0).getTitle());



                DataBase.closeConnection();


            } catch (SQLException e) {
                System.err.println(e);
                DataBase.rollback();
            }

        }
    }
}
