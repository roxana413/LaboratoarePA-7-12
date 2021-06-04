package com.company;

import java.sql.SQLException;
import java.util.List;

public interface GenreDAO {
    List<Genres> findAll();
    List<Genres> findById(Integer id) throws ClassNotFoundException, SQLException;
    List<Genres> findByName();
    boolean insertGenre(Genres genre) throws ClassNotFoundException, SQLException;
    boolean updateGenre(Genres genre );
    boolean deleteGenre(Genres genre) throws ClassNotFoundException, SQLException;
}
