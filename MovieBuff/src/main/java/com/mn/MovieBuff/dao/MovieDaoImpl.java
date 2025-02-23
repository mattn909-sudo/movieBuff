package com.mn.MovieBuff.dao;

import com.mn.MovieBuff.dao.mappers.DirectorMapper;
import com.mn.MovieBuff.dao.mappers.MovieMapper;
import com.mn.MovieBuff.dto.Director;
import com.mn.MovieBuff.dto.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MovieDaoImpl implements MovieDao{

    @Autowired
    JdbcTemplate jdbc;

    public List<Movie> getAllMovies() {
        final String ALL_MOVIES = "SELECT * FROM movies";
        return jdbc.query(ALL_MOVIES, new MovieMapper());
    }

    public Movie addNewMovie(Movie movie) {
        final String ADD_MOVIE = "INSERT INTO movies(name) VALUES(?)";
        jdbc.update(ADD_MOVIE, movie.getMovieName());
        return movie;
    }

    public Movie getMovieById(int movieId) {
        final String GET_MOVIES = "SELECT * FROM movies WHERE movie_id = ?";
        return jdbc.queryForObject(GET_MOVIES, new MovieMapper());
    }

    public void updateMovie(Movie movie) {
        final String UPDATE_MOVIE = "UPDATE movies SET name = ? WHERE movies_id = ?";
        jdbc.update(UPDATE_MOVIE, movie.getMovieName(), movie.getMovieId());
    }

    public Director getMovieDirector(int id){
        final String GET_DIRECTOR = "SELECT d.director_id, d.name FROM director d JOIN movies_director md ON d.director_id = md.director_id WHERE md.movies_id = ?";
        return jdbc.queryForObject(GET_DIRECTOR, new DirectorMapper(), id);
    }

    public void deleteMovie(int movieId) {
        final String DELETE_FAVORITES = "DELETE from user_favorites WHERE movies_id = ?";
        final String DELETE_WATCHLIST = "DELETE from user_watchlist WHERE movies_id = ?";
        final String DELETE_REVIEWS = "DELETE from review WHERE movies_id = ?";
        final String DELETE_ACTOR = "DELETE FROM movies_actor WHERE movies_id = ?";
        final String DELETE_DIRECTOR = "DELETE FROM movies_director WHERE movies_id = ?";
        final String DELETE_USER =  "DELETE FROM movies WHERE movies_id = ?";

        jdbc.update(DELETE_ACTOR, movieId);

        jdbc.update(DELETE_DIRECTOR, movieId);

        jdbc.update(
                DELETE_FAVORITES,
                movieId
        );

        jdbc.update(
                DELETE_WATCHLIST,
                movieId
        );

        jdbc.update(
                DELETE_REVIEWS,
                movieId
        );

        jdbc.update(
                DELETE_USER,
                movieId
        );

    }
}
