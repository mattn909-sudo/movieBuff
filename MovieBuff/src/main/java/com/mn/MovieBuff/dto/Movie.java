package com.mn.MovieBuff.dto;

import java.util.List;

public class Movie {

    private int movieId;

    private String movieName;

    private List<Review> movieReviews;

    private Director movieDirector;

    private List<Actor> movieActors;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public List<Review> getMovieReviews() {
        return movieReviews;
    }

    public void setMovieReviews(List<Review> movieReviews) {
        this.movieReviews = movieReviews;
    }

    public Director getMovieDirectors() {
        return movieDirector;
    }

    public void setMovieDirectors(List<Director> movieDirectors) {
        this.movieDirector = movieDirector;
    }

    public List<Actor> getMovieActors() {
        return movieActors;
    }

    public void setMovieActors(List<Actor> movieActors) {
        this.movieActors = movieActors;
    }
}
