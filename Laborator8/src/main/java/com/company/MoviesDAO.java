package com.company;

import java.sql.SQLException;
import java.util.List;

public interface MoviesDAO {
   //interfata care contine doar metode
    List<Movies> findAll();
    List<Movies> findById(int id) throws ClassNotFoundException, SQLException;
    List<Movies> findByName(String name) throws ClassNotFoundException, SQLException;
    boolean insertMovie(Movies movie) throws ClassNotFoundException, SQLException;
    boolean updateMovie(Movies movie);
    boolean deleteMovie(Movies movie) throws ClassNotFoundException, SQLException;


}
