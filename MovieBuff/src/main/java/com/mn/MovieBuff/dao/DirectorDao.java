package com.mn.MovieBuff.dao;

import com.mn.MovieBuff.dto.Director;
import com.mn.MovieBuff.dto.Movie;

import java.util.List;

public interface DirectorDao {

    Director addNewDirector(Director director);

    List<Director> getAllDirectors();

    List<Movie> getAllMoviesByDirector(int id);

    Director getDirectorById(int id);

    void updateDirector(Director director);

    void deleteDirector(int directorId);
}

