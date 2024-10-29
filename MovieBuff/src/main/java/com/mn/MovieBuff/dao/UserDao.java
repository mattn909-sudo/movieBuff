package com.mn.MovieBuff.dao;

import com.mn.MovieBuff.dto.Movie;
import com.mn.MovieBuff.dto.User;

import java.util.List;

public interface UserDao {

    User createNewUser(User user);

    List<User> getAllUsers();

    User getUserById(int userId);

    void updateUser(int userId);

    void deleteUser(int userId);

    void addMovieToUserFavorites(int userId, int movieId);

    void addMovieToUserWatchList(int userId, int movieId);

    List<Movie> getAllUserFavorites(int userId);

    List<Movie> getAllUserWatchlist(int userId);
}
