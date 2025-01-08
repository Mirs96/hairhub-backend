package org.generation.italy.hairhub.dto;

import org.generation.italy.hairhub.model.entities.Review;

import java.util.List;

public class ReviewDto {
    private long id;
    private long rating;
    private String comment;
    private String date;

    public ReviewDto() {}

    public ReviewDto(long id, long rating, String comment, String date) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }

    public ReviewDto(Review r){
        this.id = r.getId();
        this.rating = r.getRating();
        this.comment = r.getComment();
        this.date = r.getDate().toString();
    }

    public static List<ReviewDto> fromReviews(List<Review> reviews){
        return reviews.stream().map(ReviewDto::new).toList();
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getRating() {
        return rating;
    }
    public void setRating(long rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
