package com.mn.MovieBuff.dao.mappers;

import com.mn.MovieBuff.dto.Review;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewMapper implements RowMapper<Review> {
    @Override
    public Review mapRow(ResultSet rs, int rowNum) throws SQLException {

        Review review = new Review();
        review.setReviewId(rs.getInt("id"));
        review.setStars(rs.getInt("stars"));
        review.setReviewBody(rs.getString("userreview"));
        review.setMovieId(rs.getInt("movies_id"));
        review.setUserId(rs.getInt("user_id"));

        return review;

    }
}
