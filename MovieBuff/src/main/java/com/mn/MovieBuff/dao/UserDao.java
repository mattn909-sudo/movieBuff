package com.mn.MovieBuff.dao;

import com.mn.MovieBuff.dto.Movie;
import com.mn.MovieBuff.dto.User;

import java.util.List;

public interface UserDao {

    User createNewUser(User user);

    List<User> getAllUsers();

    User getUserById(int userId);

    User getUserByUsername(String userName);

    User updateUser(User user, int id);

    void deleteUser(int userId);

    void addMovieToUserFavorites(int userId, int movieId);

    void addMovieToUserWatchList(int userId, int movieId);

    List<Movie> getAllUserFavorites(int userId);

    List<Movie> getAllUserWatchlist(int userId);
}
