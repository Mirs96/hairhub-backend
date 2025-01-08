package org.generation.italy.hairhub.model.services;

import org.generation.italy.hairhub.model.entities.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getReviewsBySalonId(long salonId);
}
