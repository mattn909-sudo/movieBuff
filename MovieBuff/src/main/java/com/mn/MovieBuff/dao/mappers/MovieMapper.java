package com.mn.MovieBuff.dao.mappers;

import com.mn.MovieBuff.dto.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {

        Movie movie = new Movie();
        movie.setMovieId(rs.getInt("movies_id"));
        movie.setMovieName(rs.getString("name"));

        return movie;

    }
}
