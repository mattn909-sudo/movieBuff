package com.mn.MovieBuff.controllers;

import com.mn.MovieBuff.dao.UserDaoImpl;
import com.mn.MovieBuff.dto.Movie;
import com.mn.MovieBuff.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDaoImpl userDao;


    @GetMapping("/all")
    public List<User> getAllUsers() {

        return userDao.getAllUsers();

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userDao.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/name/{userName}")
    public ResponseEntity<User> getUserById(@PathVariable String userName) {
        User user = userDao.getUserByUsername(userName);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/favorites/{id}")
    public List<Movie> getUserFavorites(@PathVariable int id) {
        return userDao.getAllUserFavorites(id);
    }

    @GetMapping("/watchlist/{id}")
    public List<Movie> getUserWatchlist(@PathVariable int id) {
        return userDao.getAllUserWatchlist(id);
    }

    @PostMapping("/add")
    public User addNewUser(@RequestBody User user) {

        return userDao.createNewUser(user);

    }

    @PutMapping("update/{id}")
    public User updateUser(@RequestBody User user, @PathVariable int id) {
        return userDao.updateUser(user, id);
    }

    @DeleteMapping("delete/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userDao.deleteUser(userId);
    }


}
