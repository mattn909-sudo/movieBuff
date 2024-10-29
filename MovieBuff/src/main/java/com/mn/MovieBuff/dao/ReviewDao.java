package com.mn.MovieBuff.dao;

import com.mn.MovieBuff.dto.Review;

import java.util.List;

public interface ReviewDao {

    Review createNewReview(Review review);

    Review getReviewById(int reviewId);

    List<Review> getAllReviews();

    List<Review> getAllReviewsByUser(int userId);

    List<Review> getAllReviewsByMovie(int userId);

    void updateReview(Review review);

    void deleteReview(int reviewId);

}
