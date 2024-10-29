package com.mn.MovieBuff.dao;

import com.mn.MovieBuff.dto.Actor;
import com.mn.MovieBuff.dto.Movie;

import java.util.List;

public interface ActorDao {

    Actor addNewActor(Actor actor);

    List<Actor> getAllActors();

    List<Movie> getAllMoviesByActor();

    Actor getActorById();

    void updateActor(Actor actor);

    void deleteActor(int actorId);
}
