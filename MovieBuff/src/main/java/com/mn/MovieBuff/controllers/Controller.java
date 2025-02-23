package com.mn.MovieBuff.controllers;

import com.mn.MovieBuff.dao.UserDaoImpl;
import com.mn.MovieBuff.dto.Movie;
import com.mn.MovieBuff.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Controller {

    @Autowired
    UserDaoImpl userDao;


    @GetMapping("/all")
    public List<User> getAllUsers(){

        return userDao.getAllUsers();

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        User user = userDao.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/favorites/{id}")
    public List<Movie> getUserFavorites(@PathVariable int id){
        return userDao.getAllUserFavorites(id);
    }

//    @GetMapping("/watchlist/{id}")
//    public List<Movie> getUserWatchlist(@PathVariable int id){
//        return userDao.getAllUserFavorites(id);
//    }


}
