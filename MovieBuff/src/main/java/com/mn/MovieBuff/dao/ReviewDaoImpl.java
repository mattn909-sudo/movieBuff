package com.mn.MovieBuff.dao;

import com.mn.MovieBuff.dao.mappers.ReviewMapper;
import com.mn.MovieBuff.dto.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewDaoImpl implements ReviewDao{
    @Autowired
    JdbcTemplate jdbc;

    public Review createNewReview(Review review) {
        final String CREATE_REVIEW = "INSERT INTO review(stars, userreview, movies_id, user_id) VALUES(? , ? , ? , ?)";
        jdbc.update(CREATE_REVIEW, review.getStars(), review.getReviewBody(), review.getMovieId(), review.getUserId());
        return review;
    }

    public Review getReviewById(int reviewId) {
        final String GET_REVIEW = "SELECT * FROM review WHERE id = ?";
        return jdbc.queryForObject(GET_REVIEW, new ReviewMapper());
    }

    public List<Review> getAllReviews() {
        final String GET_ALL_REVIEWS = "SELECT * FROM review";
        return jdbc.query(GET_ALL_REVIEWS, new ReviewMapper());
    }

    public List<Review> getAllReviewsByUser(int userId) {
        final String GET_USER_REVIEWS = "SELECT * from review WHERE user_id = ?";
        return jdbc.query(GET_USER_REVIEWS, new ReviewMapper(), userId);
    }

    public List<Review> getAllReviewsByMovie(int movieId) {
        final String GET_MOVIE_REVIEWS = "SELECT * from review WHERE movies_id = ?";
        return jdbc.query(GET_MOVIE_REVIEWS, new ReviewMapper(), movieId);
    }

    public void updateReview(Review review) {
        final String UPDATE_REVIEW = "UPDATE review SET stars = ?, userreview = ? WHERE id = ?";
        jdbc.update(UPDATE_REVIEW, review.getStars(), review.getReviewBody(), review.getReviewId());
    }

    public void deleteReview(int reviewId) {
        final String DELETE_REVIEW = "DELETE FROM review WHERE id = ?";
        jdbc.update(DELETE_REVIEW, reviewId);
    }
}
