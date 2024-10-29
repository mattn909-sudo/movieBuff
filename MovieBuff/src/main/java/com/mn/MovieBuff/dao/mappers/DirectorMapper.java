package com.mn.MovieBuff.dao.mappers;

import com.mn.MovieBuff.dto.Director;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DirectorMapper implements RowMapper<Director> {
    @Override
    public Director mapRow(ResultSet rs, int rowNum) throws SQLException {

        Director director = new Director();
        director.setDirectorId(rs.getInt("director_id"));
        director.setDirectorName(rs.getString("name"));

        return director;

    }
}
