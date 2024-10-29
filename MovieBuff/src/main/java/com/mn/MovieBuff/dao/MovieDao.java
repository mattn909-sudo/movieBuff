package com.mn.MovieBuff.dao;

import com.mn.MovieBuff.dto.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> getAllMovies();

    Movie addNewMovie(Movie movie);

    Movie getMovieById(int movieId);

    void updateMovie(int movieId);

    void deleteMovie(int movieId);
}
