package com.mn.MovieBuff.dao.mappers;

import com.mn.MovieBuff.dto.Actor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorMapper implements RowMapper<Actor> {
    @Override
    public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {

        Actor actor = new Actor();
        actor.setActorId(rs.getInt("actor_id"));
        actor.setActorName(rs.getString("Name"));

        return actor;

    }
}
