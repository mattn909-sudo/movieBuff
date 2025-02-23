package com.mn.MovieBuff.dao;

import com.mn.MovieBuff.dao.mappers.DirectorMapper;
import com.mn.MovieBuff.dao.mappers.MovieMapper;
import com.mn.MovieBuff.dao.mappers.ReviewMapper;
import com.mn.MovieBuff.dto.Director;
import com.mn.MovieBuff.dto.Movie;
import com.mn.MovieBuff.dto.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DirectorDaoImpl implements DirectorDao{

    @Autowired
    JdbcTemplate jdbc;

    public Director addNewDirector(Director director) {
        final String CREATE_DIRECTOR = "INSERT INTO director(name) VALUES(?)";

        jdbc.update(CREATE_DIRECTOR, director.getDirectorName());

        return director;
    }

    public List<Director> getAllDirectors() {
        return jdbc.query("SELECT * FROM director", new DirectorMapper());
    }

    public List<Movie> getAllMoviesByDirector(int id) {
        final String GET_MOVIES = "SELECT * FROM movie m JOIN movie_director md ON m.movies_id = md.movies_id WHERE director_id = ?";

        return jdbc.query(GET_MOVIES, new MovieMapper(), id);
    }

    public List<Review> getAllReviewsByDirector(int id){
        final String GET_DIRECTOR_REVIEWS = "SELECT * FROM reviews r JOIN movie_director md ON r.movie_id = md.movie_id WHERE md.director_id = ?";
        return jdbc.query(GET_DIRECTOR_REVIEWS, new ReviewMapper(), id);
    }

    public Director getDirectorById(int id) {
        return jdbc.queryForObject("SELECT * FROM director WHERE director_id = ?", new DirectorMapper(), id);
    }

    public void updateDirector(Director director) {
        final String UPDATE_DIRECTOR = "UPDATE director SET name = ? WHERE director_id = ?";
        jdbc.update(UPDATE_DIRECTOR, director.getDirectorName(), director.getDirectorId());
    }

    public void deleteDirector(int directorId) {
        final String DELETE_MOVIES = "DELETE m FROM movies m JOIN movie_director md ON m.movies_id = md.movies_id WHERE md.director_id = ?";
        final String DELETE_DIRECTOR_MOVIES = "DELETE FROM movie_director WHERE director_id = ?";
        final String DELETE_DIRECTOR = "DELETE FROM director WHERE director_id = ?";

        jdbc.update(DELETE_MOVIES, directorId);
        jdbc.update(DELETE_DIRECTOR_MOVIES, directorId);
        jdbc.update(DELETE_DIRECTOR, directorId);

    }
}
