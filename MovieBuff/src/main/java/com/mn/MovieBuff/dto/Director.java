package com.mn.MovieBuff.dto;

import java.util.List;

public class Director {

    private int directorId;

    private String directorName;

    private List<Movie> directorMovies;

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public List<Movie> getDirectorMovies() {
        return directorMovies;
    }

    public void setDirectorMovies(List<Movie> directorMovies) {
        this.directorMovies = directorMovies;
    }
}
