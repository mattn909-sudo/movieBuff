package com.mn.MovieBuff.dao;

import com.mn.MovieBuff.dao.mappers.MovieMapper;
import com.mn.MovieBuff.dao.mappers.UserMapper;
import com.mn.MovieBuff.dto.Movie;
import com.mn.MovieBuff.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    JdbcTemplate jdbc;

    public User createNewUser(User user) {
        final String CREATE_USER = "INSERT INTO user(username, password, name) VALUES(? , ? , ?)";
        jdbc.update(CREATE_USER, user.getUsername(), user.getPassword(), user.getName());
        return user;
    }

    public List<User> getAllUsers() {
        List<User> userList = jdbc.query("SELECT * FROM user", new UserMapper());
        return userList;
    }

    public User getUserById(int userId) {

        return jdbc.queryForObject("SELECT * FROM user WHERE user_id = ?", new UserMapper(), userId);
    }

    public void updateUser(User user) {

        final String UPDATE_STRING = "UPDATE user SET username = ?, password = ?, name = ? WHERE user_id = ?";

        jdbc.update(UPDATE_STRING,
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getUserId()
                );

    }

    public void deleteUser(int userId) {
        final String DELETE_FAVORITES = "DELETE from user_favorites WHERE user_id = ?";
        final String DELETE_WATCHLIST = "DELETE from user_watchlist WHERE user_id = ?";
        final String DELETE_REVIEWS = "DELETE from review WHERE user_id = ?";
        final String DELETE_USER =  "DELETE FROM user WHERE user_id = ?";

        jdbc.update(
                DELETE_FAVORITES,
                userId
        );

        jdbc.update(
                DELETE_WATCHLIST,
                userId
        );

        jdbc.update(
                DELETE_REVIEWS,
                userId
        );

        jdbc.update(
                DELETE_USER,
                userId
        );
    }

    public void addMovieToUserFavorites(int userId, int movieId) {
        final String ADD_FAVORITE = "INSERT INTO user_favorites VALUES(?,?)";

        jdbc.update(ADD_FAVORITE, userId, movieId);
    }

    public void addMovieToUserWatchList(int userId, int movieId) {
        final String ADD_WATCHLIST = "INSERT INTO user_favorites VALUES(?,?)";

        jdbc.update(ADD_WATCHLIST, userId, movieId);
    }

    public List<Movie> getAllUserFavorites(int userId) {
        final String GET_FAVORITES = "SELECT * FROM movies m " +
                                     "JOIN user_favorites uf ON m.movies_id = uf.movies_id " +
                                     "WHERE user_id = ?";
        return jdbc.query(GET_FAVORITES, new MovieMapper(), userId);
    }

    public List<Movie> getAllUserWatchlist(int userId) {
        final String GET_WATCHLIST = "SELECT * FROM movies m " +
                "JOIN user_watchlist uf ON m.movies_id = uf.movies_id " +
                "WHERE user_id = ?";
        return jdbc.query(GET_WATCHLIST, new MovieMapper(), userId);
    }
}
